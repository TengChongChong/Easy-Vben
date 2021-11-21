package com.easy.admin.sys.service;

import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.sys.model.SysPermissions;

import java.util.List;

/**
 * 权限/菜单管理
 *
 * @author TengChongChong
 * @date 2018/11/27
 */
public interface SysPermissionsService {
    /**
     * 根据父id获取数据
     *
     * @param pId 父id
     * @return List<JsTree>
     */
    List<Tree> selectByPId(String pId);

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
    SysPermissions get(String id);

    /**
     * 新增
     *
     * @param pId 上级id
     * @return SysPermissions
     */
    SysPermissions add(String pId);

    /**
     * 删除
     *
     * @param id 权限id
     * @return true/false
     */
    boolean remove(String id);

    /**
     * 批量删除
     *
     * @param ids String ids 示例 1,2,3,4
     * @return true/false
     */
    boolean batchRemove(String ids);

    /**
     * 设置状态
     *
     * @param ids    角色id
     * @param status 状态
     * @return true/false
     */
    boolean setStatus(String ids, String status);

    /**
     * 复制节点到目标id
     *
     * @param nodeIds  String 复制的节点ids [1,2,3]
     * @param targetId String 目标节点id
     * @return List<SysPermissions>
     */
    List<SysPermissions> copyNode(String nodeIds, String targetId);

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysPermissions
     */
    SysPermissions saveData(SysPermissions object);

    /**
     * 拖动菜单/权限改变目录或顺序
     *
     * @param id          拖动的菜单/权限id
     * @param parent      拖动后的父id
     * @param oldParent   拖动前的id
     * @param position    拖动前的下标
     * @param oldPosition 拖动后的下标
     * @return true/false
     */
    boolean move(String id, String parent, String oldParent, Integer position, Integer oldPosition);

    /**
     * 根据关键字搜索
     *
     * @param title 关键字
     * @return List<JsTree>
     */
    List<Tree> selectByTitle(String title);

    /**
     * 检查菜单是否已存在
     *
     * @param name 菜单名称
     * @return true/false
     */
    boolean checkMenuIsHaving(String name);
}