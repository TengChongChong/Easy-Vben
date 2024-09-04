package com.easy.admin.file.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 文件上传规则
 *
 * @author tengchongchong
 * @date 2023-11-17
 */
@Data
@TableName("file_upload_rule")
public class FileUploadRule extends Model<FileUploadRule> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private String id;
    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空")
    private String name;
    /**
     * 别名
     */
    @NotBlank(message = "别名不能为空")
    private String slug;
    /**
     * 分类
     */
    @NotBlank(message = "分类不能为空")
    private String category;
    /**
     * 存放目录
     */
    private String directory;
    /**
     * 文件最小长度，单位 kb
     */
    @NotNull(message = "文件最小长度，单位 kb不能为空")
    private Integer lowerLimit;
    /**
     * 文件最大长度，单位 kb
     */
    @NotNull(message = "文件最大长度，单位 kb不能为空")
    private Integer upperLimit;
    /**
     * 文件后缀
     */
    @NotBlank(message = "文件后缀不能为空")
    private String suffix;
    /**
     * 状态
     */
    private String status;
    /**
     * 租户Id
     */
    private String tenantId;
    /**
     * 乐观锁
     */
    @Version
    private Integer version;
    /**
     * 部门Id
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
     * 文件后缀
     */
    @TableField(exist = false)
    private List<String> suffixArray;
}
