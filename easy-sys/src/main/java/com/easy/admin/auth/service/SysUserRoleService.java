package com.easy.admin.auth.service;

import com.easy.admin.auth.model.SysPermission;
import com.easy.admin.auth.model.SysRole;

import java.util.List;

/**
 * 用户角色管理
 *
 * @author TengChongChong
 * @date 2018/12/6
 */
public interface SysUserRoleService {
    /**
     * 保存用户拥有的角色
     *
     * @param userId 用户id
     * @param roles  角色ids 1,2,3,4,5
     * @return boolean
     */
    boolean saveUserRole(String userId, List<String> roles);

    /**
     * 删除用户拥有的角色
     *
     * @param userIds 用户ids
     * @return boolean
     */
    boolean deleteUserRoleByUserIds(String userIds);


    /**
     * 删除用户拥有的角色
     *
     * @param roles 角色ids 1,2,3,4,5
     * @return boolean
     */
    boolean deleteUserRole(String roles);

    /**
     * 根据用户id获取菜单集合
     *
     * @param userId 用户id
     * @return 菜单集合
     */
    List<SysPermission> selectPermissionByUserId(String userId);

    /**
     * 根据用户id获取角色名称集合
     *
     * @param userId 用户id
     * @return 角色集合
     */
    List<SysRole> selectRoleByUserId(String userId);
}