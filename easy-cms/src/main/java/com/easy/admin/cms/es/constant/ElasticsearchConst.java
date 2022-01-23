package com.easy.admin.cms.es.constant;

/**
 * Elasticsearch 常量
 *
 * @author tengchong
 * @date 2022/1/14
 */
public class ElasticsearchConst {
    /**
     * 索引前缀
     */
    public static final String CMS_ARTICLE_PREFIX = "cms_article_prefix_";

    /**
     * 高亮字段名称 - 标题
     */
    public static final String HIGHLIGHT_FIELD_TITLE = "title";
    
    /**
     * 高亮字段名称 - 内容
     */
    public static final String HIGHLIGHT_FIELD_CONTENT = "content";
}
