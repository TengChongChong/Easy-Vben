package com.easy.admin.cms.es.model;

import com.easy.admin.cms.model.CmsArticle;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * 文章
 *
 * @author TengChongChong
 * @date 2022-01-14
 */
public class ElasticSearchCmsArticle {

    @Id
    private String id;
    /**
     * 站点id
     */
    @Field(type=FieldType.Keyword)
    private String siteId;
    /**
     * 栏目id
     */
    @Field(type=FieldType.Keyword)
    private String columnId;
    /**
     * 标题
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;
    /**
     * 内容
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String content;
    /**
     * 作者
     */
    @Field(type=FieldType.Keyword)
    private String author;
    /**
     * 发布时间
     */
    @Field(type=FieldType.Date)
    private Date releaseDate;
    /**
     * 访问地址
     */
    @Field(type=FieldType.Keyword)
    private String url;
    /**
     * 封面路径
     */
    @Field(type=FieldType.Keyword)
    private String coverPath;
    /**
     * 栏目名称
     */
    @Field(type=FieldType.Keyword)
    private String columnName;

    public ElasticSearchCmsArticle() {
    }

    public ElasticSearchCmsArticle(CmsArticle cmsArticle) {
        this.id = cmsArticle.getId();
        this.siteId = cmsArticle.getSiteId();
        this.columnId = cmsArticle.getColumnId();
        this.columnName = cmsArticle.getColumnName();
        this.title = cmsArticle.getTitle();
        this.content = cmsArticle.getContent();
        this.author = cmsArticle.getAuthor();
        this.releaseDate = cmsArticle.getReleaseDate();
        this.url = cmsArticle.getUrl();
        this.coverPath = cmsArticle.getCoverPath();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
