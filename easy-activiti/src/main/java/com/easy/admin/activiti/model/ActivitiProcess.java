package com.easy.admin.activiti.model;

import lombok.Data;

import java.util.Date;

/**
 * 流程
 *
 * @author TengChongChong
 * @date 2019-07-12
 */
@Data
public class ActivitiProcess {

    /**
     * 流程定义ID
     */
    private String processDefinitionId;

    /**
     * 命名空间
     */
    private String category;
    /**
     * 名称
     */
    private String name;
    /**
     * 标识
     */
    private String key;
    /**
     * 版本号
     */
    private int version;
    /**
     * 部署id
     */
    private String deploymentId;
    /**
     * 资源文件名称
     */
    private String resourceName;
    /**
     * 图片资源文件名称
     */
    private String dgrmResourceName;
    /**
     * 描述
     */
    private String description;

    /**
     * 启动节点有无外置表单
     */
    private Integer hasStartFormKey;

    private Integer hasGraphicalNotation;

    /**
     * 挂起状态
     */
    private Integer suspensionState;
    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 部署时间
     */
    private Date deployTime;

}
