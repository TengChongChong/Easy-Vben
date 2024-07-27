package com.easy.admin.sys.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 字典
 *
 * @author TengChongChong
 * @date 2018/11/4
 */
@Data
@TableName("sys_dict")
public class SysDict extends Model<SysDict> {

    private static final long serialVersionUID = 1L;

    @TableId
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    /**
     * 名称
     */
    @Excel(name = "名称", width = 30, orderNum = "0")
    @NotBlank(message = "名称不能为空")
    private String name;
    /**
     * 编码
     */
    @Excel(name = "编码", width = 30, orderNum = "1")
    @NotBlank(message = "编码不能为空")
    private String code;
    /**
     * 父code
     */
    @Excel(name = "上级编码", width = 30, orderNum = "2")
    private String parentCode;
    /**
     * 字典类型
     */
    @Excel(name = "字典类型", width = 30, orderNum = "3")
    @NotBlank(message = "字典类型不能为空")
    private String dictType;
    /**
     * 图标
     */
    @Excel(name = "图标", width = 30, orderNum = "4")
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String icon;
    /**
     * 显示方式
     */
    @Excel(name = "显示方式", width = 30, orderNum = "5")
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String displayType;

    /**
     * 状态
     */
    @Excel(name = "状态", width = 15, orderNum = "6")
    @NotNull(message = "状态不能为空")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String status;
    /**
     * 备注
     */
    @Excel(name = "备注", width = 30, orderNum = "8")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String remarks;
    /**
     * 排序值
     */
    @Excel(name = "排序值", width = 15, orderNum = "7")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer orderNo;
    /**
     * 乐观锁
     */
    @Version
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer version;
    @TableField(fill = FieldFill.INSERT)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date createDate;
    @TableField(fill = FieldFill.INSERT)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String editUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date editDate;

    //
    /**
     * 父字典名称
     */
    @TableField(exist = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String parentName;
    /**
     * 字典类型名称
     */
    @TableField(exist = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String dictTypeName;

}