package com.easy.admin.file.storage.type.local;

import cn.hutool.core.codec.Base64Decoder;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.file.model.FileUploadResponse;
import com.easy.admin.file.model.StatObjectResponse;
import com.easy.admin.file.storage.FileStorageAbstract;
import com.easy.admin.file.storage.common.constant.FileStoragePathConstant;
import com.easy.admin.file.storage.model.Bucket;
import com.easy.admin.file.storage.model.PreSignatureParam;
import com.easy.admin.file.storage.model.StorageObject;
import com.easy.admin.file.storage.properties.FileStorageProperties;
import com.easy.admin.file.storage.properties.storage.FileStorageLocalProperties;
import io.minio.Result;
import io.minio.messages.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 本地存储
 *
 * @author TengChongChong
 * @date 2023-12-18
 **/
@Component
public class FileStorageLocal extends FileStorageAbstract {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FileStorageProperties fileStorageProperties;

    /**
     * local - 本地存储
     */
    @Autowired
    private FileStorageLocalProperties localProperties;

    @Value("${project.url}")
    private String projectUrl;

    public FileStorageLocal() {
    }

    @Override
    public Map<String, String> preSignature(PreSignatureParam preSignatureParam) {
        throw new EasyException("本地存储模式不支持[获取对象存储上传签名]");
    }

    @Override
    public boolean bucketExists(String bucketName) {
        return new File(localProperties.getPath() + bucketName).exists();
    }

    @Override
    public String getBucketPolicy(String bucketName) {
        throw new EasyException("本地存储模式不支持[获得Bucket的策略]");
    }

    @Override
    public List<Bucket> getAllBuckets() {
        File[] fileList = new File(localProperties.getPath()).listFiles();
        if (fileList == null || fileList.length == 0) {
            return Collections.emptyList();
        }
        List<Bucket> bucketList = new ArrayList<>();
        for (File file : fileList) {
            bucketList.add(new Bucket(file.getName()));
        }
        return bucketList;
    }

    @Override
    public Optional<Bucket> getBucket(String bucketName) {
        throw new EasyException("本地存储模式不支持[根据bucketName获取其相关信息]");
    }

    @Override
    public void removeBucket(String bucketName) {
        FileUtil.del(localProperties.getPath() + bucketName);
    }

    @Override
    public String getTemporaryPath() {
        return FileStoragePathConstant.TEMPORARY + File.separator + getDatePath() + File.separator;
    }

    @Override
    public String getFormalPath() {
        return FileStoragePathConstant.FORMAL + File.separator + getDatePath() + File.separator;
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
    public String moveToFormal(String bucketName, String objectName) {
        if (inFormalPath(objectName)) {
            return objectName;
        }
        String fullFilePath = getFullFilePath(bucketName, objectName);
        File src = new File(fullFilePath);
        if (src.exists()) {
            String formalPath = FileStoragePathConstant.FORMAL + File.separator + getDatePath();
            File formalFolder = new File(localProperties.getPath() + bucketName + File.separator + formalPath);
            checkDirs(formalFolder);
            File dest = new File(formalFolder.getPath() + File.separator + src.getName());
            cn.hutool.core.io.FileUtil.copy(src, dest, true);
            return formalPath + File.separator + src.getName();
        } else {
            throw new EasyException("移动到正式目录失败[源文件 - " + fullFilePath + " 不存在]");
        }
    }

    @Override
    public boolean isObjectExist(String bucketName, String objectName) {
        return new File(getFullFilePath(bucketName, objectName)).exists();
    }

    @Override
    public boolean isFolderExist(String bucketName, String objectName) {
        return new File(getFullFilePath(bucketName, objectName)).exists();
    }

    @Override
    public List<StorageObject> getAllObjectsByPrefix(String bucketName, String prefix, boolean recursive) {
        File parentFile = new File(getFullFilePath(bucketName, prefix));
        if (!parentFile.exists()) {
            return Collections.emptyList();
        }
        File[] fileArray = parentFile.listFiles();
        if(fileArray == null || fileArray.length == 0){
            return Collections.emptyList();
        }
        List<StorageObject> storageObjectList = new ArrayList<>();
        for (File file : fileArray) {
            String objectName = file.getPath().replace(localProperties.getPath() + bucketName + File.separator, "");
            storageObjectList.add(
                    new StorageObject(objectName, file.isDirectory())
            );
        }
        return storageObjectList;
    }

    @Override
    public String downloadToLocalTemporaryPath(String bucketName, String objectName) {
        String fullFilePath = getFullFilePath(bucketName, objectName);
        if (inTemporaryPath(objectName)) {
            return fullFilePath;
        }
        String destPath = localProperties.getPath() + bucketName + File.separator + File.separator +
                getTemporaryPath() + IdUtil.fastSimpleUUID() + objectName.substring(objectName.lastIndexOf("."));
        FileUtil.copy(fullFilePath, destPath, true);
        return destPath;
    }

    @Override
    public InputStream getObject(String bucketName, String objectName) {
        return FileUtil.getInputStream(getFullFilePath(bucketName, objectName));
    }

    @Override
    public InputStream getObject(String bucketName, String objectName, long offset, long length) {
        throw new EasyException("本地存储模式不支持[断点下载]");
    }

    @Override
    public Iterable<Result<Item>> listObjects(String bucketName, String prefix, boolean recursive) {
        throw new EasyException("本地存储模式不支持[获取路径下文件列表]");
    }

    @Override
    public FileUploadResponse uploadFile(String bucketName, MultipartFile file, String objectName, String contentType) {
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            throw new EasyException("上传文件失败[获取InputStream失败]");
        }
        return uploadFile(bucketName, objectName, inputStream);
    }

