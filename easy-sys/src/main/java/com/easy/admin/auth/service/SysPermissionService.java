package com.easy.admin.auth.service;

import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.auth.model.SysPermission;

import java.util.List;

/**
 * 权限/菜单管理
 *
 * @author TengChongChong
 * @date 2018/11/27
 */
public interface SysPermissionService {
    /**
     * 根据父id获取数据
     *
     * @param sysPermission 查询条件
     * @return List<SysPermission>
     */
    List<SysPermission> select(SysPermission sysPermission);

    /**
     * 获取所有数据
     *
     * @return List<JsTree>
     */
    List<Tree> selectAll();

    /**
     * 详情
     *
     * @param id 权限id
     * @return SysPermissions
     */
    SysPermission get(String id);

    /**
     * 新增
     *
     * @param parentId 上级id
     * @return SysPermissions
     */
    SysPermission add(String parentId);

    /**
     * 删除
     *
     * @param ids ids
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 设置状态
     *
     * @param id     角色id
     * @param status 状态
     * @param type   菜单类型
     * @return true/false
     */
    boolean setStatus(String id, String status, String type);

    /**
     * 保存
     *
     * @param sysPermission 表单内容
     * @return SysPermissions
     */
    SysPermission saveData(SysPermission sysPermission);

    /**
     * 保存排序
     *
     * @param sysPermissionList 排序
     * @return true/false
     */
    boolean saveOrder(List<SysPermission> sysPermissionList);

    /**
     * 检查是否有此标题的菜单
     *
     * @param title 标题
     * @return true/false
     */
    boolean hasMenu(String title);

}