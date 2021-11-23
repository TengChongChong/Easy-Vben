package com.easy.admin.activiti.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.activiti.constant.TaskStatusConst;
import com.easy.admin.activiti.constant.VariableConst;
import com.easy.admin.activiti.constant.WorkflowConst;
import com.easy.admin.activiti.constant.status.SuspensionStatus;
import com.easy.admin.activiti.dao.TaskMapper;
import com.easy.admin.activiti.model.FormPropertyVO;
import com.easy.admin.activiti.model.Task;
import com.easy.admin.activiti.service.ProcessDefinitionService;
import com.easy.admin.activiti.service.TaskService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.core.mail.MailTemplate;
import com.easy.admin.sys.common.constant.MessageConst;
import com.easy.admin.sys.model.SysMessage;
import com.easy.admin.sys.model.SysUser;
import com.easy.admin.sys.service.SysMessageService;
import com.easy.admin.sys.service.SysUserService;
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
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    @Autowired
    private org.activiti.engine.TaskService taskService;

    @Autowired
    private FormService formService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProcessDefinitionService processDefinitionService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private SysMessageService sysMessageService;

    @Override
    public Page<Task> select(Task task, Page<Task> page) {
        QueryWrapper<Task> queryWrapper = new QueryWrapper<>();
        SysUser currentUser = ShiroUtil.getCurrentUser();
        // 查询条件
        if (task != null) {
            // 名称
            if (StrUtil.isNotBlank(task.getBusinessTitle())) {
                queryWrapper.like("arv_businessTitle.text_", "%" + task.getBusinessTitle() + "%");
            }
            // 流水
            if (StrUtil.isNotBlank(task.getProcessInstanceId())) {
                queryWrapper.eq("art.proc_inst_id_", task.getProcessInstanceId());
            }
            if (StrUtil.isNotBlank(task.getStatus())) {
                if (TaskStatusConst.WAITING_CLAIM.equals(task.getStatus())) {
                    // 待签收
                    queryWrapper.isNull("art.assignee_")
                            .eq("ari.type_", "candidate")
                            .and(i -> i.eq("ari.user_id_", currentUser.getId()).or().in("ari.group_id_", currentUser.getRoleIds().toArray()));
                } else if (TaskStatusConst.CLAIMED.equals(task.getStatus())) {
                    // 待办任务：签收人或委托人为当前用户
                    queryWrapper.and(i -> i.eq("art.assignee_", currentUser.getId()).or().eq("art.owner_", currentUser.getId()));
                } else {
                    return null;
                }
            }
        }
        // 待签、待办中只查询激活流程实例数据，已挂起的不查询
        queryWrapper.eq("arp.suspension_state_", SuspensionStatus.ACTIVATION.getCode());
        page.setDefaultDesc("art.id_");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    @Override
    public void claimTask(String taskId) {
        taskService.claim(taskId, ShiroUtil.getCurrentUser().getId());
    }

    @Override
    public JSONObject readTaskForm(String taskId) {
        JSONObject res = new JSONObject();
        org.activiti.engine.task.Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            throw new EasyException("任务[" + taskId + "]已办理或不存在");
        }
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
        res.set("processInstance", processInstance);
        TaskFormData taskFormData = formService.getTaskFormData(taskId);
        if (taskFormData.getFormProperties() != null && !taskFormData.getFormProperties().isEmpty()) {
            List<FormPropertyVO> formPropertyVOList = new ArrayList<>();
            for (FormProperty formProperty : taskFormData.getFormProperties()) {
                formPropertyVOList.add(new FormPropertyVO(formProperty));
            }
            // 有动态表单
            res.set("hasTaskForm", true);
            res.set("taskFormData", formPropertyVOList);
        }

        res.set("task", task);

        // 流程发起信息
        StartFormData startTaskFormData = formService.getStartFormData(task.getProcessDefinitionId());
        // 有动态表单
        if (startTaskFormData.getFormProperties() != null && !startTaskFormData.getFormProperties().isEmpty()) {
            List<FormPropertyVO> formPropertyVOList = new ArrayList<>();
            for (FormProperty formProperty : startTaskFormData.getFormProperties()) {
                formPropertyVOList.add(new FormPropertyVO(formProperty));
            }
            res.set("hasStartForm", true);
            res.set("startFormData", formPropertyVOList);
        }

        // 获取流程参数
        Map<String, Object> variables = taskService.getVariables(taskId);
        res.set("variables", variables);
        // 设置发起人信息
        if (variables.get(VariableConst.APPLY_USER_ID) != null) {
            res.set("applyUser", sysUserService.getUser((String) variables.get(VariableConst.APPLY_USER_ID)));
        }
        return res;
    }

    @Override
    public void completeTask(String taskId, JSONObject params) {
        // 流程定义ID
        Task task = baseMapper.selectProcessDefinitionId(taskId, SuspensionStatus.ACTIVATION.getCode());
        if (task == null) {
            throw new EasyException("任务不存在，请检查后重试");
        }
        if (StrUtil.isNotBlank(task.getProcessDefinitionId())) {
            // 检查流程状态
            processDefinitionService.getProcessDefinition(task.getProcessDefinitionId());

            // 获取提交表单数据
            Map<String, String> formValues = Convert.toMap(String.class, String.class, params) ;
            formService.submitTaskFormData(taskId, formValues);

            // 自动签收
            processDefinitionService.autoClaimTask(task.getProcessInstanceId());
        }
    }

    @Override
    public void revoke(String processInstanceId, String deleteReason) {
        // 检查是否可以撤销
        Subject subject = SecurityUtils.getSubject();
        Task task = baseMapper.selectTask(processInstanceId);
        if(task == null){
            throw new EasyException("撤销失败，流程未发起或已办结");
        }
        boolean isApplyUser = task.getApplyUserId().equals(ShiroUtil.getCurrentUser().getId());
        boolean isAdmin = subject.hasRole(WorkflowConst.SYS_ADMIN_ROLE);
        if (!isAdmin && !isApplyUser) {
            throw new EasyException("撤销失败，你无权撤销此申请");
        }

        // 系统管理员或发起人可以撤销
        runtimeService.deleteProcessInstance(processInstanceId, deleteReason);

        if (isAdmin && !isApplyUser) {
            // 是管理员，但是不是发起人，撤销后给发起人发消息
            sendMessage(task, deleteReason);
        }
    }

    /**
     * 发送申请被管理员撤销信息
     *
     * @param task         任务
     * @param deleteReason 撤销原因
     */
    private void sendMessage(Task task, String deleteReason) {
        SysUser currentUser = ShiroUtil.getCurrentUser();
        // 设置模板引擎变量
        Map<String,Object> params = new HashMap<>(4);
        params.put("processDefinitionName", task.getProcessDefinitionName());
        params.put("processVersion", task.getProcessVersion());
        params.put("createTime", DateUtil.format(task.getCreateTime(), DatePattern.NORM_DATETIME_MINUTE_PATTERN));
        params.put("processInstanceId", task.getProcessInstanceId());
        params.put("businessDetailsPath",task.getBusinessDetailsPath());
        params.put("businessTitle", task.getBusinessTitle());
        params.put("deleteDate", DateUtil.format(new Date(), DatePattern.NORM_DATETIME_MINUTE_PATTERN));
        params.put("deleteUser", currentUser.getNickname());
        params.put("deleteReason", deleteReason);

        SysMessage sysMessage = new SysMessage();
        sysMessage.setTitle("你发起的[" + task.getProcessDefinitionName() + "]" + task.getBusinessTitle() + "被" + currentUser.getNickname() + "]撤销");
        // 重要
        sysMessage.setImportant(1);
        sysMessage.setContent(MailTemplate.getContent("/message/revocation-notice.html", params));
        // 接收人
        sysMessage.setReceivers(Collections.singletonList(task.getApplyUserId()));
        // 立即发出
        sysMessage.setStatus(MessageConst.STATUS_HAS_BEEN_SENT);
        // 消息类型 - 通知
        sysMessage.setType(MessageConst.TYPE_NOTICE);
        sysMessageService.saveData(sysMessage);
    }
}
