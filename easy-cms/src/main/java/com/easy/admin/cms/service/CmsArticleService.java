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
    CmsArticle input(String id);

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
     * 保存
     *
     * @param object 表单内容
     * @return CmsArticle
     */
    CmsArticle saveData(CmsArticle object);

}
