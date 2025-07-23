package com.easy.admin.auth.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 角色快捷导航
 *
 * @author 系统管理员
 * @date 2025-07-09
 */
@Data
@TableName("sys_role_quick_navigation")
public class SysRoleQuickNavigation extends Model<SysRoleQuickNavigation> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private String id;
    /**
     * 角色Id
     */
    private String roleId;
    /**
     * 快捷导航Id
     */
    private String navigationId;
}
