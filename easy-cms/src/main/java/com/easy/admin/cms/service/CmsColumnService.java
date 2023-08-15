package com.easy.admin.cms.service;

import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.common.core.common.tree.Tree;

import java.util.List;

/**
 * 栏目
 *
 * @author 系统管理员
 * @date 2023-06-19
 */
public interface CmsColumnService {
    /**
     * 查询数据（无分页）
     *
     * @param cmsColumn 查询条件
     * @return List<CmsColumn>
     */
    List<CmsColumn> select(CmsColumn cmsColumn);

    /**
     * 查询所有数据（Tree）
     *
     * @return List<Tree>
     */
    List<Tree> selectAll();

    /**
     * 查询指定站点下栏目数量
     *
     * @param siteIds 站点ids
     * @return 文章数量
     */
    long countBySiteId(String siteIds);

    /**
     * 查询详情
     *
     * @param id id
     * @return CmsColumn
     */
    CmsColumn get(String id);

    /**
     * 查询详情，优先从缓存获取
     *
     * @param siteId 站点id
     * @param id     id
     * @return CmsColumn
     */
    CmsColumn getCmsColumnUseCache(String siteId, String id);

    /**
     * 根据站点id与别名获取栏目信息
     *
     * @param siteId 站点id
     * @param slug   别名
     * @return CmsColumn
     */
    CmsColumn getBySlug(String siteId, String slug);

    /**
     * 新增或新增下级
     *
     * @param parentId 上级id
     * @return CmsColumn
     */
    CmsColumn add(String parentId);

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
     * @param cmsColumnList 排序
     * @return true/false
     */
    boolean saveOrder(List<CmsColumn> cmsColumnList);

    /**
     * 保存/修改
     *
     * @param cmsColumn 表单内容
     * @return CmsColumn
     */
    CmsColumn saveData(CmsColumn cmsColumn);

    /**
     * 导出数据
     *
     * @param cmsColumn 查询条件
     * @return 文件下载id
     */
    String exportData(CmsColumn cmsColumn);

    /**
     * 查询栏目数据 for 网站发布
     *
     * @param ids ids
     * @return List<CmsColumn>
     */
    List<CmsColumn> selectCmsColumns(String[] ids);

}
