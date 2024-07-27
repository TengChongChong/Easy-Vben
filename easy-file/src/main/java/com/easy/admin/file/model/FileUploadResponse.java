package com.easy.admin.file.model;

import lombok.Data;

/**
 * 文件对象
 * 用于上传返回数据
 *
 * @author TengChongChong
 * @date 2019-03-08
 */
@Data
public class FileUploadResponse extends BaseFileInfo {
    /**
     * 显示名称
     */
    private String displayName;
    /**
     * 文件名称
     */
    private String name;
    /**
     * url
     */
    private String url;
    /**
     * 文件大小
     */
    private long size;
    /**
     * 后缀
     */
    private String suffix;
    /**
     * 内容类型
     */
    private String contentType;

    public FileUploadResponse() {
    }

    public FileUploadResponse(String bucketName, String objectName) {
        this.bucketName = bucketName;
        this.objectName = objectName;
    }
}
