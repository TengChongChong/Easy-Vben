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
 * 角色
 *
 * @author tengchong
 * @date 2018/9/4
 */

@TableName("sys_role")
public class SysRole extends Model<SysRole> {

    @TableId(value = "id")
    private String id;
    /**
     * 排序值
     */
    private Integer orderNo;
    /**
     * 父id
     */
    private String pId;
    /**
     * 角色名称
     */
    @NotBlank(message = "名称不能为空")
    private String name;
    /**
     * 部门id
     */
    private String deptId;
    /**
     * 角色标识
     */
    private String code;
    /**
     * 状态(1.启用 0.禁用)
     */
    @NotNull(message = "状态不能为空")
    private Integer status;
    /**
     * 乐观锁保留字段
     */
    private Integer version;
    /**
     * 备注
     */
    private String tips;
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    @TableField(fill = FieldFill.INSERT)
    private String createUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date editDate;

    // ==== 非数据库中字段
    /**
     * 父角色名称
     */
    @TableField(exist=false)
    private String pName;
    @TableField(exist=false)
    /**
     * 权限ids
     */
    private String permissions;

    public SysRole() {
    }

    public SysRole(String id, Integer orderNo) {
        this.id = id;
        this.orderNo = orderNo;
    }

    public SysRole(String id, String pId, Integer orderNo) {
        this.id = id;
        this.pId = pId;
        this.orderNo = orderNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}