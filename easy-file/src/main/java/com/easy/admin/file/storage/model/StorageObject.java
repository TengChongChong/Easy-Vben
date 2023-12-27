package com.easy.admin.file.storage.model;

/**
 * 存储对象
 *
 * @author TengChongChong
 * @date 2023-12-27
 **/
public class StorageObject {

    /**
     * local - 文件路径 /  oss - objectName
     */
    private String objectName;

    /**
     * 是否文件夹
     */
    private boolean directory = false;

    public StorageObject() {
    }

    public StorageObject(String objectName, boolean directory) {
        this.objectName = objectName;
        this.directory = directory;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public boolean getDirectory() {
        return directory;
    }

    public void setDirectory(boolean directory) {
        this.directory = directory;
    }
}
