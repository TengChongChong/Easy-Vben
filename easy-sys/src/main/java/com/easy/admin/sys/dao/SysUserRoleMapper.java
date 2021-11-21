package com.easy.admin.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.sys.model.SysPermissions;
import com.easy.admin.sys.model.SysUserRole;
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
     * @param userId          用户id
     * @param status          状态
     * @return List<String> 权限集合
     */
    List<String> selectPermissionsByUserId(@Param("userId") String userId, @Param("status") String status);

    /**
     * 根据用户id获取菜单集合
     *
     * @param userId 用户id
     * @param status 状态
     * @param type   类型
     * @return List<String> 权限集合
     */
    List<SysPermissions> selectMenusByUserId(@Param("userId") String userId, @Param("status") String status, @Param("type") String type);

    /**
     * 根据角色id获取角色集合
     *
     * @param userId 用户id
     * @param status 状态
     * @return List<String> 角色集合
     */
    List<String> selectRoleByUserId(@Param("userId") String userId, @Param("status") String status);

    /**
     * 根据角色id获取角色id集合
     *
     * @param userId 用户id
     * @param status 状态
     * @return List<String> 角色集合
     */
    List<String> selectRoleIdByUserId(@Param("userId") String userId, @Param("status") String status);

    /**
     * 根据角色id获取角色名称集合
     *
     * @param userId 用户id
     * @param status 状态
     * @return List<String> 角色集合
     */
    List<String> selectRoleNameByUserId(@Param("userId") String userId, @Param("status") String status);

}