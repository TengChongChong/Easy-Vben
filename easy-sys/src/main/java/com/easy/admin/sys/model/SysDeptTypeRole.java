package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 配置部门类型可以选择那些角色
 *
 * @author TengChongChong
 * @date 2018/9/4
 */
@TableName("sys_dept_type_role")
public class SysDeptTypeRole extends Model<SysDeptTypeRole> {

    @TableId(value = "id")
    private String id;
    /**
     * 部门类型id
     */
    private String deptTypeId;
    /**
     * 角色id
     */
    private String roleId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeptTypeId() {
        return deptTypeId;
    }

    public void setDeptTypeId(String deptTypeId) {
        this.deptTypeId = deptTypeId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }
}