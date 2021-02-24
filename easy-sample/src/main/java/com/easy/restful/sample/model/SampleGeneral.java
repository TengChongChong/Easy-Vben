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
import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * 代码生成示例
 *
 * @author 系统管理员
 * @date 2021-02-23
 */
@TableName("sample_general")
public class SampleGeneral extends Model<SampleGeneral> {

    @TableId(value = "id")
    
    private String id;
    /**
     * 姓名
     */
    @Excel(name = "姓名", orderNum = "0")    
    private String name;
    /**
     * 性别
     */
    @Excel(name = "性别", orderNum = "1")    
    private String sex;
    /**
     * 年龄
     */
    @Excel(name = "年龄", orderNum = "2")    
    private Integer age;
    /**
     * 手机号码
     */
    @Excel(name = "手机号码", orderNum = "3")    
    private String phone;
    /**
     * 状态
     */
    @Excel(name = "状态", orderNum = "4")    
    private Integer status;
    /**
     * 地址
     */
    @Excel(name = "地址", orderNum = "5")    
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
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}
