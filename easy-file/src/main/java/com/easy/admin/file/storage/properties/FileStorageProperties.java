package com.easy.admin.file.storage.properties;

import com.easy.admin.file.storage.common.type.FileStorageTypeEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * MinIO 对象存储
 *
 * @author TengChongChong
 * @date 2023-10-25
 **/
@Configuration
@ConfigurationProperties(prefix = "file.storage")
public class FileStorageProperties {
    /**
     * 文件存储方式：local - 本地存储 / oss - 对象存储
     */
    private String type;
    /**
     * 文件存放（local - 默认文件夹名称 / oss - 默认bucket名称）
     * 命名规范：只能包括小写字母、数字和短划线（-）；必须以小写字母或者数字开头和结尾；长度为3~63个字符。
     */
    private String defaultBucket;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDefaultBucket() {
        return defaultBucket;
    }

    public void setDefaultBucket(String defaultBucket) {
        this.defaultBucket = defaultBucket;
    }

    public boolean enableLocal() {
        return FileStorageTypeEnum.LOCAL.getCode().equals(type);
    }

    public boolean enableOss() {
        return FileStorageTypeEnum.OSS.getCode().equals(type);
    }


}
