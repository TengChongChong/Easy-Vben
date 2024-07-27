package com.easy.admin.file.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * 文件
 *
 * @author TengChongChong
 * @date 2021-02-21
 */
@Data
@TableName("file_info")
public class FileInfo extends Model<FileInfo> {

    /**
     * 主键
     */
    @TableId
    private String id;

    /**
     * 父id
     */
    private String parentId;

    /**
     * 类型
     */
    private String type;

    /**
     * 名称
     */
    private String displayName;

    /**
     * local - 文件夹名称 / oss - bucket名称
     */
    private String bucketName;
    /**
     * local - 文件路径 /  oss - objectName
     */
    private String objectName;
    /**
     * 访问地址
     */
    private String url;

    /**
     * 大小
     */
    private Long size;

    /**
     * 内容类型
     */
    private String contentType;

    /**
     * 排序值
     */
    private Integer orderNo;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 状态
     */
    private String status;

    /**
     * 租户Id
     */
    private String tenantId;

    /**
     * 部门Id
     */
    @TableField(fill = FieldFill.INSERT)
    private String deptId;

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
     * 修改人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUser;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date editDate;

    //

}
