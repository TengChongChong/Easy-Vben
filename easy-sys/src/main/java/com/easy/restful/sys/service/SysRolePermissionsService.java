package com.easy.restful.sys.service;

import java.util.List;

/**
 * 角色权限管理
 *
 * @author tengchong
 * @date 2018/11/27
 */
public interface SysRolePermissionsService {
    /**
     * 保存角色权限
     *
     * @param roleId      角色id
     * @param permissions 权限ids
     * @return boolean
     */
    boolean saveRolePermissions(String roleId, List<String> permissions);

    /**
     * 删除角色中的权限
     *
     * @param permissions 权限ids 1,2,3,4
     * @return
     */
    boolean removeRolePermissions(String permissions);

}