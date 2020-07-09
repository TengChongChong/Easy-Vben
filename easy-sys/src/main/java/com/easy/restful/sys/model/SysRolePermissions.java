package com.easy.restful.sys.model;

import com.baomidou.mybatisplus.annotation.TableField;
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

    // ==== 非数据库中字段
    /**
     * 角色标识
     */
    @TableField(exist = false)
    private String roleCode;
    /**
     * url
     */
    @TableField(exist = false)
    private String url;
    /**
     * http methods
     */
    @TableField(exist = false)
    private String httpMethods;


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

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHttpMethods() {
        return httpMethods;
    }

    public void setHttpMethods(String httpMethods) {
        this.httpMethods = httpMethods;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}