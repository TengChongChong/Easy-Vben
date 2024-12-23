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
     * 文件Id
     */
    private String fileId;

    /**
     * 有效期类型
     */
    private String effectiveType;

    /**
     * 过期时间
     */
    private Date expire;

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


    public FileDownload() {
    }

    public FileDownload(String fileId) {
        this.fileId = fileId;
    }
}
