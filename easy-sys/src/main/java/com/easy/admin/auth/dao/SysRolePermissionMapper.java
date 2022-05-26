package com.easy.admin.auth.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.auth.model.SysPermission;
import com.easy.admin.auth.model.SysRolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 角色权限
 * @author TengChongChong
 */
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {
    /**
     * 根据角色id获取权限集合
     *
     * @param roleId 角色id
     * @param  status 状态
     * @return List<SysPermissions> 权限集合
     */
    List<SysPermission> selectPermissionsByRoleId(@Param("roleId") String roleId, @Param("status") String status);

}