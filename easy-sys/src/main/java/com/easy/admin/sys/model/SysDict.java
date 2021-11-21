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
 * 字典
 *
 * @author TengChongChong
 * @date 2018/11/4
 */
@TableName("sys_dict")
public class SysDict extends Model<SysDict> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private String id;
    /**
     * 排序值
     */
    private Integer orderNo;
    /**
     * 父code
     */
    private String pCode;
    /**
     * 编码
     */
    @NotBlank(message = "编码不能为空")
    private String code;
    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空")
    private String name;
    /**
     * 图标
     */
    private String icon;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 状态
     */
    @NotNull(message = "状态不能为空")
    private String status;
    /**
     * 字典类型
     */
    @NotBlank(message = "类型不能为空")
    private String dictType;
    /**
     * css
     */
    private String css;
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    @TableField(fill = FieldFill.INSERT)
    private String createUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date editDate;

    //
    /**
     * 父字典名称
     */
    @TableField(exist=false)
    private String parentName;
    /**
     * 字典类型名称
     */
    @TableField(exist=false)
    private String dictTypeName;

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

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictTypeName() {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName;
    }

    @Override
    public String toString() {
        return "SysDict{" +
                "id=" + id +
                ", orderNo=" + orderNo +
                ", pCode=" + pCode +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", icon='" + icon + '\'' +
                ", remarks='" + remarks + '\'' +
                ", status=" + status +
                ", dictType='" + dictType + '\'' +
                ", createDate=" + createDate +
                ", createUser=" + createUser +
                ", editUser=" + editUser +
                ", editDate=" + editDate +
                ", css='" + css + '\'' +
                '}';
    }
}