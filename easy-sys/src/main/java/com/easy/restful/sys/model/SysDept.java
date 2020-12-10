package com.easy.restful.sys.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.easy.restful.sys.common.status.DeptStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 部门
 *
 * @author tengchong
 * @date 2018/9/4
 */
@TableName("sys_dept")
public class SysDept extends Model<SysDept> {

    @TableId(value="id")
    private String id;
    /**
     * 父id
     */
    private String pId;
    /**
     * 部门类型编码
     */
    @NotBlank(message = "部门类型不能为空")
    private String typeCode;
    /**
     * 部门代码
     */
    private String code;
    /**
     * 全称
     */
    @NotBlank(message = "名称不能为空")
    private String name;
    /**
     * 简称
     */
    private String simpleName;
    /**
     * 状态
     */
    @NotNull(message = "状态不能为空")
    private String status;
    /**
     * 备注
     */
    private String tips;
    /**
     * 排序值
     */
    private Integer orderNo;
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

    // ==== 非数据库中字段
    /**
     * 部门类型名称
     */
    @TableField(exist=false)
    private String typeName;
    /**
     * 上级部门名称
     */
    @TableField(exist=false)
    private String pName;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    /**
     * 部门是否可用
     *
     * @return true/false
     */
    public boolean isEnabled() {
        return DeptStatus.ENABLE.getCode().equals(this.status);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
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

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

}