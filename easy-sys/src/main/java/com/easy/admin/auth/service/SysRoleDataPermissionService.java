package com.easy.admin.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.easy.admin.auth.model.SysRole;
import com.easy.admin.auth.model.SysRoleDataPermission;
import com.easy.admin.config.mybatis.plugins.model.DataPermission;

import java.util.List;

/**
 * 角色数据权限
 *
 * @author 系统管理员
 * @date 2024-07-22
 */
public interface SysRoleDataPermissionService extends IService<SysRoleDataPermission> {

    /**
     * 查询数据（无分页）
     *
     * @param roleId roleId
     * @return List<String> deptIds
     */
    List<String> selectDeptByRoleId(String roleId);

    /**
     * 根据roleId删除
     *
     * @param roleIds roleIds
     * @return true/false
     */
    boolean removeByRoleId(String roleIds);

    /**
     * 批量保存
     *
     * @param roleId  roleId
     * @param deptIds deptIds
     * @return true/false
     */
    boolean saveBatchData(String roleId, List<String> deptIds);

    /**
     * 将角色数据权限汇总，并按照数据范围合并
     *
     * @param roleList 角色
     * @return 数据权限
     */
    List<DataPermission> convertToDataPermission(List<SysRole> roleList);
}
