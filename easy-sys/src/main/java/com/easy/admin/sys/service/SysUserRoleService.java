package com.easy.admin.sys.service;

import com.easy.admin.sys.model.SysPermissions;

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
     * 根据用户id获取权限集合
     *
     * @param userId 用户id
     * @return 权限集合
     */
    List<String> selectPermissionsByUserId(String userId);

    /**
     * 根据用户id获取菜单集合
     *
     * @param userId          用户id
     * @return 菜单集合
     */
    List<SysPermissions> selectMenusByUserId(String userId);

    /**
     * 根据角色id获取角色集合
     *
     * @param userId 用户id
     * @return 角色集合
     */
    List<String> selectRoleByUserId(String userId);

    /**
     * 根据角色id获取角色id集合
     *
     * @param userId 用户id
     * @return 角色集合
     */
    List<String> selectRoleIdByUserId(String userId);

    /**
     * 根据角色id获取角色名称集合
     *
     * @param userId 用户id
     * @return 角色集合
     */
    List<String> selectRoleNameByUserId(String userId);
}