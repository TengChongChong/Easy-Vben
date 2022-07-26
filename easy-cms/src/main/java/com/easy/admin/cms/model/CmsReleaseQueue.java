package com.easy.admin.cms.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.easy.admin.cms.common.constant.CmsWeightConst;
import com.easy.admin.cms.common.status.CmsReleaseStatus;

import java.io.Serializable;

/**
 * 发布列队
 *
 * @author TengChongChong
 * @date 2021-11-24
 */
@TableName("cms_release_queue")
public class CmsReleaseQueue extends Model<CmsReleaseQueue> {

    @TableId(value = "id")
    private String id;

    /**
     * 任务id
     */
    private String pId;
    /**
     * 标题
     */
    private String title;
    /**
     * 类型
     */
    private String type;
    /**
     * 站点id
     */
    private String siteId;
    /**
     * 权重
     */
    private Integer weight;
    /**
     * 数据id
     */
    private String dataId;
    /**
     * 发布状态
     */
    private String status;
    /**
     * 发布回执
     */
    private String receipt;
    /**
     * 耗时 毫秒
     */
    private Long duration;
    //

    public CmsReleaseQueue() {}

    public CmsReleaseQueue(String pId, String type, String siteId, String dataId, String title) {
        this.pId = pId;
        this.type = type;
        this.siteId = siteId;
        this.dataId = dataId;
        this.title = title;
        this.weight = CmsWeightConst.DEFAULT;
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
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }
}
