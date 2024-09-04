package com.easy.admin.file.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 文件信息
 *
 * @author 系统管理员
 * @date 2024-09-03
 */
@Data
@TableName("file_detail")
public class FileDetail extends Model<FileDetail> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文件id
     */
    @TableId
    private String id;
    /**
     * 文件访问地址
     */
    @NotBlank(message = "文件访问地址不能为空")
    private String url;
    /**
     * 文件大小，单位字节
     */
    private Long size;
    /**
     * 文件名称
     */
    private String filename;
    /**
     * 原始文件名
     */
    private String originalFilename;
    /**
     * 基础存储路径
     */
    private String basePath;
    /**
     * 存储路径
     */
    private String path;
    /**
     * 文件扩展名
     */
    private String ext;
    /**
     * MIME类型
     */
    private String contentType;
    /**
     * 存储平台
     */
    private String platform;
    /**
     * 缩略图访问路径
     */
    private String thUrl;
    /**
     * 缩略图名称
     */
    private String thFilename;
    /**
     * 缩略图大小，单位字节
     */
    private Long thSize;
    /**
     * 缩略图MIME类型
     */
    private String thContentType;
    /**
     * 文件所属对象id
     */
    private String objectId;
    /**
     * 文件所属对象类型，例如用户头像 user-avatar，评价图片 - comment-image
     */
    private String objectType;
    /**
     * 文件元数据
     */
    private String metadata;
    /**
     * 文件用户元数据
     */
    private String userMetadata;
    /**
     * 缩略图元数据
     */
    private String thMetadata;
    /**
     * 缩略图用户元数据
     */
    private String thUserMetadata;
    /**
     * 附加属性
     */
    private String attr;
    /**
     * 文件ACL
     */
    private String fileAcl;
    /**
     * 缩略图文件ACL
     */
    private String thFileAcl;
    /**
     * 哈希信息
     */
    private String hashInfo;
    /**
     * 上传ID，仅在手动分片上传时使用
     */
    private String uploadId;
    /**
     * 上传状态，仅在手动分片上传时使用，1：初始化完成，2：上传完成
     */
    private Integer uploadStatus;
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
     * 删除时间
     */
    private Date deleteDate;
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

    public FileDetail() {
    }

    public FileDetail(String objectId) {
        this.objectId = objectId;
    }

    public FileDetail(String objectId, String objectType) {
        this.objectId = objectId;
        this.objectType = objectType;
    }
}
