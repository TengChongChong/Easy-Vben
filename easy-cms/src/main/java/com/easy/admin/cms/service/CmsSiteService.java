package com.easy.admin.cms.service;

import com.easy.admin.cms.model.CmsSite;
import com.easy.admin.common.core.common.tree.Tree;

import java.util.List;

/**
 * 站点
 *
 * @author TengChongChong
 * @date 2021-11-18
 */
public interface CmsSiteService {
    /**
     * 根据父id获取数据
     *
     * @param pId 父id
     * @return List<JsTree>hotNews/list
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
     * @return CmsSite
     */
    CmsSite get(String id);

    /**
     * 新增
     *
     * @param pId 上级id
     * @return CmsSite
     */
    CmsSite add(String pId);

    /**
     * 删除
     *
     * @param id id
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
     * @return List<CmsSite>
     */
    List<CmsSite> copyNode(String nodeIds, String targetId);

    /**
     * 保存
     *
     * @param object 表单内容
     * @return CmsSite
     */
    CmsSite saveData(CmsSite object);

    /**
     * 拖动改变目录或顺序
     *
     * @param id          拖动的id
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
     * 检查是否已存在
     *
     * @param name 名称
     * @return true/false
     */
    boolean checkMenuIsHaving(String name);
}
