package com.easy.admin.file.model;

/**
 * BaseFile
 *
 * @author TengChongChong
 * @date 2023-12-27
 **/
public class BaseFileInfo {
    /**
     * local - 文件夹名称 / oss - bucket名称
     */
    protected String bucketName;
    /**
     * local - 文件路径 /  oss - objectName
     */
    protected String objectName;

    public BaseFileInfo() {
    }

    public BaseFileInfo(String bucketName, String objectName) {
        this.bucketName = bucketName;
        this.objectName = objectName;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
}
