package com.easy.restful.sys.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 权限
 *
 * @author tengchong
 * @date 2018/9/4
 */
@TableName("sys_permissions")
public class SysPermissions extends Model<SysPermissions> {

    @TableId(value = "id")
    private String id;
    /**
     * 父id
     */
    private String pId;
    /**
     * 权限标识
     */
    private String code;
    /**
     * 权限名称
     */
    @NotBlank(message = "菜单/权限名称不能为空")
    private String name;
    /**
     * 图标
     */
    private String icon;
    /**
     * 权限地址
     */
    private String url;
    /**
     * http method
     */
    private String httpMethod;
    /**
     * 排序值
     */
    private Integer orderNo;
    /**
     * 级别
     */
    private Integer levels;
    /**
     * 类型
     */
    @NotNull(message = "类型不能为空")
    private Integer type;
    /**
     * 状态
     */
    @NotNull(message = "状态不能为空")
    private Integer status;
    /**
     * 是否默认打开
     */
    private Integer isOpen;
    /**
     * 是否外部链接
     */
    private Integer isExternalLinks;
    /**
     * 备注
     */
    private String tips;
    /**
     * 乐观锁保留字段
     */
    private Integer version;
    /**
     * 字体颜色
     */
    private String color;
    @TableField(fill = FieldFill.INSERT)
    private String createUser;
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date editDate;

    // ==== 非数据库中字段
    /**
     * 父菜单名称
     */
    @TableField(exist=false)
    private String pName;

    public SysPermissions() {
    }

    public SysPermissions(String id) {
        this.id = id;
    }

    public SysPermissions(String id, Integer orderNo) {
        this.id = id;
        this.orderNo = orderNo;
    }

    public SysPermissions(String id, String pId, Integer orderNo) {
        this.id = id;
        this.pId = pId;
        this.orderNo = orderNo;
    }

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

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public String getEditUser() {
        return editUser;
    }

    public void setEditUser(String editUser) {
        this.editUser = editUser;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getIsExternalLinks() {
        return isExternalLinks;
    }

    public void setIsExternalLinks(Integer isExternalLinks) {
        this.isExternalLinks = isExternalLinks;
    }

}