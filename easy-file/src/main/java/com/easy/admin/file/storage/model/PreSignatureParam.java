package com.easy.admin.file.storage.model;

/**
 * 文件上传对象存储签名
 *
 * @author TengChongChong
 * @date 2023-10-25
 **/
public class PreSignatureParam {

    /**
     * 文件桶
     */
    private  String bucket;

    /**
     * 文件名
     */
    private String filename;

    /**
     * 文件最小长度，单位 b
     */
    private Long lowerLimit;

    /**
     * 文件最大长度，单位 b
     */
    private Long upperLimit;

    /**
     * 文件 Content-Type
     */
    private  String contentType;

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Long getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(Long lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public Long getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Long upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
