package com.easy.admin.file.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * 下载
 *
 * @author TengChong
 * @date 2019-11-11
 */
@Data
@TableName("file_download")
public class FileDownload extends Model<FileDownload> {

    /**
     * id
     */
    @TableId
    private String id;

    /**
     * 显示名称
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
     * 有效期类型
     */
    private String effectiveType;

    /**
     * 过期时间
     */
    private Date expire;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * 授权（保留）
     */
    private String auth;

    /**
     * 权限代码（保留）
     */
    private String code;

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
     * 租户Id
     */
    private String tenantId;

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

    //

    public FileDownload() {
    }

    public FileDownload(String displayName, String bucketName, String objectName) {
        this.displayName = displayName;
        this.bucketName = bucketName;
        this.objectName = objectName;
    }
}
