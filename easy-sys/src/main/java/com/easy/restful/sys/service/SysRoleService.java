package com.easy.restful.sys.service;

import com.easy.restful.common.core.common.tree.Tree;
import com.easy.restful.sys.model.SysRole;

import java.util.List;

/**
 * 角色管理
 *
 * @author tengchong
 * @date 2018/11/2
 */
public interface SysRoleService {

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
     * @param id id
     * @return SysRole
     */
    SysRole get(String id);

    /**
     * 新增
     *
     * @param pId 上级id
     * @return SysRole
     */
    SysRole add(String pId);

    /**
     * 删除
     *
     * @param id 角色id
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
     * 保存
     *
     * @param object 表单内容
     * @return SysRole
     */
    SysRole saveData(SysRole object);

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
     * 根据关键字搜索角色
     *
     * @param title 关键字
     * @return List<JsTree>
     */
    List<Tree> selectByTitle(String title);

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
}