package com.easy.admin.cms.service;

import com.easy.admin.cms.model.CmsArticle;
import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章管理
 *
 * @author TengChongChong
 * @date 2021-11-19
 */
public interface CmsArticleService {
    /**
     * 列表
     *
     * @param object 查询条件
     * @param page   分页
     * @return Page<CmsArticle>
     */
    Page<CmsArticle> select(CmsArticle object, Page<CmsArticle> page);

    /**
     * 列表
     *
     * @param object 查询条件
     * @param page   分页
     * @return Page<CmsArticle>
     */
    Page<CmsArticle> selectForUtil(CmsArticle object, Page<CmsArticle> page);

    /**
     * 根据栏目ids获取已发布的文章 for 网站发布
     *
     * @param columnIds 栏目ids
     * @return List<CmsArticle>
     */
    List<CmsArticle> selectArticleByColumnIds(String[] columnIds);

    /**
     * 详情
     *
     * @param id id
     * @return CmsArticle
     */
    CmsArticle get(String id);

    /**
     * 新增
     *
     * @param columnId 栏目id
     * @return CmsArticle
     */
    CmsArticle add(String columnId);

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 根据站点id删除
     *
     * @param siteId 站点id
     * @return true/false
     */
    boolean removeBySiteId(String siteId);

    /**
     * 保存
     *
     * @param object 表单内容
     * @return CmsArticle
     */
    CmsArticle saveData(CmsArticle object);

    /**
     * 更改状态
     *
     * @param ids    数据ids
     * @param status 状态
     * @return true/false
     */
    boolean setStatus(String ids, String status);


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
