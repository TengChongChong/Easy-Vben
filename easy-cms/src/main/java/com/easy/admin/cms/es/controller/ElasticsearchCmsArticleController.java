package com.easy.admin.cms.es.controller;

import com.easy.admin.cms.es.model.ElasticSearchCmsArticle;
import com.easy.admin.cms.es.service.ElasticsearchCmsArticleService;
import com.easy.admin.cms.model.CmsArticle;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.core.annotation.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章搜索 Elasticsearch
 *
 * @author tengchong
 * @date 2022/1/14
 */
@RestController
@ResponseResult
public class ElasticsearchCmsArticleController {

    @Autowired
    private ElasticsearchCmsArticleService service;

    /**
     * 重新生成索引
     *
     * @param siteId 站点id
     * @return true/false
     */
    @PostMapping("/es/cms/article/rebuild/index")
    public boolean rebuildIndex(String siteId) {
        return service.rebuildIndex(siteId);
    }

    /**
     * 根据关键字查询文章
     *
     * @param siteId   站点id
     * @param keywords 关键字，多个使用空格隔开
     * @param page     分页
     * @return Page<CmsArticle>
     */
    @GetMapping("/es/cms/article/keywords")
    public Page<ElasticSearchCmsArticle> selectByKeywords(String siteId, String keywords, Page<ElasticSearchCmsArticle> page) {
        return service.selectByKeywords(siteId, keywords, page);
    }

    /**
     * 根据查询条件精确查询
     *
     * @param cmsArticle 查询条件
     * @param page       分页
     * @return List<CmsArticle>
     */
    @GetMapping("/es/cms/article/query")
    public Page<ElasticSearchCmsArticle> selectByQuery(CmsArticle cmsArticle, Page<ElasticSearchCmsArticle> page) {
        return service.selectByQuery(cmsArticle, page);
    }
}
