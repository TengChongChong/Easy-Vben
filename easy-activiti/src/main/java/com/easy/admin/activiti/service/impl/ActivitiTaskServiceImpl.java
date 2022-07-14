package com.easy.admin.activiti.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.activiti.constant.ActivitiTaskStatusConst;
import com.easy.admin.activiti.constant.ActivitiVariableConst;
import com.easy.admin.activiti.constant.ActivitiWorkflowConst;
import com.easy.admin.activiti.constant.status.ActivitiSuspensionStatus;
import com.easy.admin.activiti.dao.ActivitiTaskMapper;
import com.easy.admin.activiti.model.ActivitiFormPropertyVO;
import com.easy.admin.activiti.model.ActivitiTask;
import com.easy.admin.activiti.model.ActivitiTaskInfo;
import com.easy.admin.activiti.service.ActivitiProcessDefinitionService;
import com.easy.admin.activiti.service.ActivitiTaskService;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.auth.service.SysUserService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.core.mail.MailTemplate;
import com.easy.admin.sys.common.constant.MessageConst;
import com.easy.admin.sys.model.SysMessage;
import com.easy.admin.sys.service.SysMessageService;
import com.easy.admin.util.ShiroUtil;
import org.activiti.engine.FormService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.StartFormData;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 待办任务
 *
 * @author TengChongChong
 * @date 2020/3/27
 */
@Service
public class ActivitiTaskServiceImpl extends ServiceImpl<ActivitiTaskMapper, ActivitiTask> implements ActivitiTaskService {

    @Autowired
    private org.activiti.engine.TaskService taskService;

    @Autowired
    private FormService formService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ActivitiProcessDefinitionService activitiProcessDefinitionService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private SysMessageService sysMessageService;

    @Override
    public Page<ActivitiTask> select(ActivitiTask activitiTask, Page<ActivitiTask> page) {
        QueryWrapper<ActivitiTask> queryWrapper = new QueryWrapper<>();
        SysUser currentUser = ShiroUtil.getCurrentUser();
        // 查询条件
        if (activitiTask != null) {
            // 名称
            if (StrUtil.isNotBlank(activitiTask.getBusinessTitle())) {
                queryWrapper.like("arv_businessTitle.text_", "%" + activitiTask.getBusinessTitle() + "%");
            }
            // 流水
            if (StrUtil.isNotBlank(activitiTask.getProcessInstanceId())) {
                queryWrapper.eq("art.proc_inst_id_", activitiTask.getProcessInstanceId());
            }
            if (StrUtil.isNotBlank(activitiTask.getStatus())) {
                if (ActivitiTaskStatusConst.WAITING_CLAIM.equals(activitiTask.getStatus())) {
                    // 待签收
                    queryWrapper.isNull("art.assignee_")
                            .eq("ari.type_", "candidate")
                            .and(i -> i.eq("ari.user_id_", currentUser.getId()).or().in("ari.group_id_", ShiroUtil.getRoleIds(currentUser.getRoleList()).toArray()));
                } else if (ActivitiTaskStatusConst.CLAIMED.equals(activitiTask.getStatus())) {
                    // 待办任务：签收人或委托人为当前用户
                    queryWrapper.and(i -> i.eq("art.assignee_", currentUser.getId()).or().eq("art.owner_", currentUser.getId()));
                } else {
                    return null;
                }
            }
        }
        // 待签、待办中只查询激活流程实例数据，已挂起的不查询
        queryWrapper.eq("arp.suspension_state_", ActivitiSuspensionStatus.ACTIVATION.getCode());
        page.setDefaultDesc("art.id_");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    @Override
    public void claimTask(String taskId) {
        taskService.claim(taskId, ShiroUtil.getCurrentUser().getId());
    }

    @Override
    public ActivitiTaskInfo readTaskForm(String taskId) {
        ActivitiTaskInfo taskInfo = new ActivitiTaskInfo();
        org.activiti.engine.task.Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            throw new EasyException("任务[" + taskId + "]已办理或不存在");
        }
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
        taskInfo.setBusinessKey(processInstance.getBusinessKey());
        TaskFormData taskFormData = formService.getTaskFormData(taskId);
        if (taskFormData.getFormProperties() != null && !taskFormData.getFormProperties().isEmpty()) {
            List<ActivitiFormPropertyVO> activitiFormPropertyVOList = new ArrayList<>();
            for (FormProperty formProperty : taskFormData.getFormProperties()) {
                activitiFormPropertyVOList.add(new ActivitiFormPropertyVO(formProperty));
            }
            // 有动态表单
            taskInfo.setHasTaskForm(true);
            taskInfo.setTaskFormData(activitiFormPropertyVOList);
        }

        taskInfo.setCreateDate(task.getCreateTime());

        // 流程发起信息
        StartFormData startTaskFormData = formService.getStartFormData(task.getProcessDefinitionId());
        // 有动态表单
        if (startTaskFormData.getFormProperties() != null && !startTaskFormData.getFormProperties().isEmpty()) {
            List<ActivitiFormPropertyVO> activitiFormPropertyVOList = new ArrayList<>();
            for (FormProperty formProperty : startTaskFormData.getFormProperties()) {
                activitiFormPropertyVOList.add(new ActivitiFormPropertyVO(formProperty));
            }
            taskInfo.setHasTaskForm(true);
            taskInfo.setStartFormData(activitiFormPropertyVOList);
        }

        // 获取流程参数
        Map<String, Object> variables = taskService.getVariables(taskId);
        taskInfo.setVariables(variables);
        // 设置发起人信息
        if (variables.get(ActivitiVariableConst.APPLY_USER_ID) != null) {
            taskInfo.setApplyUser(sysUserService.getUser((String) variables.get(ActivitiVariableConst.APPLY_USER_ID)));
        }
        return taskInfo;
    }

