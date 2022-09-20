package com.easy.admin.auth.service;

import com.easy.admin.auth.model.SysRole;
import com.easy.admin.common.core.common.pagination.Page;

import java.util.List;

/**
 * 角色管理
 *
 * @author TengChongChong
 * @date 2018/11/2
 */
public interface SysRoleService {

    /**
     * 查询
     *
     * @param sysRole 查询条件
     * @param page 分页
     * @return Page<SysRole>
     */
    Page<SysRole> select(SysRole sysRole, Page<SysRole> page);

    /**
     * 获取所有数据
     *
     * @return List<SysRole>
     */
    List<SysRole> selectAll();

    /**
     * 详情
     *
     * @param id id
     * @return SysRole
     */
    SysRole get(String id);

    /**
     * 新增
     *
     * @return SysRole
     */
    SysRole add();

    /**
     * 删除
     *
     * @param ids String ids 示例 1,2,3,4
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 设置状态
     *
     * @param ids    id
     * @param status 状态
     * @return true/false
     */
    boolean setStatus(String ids, String status);

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysRole
     */
    SysRole saveData(SysRole object);

    /**
     * 根据用户id获取角色标识
     *
     * @param userId 用户id
     * @return 角色标识
     */
    List<String> selectRoleCodeByUserId(String userId);

    /**
     * 查询所有权限标识
     *
     * @return List<String>
     */
    List<String> selectAllRoleCodes();

    /**
     * 查询所有权限 Activiti
     *
     * @param sysRole  查询条件
     * @param isSelect 是否为查找
     * @return List<SysRole>
     */
    List<SysRole> selectRole(SysRole sysRole, boolean isSelect);

    /**
     * 根据部门类型获取可分配的角色数据
     *
     * @param deptId 部门id
     * @return List<SysRole>
     */
    List<SysRole> selectRoleByDept(String deptId);
}