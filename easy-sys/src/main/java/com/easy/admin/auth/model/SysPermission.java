package com.easy.admin.auth.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 权限
 *
 * @author TengChongChong
 * @date 2018/9/4
 */

@TableName("sys_permission")
public class SysPermission extends Model<SysPermission> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private String id;
    /**
     * 父id
     */
    private String parentId;
    /**
     * 类型
     */
    @NotNull(message = "类型不能为空")
    private String type;
    /**
     * 名称
     */
    @NotNull(message = "名称不能为空")
    private String title;
    /**
     * 组件名称
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    /**
     * 标识
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String code;
    /**
     * 图标
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String icon;
    /**
     * 地址
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String path;
    /**
     * 组件路径
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String component;
    /**
     * 是否外链
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String external;
    /**
     * 排序值
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer orderNo;
    /**
     * 是否显示
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String display;
    /**
     * 打开方式
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String openMode;
    /**
     * 状态
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "状态不能为空")
    private String status;
    /**
     * 备注
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String remarks;
    /**
     * 乐观锁
     */
    @Version
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createUser;

    @TableField(fill = FieldFill.INSERT)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date createDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String editUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date editDate;

    public SysPermission() {
    }

    public SysPermission(String id) {
        this.id = id;
    }

    public SysPermission(String id, Integer orderNo) {
        this.id = id;
        this.orderNo = orderNo;
    }

    public SysPermission(String id, String parentId, Integer orderNo) {
        this.id = id;
        this.parentId = parentId;
        this.orderNo = orderNo;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getExternal() {
        return external;
    }

    public void setExternal(String external) {
        this.external = external;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getOpenMode() {
        return openMode;
    }

    public void setOpenMode(String openMode) {
        this.openMode = openMode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
}