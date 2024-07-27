package com.easy.admin.activiti.model;

import com.easy.admin.auth.model.SysUser;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 任务办理详情
 *
 * @author tengchong
 * @date 2022/7/12
 */
@Data
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
}
