package com.easy.admin.file.storage;

import com.easy.admin.file.model.FileUploadResponse;
import com.easy.admin.file.model.StatObjectResponse;
import com.easy.admin.file.storage.model.Bucket;
import com.easy.admin.file.storage.model.PreSignatureParam;
import com.easy.admin.file.storage.model.StorageObject;
import io.minio.Result;
import io.minio.messages.Item;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 文件存储存储
 *
 * @author TengChongChong
 * @date 2023-10-25
 **/
public interface FileStorage {

    // ********************* Bucket *********************

    /**
     * 判断 Bucket - 根目录（local - 文件夹名称 / oss - bucket名称）是否存在
     *
     * @param bucketName  根目录（local - 文件夹名称 / oss - bucket名称）
     * @return true/false
     */
    boolean bucketExists(String bucketName);

    /**
     * 获得 Bucket - 根目录（local - 文件夹名称 / oss - bucket名称）的策略
     *
     * @param bucketName  根目录（local - 文件夹名称 / oss - bucket名称）
     * @return
     */
    String getBucketPolicy(String bucketName);

    /**
     * 获得所有 Bucket - 根目录（local - 文件夹名称 / oss - bucket名称）列表
     *
     * @return Bucket - 根目录（local - 文件夹名称 / oss - bucket名称）列表
     */
    List<Bucket> getAllBuckets();

    /**
     * 根据bucketName获取其相关信息
     *
     * @param bucketName  根目录（local - 文件夹名称 / oss - bucket名称）
     * @return Optional<Bucket>
     */
    Optional<Bucket> getBucket(String bucketName);

    /**
     * 根据bucketName删除 Bucket - 根目录（local - 文件夹名称 / oss - bucket名称），true：删除成功； false：删除失败，有文件或Bucket不存在
     *
     * @param bucketName  根目录（local - 文件夹名称 / oss - bucket名称）
     */
    void removeBucket(String bucketName);

    // ********************* 文件 *********************
    
    /**
     * 获取对象存储上传签名
     *
     * @param preSignatureParam 签名参数
     */
    Map<String, String> preSignature(PreSignatureParam preSignatureParam);

    /**
     * 获取临时文件存放路径
     * local: temporary/yyyy/mm/dd
     * oss:   temporary/yyyy/mm/dd
     *
     * @return 临时路径/yyyy/mm/dd/
     */
    String getTemporaryPath();

    /**
     * 获取正式文件存放路径
     * local: formal/yyyy/mm/dd
     * oss:   formal/yyyy/mm/dd
     *
     * @return 临时路径/yyyy/mm/dd/
     */
    String getFormalPath();

    /**
     * 将临时目录下的文件移动到正式目录
     *
     * @param bucketName  根目录（local - 文件夹名称 / oss - bucket名称）
     * @param objectName local - 文件路径 /  oss - objectName
     * @return objectName
     */
    String moveToFormal(String bucketName, String objectName);

    /**
     * 判断文件是否存在
     *
     * @param bucketName  根目录（local - 文件夹名称 / oss - bucket名称）
     * @param objectName local - 文件路径 /  oss - objectName
     * @return true/false
     */
    boolean isObjectExist(String bucketName, String objectName);

    /**
     * 判断文件夹是否存在
     *
     * @param bucketName  根目录（local - 文件夹名称 / oss - bucket名称）
     * @param objectName local - 文件路径 /  oss - objectName
     * @return true/false
     */
    boolean isFolderExist(String bucketName, String objectName);

    /**
     * 根据文件前缀查询文件
     *
     * @param bucketName local - 文件夹名称 / oss - bucket名称
     * @param prefix     前缀
     * @param recursive  是否使用递归查询
     * @return MinioItem 列表
     */
    List<StorageObject> getAllObjectsByPrefix(String bucketName,
                                              String prefix,
                                              boolean recursive);

    /**
     * 下载文件到本地临时目录，一般用于文件处理
     *
     * @param bucketName local - 文件夹名称 / oss - bucket名称
     * @param objectName local - 文件路径 /  oss - objectName
     * @return 磁盘文件绝对路径
     */
    String downloadToLocalTemporaryPath(String bucketName, String objectName);

    /**
     * 获取文件流
     *
     * @param bucketName local - 文件夹名称 / oss - bucket名称
     * @param objectName local - 文件路径 /  oss - objectName
     * @return 二进制流
     */
    InputStream getObject(String bucketName, String objectName);

