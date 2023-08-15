package com.easy.admin.cms.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.easy.admin.cms.common.status.CmsReleaseStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 发布列队详情
 *
 * @author 系统管理员
 * @date 2023-07-12
 */
@TableName("cms_release_queue")
public class CmsReleaseQueue extends Model<CmsReleaseQueue> {

    /**
     * 主键
     */
    @TableId
    private String id;
    /**
     * 列队id
     */
    private String parentId;
    /**
     * 站点id
     */
    private String siteId;
    /**
     * 类型
     */
    @NotBlank(message = "类型不能为空")
    private String type;
    /**
     * 数据id
     */
    private String dataId;
    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    private String title;
    /**
     * 权重
     */
    @NotNull(message = "权重不能为空")
    private Long weight;
    /**
     * 发布回执
     */
    private String receipt;
    /**
     * 耗时 毫秒
     */
    private Long duration;
    /**
     * 发布状态
     */
    private String status;

    // 非表字段


    public CmsReleaseQueue() {
    }

    public CmsReleaseQueue(String parentId, String type, String siteId, String dataId, String title) {
        this.parentId = parentId;
        this.type = type;
        this.siteId = siteId;
        this.dataId = dataId;
        this.title = title;
        this.weight = 0L;
        this.status = CmsReleaseStatus.TO_BE_RELEASED.getCode();
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
