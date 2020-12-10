package com.easy.restful.sys.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 下载
 *
 * @author TengChong
 * @date 2019-11-11
 */
@TableName("sys_download")
public class SysDownload extends Model<SysDownload> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 路径
     */
    private String path;

    /**
     * 有效期类型
     */
    private String effectiveType;

    /**
     * 过期时间
     */
    private Date expire;

    /**
     * 文件类型
     */
    private String type;

    /**
     * 文件大小
     */
    private Long length;

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
    private Integer version;

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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
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
}
