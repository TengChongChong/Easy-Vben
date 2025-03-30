package com.easy.admin.sample.model;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.baomidou.mybatisplus.annotation.Version;
import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * 代码生成示例
 *
 * @author 系统管理员
 * @date 2025-03-21
 */
@Data
@TableName("sample_general")
public class SampleGeneral extends Model<SampleGeneral> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id;
     */
    @TableId
    private String id;
    /**
     * 父Id
     */
    private String parentId;
    /**
     * 姓名
     */
    @Excel(name = "姓名", width = 15, orderNum = "0")
    @NotBlank(message = "姓名不能为空")
    private String name;
    /**
     * 性别
     */
    @Excel(name = "性别", width = 9, orderNum = "1")
    private String sex;
    /**
     * 年龄
     */
    @Excel(name = "年龄", width = 10, orderNum = "2")
    @NotNull(message = "年龄不能为空")
    private Integer age;
    /**
     * 手机号码
     */
    @Excel(name = "手机号码", width = 15, orderNum = "3")
    @NotBlank(message = "手机号码不能为空")
    private String phone;
    /**
     * 状态
     */
    @Excel(name = "状态", width = 9, orderNum = "4")
    private String status;
    /**
     * 地址
     */
    @Excel(name = "地址", width = 25, orderNum = "5")
    private String address;
    /**
     * 排序值
     */
    @Excel(name = "排序值", width = 10, orderNum = "6")
    private Integer orderNo;
    /**
     * 乐观锁
     */
    @Version
    private Integer version;
    /**
     * 部门Id
     */
    @TableField(fill = FieldFill.INSERT)
    @Excel(name = "部门Id", width = 15, orderNum = "7")
    private String deptId;
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
}
