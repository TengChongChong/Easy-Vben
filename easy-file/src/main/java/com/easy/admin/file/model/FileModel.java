package com.easy.admin.file.model;

/**
 * 文件对象
 * 用于上传返回数据
 *
 * @author TengChongChong
 * @date 2019-03-08
 */
public class FileModel {
    /**
     * 显示名称
     */
    private String displayName;
    /**
     * 文件名称
     */
    private String name;
    /**
     * 路径
     */
    private String path;
    /**
     * url
     */
    private String url;
    /**
     * 文件大小
     */
    private long length;
    /**
     * 后缀
     */
    private String suffix;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
