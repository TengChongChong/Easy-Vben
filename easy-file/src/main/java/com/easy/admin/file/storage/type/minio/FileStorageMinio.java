package com.easy.admin.file.storage.type.minio;

import cn.hutool.core.codec.Base64Decoder;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.file.model.FileUploadResponse;
import com.easy.admin.file.model.StatObjectResponse;
import com.easy.admin.file.storage.FileStorage;
import com.easy.admin.file.storage.FileStorageAbstract;
import com.easy.admin.file.storage.common.constant.FileStoragePathConstant;
import com.easy.admin.file.storage.model.Bucket;
import com.easy.admin.file.storage.model.PreSignatureParam;
import com.easy.admin.file.storage.model.StorageObject;
import com.easy.admin.file.storage.properties.FileStorageProperties;
import com.easy.admin.file.storage.properties.storage.FileStorageLocalProperties;
import com.easy.admin.file.storage.properties.storage.FileStorageOSSProperties;
import com.easy.admin.file.storage.util.PreSignatureParamUtil;
import io.minio.*;
import io.minio.errors.*;
import io.minio.messages.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * Minio 对象存储
 *
 * @author TengChongChong
 * @date 2023-10-25
 **/
@Component
public class FileStorageMinio extends FileStorageAbstract implements FileStorage {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FileStorageProperties fileStorageProperties;

    /**
     * local - 本地存储
     */
    @Autowired
    private FileStorageLocalProperties localProperties;

    /**
     * oss - 对象存储
     */
    @Autowired
    private FileStorageOSSProperties ossProperties;

    @Autowired(required = false)
    private MinioClient minioClient;

    @Override
    public Map<String, String> preSignature(PreSignatureParam preSignatureParam) {
        // 桶
        if (StrUtil.isBlank(preSignatureParam.getBucket())) {
            preSignatureParam.setBucket(fileStorageProperties.getDefaultBucket());
        }

        // 文件名
        if (StrUtil.isBlank(preSignatureParam.getFilename())) {
            preSignatureParam.setFilename(UUID.fastUUID().toString());
        }

        // 凭证有效期 10 分钟
        ZonedDateTime expirationDate = ZonedDateTime.now().plusMinutes(10);

        // 创建凭证
        PostPolicy policy = new PostPolicy(preSignatureParam.getBucket(), expirationDate);

        // 设置文件名称
        policy.addEqualsCondition("key", preSignatureParam.getFilename());

        // 设置允许上传的文件类型
        policy.addStartsWithCondition("Content-Type", preSignatureParam.getContentType());

        // 设置允许上传的文件长度范围，默认最小长度1b，默认最大长度会根据系统参数设置中的`ossUpperLimit`参数设置，如未设置默认为1gb
        policy.addContentLengthRangeCondition(
                PreSignatureParamUtil.getLowerLimit(preSignatureParam.getLowerLimit()),
                PreSignatureParamUtil.getUpperLimit(preSignatureParam.getUpperLimit())
        );

        try {
            return minioClient.getPresignedPostFormData(policy);
        } catch (MinioException | InvalidKeyException | IOException | NoSuchAlgorithmException e) {
            logger.debug("获取签名失败，{}", e.getMessage());
            throw new EasyException("获取签名失败，" + e.getMessage());
        }
    }

    @Override
    public boolean bucketExists(String bucketName) {
        try {
            return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException |
                 InvalidResponseException | IOException | NoSuchAlgorithmException | ServerException |
                 XmlParserException e) {
            logger.error("判断Bucket是否存在失败，{}", e.getMessage());
            throw new EasyException("判断Bucket是否存在失败，" + e.getMessage());
        }
    }

    @Override
    public String getBucketPolicy(String bucketName) {
        try {
            return minioClient.getBucketPolicy(GetBucketPolicyArgs
                    .builder()
                    .bucket(bucketName)
                    .build());
        } catch (Exception e) {
            logger.error("获得Bucket的策略失败，{}", e.getMessage());
            throw new EasyException("获得Bucket的策略失败，" + e.getMessage());
        }
    }

