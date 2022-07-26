package com.easy.admin.cms.model;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.easy.admin.sys.model.SysFile;
import com.easy.admin.util.file.FileUtil;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章管理
 *
 * @author TengChongChong
 * @date 2021-11-19
 */
@TableName("cms_article")
public class CmsArticle extends Model<CmsArticle> {

    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;
    /**
     * 站点id
     */
    private String siteId;
    /**
     * 栏目id
     */
    private String columnId;
    /**
     * 排序值
     */
    private Integer orderNo;
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
     * 信息来源
     */
    private String source;
    /**
     * 作者
     */
    private String author;
    /**
     * 标签
     */
    private String tags;
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
     * 状态
     */
    private String status;
    /**
     * 乐观锁
     */
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
    //

    @TableField(exist = false)
    private SysFile cover;

    /**
     * 封面路径
     */
    @TableField(exist = false)
    private String coverPath;

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

    @TableField(exist = false)
    private String appendField;

    public CmsArticle() {
    }

    public CmsArticle(String siteId, String columnSlug) {
        this.siteId = siteId;
        this.columnSlug = columnSlug;
    }

    public CmsArticle(String siteId, String columnSlug, String status) {
        this.siteId = siteId;
        this.columnSlug = columnSlug;
        this.status = status;
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

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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

    public SysFile getCover() {
        return cover;
    }

    public void setCover(SysFile cover) {
        this.cover = cover;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        if (StrUtil.isNotBlank(coverPath)) {
            this.coverPath = FileUtil.getUrl(coverPath);
        } else {
            this.coverPath = null;
        }
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

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
