package com.easy.admin.activiti.model;

import java.util.Date;

/**
 * 流程
 *
 * @author TengChongChong
 * @date 2019-07-12
 */
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

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getDgrmResourceName() {
        return dgrmResourceName;
    }

    public void setDgrmResourceName(String dgrmResourceName) {
        this.dgrmResourceName = dgrmResourceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getHasStartFormKey() {
        return hasStartFormKey;
    }

    public void setHasStartFormKey(Integer hasStartFormKey) {
        this.hasStartFormKey = hasStartFormKey;
    }

    public Integer getHasGraphicalNotation() {
        return hasGraphicalNotation;
    }

    public void setHasGraphicalNotation(Integer hasGraphicalNotation) {
        this.hasGraphicalNotation = hasGraphicalNotation;
    }

    public Integer getSuspensionState() {
        return suspensionState;
    }

    public void setSuspensionState(Integer suspensionState) {
        this.suspensionState = suspensionState;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Date getDeployTime() {
        return deployTime;
    }

    public void setDeployTime(Date deployTime) {
        this.deployTime = deployTime;
    }
}
