package com.easy.admin.cms.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.easy.admin.cms.common.status.CmsReleaseStatus;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 发布列队详情
 *
 * @author tengchongchong
 * @date 2023-07-12
 */
@Data
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


}
