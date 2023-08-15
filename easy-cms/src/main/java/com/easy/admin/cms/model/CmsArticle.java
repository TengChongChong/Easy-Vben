package com.easy.admin.cms.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.easy.admin.sys.model.SysFile;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章
 *
 * @author 系统管理员
 * @date 2023-06-21
 */
@TableName("cms_article")
public class CmsArticle extends Model<CmsArticle> {

    /**
     * 主键
     */
    @TableId
    private String id;
    /**
     * 站点id
     */
    private String siteId;
    /**
     * 栏目id
     */
    @NotBlank(message = "栏目不能为空")
    private String columnId;
    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    private String title;
    /**
     * 标题字体
     */
    private String titleFontFamily;
    /**
     * 标题颜色
     */
    private String titleColor;
    /**
     * 标题字重
     */
    private String titleFontWeight;
    /**
     * 标题文字大小
     */
    private Integer titleFontSize;
    /**
     * 副标题
     */
    private String subtitle;
    /**
     * 摘要
     */
    private String excerpt;
    /**
     * 内容
     */
    private String content;
    /**
     * 关键字
     */
    private String keyword;
    /**
     * 描述
     */
    private String description;
    /**
     * 标签
     */
    private String tags;
    /**
     * 信息来源
     */
    private String source;
    /**
     * 作者
     */
    private String author;
    /**
     * 发布方式 1.手动 2.定时
     */
    private String releaseType;
    /**
     * 发布时间
     */
    private Date releaseDate;
    /**
     * 下线时间
     */
    private Date offlineDate;
    /**
     * 浏览次数
     */
    private Integer viewCount;
    /**
     * 类型
     */
    private String type;
    /**
     * 访问地址
     */
    private String url;
    /**
     * 部门id
     */
    private String deptId;
    /**
     * 排序值
     */
    private Integer orderNo;
    /**
     * 状态
     */
    private String status;
    /**
     * 乐观锁
     */
    @Version
    private Integer version;
    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createUser;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUser;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date editDate;

    // 非表字段
    /**
     * 发布时间 - 开始时间
     */
    @TableField(exist = false)
    private Date startReleaseDate;
    /**
     * 发布时间 - 结束时间
     */
    @TableField(exist = false)
    private Date endReleaseDate;
    /**
     * 下线时间 - 开始时间
     */
    @TableField(exist = false)
    private Date startOfflineDate;
    /**
     * 下线时间 - 结束时间
     */
    @TableField(exist = false)
    private Date endOfflineDate;

    /**
     * 封面
     */
    @TableField(exist = false)
    private SysFile cover;

    /**
     * 栏目别名
     */
    @TableField(exist = false)
    private String columnSlug;

    /**
     * 栏目名称
     */
    @TableField(exist = false)
    private String columnName;

    /**
     * 封面路径
     */
    @TableField(exist = false)
    private String coverUrl;

    @TableField(exist = false)
    private String appendField;

    public CmsArticle() {
    }

    public CmsArticle(String siteId, String columnSlug) {
        this.siteId = siteId;
        this.columnSlug = columnSlug;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
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

    public String getTitleFontFamily() {
        return titleFontFamily;
    }

    public void setTitleFontFamily(String titleFontFamily) {
        this.titleFontFamily = titleFontFamily;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public String getTitleFontWeight() {
        return titleFontWeight;
    }

    public void setTitleFontWeight(String titleFontWeight) {
        this.titleFontWeight = titleFontWeight;
    }

    public Integer getTitleFontSize() {
        return titleFontSize;
    }

    public void setTitleFontSize(Integer titleFontSize) {
        this.titleFontSize = titleFontSize;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseType() {
        return releaseType;
    }

    public void setReleaseType(String releaseType) {
        this.releaseType = releaseType;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getOfflineDate() {
        return offlineDate;
    }

    public void setOfflineDate(Date offlineDate) {
        this.offlineDate = offlineDate;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getEditUser() {
        return editUser;
    }

    public void setEditUser(String editUser) {
        this.editUser = editUser;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }


    public Date getStartReleaseDate() {
        return startReleaseDate;
    }

    public void setStartReleaseDate(Date startReleaseDate) {
        this.startReleaseDate = startReleaseDate;
    }

    public Date getEndReleaseDate() {
        return endReleaseDate;
    }

    public void setEndReleaseDate(Date endReleaseDate) {
        this.endReleaseDate = endReleaseDate;
    }

    public Date getStartOfflineDate() {
        return startOfflineDate;
    }

    public void setStartOfflineDate(Date startOfflineDate) {
        this.startOfflineDate = startOfflineDate;
    }

    public Date getEndOfflineDate() {
        return endOfflineDate;
    }

    public void setEndOfflineDate(Date endOfflineDate) {
        this.endOfflineDate = endOfflineDate;
    }

    public SysFile getCover() {
        return cover;
    }

    public void setCover(SysFile cover) {
        this.cover = cover;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getColumnSlug() {
        return columnSlug;
    }

    public void setColumnSlug(String columnSlug) {
        this.columnSlug = columnSlug;
    }

    public String getAppendField() {
        return appendField;
    }

    public void setAppendField(String appendField) {
        this.appendField = appendField;
    }
}
