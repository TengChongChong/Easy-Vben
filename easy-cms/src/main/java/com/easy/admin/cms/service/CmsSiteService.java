package com.easy.admin.cms.service;

import com.easy.admin.cms.model.CmsSite;
import com.easy.admin.common.core.common.tree.Tree;

import java.util.List;

/**
 * 站点
 *
 * @author 系统管理员
 * @date 2023-06-19
 */
public interface CmsSiteService {
    /**
     * 查询数据（无分页）
     *
     * @param cmsSite 查询条件
     * @return List<CmsSite>
     */
    List<CmsSite> select(CmsSite cmsSite);

    /**
     * 查询所有数据（Tree）
     *
     * @return List<Tree>
     */
    List<Tree> selectAll();

    /**
     * 查询所有站点数据
     *
     * @return List<CmsSite>
     */
    List<CmsSite> selectAllSite();

    /**
     * 查询详情
     *
     * @param id id
     * @return CmsSite
     */
    CmsSite get(String id);

    /**
     * 查询详情，优先从缓存获取
     *
     * @param id id
     * @return CmsSite
     */
    CmsSite getCmsSiteUseCache(String id);

    /**
     * 新增或新增下级
     *
     * @param parentId 上级id
     * @return CmsSite
     */
    CmsSite add(String parentId);

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 保存排序
     *
     * @param cmsSiteList 排序
     * @return true/false
     */
    boolean saveOrder(List<CmsSite> cmsSiteList);

    /**
     * 保存/修改
     *
     * @param cmsSite 表单内容
     * @return CmsSite
     */
    CmsSite saveData(CmsSite cmsSite);

    /**
     * 设置用户选中站点
     *
     * @param cmsSite 站点
     * @return true/false
     */
    boolean setUserActiveSite(CmsSite cmsSite);

    /**
     * 获取用户当前选中站点
     *
     * @return 站点信息
     */
    CmsSite getUserActiveSite();

    /**
     * 导出数据
     *
     * @param cmsSite 查询条件
     * @return 文件下载id
     */
    String exportData(CmsSite cmsSite);

}
