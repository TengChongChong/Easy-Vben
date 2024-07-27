package com.easy.admin.cms.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.easy.admin.file.model.FileInfo;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 文章
 *
 * @author tengchongchong
 * @date 2023-06-21
 */
@Data
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
    private FileInfo cover;

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
}
