package com.easy.admin.sys.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

/**
 * 字典类型
 *
 * @author TengChongChong
 * @date 2018/11/4
 */
@Data
@TableName("sys_dict_type")
public class SysDictType extends Model<SysDictType> {

    @TableId
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

}