package com.easy.admin.auth.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

/**
 * 部门类型
 *
 * @author TengChongChong
 * @date 2018/9/4
 */
@Data
@TableName("sys_dept_type")
public class SysDeptType extends Model<SysDeptType> {

    @TableId
    private String id;
    /**
     * 父id
     */
    private String parentId;
    /**
     * 代码
     */
    @NotBlank(message = "代码不能为空")
    private String code;
    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空")
    private String name;
    /**
     * 排序值 升序
     */
    private Integer orderNo;
    /**
     * 状态
     */
    @NotNull(message = "状态不能为空")
    private String status;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 租户id
     */
    private String tenantId;
    /**
     * 乐观锁
     */
    @Version
    private Integer version;
    @TableField(fill = FieldFill.INSERT)
    private String createUser;
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date editDate;
    
    public SysDeptType() {
    }

    public SysDeptType(String id, Integer orderNo) {
        this.id = id;
        this.orderNo = orderNo;
    }

    public SysDeptType(String id, String parentId, Integer orderNo) {
        this.id = id;
        this.parentId = parentId;
        this.orderNo = orderNo;
    }
}