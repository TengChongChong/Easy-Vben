package com.easy.admin.auth.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.auth.model.SysMenu;
import com.easy.admin.auth.model.SysRoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 角色菜单&权限
 *
 * @author TengChongChong
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
    /**
     * 根据角色id获取菜单&权限集合
     *
     * @param roleId 角色id
     * @param status 状态
     * @return List<SysMenu> 权限集合
     */
    List<SysMenu> selectMenuByRoleId(@Param("roleId") String roleId, @Param("status") String status);

    /**
     * 根据角色id获取权限数据
     *
     * @param roleId 角色id
     * @param status 权限状态
     * @return List<SysPermission>
     */
    List<SysMenu> selectSysMenuByRoleId(@Param("roleId") String roleId, @Param("status") String status);
}