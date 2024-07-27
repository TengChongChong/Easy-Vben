package com.easy.admin.auth.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.easy.admin.auth.model.SysRoleDataPermission;

/**
 * 角色数据权限
 *
 * @author 系统管理员
 * @date 2024-07-22
 */
public interface SysRoleDataPermissionMapper extends BaseMapper<SysRoleDataPermission> {

    /**
     * 查询数据（无分页）
     *
     * @param queryWrapper 查询条件
     * @return List<SysRoleDataPermission>
     */
    List<String> selectWithoutPage(@Param("ew") QueryWrapper<SysRoleDataPermission> queryWrapper);

}