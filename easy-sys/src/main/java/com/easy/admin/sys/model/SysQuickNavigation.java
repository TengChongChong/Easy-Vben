package com.easy.admin.sys.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 快捷导航
 *
 * @author 系统管理员
 * @date 2025-07-09
 */
@Data
@TableName("sys_quick_navigation")
public class SysQuickNavigation extends Model<SysQuickNavigation> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private String id;
    /**
     * 名称
     */
    @Excel(name = "名称", width = 15, orderNum = "0")
    @NotBlank(message = "名称不能为空")
    private String name;
    /**
     * 地址
     */
    @Excel(name = "地址", width = 25, orderNum = "1")
    @NotBlank(message = "地址不能为空")
    private String url;
    /**
     * 图标
     */
    @Excel(name = "图标", width = 15, orderNum = "2")
    private String icon;
    /**
     * 颜色
     */
    @Excel(name = "颜色", width = 15, orderNum = "3")
    private String color;
    /**
     * 排序值
     */
    @Excel(name = "排序值", width = 10, orderNum = "4")
    @NotNull(message = "排序值不能为空")
    private Integer orderNo;
    /**
     * 状态
     */
    @Excel(name = "状态", width = 9, orderNum = "5")
    private String status;
    /**
     * 乐观锁
     */
    @Version
    private Integer version;
    /**
     * 部门Id
     */
    @TableField(fill = FieldFill.INSERT)
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
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUser;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date editDate;
}
