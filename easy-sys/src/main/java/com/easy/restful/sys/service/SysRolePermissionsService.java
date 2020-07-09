package com.easy.restful.sys.service;

import com.easy.restful.sys.model.SysRolePermissions;

import java.util.List;

/**
 * 角色权限
 *
 * @author tengchong
 * @date 2020/7/9
 */
public interface SysRolePermissionsService {
    /**
     * 查询所有角色权限
     *
     * @return List<SysRolePermissions>
     */
    List<SysRolePermissions> selectAll();
}
