package com.easy.admin.auth.service;

import com.easy.admin.auth.model.SysMenu;

import java.util.List;

/**
 * 角色菜单管理
 *
 * @author TengChongChong
 * @date 2018/11/27
 */
public interface SysRoleMenuService {


    /**
     * 保存角色菜单
     *
     * @param roleId  角色id
     * @param menuIds 菜单ids
     * @return true/false
     */
    boolean saveRoleMenu(String roleId, List<String> menuIds);

    /**
     * 根据角色删除角色菜单
     *
     * @param roleIds 角色ids
     * @return true/false
     */
    boolean removeByRoleId(String roleIds);

    /**
     * 删除角色中的菜单
     *
     * @param menuIds 菜单ids 1,2,3,4
     * @return true/false
     */
    boolean removeRoleMenu(String menuIds);

    /**
     * 根据角色id获取菜单数据
     *
     * @param roleId 角色id
     * @return List<SysMenu>
     */
    List<SysMenu> selectSysMenuByRoleId(String roleId);
}