package com.easy.restful.sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 角色权限
 *
 * @author tengchong
 * @date 2018/9/4
 */

@TableName("sys_role_permissions")
public class SysRolePermissions extends Model<SysRolePermissions> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private String id;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 权限id
     */
    private String permissionsId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionsId() {
        return permissionsId;
    }

    public void setPermissionsId(String permissionsId) {
        this.permissionsId = permissionsId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysRolePermissions{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", permissionsId=" + permissionsId +
                '}';
    }
}