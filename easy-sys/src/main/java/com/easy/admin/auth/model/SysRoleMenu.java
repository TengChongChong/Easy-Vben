package com.easy.admin.auth.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 角色权限
 *
 * @author TengChongChong
 * @date 2018/9/4
 */
@Data
@TableName("sys_role_menu")
public class SysRoleMenu extends Model<SysRoleMenu> {

    @TableId
    private String id;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 权限id
     */
    private String menuId;
}