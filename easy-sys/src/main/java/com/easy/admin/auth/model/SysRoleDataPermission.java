package com.easy.admin.auth.model;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.Version;

/**
 * 角色数据权限
 *
 * @author 系统管理员
 * @date 2024-07-22
 */
@Data
@TableName("sys_role_data_permission")
public class SysRoleDataPermission extends Model<SysRoleDataPermission> implements Serializable {

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
     * 部门Id
     */
    private String deptId;

    // 非表字段


    public SysRoleDataPermission() {
    }

    public SysRoleDataPermission(String roleId, String deptId) {
        this.roleId = roleId;
        this.deptId = deptId;
    }
}
