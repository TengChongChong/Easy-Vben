package com.easy.admin.cms.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.cms.model.CmsArticle;

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

}