    /**
     * 断点下载
     *
     * @param bucketName local - 文件夹名称 / oss - bucket名称
     * @param objectName local - 文件路径 /  oss - objectName
     * @param offset     起始字节的位置
     * @param length     要读取的长度
     * @return 二进制流
     */
    InputStream getObject(String bucketName, String objectName, long offset, long length);

    /**
     * 获取路径下文件列表
     *
     * @param bucketName local - 文件夹名称 / oss - bucket名称
     * @param prefix     文件前缀
     * @param recursive  是否递归查找，false：模拟文件夹结构查找
     * @return 二进制流
     */
    Iterable<Result<Item>> listObjects(String bucketName, String prefix, boolean recursive);

    /**
     * 使用MultipartFile进行文件上传
     *
     * @param bucketName  根目录（local - 文件夹名称 / oss - bucket名称）
     * @param file        文件
     * @param objectName local - 文件路径 /  oss - objectName
     * @param contentType 类型
     * @return FileUploadResponse
     */
    FileUploadResponse uploadFile(String bucketName, MultipartFile file, String objectName, String contentType);

    /**
     * 图片上传
     *
     * @param bucketName local - 文件夹名称 / oss - bucket名称
     * @param imageBase64 imageBase64
     * @param objectName  local - 文件路径 /  oss - objectName
     * @return FileUploadResponse
     */
    FileUploadResponse uploadImage(String bucketName, String imageBase64, String objectName);

    /**
     * 上传本地文件
     *
     * @param bucketName local - 文件夹名称 / oss - bucket名称
     * @param objectName local - 文件路径 /  oss - objectName
     * @param filePath   本地文件路径
     * @return FileUploadResponse
     */
    FileUploadResponse uploadFile(String bucketName, String objectName, String filePath);

    /**
     * 通过流上传文件
     *
     * @param bucketName  根目录（local - 文件夹名称 / oss - bucket名称）
     * @param objectName  local - 文件路径 /  oss - objectName
     * @param inputStream 文件流
     * @return FileUploadResponse
     */
    FileUploadResponse uploadFile(String bucketName, String objectName, InputStream inputStream);

    /**
     * 创建文件夹或目录
     *
     * @param bucketName local - 文件夹名称 / oss - bucket名称
     * @param objectName local - 文件路径 /  oss - objectName 目录路径
     * @return FileUploadResponse
     */
    FileUploadResponse createDir(String bucketName, String objectName);

    /**
     * 获取文件信息, 如果抛出异常则说明文件不存在
     *
     * @param bucketName local - 文件夹名称 / oss - bucket名称
     * @param objectName local - 文件路径 /  oss - objectName
     * @return StatObjectResponse
     */

    StatObjectResponse getStatObject(String bucketName, String objectName);

    /**
     * 拷贝文件
     *
     * @param srcBucketName  源存储桶
     * @param srcObjectName  源文件名
     * @param destBucketName 目标存储桶
     * @param destObjectName 目标文件名
     * @return FileUploadResponse
     */
    FileUploadResponse copyFile(String srcBucketName, String srcObjectName, String destBucketName, String destObjectName);

    /**
     * 删除文件/文件夹
     *
     * @param bucketName local - 文件夹名称 / oss - bucket名称
     * @param objectName local - 文件路径 /  oss - objectName
     */
    void removeFile(String bucketName, String objectName);

    /**
     * 批量删除文件
     *
     * @param bucketName local - 文件夹名称 / oss - bucket名称 存储桶
     * @param objectNames local - 需要删除的文件列表 /  oss - 需要删除的objectName列表
     */
    void removeFiles(String bucketName, List<String> objectNames);

    /**
     * 获取文件外链
     *
     * @param bucketName local - 文件夹名称 / oss - bucket名称
     * @param objectName local - 文件路径 /  oss - objectName
     * @param expires    过期时间 <=7 秒 （外链有效时间（单位：秒））
     * @return url
     */
    String getFileUrl(String bucketName, String objectName, Integer expires);

    /**
     * 获得文件外链
     * 暂定oss也允许访问所有文件，不做权限限制
     *
     * @param bucketName  根目录（local - 文件夹名称 / oss - bucket名称）
     * @param objectName local - 文件路径 /  oss - objectName
     * @return url
     */
    String getFileUrl(String bucketName, String objectName);


}
