package com.easy.restful.sample.model;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 代码生成示例
 *
 * @author 系统管理员
 * @date 2021-01-25
 */
@TableName("sample_general")
public class SampleGeneral extends Model<SampleGeneral> {

    @TableId(value = "id")
    private String id;

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    private String name;

    /**
     * 性别
     */
    @NotBlank(message = "性别不能为空")
    private String sex;

    /**
     * 手机号码
     */
    @NotBlank(message = "手机号码不能为空")
    private String phone;

    /**
     * 地址
     */
    private String address;

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

    /**
     * 编辑人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUser;

    /**
     * 编辑时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date editDate;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 年龄
     */
    private Integer age;

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
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