    @Override
    public List<Bucket> getAllBuckets() {
        try {
            List<io.minio.messages.Bucket> bucketList = minioClient.listBuckets();
            List<Bucket> buckets = new ArrayList<>();
            bucketList.forEach(bucket -> {
                buckets.add(new Bucket(bucket.name(), Date.from(bucket.creationDate().toInstant())));
            });
            return buckets;
        } catch (Exception e) {
            logger.error("获得所有Bucket列表失败，{}", e.getMessage());
            throw new EasyException("获得所有Bucket列表失败，" + e.getMessage());
        }
    }

    @Override
    public Optional<Bucket> getBucket(String bucketName) {
        return getAllBuckets().stream().filter(b -> b.getName().equals(bucketName)).findFirst();
    }

    @Override
    public void removeBucket(String bucketName) {
        try {
            minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            logger.error("根据bucketName删除Bucket失败，{}", e.getMessage());
            throw new EasyException("根据bucketName删除Bucket失败，" + e.getMessage());
        }
    }

    @Override
    public String getTemporaryPath() {
        return FileStoragePathConstant.TEMPORARY + "/" + getDatePath() + "/";
    }

    @Override
    public String getFormalPath() {
        return FileStoragePathConstant.FORMAL + "/" + getDatePath() + "/";
    }

    @Override
    public String moveToFormal(String bucketName, String objectName) {
        return copyFile(bucketName, objectName, bucketName, objectName.replace(FileStoragePathConstant.TEMPORARY, FileStoragePathConstant.FORMAL)).getObjectName();
    }

    @Override
    public boolean isObjectExist(String bucketName, String objectName) {
        boolean exist = true;
        try {
            minioClient.statObject(StatObjectArgs.builder().bucket(bucketName).object(objectName).build());
        } catch (Exception e) {
            logger.error("判断文件是否存在失败，{}", e.getMessage());
            throw new EasyException("判断文件是否存在失败，" + e.getMessage());
        }

        return exist;
    }

    @Override
    public boolean isFolderExist(String bucketName, String objectName) {
        boolean exist = false;
        try {
            Iterable<Result<Item>> results = minioClient.listObjects(
                    ListObjectsArgs.builder().bucket(bucketName).prefix(objectName).recursive(false).build()
            );
            for (Result<Item> result : results) {
                Item item = result.get();
                if (item.isDir() && objectName.equals(item.objectName())) {
                    exist = true;
                }
            }
        } catch (Exception e) {
            logger.error("判断文件夹是否存在失败，", e);
            throw new EasyException("判断文件夹是否存在失败，" + e.getMessage());
        }
        return exist;
    }

    @Override
    public List<StorageObject> getAllObjectsByPrefix(String bucketName, String prefix, boolean recursive) {
        try {
            if (!prefix.endsWith("/")) {
                prefix += "/";
            }
            List<StorageObject> list = new ArrayList<>();
            Iterable<Result<Item>> objectsIterator = minioClient.listObjects(
                    ListObjectsArgs.builder().bucket(bucketName).prefix(prefix).recursive(recursive).build()
            );
            if (objectsIterator != null) {
                for (Result<Item> object : objectsIterator) {
                    Item item = object.get();
                    list.add(new StorageObject(item.objectName(), item.isDir()));
                }
            }
            return list;
        } catch (Exception e) {
            logger.error("根据文件前缀查询文件失败，", e);
            throw new EasyException("根据文件前缀查询文件失败，" + e.getMessage());
        }
    }

