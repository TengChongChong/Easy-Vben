package com.easy.admin.file.model;

import lombok.Data;

/**
 * 文件信息
 *
 * @author TengChongChong
 * @date 2023-12-27
 **/
@Data
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
}
