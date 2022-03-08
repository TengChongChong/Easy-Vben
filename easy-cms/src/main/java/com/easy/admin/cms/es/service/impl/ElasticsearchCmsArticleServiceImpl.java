package com.easy.admin.cms.es.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.easy.admin.cms.common.status.CmsArticleStatus;
import com.easy.admin.cms.common.type.CmsFileType;
import com.easy.admin.cms.dao.CmsArticleMapper;
import com.easy.admin.cms.es.constant.ElasticsearchConst;
import com.easy.admin.cms.es.model.ElasticSearchCmsArticle;
import com.easy.admin.cms.es.service.ElasticsearchCmsArticleService;
import com.easy.admin.cms.model.CmsArticle;
import com.easy.admin.cms.utils.CmsArticleUtil;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.exception.EasyException;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章搜索 Elasticsearch
 *
 * @author tengchong
 * @date 2022/1/14
 */
@Service
public class ElasticsearchCmsArticleServiceImpl implements ElasticsearchCmsArticleService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private CmsArticleMapper cmsArticleMapper;


    @Override
    public boolean deleteIndex(String siteId) {
        getIndexOperations(siteId).delete();
        return true;
    }

    @Override
    public boolean rebuildIndex(String siteId) {
        IndexOperations indexOperations = getIndexOperations(siteId);

        // 删除索引
        indexOperations.delete();

        // 重新生成索引
        boolean isSuccess = indexOperations.create();
        indexOperations.putMapping(indexOperations.createMapping(ElasticSearchCmsArticle.class));

        QueryWrapper<CmsArticle> cmsArticleQueryWrapper = new QueryWrapper<>();
        cmsArticleQueryWrapper.eq("t.site_id", siteId);
        cmsArticleQueryWrapper.eq("t.status", CmsArticleStatus.PUBLISHED.getCode());
        List<CmsArticle> cmsArticles = cmsArticleMapper.selectAllArticleForElasticsearch(
                cmsArticleQueryWrapper,
                CmsFileType.ARTICLE_COVER.getCode()
        );

        if (!cmsArticles.isEmpty()) {
            cmsArticles = CmsArticleUtil.initArticle(cmsArticles);

            List<IndexQuery> indexQueries = new ArrayList<>();

            cmsArticles.forEach(cmsArticle -> {
                indexQueries.add(
                        new IndexQueryBuilder()
                                .withId(IdUtil.randomUUID())
                                .withSource(new JSONObject(cmsArticle).toString())
                                .build()
                );
            });
            elasticsearchRestTemplate.bulkIndex(indexQueries, getIndexCoordinates(siteId));
        }

        return isSuccess;
    }

    @Override
    public boolean saveOrUpdate(CmsArticle cmsArticle) {
        elasticsearchRestTemplate.index(
                new IndexQueryBuilder()
                        .withId(cmsArticle.getId())
                        .withSource(new JSONObject(cmsArticle).toString())
                        .build(),
                getIndexCoordinates(cmsArticle.getSiteId())
        );
        return true;
    }

    @Override
    public boolean deleteDoc(String siteId, String articleId) {
        elasticsearchRestTemplate.delete(articleId, getIndexCoordinates(siteId));
        return true;
    }

    @Override
    public Page<ElasticSearchCmsArticle> selectByKeywords(String siteId, String keywords, Page<ElasticSearchCmsArticle> page) {
        if (StrUtil.isBlank(keywords)) {
            throw new EasyException("请输入关键字");
        }

        // 分页
        Pageable pageable = getPageable(page);

        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.queryStringQuery(keywords))
                .withHighlightFields(
                        new HighlightBuilder.Field(ElasticsearchConst.HIGHLIGHT_FIELD_TITLE),
                        new HighlightBuilder.Field(ElasticsearchConst.HIGHLIGHT_FIELD_CONTENT)
                )
                .withPageable(pageable);

        SearchHits<CmsArticle> searchHits = elasticsearchRestTemplate.search(
                nativeSearchQueryBuilder.build(),
                CmsArticle.class,
                getIndexCoordinates(siteId)
        );

        // 处理数据
        convertData(page, searchHits);

        return page;
    }

    @Override
    public Page<ElasticSearchCmsArticle> selectByQuery(CmsArticle cmsArticle, Page<ElasticSearchCmsArticle> page) {
        if (cmsArticle == null) {
            throw new EasyException("请输入查询条件");
        }

        // 分页
        Pageable pageable = getPageable(page);

        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder()
                .withHighlightFields(
                        new HighlightBuilder.Field(ElasticsearchConst.HIGHLIGHT_FIELD_TITLE),
                        new HighlightBuilder.Field(ElasticsearchConst.HIGHLIGHT_FIELD_CONTENT)
                )
                .withPageable(pageable);

        // 精准查询
        if (StrUtil.isNotBlank(cmsArticle.getTitle())) {
            nativeSearchQueryBuilder.withQuery(QueryBuilders.matchQuery("title", cmsArticle.getTitle()));
        }
        if (StrUtil.isNotBlank(cmsArticle.getContent())) {
            nativeSearchQueryBuilder.withQuery(QueryBuilders.matchQuery("content", cmsArticle.getContent()));
        }
        if (StrUtil.isNotBlank(cmsArticle.getAuthor())) {
            nativeSearchQueryBuilder.withQuery(QueryBuilders.matchQuery("author", cmsArticle.getAuthor()));
        }
        if (StrUtil.isNotBlank(cmsArticle.getColumnName())) {
            nativeSearchQueryBuilder.withQuery(QueryBuilders.matchQuery("columnName", cmsArticle.getColumnName()));
        }
        if (StrUtil.isNotBlank(cmsArticle.getTags())) {
            nativeSearchQueryBuilder.withQuery(QueryBuilders.matchQuery("tags", cmsArticle.getTags()));
        }

        SearchHits<CmsArticle> searchHits = elasticsearchRestTemplate.search(nativeSearchQueryBuilder.build(), CmsArticle.class, getIndexCoordinates(cmsArticle.getSiteId()));

        // 处理数据
        convertData(page, searchHits);

        return page;
    }

    /**
     * 获取索引名称
     *
     * @param siteId 站点id
     * @return 索引名称
     */
    private String getIndexName(String siteId) {
        return ElasticsearchConst.CMS_ARTICLE_PREFIX + siteId;
    }

    /**
     * 根据站点id获取索引
     * (如果没有，则创建索引)
     *
     * @param siteId 站点id
     * @return IndexOperations
     */
    private IndexOperations getIndexOperations(String siteId) {
        String indexName = getIndexName(siteId);
        IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(IndexCoordinates.of(indexName));
        if (!indexOperations.exists()) {
            // 生成索引
            indexOperations.create();
        }
        return indexOperations;
    }

    /**
     * 获取 IndexCoordinates
     *
     * @param siteId 站点id
     * @return IndexCoordinates
     */
    private IndexCoordinates getIndexCoordinates(String siteId) {
        return IndexCoordinates.of(getIndexName(siteId));
    }

    /**
     * 处理查询结果并放到page中
     *
     * @param page       page
     * @param searchHits 查询结果
     * @return page
     */
    private Page<ElasticSearchCmsArticle> convertData(Page<ElasticSearchCmsArticle> page, SearchHits<CmsArticle> searchHits) {
        // 总数
        page.setTotal(searchHits.getTotalHits());

        if (!searchHits.getSearchHits().isEmpty()) {
            List<ElasticSearchCmsArticle> records = new ArrayList<>();

            searchHits.getSearchHits().forEach(cmsArticleSearchHit -> {
                ElasticSearchCmsArticle elasticSearchCmsArticle = new ElasticSearchCmsArticle(cmsArticleSearchHit.getContent());
                if (!cmsArticleSearchHit.getHighlightField(ElasticsearchConst.HIGHLIGHT_FIELD_TITLE).isEmpty()) {
                    elasticSearchCmsArticle.setTitle(CollUtil.join(cmsArticleSearchHit.getHighlightField(ElasticsearchConst.HIGHLIGHT_FIELD_TITLE), ""));
                }
                if (!cmsArticleSearchHit.getHighlightField(ElasticsearchConst.HIGHLIGHT_FIELD_CONTENT).isEmpty()) {
                    elasticSearchCmsArticle.setContent(CollUtil.join(cmsArticleSearchHit.getHighlightField(ElasticsearchConst.HIGHLIGHT_FIELD_CONTENT), ""));
                }
                records.add(elasticSearchCmsArticle);
            });

            page.setRecords(records);
        }
        return page;
    }

    /**
     * 将框架分页转为ElasticSearch分页
     *
     * @param page 框架分页
     * @return Pageable
     */
    private Pageable getPageable(Page<ElasticSearchCmsArticle> page) {
        if (page == null) {
            page = new Page<>();
        }

        // 分页，注：下标从0开始
        return PageRequest.of(
                Convert.convert(Integer.class, page.getCurrent() - 1),
                Convert.convert(Integer.class, page.getPageSize())
        );
    }


}
