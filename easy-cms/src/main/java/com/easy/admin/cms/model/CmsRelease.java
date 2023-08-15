package com.easy.admin.cms.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 网站发布
 *
 * @author 系统管理员
 * @date 2023-07-12
 */
@TableName("cms_release")
public class CmsRelease extends Model<CmsRelease> {

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
     * 页面id
     */
    private String pageIds;
    /**
     * 栏目id
     */
    private String columnIds;
    /**
     * 是否发布栏目下文章
     */
    private String releaseArticle;
    /**
     * 总任务
     */
    private Long total;
    /**
     * 已完成数量
     */
    private Long done;
    /**
     * 发布失败数量
     */
    private Long fail;
    /**
     * 发布时间
     */
    private Date releaseDate;
    /**
     * 结束时间
     */
    private String endDate;
    /**
     * 发布回执
     */
    private String receipt;
    /**
     * 状态
     */
    private String status;
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

    public String getPageIds() {
        return pageIds;
    }

    public void setPageIds(String pageIds) {
        this.pageIds = pageIds;
    }

    public String getColumnIds() {
        return columnIds;
    }

    public void setColumnIds(String columnIds) {
        this.columnIds = columnIds;
    }

    public String getReleaseArticle() {
        return releaseArticle;
    }

    public void setReleaseArticle(String releaseArticle) {
        this.releaseArticle = releaseArticle;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getDone() {
        return done;
    }

    public void setDone(Long done) {
        this.done = done;
    }

    public Long getFail() {
        return fail;
    }

    public void setFail(Long fail) {
        this.fail = fail;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

}
