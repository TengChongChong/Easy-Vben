package com.easy.admin.sys.model;

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
 * @author TengChongChong
 * @date 2018/9/4
 */

@TableName("sys_permissions")
public class SysPermissions extends Model<SysPermissions> {

    private static final long serialVersionUID = 1L;

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
    private String path;
    /**
     * views 页面地址
     */
    private String component;
    /**
     * 排序值
     */
    private Integer orderNo;
    /**
     * 类型
     */
    @NotNull(message = "类型不能为空")
    private String type;
    /**
     * 隐藏路由
     */
    private String hide;
    /**
     * 状态
     */
    @NotNull(message = "状态不能为空")
    private String status;
    /**
     * 打开方式
     */
    private String target;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 乐观锁保留字段
     */
    private Integer version;
    @TableField(fill = FieldFill.INSERT)
    private String createUser;
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date editDate;

    //
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

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
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

    public String getHide() {
        return hide;
    }

    public void setHide(String hide) {
        this.hide = hide;
    }
}