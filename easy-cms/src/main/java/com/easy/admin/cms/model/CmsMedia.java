package com.easy.admin.cms.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.dromara.x.file.storage.core.FileInfo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

/**
 * 资源
 *
 * @author tengchongchong
 * @date 2023-06-21
 */
@Data
@TableName("cms_media")
public class CmsMedia extends Model<CmsMedia> {

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
     * 名称
     */
    @NotBlank(message = "名称不能为空")
    private String name;
    /**
     * 类型
     */
    @NotBlank(message = "类型不能为空")
    private String type;
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
    /**
     * 附件
     */
    @TableField(exist = false)
    @NotNull(message = "文件不能为空")
    private FileInfo file;

    /**
     * 附件路径
     */
    @TableField(exist = false)
    private String fileUrl;
    /**
     * 文件id
     */
    @TableField(exist = false)
    protected String fileId;
}
