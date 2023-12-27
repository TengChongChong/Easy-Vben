package com.easy.admin.file.storage.properties.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * local - 本地存储
 *
 * @author TengChongChong
 * @date 2023-10-25
 **/
@Configuration
@ConfigurationProperties(prefix = "file.storage.local")
public class FileStorageLocalProperties {
    /**
     * 文件上传路径，以目录分隔符结尾(不要写以~开头的路径会导致无法访问)
     */
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
