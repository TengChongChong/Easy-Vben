package com.easy.admin.file.model;

/**
 * 文件对象
 * 用于上传返回数据
 *
 * @author TengChongChong
 * @date 2019-03-08
 */
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
