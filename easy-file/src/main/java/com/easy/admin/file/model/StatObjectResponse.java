package com.easy.admin.file.model;

/**
 * 文件信息
 *
 * @author TengChongChong
 * @date 2023-12-27
 **/
public class StatObjectResponse extends BaseFileInfo {
    /**
     * 文件大小
     */
    private long size;

    public StatObjectResponse() {
    }

    public StatObjectResponse(String bucketName, String objectName, long size) {
        this.bucketName = bucketName;
        this.objectName = objectName;
        this.size = size;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