    @Override
    public String downloadToLocalTemporaryPath(String bucketName, String objectName) {
        String localTemporaryPath = getLocalTemporaryPath();
        String fileName = objectName.substring(objectName.lastIndexOf(File.separator) + 1);
        String fullFilePath = localTemporaryPath + fileName;
        // 写入文件
        FileUtil.writeFromStream(getObject(bucketName, objectName), fullFilePath);
        return fullFilePath;
    }

    /**
     * 获取本地磁盘临时文件目录
     *
     * @return 路径
     */
    private String getLocalTemporaryPath() {
        File file = new File(
                localProperties.getPath() +
                        fileStorageProperties.getDefaultBucket() + File.separator +
                        FileStoragePathConstant.TEMPORARY + File.separator +
                        getDatePath()
        );
        checkDirs(file);
        return file.getPath() + File.separator;
    }

    /**
     * 检查文件夹是否存在,如不存在则新建
     *
     * @param file 文件
     */
    private void checkDirs(File file) {
        if (!file.exists() && !file.mkdirs()) {
            throw new EasyException("文件创建失败[" + file.getPath() + "]");
        }
    }

    @Override
    public InputStream getObject(String bucketName, String objectName) {
        try {
            return minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .build());
        } catch (Exception e) {
            logger.error("获取文件流失败，", e);
            throw new EasyException("获取文件流失败，" + e.getMessage());
        }
    }

    @Override
    public InputStream getObject(String bucketName, String objectName, long offset, long length) {
        try {
            return minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .build());
        } catch (Exception e) {
            logger.error("断点下载失败，", e);
            throw new EasyException("断点下载失败，" + e.getMessage());
        }
    }

    @Override
    public Iterable<Result<Item>> listObjects(String bucketName, String prefix, boolean recursive) {
        try {
            return minioClient.listObjects(
                    ListObjectsArgs.builder()
                            .bucket(bucketName)
                            .prefix(prefix)
                            .recursive(recursive)
                            .build());
        } catch (Exception e) {
            logger.error("获取路径下文件列表失败，", e);
            throw new EasyException("获取路径下文件列表失败，" + e.getMessage());
        }
    }

    @Override
    public FileUploadResponse uploadFile(String bucketName, MultipartFile file, String objectName, String contentType) {
        try {
            InputStream inputStream = file.getInputStream();
            return convert(minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .contentType(contentType)
                            .stream(inputStream, inputStream.available(), -1)
                            .build()));
        } catch (Exception e) {
            logger.error("使用MultipartFile进行文件上传失败，", e);
            throw new EasyException("使用MultipartFile进行文件上传失败，" + e.getMessage());
        }
    }

    @Override
    public FileUploadResponse uploadImage(String bucketName, String imageBase64, String objectName) {
        if (StrUtil.isEmpty(imageBase64)) {
            throw new EasyException("图片上传失败，图片数据为空");
        }
        try {
            InputStream in = base64ToInputStream(imageBase64);
            return uploadFile(bucketName, objectName, in);
        } catch (Exception e) {
            logger.error("图片上传失败，", e);
            throw new EasyException("图片上传失败，" + e.getMessage());
        }
    }

    private static InputStream base64ToInputStream(String base64) {
        byte[] bytes = Base64Decoder.decode(base64.trim());
        return new ByteArrayInputStream(bytes);
    }

    @Override
    public FileUploadResponse uploadFile(String bucketName, String objectName, String filePath) {
        try {
            return convert(minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .filename(filePath)
                            .build()));
        } catch (Exception e) {
            logger.error("上传本地文件失败，", e);
            throw new EasyException("上传本地文件失败，" + e.getMessage());
        }
    }

    @Override
    public FileUploadResponse uploadFile(String bucketName, String objectName, InputStream inputStream) {
        try {
            return convert(minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .stream(inputStream, inputStream.available(), -1)
                            .build()));
        } catch (Exception e) {
            logger.error("通过流上传文件失败，", e);
            throw new EasyException("通过流上传文件失败，" + e.getMessage());
        }
    }

    @Override
    public FileUploadResponse createDir(String bucketName, String objectName) {
        try {
            return convert(minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .stream(new ByteArrayInputStream(new byte[]{}), 0, -1)
                            .build()));
        } catch (Exception e) {
            logger.error("创建文件夹或目录失败，", e);
            throw new EasyException("创建文件夹或目录失败，" + e.getMessage());
        }
    }

    @Override
    public StatObjectResponse getStatObject(String bucketName, String objectName) {
        try {
            io.minio.StatObjectResponse statObject = minioClient.statObject(
                    StatObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .build());

            return new StatObjectResponse(statObject.bucket(), statObject.object(), statObject.size());
        } catch (Exception e) {
            logger.error("获取文件信息失败，", e);
            throw new EasyException("获取文件信息失败，" + e.getMessage());
        }
    }

    @Override
    public FileUploadResponse copyFile(String srcBucketName, String srcObjectName, String destBucketName, String destObjectName) {
        try {
            return convert(minioClient.copyObject(
                    CopyObjectArgs.builder()
                            .source(CopySource.builder().bucket(srcBucketName).object(srcObjectName).build())
                            .bucket(destBucketName)
                            .object(destObjectName)
                            .build()));
        } catch (Exception e) {
            logger.error("拷贝文件失败，", e);
            throw new EasyException("拷贝文件失败，" + e.getMessage());
        }
    }

    @Override
    public void removeFile(String bucketName, String objectName) {
        try {
            if (objectName.endsWith(".") || objectName.endsWith("/")) {
                Iterable<Result<Item>> list = minioClient.listObjects(ListObjectsArgs.builder().bucket(bucketName).prefix(objectName).recursive(true).build());
                for (Result<Item> itemResult : list) {
                    Item item = itemResult.get();
                    removeFile(bucketName, item.objectName());
                }
            } else {
                minioClient.removeObject(
                        RemoveObjectArgs.builder()
                                .bucket(bucketName)
                                .object(objectName)
                                .build());
            }
        } catch (Exception e) {
            logger.error("删除文件失败，", e);
            throw new EasyException("删除文件失败，" + e.getMessage());
        }
    }

    @Override
    public void removeFiles(String bucketName, List<String> objectNames) {
        try {
            objectNames.forEach(objectName -> {
                removeFile(bucketName, objectName);
            });
        } catch (Exception e) {
            logger.error("批量删除文件失败，", e);
            throw new EasyException("批量删除文件失败，" + e.getMessage());
        }
    }

    @Override
    public String getFileUrl(String bucketName, String objectName, Integer expires) {
        try {
            GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder().expiry(expires).bucket(bucketName).object(objectName).build();
            return minioClient.getPresignedObjectUrl(args);
        } catch (Exception e) {
            logger.error("获取文件外链失败，", e);
            throw new EasyException("获取文件外链失败，" + e.getMessage());
        }
    }

    @Override
    public String getFileUrl(String bucketName, String objectName) {
        //try {
        //    GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder()
        //            .bucket(bucketName)
        //            .object(objectName)
        //            .method(Method.GET).build();
        //    return minioClient.getPresignedObjectUrl(args);
        //} catch (Exception e) {
        //    logger.error("获得文件外链失败，", e);
        //    throw new EasyException("获得文件外链失败，" + e.getMessage());
        //}
        return ossProperties.getEndpoint() + "/" + bucketName + "/" + objectName;
    }

    /**
     * 转为FileUploadResponse
     *
     * @param response ObjectWriteResponse
     * @return FileUploadResponse
     */
    private FileUploadResponse convert(ObjectWriteResponse response) {
        FileUploadResponse fileUploadResponse = new FileUploadResponse(response.bucket(), response.object());
        // 获取预览/下载地址
        fileUploadResponse.setUrl(getFileUrl(fileUploadResponse.getBucketName(), fileUploadResponse.getObjectName()));
        return fileUploadResponse;
    }
}