    @Override
    public void completeTask(String taskId, JSONObject params) {
        // 流程定义ID
        ActivitiTask activitiTask = baseMapper.selectProcessDefinitionId(taskId, ActivitiSuspensionStatus.ACTIVATION.getCode());
        if (activitiTask == null) {
            throw new EasyException("任务不存在，请检查后重试");
        }
        if (StrUtil.isNotBlank(activitiTask.getProcessDefinitionId())) {
            // 检查流程状态
            activitiProcessDefinitionService.getProcessDefinition(activitiTask.getProcessDefinitionId());

            // 获取提交表单数据
            Map<String, String> formValues = Convert.toMap(String.class, String.class, params) ;
            formService.submitTaskFormData(taskId, formValues);

            // 自动签收
            activitiProcessDefinitionService.autoClaimTask(activitiTask.getProcessInstanceId());
        }
    }

    @Override
    public void revoke(String processInstanceId, String deleteReason) {
        // 检查是否可以撤销
        Subject subject = SecurityUtils.getSubject();
        ActivitiTask activitiTask = baseMapper.selectTask(processInstanceId);
        if(activitiTask == null){
            throw new EasyException("撤销失败，流程未发起或已办结");
        }
        boolean isApplyUser = activitiTask.getApplyUserId().equals(ShiroUtil.getCurrentUser().getId());
        boolean isAdmin = subject.hasRole(ActivitiWorkflowConst.SYS_ADMIN_ROLE);
        if (!isAdmin && !isApplyUser) {
            throw new EasyException("撤销失败，你无权撤销此申请");
        }

        // 系统管理员或发起人可以撤销
        runtimeService.deleteProcessInstance(processInstanceId, deleteReason);

        if (isAdmin && !isApplyUser) {
            // 是管理员，但是不是发起人，撤销后给发起人发消息
            sendMessage(activitiTask, deleteReason);
        }
    }

    /**
     * 发送申请被管理员撤销信息
     *
     * @param activitiTask         任务
     * @param deleteReason 撤销原因
     */
    private void sendMessage(ActivitiTask activitiTask, String deleteReason) {
        SysUser currentUser = ShiroUtil.getCurrentUser();
        // 设置模板引擎变量
        Map<String,Object> params = new HashMap<>(4);
        params.put("processDefinitionName", activitiTask.getProcessDefinitionName());
        params.put("processVersion", activitiTask.getProcessVersion());
        params.put("createTime", DateUtil.format(activitiTask.getCreateTime(), DatePattern.NORM_DATETIME_MINUTE_PATTERN));
        params.put("processInstanceId", activitiTask.getProcessInstanceId());
        params.put("businessDetailsPath", activitiTask.getBusinessDetailsPath());
        params.put("businessTitle", activitiTask.getBusinessTitle());
        params.put("deleteDate", DateUtil.format(new Date(), DatePattern.NORM_DATETIME_MINUTE_PATTERN));
        params.put("deleteUser", currentUser.getNickname());
        params.put("deleteReason", deleteReason);

        SysMessage sysMessage = new SysMessage();
        sysMessage.setTitle("你发起的[" + activitiTask.getProcessDefinitionName() + "]" + activitiTask.getBusinessTitle() + "被" + currentUser.getNickname() + "]撤销");
        // 重要
        sysMessage.setImportant(MessageConst.IMPORTANT_YES);
        sysMessage.setContent(MailTemplate.getContent("/message/revocation-notice.html", params));
        // 接收人
        sysMessage.setReceivers(Collections.singletonList(activitiTask.getApplyUserId()));
        // 立即发出
        sysMessage.setStatus(MessageConst.STATUS_HAS_BEEN_SENT);
        // 消息类型 - 通知
        sysMessage.setType(MessageConst.TYPE_NOTICE);
        sysMessageService.saveData(sysMessage);
    }
}
