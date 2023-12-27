package com.easy.admin.file.storage;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.file.storage.common.type.FileStorageEnum;
import com.easy.admin.file.storage.properties.FileStorageProperties;
import com.easy.admin.file.storage.properties.storage.FileStorageLocalProperties;
import com.easy.admin.file.storage.properties.storage.FileStorageOSSProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 对象存储 Factory
 *
 * @author TengChongChong
 * @date 2023-10-25
 **/
@Component
public class FileStorageFactory {

    /**
     * 文件存储方式
     */
    @Autowired
    private FileStorageProperties fileStorageProperties;

    /**
     * oss - 对象存储
     */
    @Autowired
    private FileStorageOSSProperties fileStorageOSSProperties;

    /**
     * local - 本地存储
     */
    @Autowired
    private FileStorageLocalProperties fileStorageLocalProperties;

    /**
     * 文件存储实现
     */
    @Autowired
    private Map<String, FileStorageAbstract> fileStorageMap;

    private static final String PREFIX = "fileStorage";

    private FileStorageFactory() {
    }

    /**
     * 获取默认文件存储对象
     *
     * @return FileStorage
     */
    public FileStorageAbstract getFileStorage() {
        if (fileStorageProperties.enableLocal()) {
            return getFileStorage(FileStorageEnum.LOCAL);
        } else if (fileStorageProperties.enableOss()) {
            return fileStorageMap.get(getMapKey(fileStorageOSSProperties.getType()));
        } else {
            throw new EasyException("不支持[" + fileStorageProperties.getType() + "]文件存储方式");
        }
    }

    /**
     * 获取文件存储对象
     *
     * @param fileStorageEnum 文件存储方式
     * @return FileStorage
     */
    public FileStorageAbstract getFileStorage(FileStorageEnum fileStorageEnum) {
        return fileStorageMap.get(getMapKey(fileStorageEnum));
    }

    private String getMapKey(String storageType) {
        return PREFIX + StrUtil.upperFirst(storageType);
    }

    private String getMapKey(FileStorageEnum storageEnum) {
        return PREFIX + StrUtil.upperFirst(storageEnum.getCode());
    }

    public FileStorageProperties getFileStorageProperties() {
        return fileStorageProperties;
    }

    public FileStorageOSSProperties getFileStorageOSSProperties() {
        return fileStorageOSSProperties;
    }

    public FileStorageLocalProperties getFileStorageLocalProperties() {
        return fileStorageLocalProperties;
    }
}
