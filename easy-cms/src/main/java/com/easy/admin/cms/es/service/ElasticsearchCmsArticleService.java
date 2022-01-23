package com.easy.admin.cms.es.service;

import com.easy.admin.cms.es.model.ElasticSearchCmsArticle;
import com.easy.admin.cms.model.CmsArticle;
import com.easy.admin.common.core.common.pagination.Page;

/**
 * 文章搜索 Elasticsearch
 *
 * @author tengchong
 * @date 2022/1/14
 */
public interface ElasticsearchCmsArticleService {

    /**
     * 删除索引
     *
     * @param siteId 站点id
     * @return true/false
     */
    boolean deleteIndex(String siteId);

    /**
     * 重新生成索引
     *
     * @param siteId 站点id
     * @return true/false
     */
    boolean rebuildIndex(String siteId);

    /**
     * 更新文章索引
     *
     * @param cmsArticle 文章信息
     * @return true/false
     */
    boolean saveOrUpdate(CmsArticle cmsArticle);

    /**
     * 删除文章索引
     *
     * @param siteId    站点id
     * @param articleId 文章id
     * @return true/false
     */
    boolean deleteDoc(String siteId, String articleId);

    /**
     * 根据关键字查询文章
     *
     * @param siteId   站点id
     * @param keywords 关键字，多个使用空格隔开
     * @param page     分页
     * @return Page<ElasticSearchCmsArticle>
     */
    Page<ElasticSearchCmsArticle> selectByKeywords(String siteId, String keywords, Page<ElasticSearchCmsArticle> page);

    /**
     * 根据查询条件精确查询
     *
     * @param cmsArticle 查询条件
     * @param page       分页
     * @return Page<ElasticSearchCmsArticle>
     */
    Page<ElasticSearchCmsArticle> selectByQuery(CmsArticle cmsArticle, Page<ElasticSearchCmsArticle> page);
}
