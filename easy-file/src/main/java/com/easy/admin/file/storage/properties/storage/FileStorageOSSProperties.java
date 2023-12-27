package com.easy.admin.file.storage.properties.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * oss - 对象存储
 *
 * @author TengChongChong
 * @date 2023-10-25
 **/
@Configuration
@ConfigurationProperties(prefix = "file.storage.oss")
public class FileStorageOSSProperties {
    /**
     * 对象存储类型，暂时仅支持 minio
     */
    private String type;

    /**
     * 对象存储服务的URL
     */
    private String endpoint;

    /**
     * Access key
     */
    private String accessKey;

    /**
     * Secret key
     */
    private String secretKey;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

}
