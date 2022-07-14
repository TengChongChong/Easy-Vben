package com.easy.admin.activiti.model;

import com.easy.admin.auth.model.SysUser;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 任务办理详情
 *
 * @author tengchong
 * @date 2022/7/12
 */
public class ActivitiTaskInfo {
    /**
     * 是否有表单
     */
    private boolean hasTaskForm;
    /**
     * 表单
     */
    private List<ActivitiFormPropertyVO> taskFormData;
    /**
     * 发起时表单
     */
    private List<ActivitiFormPropertyVO> startFormData;
    /**
     * 流程变量
     */
    private Map<String, Object> variables;
    /**
     * 发起人
     */
    private SysUser applyUser;

    /**
     * 业务数据id
     */
    private String businessKey;

    /**
     * 发起时间
     */
    private Date createDate;

    public ActivitiTaskInfo() {
        this.hasTaskForm = false;
    }

    public boolean isHasTaskForm() {
        return hasTaskForm;
    }

    public void setHasTaskForm(boolean hasTaskForm) {
        this.hasTaskForm = hasTaskForm;
    }

    public List<ActivitiFormPropertyVO> getTaskFormData() {
        return taskFormData;
    }

    public void setTaskFormData(List<ActivitiFormPropertyVO> taskFormData) {
        this.taskFormData = taskFormData;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }

    public SysUser getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(SysUser applyUser) {
        this.applyUser = applyUser;
    }

    public List<ActivitiFormPropertyVO> getStartFormData() {
        return startFormData;
    }

    public void setStartFormData(List<ActivitiFormPropertyVO> startFormData) {
        this.startFormData = startFormData;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }
}
