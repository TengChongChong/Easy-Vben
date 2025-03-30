package com.easy.admin.auth.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.util.Date;

/**
 * 部门
 *
 * @author TengChongChong
 * @date 2018/9/4
 */
@Data
@TableName("sys_dept")
public class SysDept extends Model<SysDept> {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId
    private String id;
    /**
     * 父id
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String parentId;
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
     * 部门代码
     */
    private String code;
    /**
     * 部门类型编码
     */
    @NotBlank(message = "部门类型不能为空")
    private String typeCode;
    /**
     * 状态
     */
    @NotNull(message = "状态不能为空")
    private String status;
    /**
     * 备注
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String remarks;
    /**
     * 排序值
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer orderNo;
    /**
     * 租户id
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tenantId;
    /**
     * 乐观锁
     */
    @Version
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createUser;

    @TableField(fill = FieldFill.INSERT)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date createDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String editUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date editDate;

}