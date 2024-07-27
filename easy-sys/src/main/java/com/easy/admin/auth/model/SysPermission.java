package com.easy.admin.auth.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 权限
 *
 * @author TengChongChong
 * @date 2018/9/4
 */
@Data
@TableName("sys_permission")
public class SysPermission extends Model<SysPermission> {

    private static final long serialVersionUID = 1L;

    @TableId
    private String id;
    /**
     * 父id
     */
    private String parentId;
    /**
     * 类型
     */
    @NotNull(message = "类型不能为空")
    private String type;
    /**
     * 名称
     */
    @NotNull(message = "名称不能为空")
    private String title;
    /**
     * 组件名称
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    /**
     * 标识
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String code;
    /**
     * 图标
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String icon;
    /**
     * 地址
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String path;
    /**
     * 组件路径
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String component;
    /**
     * 是否外链
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String external;
    /**
     * 排序值
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer orderNo;
    /**
     * 是否显示
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String display;
    /**
     * 打开方式
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String openMode;
    /**
     * 状态
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "状态不能为空")
    private String status;
    /**
     * 备注
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String remarks;
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

    public SysPermission() {
    }

    public SysPermission(String id) {
        this.id = id;
    }

    public SysPermission(String id, Integer orderNo) {
        this.id = id;
        this.orderNo = orderNo;
    }

    public SysPermission(String id, String parentId, Integer orderNo) {
        this.id = id;
        this.parentId = parentId;
        this.orderNo = orderNo;
    }
}