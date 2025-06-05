package com.easy.admin.auth.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 菜单
 *
 * @author 系统管理员
 * @date 2025-03-21
 */
@Data
@TableName("sys_menu")
public class SysMenu extends Model<SysMenu> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private String id;
    /**
     * 父Id
     */
    private String parentId;
    /**
     * 类型
     */
    private String type;
    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空")
    private String title;
    /**
     * 权限标识
     */
    private String authCode;
    /**
     * 路由地址
     */
    private String path;
    /**
     * 激活路径
     */
    private String activePath;
    /**
     * 图标
     */
    private String icon;
    /**
     * 激活图标
     */
    private String activeIcon;
    /**
     * 页面组件
     */
    private String component;
    /**
     * 组件Name
     */
    private String name;
    /**
     * 链接地址
     */
    private String linkSrc;
    /**
     * 路由参数，JSON 格式，将用于 route.meta.query
     */
    private String query;
    /**
     * 徽标类型
     */
    private String badgeType;
    /**
     * 徽标内容
     */
    private String badge;
    /**
     * 徽标样式
     */
    private String badgeVariants;
    /**
     * 缓存标签页
     */
    private String keepAlive;
    /**
     * 固定在标签栏
     */
    private String affixTab;
    /**
     * 隐藏菜单
     */
    private String hideInMenu;
    /**
     * 隐藏子菜单
     */
    private String hideChildrenInMenu;
    /**
     * 在面包屑中隐藏
     */
    private String hideInBreadcrumb;
    /**
     * 在标签栏中隐藏
     */
    private String hideInTab;
    /**
     * 排序值
     */
    private Integer orderNo;
    /**
     * 状态
     */
    private String status;
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
