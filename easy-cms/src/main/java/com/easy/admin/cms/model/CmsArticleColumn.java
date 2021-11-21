package com.easy.admin.cms.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章栏目
 *
 * @author TengChongChong
 * @date 2021-11-19
 */
@TableName("cms_article_column")
public class CmsArticleColumn extends Model<CmsArticleColumn> {

    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;
    /**
     * 文章id
     */
    private String articleId;
    /**
     * 栏目id
     */
    private String columnId;
    /**
     * 排序值
     */
    private Integer orderNo;
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
    //


    public CmsArticleColumn() {
    }

    public CmsArticleColumn(String articleId, String columnId) {
        this.articleId = articleId;
        this.columnId = columnId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
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
}
