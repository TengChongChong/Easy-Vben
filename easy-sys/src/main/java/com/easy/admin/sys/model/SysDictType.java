package com.easy.admin.sys.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 字典类型
 *
 * @author TengChongChong
 * @date 2018/11/4
 */
@TableName("sys_dict_type")
public class SysDictType extends Model<SysDictType> {

    @TableId(value = "id")
    private String id;
    /**
     * 类型名称
     */
    @Excel(name = "类型名称", width = 30, orderNum = "0")
    @NotBlank(message = "类型名称不能为空")
    private String name;
    /**
     * 字典类型
     */
    @Excel(name = "字典类型", width = 30, orderNum = "1")
    @NotBlank(message = "字典类型不能为空")
    private String type;
    /**
     * 状态
     */
    @Excel(name = "状态", width = 15, orderNum = "2")
    @NotNull(message = "状态不能为空")
    private String status;
    /**
     * 是否系统
     */
    @Excel(name = "是否系统", width = 15, orderNum = "3")
    private String sys;
    /**
     * 乐观锁
     */
    @Version
    private Integer version;
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    @TableField(fill = FieldFill.INSERT)
    private String createUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date editDate;
    //

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

    public String getSys() {
        return sys;
    }

    public void setSys(String sys) {
        this.sys = sys;
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

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysDictType{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", sys='" + sys + '\'' +
                ", version=" + version +
                ", createDate=" + createDate +
                ", createUser='" + createUser + '\'' +
                ", editUser='" + editUser + '\'' +
                ", editDate=" + editDate +
                '}';
    }
}