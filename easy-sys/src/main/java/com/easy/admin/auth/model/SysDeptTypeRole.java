package com.easy.admin.auth.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 配置部门类型可以选择那些角色
 *
 * @author TengChongChong
 * @date 2018/9/4
 */
@Data
@TableName("sys_dept_type_role")
public class SysDeptTypeRole extends Model<SysDeptTypeRole> {

    @TableId
    private String id;
    /**
     * 部门类型id
     */
    private String deptTypeId;
    /**
     * 角色id
     */
    private String roleId;
}