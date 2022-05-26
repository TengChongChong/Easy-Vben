package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统参数
 *
 * @author TengChongChong
 * @date 2019-03-03 23:13:03
 */
 @TableName("sys_config")
public class SysConfig extends Model<SysConfig> implements Serializable{
    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private String id;

    /**
     * key
     */
    @NotBlank(message = "key不能为空")
    private String sysKey;

    /**
     * value
     */
    @NotBlank(message = "value不能为空")
    private String value;

    /**
     * 类型
     */
    @NotBlank(message = "类型不能为空")
    private String type;

    /**
     * 是否系统
     */
    private String sys;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createUser;

    /**
     * 编辑时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date editDate;

    /**
     * 编辑人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUser;

    //

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSysKey() {
        return sysKey;
    }

    public void setSysKey(String sysKey) {
        this.sysKey = sysKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSys() {
        return sys;
    }

    public void setSys(String sys) {
        this.sys = sys;
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

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public String getEditUser() {
        return editUser;
    }

    public void setEditUser(String editUser) {
        this.editUser = editUser;
    }
}