    @Override
    public FileUploadResponse uploadImage(String bucketName, String imageBase64, String objectName) {
        return uploadFile(bucketName, objectName, base64ToInputStream(imageBase64));
    }

    private static InputStream base64ToInputStream(String base64) {
        byte[] bytes = Base64Decoder.decode(base64.trim());
        return new ByteArrayInputStream(bytes);
    }

    @Override
    public FileUploadResponse uploadFile(String bucketName, String objectName, String filePath) {
        String fullFilePath = getFullFilePath(bucketName, objectName);
        FileUtil.copy(filePath, fullFilePath, true);
        return convert(bucketName, objectName);
    }

    @Override
    public FileUploadResponse uploadFile(String bucketName, String objectName, InputStream inputStream) {
        String fullFilePath = getFullFilePath(bucketName, objectName);
        FileUtil.writeFromStream(inputStream, fullFilePath);
        return convert(bucketName, objectName);
    }

    private String getFullFilePath(String bucketName, String objectName) {
        return localProperties.getPath() + bucketName + File.separator + objectName;
    }

    @Override
    public FileUploadResponse createDir(String bucketName, String objectName) {
        String path = localProperties.getPath() + bucketName + File.separator + objectName;
        File file = new File(path);
        if (!file.exists() && !file.mkdirs()) {
            throw new EasyException("创建文件夹或目录失败");
        }

        return convert(bucketName, objectName);
    }

    @Override
    public StatObjectResponse getStatObject(String bucketName, String objectName) {
        File file = new File(getFullFilePath(bucketName, objectName));
        return new StatObjectResponse(bucketName, objectName, file.length());
    }

    @Override
    public FileUploadResponse copyFile(String srcBucketName, String srcObjectName, String destBucketName, String destObjectName) {
        FileUtil.copy(
                getFullFilePath(srcBucketName, srcObjectName),
                getFullFilePath(destBucketName, destObjectName),
                true
        );
        return convert(destBucketName, destObjectName);
    }

    @Override
    public void removeFile(String bucketName, String objectName) {
        FileUtil.del(getFullFilePath(bucketName, objectName));
    }

    @Override
    public void removeFiles(String bucketName, List<String> objectNames) {
        for (String objectName : objectNames) {
            removeFile(bucketName, objectName);
        }
    }

    @Override
    public String getFileUrl(String bucketName, String objectName, Integer expires) {
        throw new EasyException("本地存储模式不支持[获取文件外链(bucketName,objectName,expires)]");
    }

    @Override
    public String getFileUrl(String bucketName, String objectName) {
        //String path = localProperties.getPath() + bucketName+ File.separator + objectName;
        //if (path.contains(FileStoragePathConstant.FORMAL)) {
        //    return "/static" + path.substring(path.indexOf(FileStoragePathConstant.FORMAL) - 1);
        //} else if (path.contains(FileStoragePathConstant.TEMPORARY)) {
        //    return "/static" + path.substring(path.indexOf(FileStoragePathConstant.TEMPORARY) - 1);
        //} else {
        //    return path;
        //}

        return projectUrl + "/static/" + bucketName + "/" + objectName;
    }

    /**
     * 转为FileUploadResponse
     *
     * @param bucketName 根目录 - 文件夹名称
     * @param objectName 文件路径
     * @return FileUploadResponse
     */
    private FileUploadResponse convert(String bucketName, String objectName) {
        FileUploadResponse fileUploadResponse = new FileUploadResponse(bucketName, objectName);
        // 获取预览/下载地址
        fileUploadResponse.setUrl(getFileUrl(fileUploadResponse.getBucketName(), fileUploadResponse.getObjectName()));
        return fileUploadResponse;
    }
}
