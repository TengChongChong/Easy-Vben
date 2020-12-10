package com.easy.restful.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.restful.sys.model.SysPermissions;
import com.easy.restful.sys.model.SysRolePermissions;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 角色权限
 * @author tengchong
 */
public interface SysRolePermissionsMapper extends BaseMapper<SysRolePermissions> {
    /**
     * 根据角色id获取权限集合
     *
     * @param roleId 角色id
     * @param  status 状态
     * @return List<SysPermissions> 权限集合
     */
    List<SysPermissions> selectPermissionsByRoleId(@Param("roleId") String roleId, @Param("status") String status);

}