package com.easy.admin.cms.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

/**
 * 页面
 *
 * @author tengchongchong
 * @date 2023-06-27
 */
@Data
@TableName("cms_page")
public class CmsPage extends Model<CmsPage> {

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
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    private String title;
    /**
     * 副标题
     */
    private String subtitle;
    /**
     * 内容
     */
    private String content;
    /**
     * 别名
     */
    @NotBlank(message = "别名不能为空")
    private String slug;
    /**
     * 模板
     */
    @NotBlank(message = "模板不能为空")
    private String template;
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
     * 部门id
     */
    @TableField(fill = FieldFill.INSERT)
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


}
