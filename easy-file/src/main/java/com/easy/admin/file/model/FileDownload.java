package com.easy.admin.file.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 下载
 *
 * @author TengChong
 * @date 2019-11-11
 */
@TableName("file_download")
public class FileDownload extends Model<FileDownload> implements Serializable {

    /**
     * id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 显示名称
     */
    private String displayName;

    /**
     * local - 文件夹名称 / oss - bucket名称
     */
    private String bucketName;
    /**
     * local - 文件路径 /  oss - objectName
     */
    private String objectName;

    /**
     * 有效期类型
     */
    private String effectiveType;

    /**
     * 过期时间
     */
    private Date expire;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * 授权（保留）
     */
    private String auth;

    /**
     * 权限代码（保留）
     */
    private String code;

    /**
     * 状态
     */
    private String status;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;

    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createUser;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    //


    public FileDownload() {
    }

    public FileDownload(String displayName, String bucketName, String objectName) {
        this.displayName = displayName;
        this.bucketName = bucketName;
        this.objectName = objectName;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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

    public String getEffectiveType() {
        return effectiveType;
    }

    public void setEffectiveType(String effectiveType) {
        this.effectiveType = effectiveType;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
