package com.easy.restful.sys.service;

import com.easy.restful.sys.model.SysRole;

import java.util.List;

/**
 * 部门类型可选择的角色
 *
 * @author tengchong
 * @date 2018/12/3
 */
public interface SysDeptTypeRoleService {
    /**
     * 保存部门类型可选择的角色
     *
     * @param deptTypeId 部门类型id
     * @param roles      角色ids 1,2,3,4,5
     * @return true/false
     */
    boolean saveDeptTypeRole(String deptTypeId, List<String> roles);

    /**
     * 删除部门类型可选择的角色
     *
     * @param deptTypeIds 部门类型ids
     * @return true/false
     */
    boolean removeDeptTypeRoleByDeptTypeIds(String deptTypeIds);

    /**
     * 删除部门类型可选择的角色
     *
     * @param roles 角色ids 1,2,3,4,5
     * @return true/false
     */
    boolean removeDeptTypeRole(String roles);

    /**
     * 根据部门类型获取可分配的角色数据
     *
     * @param deptId 部门类型id
     * @return List<JsTree>
     */
    List<SysRole> selectRoleByDept(String deptId);
}