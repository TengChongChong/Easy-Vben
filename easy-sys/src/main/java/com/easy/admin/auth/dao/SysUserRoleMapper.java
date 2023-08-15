package com.easy.admin.auth.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.auth.model.SysPermission;
import com.easy.admin.auth.model.SysRole;
import com.easy.admin.auth.model.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户角色
 *
 * @author TengChongChong
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    /**
     * 根据用户id获取权限集合
     *
     * @param userId 用户id
     * @param status 状态
     * @return List<String> 权限集合
     */
    List<String> selectPermissionCodesByUserId(@Param("userId") String userId, @Param("status") String status);

    /**
     * 根据用户id获取菜单集合
     *
     * @param userId 用户id
     * @param status 状态
     * @return List<String> 权限集合
     */
    List<SysPermission> selectPermissionByUserId(@Param("userId") String userId, @Param("status") String status);

    /**
     * 根据用户id获取角色名称集合
     *
     * @param userId 用户id
     * @param status 状态
     * @return List<String> 角色集合
     */
    List<SysRole> selectRoleByUserId(@Param("userId") String userId, @Param("status") String status);

    /**
     * 根据用户id获取可分配的角色集合
     *
     * @param userId 用户id
     * @param status 状态
     * @return List<String> 角色集合
     */
    List<String> selectAllRoleByUserId(@Param("userId") String userId, @Param("status") String status);
}