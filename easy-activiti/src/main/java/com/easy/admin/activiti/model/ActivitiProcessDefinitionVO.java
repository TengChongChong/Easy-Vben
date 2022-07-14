package com.easy.admin.activiti.model;

import cn.hutool.json.JSONObject;

import javax.validation.constraints.NotBlank;

/**
 * 流程发起
 *
 * @author TengChongChong
 * @date 2021/1/16
 */
public class ActivitiProcessDefinitionVO {
    /**
     * 流程ID
     */
    @NotBlank(message = "流程ID不能为空")
    String processDefinitionId;
    /**
     * 业务数据ID
     */
    @NotBlank(message = "业务数据ID不能为空")
    String businessKey;
    /**
     * 业务标题
     */
    @NotBlank(message = "业务标题不能为空")
    String businessTitle;
    /**
     * 业务数据详情url
     */
    @NotBlank(message = "业务数据详情Path不能为空")
    String businessDetailsPath;
    /**
     * 扩展参数
     */
    JSONObject extentParams;

    /**
     * 包含流程发起表单数据
     */
    private Boolean hasFormData;

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getBusinessTitle() {
        return businessTitle;
    }

    public void setBusinessTitle(String businessTitle) {
        this.businessTitle = businessTitle;
    }

    public String getBusinessDetailsPath() {
        return businessDetailsPath;
    }

    public void setBusinessDetailsPath(String businessDetailsPath) {
        this.businessDetailsPath = businessDetailsPath;
    }

    public JSONObject getExtentParams() {
        return extentParams;
    }

    public void setExtentParams(JSONObject extentParams) {
        this.extentParams = extentParams;
    }

    public Boolean getHasFormData() {
        return hasFormData;
    }

    public void setHasFormData(Boolean hasFormData) {
        this.hasFormData = hasFormData;
    }

    @Override
    public String toString() {
        return "ProcessDefinitionVO{" +
                "processDefinitionId='" + processDefinitionId + '\'' +
                ", businessKey='" + businessKey + '\'' +
                ", businessTitle='" + businessTitle + '\'' +
                ", businessDetailsPath='" + businessDetailsPath + '\'' +
                ", extentParams=" + extentParams +
                ", hasFormData=" + hasFormData +
                '}';
    }
}
