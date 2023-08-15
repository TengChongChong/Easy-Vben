package com.easy.admin.cms.service;

import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.cms.model.CmsArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章
 *
 * @author 系统管理员
 * @date 2023-06-21
 */
public interface CmsArticleService {
    /**
     * 查询数据
     *
     * @param cmsArticle 查询条件
     * @param page       分页
     * @return Page<CmsArticle>
     */
    Page<CmsArticle> select(CmsArticle cmsArticle, Page<CmsArticle> page);

    /**
     * 查询文章数据，用于网站预览&发布
     *
     * @param cmsArticle 查询条件
     * @param page       分页
     * @return Page<CmsArticle>
     */
    Page<CmsArticle> selectArticle(CmsArticle cmsArticle, Page<CmsArticle> page);

    /**
     * 查询指定栏目下文章数量
     *
     * @param columnIds 栏目ids
     * @return 文章数量
     */
    long countByColumnId(String columnIds);

    /**
     * 查询指定站点下文章数量
     *
     * @param siteIds 站点ids
     * @return 文章数量
     */
    long countBySiteId(String siteIds);

    /**
     * 查询详情
     *
     * @param id id
     * @return CmsArticle
     */
    CmsArticle get(String id);

    /**
     * 新增
     *
     * @return CmsArticle
     */
    CmsArticle add();

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 保存/修改
     *
     * @param cmsArticle 表单内容
     * @return CmsArticle
     */
    CmsArticle saveData(CmsArticle cmsArticle);

    /**
     * 更改状态
     *
     * @param ids    数据ids
     * @param status 状态
     * @return true/false
     */
    boolean setStatus(String ids, String status);

    /**
     * 根据栏目ids获取已发布的文章 for 网站发布
     *
     * @param columnIds 栏目ids
     * @return List<CmsArticle>
     */
    List<CmsArticle> selectArticleByColumnIds(String[] columnIds);

    /**
     * 根据文章id获取文章所属栏目
     *
     * @param id id
     * @return CmsColumn
     */
    CmsColumn getColumnByArticleId(@Param("id") String id);

    /**
     * 根据栏目id查询文章数量
     *
     * @param columnId 栏目id
     * @return 数量
     */
    int selectCountByColumnId(String columnId);

}
