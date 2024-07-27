package com.easy.admin.file.model;

import lombok.Data;

/**
 * BaseFile
 *
 * @author TengChongChong
 * @date 2023-12-27
 **/
@Data
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

}
