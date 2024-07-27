package com.easy.admin.cms.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * 网站发布
 *
 * @author tengchongchong
 * @date 2023-07-12
 */
@Data
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
     * 部门id
     */
    private String deptId;
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

}
