package com.easy.restful.activiti.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.restful.activiti.constant.TaskStatusConst;
import com.easy.restful.activiti.constant.VariableConst;
import com.easy.restful.activiti.constant.WorkflowConst;
import com.easy.restful.activiti.constant.status.SuspensionStatus;
import com.easy.restful.activiti.dao.TaskMapper;
import com.easy.restful.activiti.model.Task;
import com.easy.restful.activiti.service.ProcessDefinitionService;
import com.easy.restful.activiti.service.TaskService;
import com.easy.restful.activiti.util.FormUtil;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.sys.common.constant.MessageConst;
import com.easy.restful.sys.model.SysMessage;
import com.easy.restful.sys.model.SysUser;
import com.easy.restful.sys.service.SysMessageService;
import com.easy.restful.sys.service.SysUserService;
import com.easy.restful.util.ShiroUtil;
import org.activiti.engine.FormService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.form.StartFormData;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 待办任务
 *
 * @author tengchong
 * @date 2020/3/27
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    @Autowired
    private RepositoryService repositoryService;

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
                            .and(i -> i.eq("ari.user_id_", currentUser.getId()).or().in("ari.group_id_", currentUser.getRoles().toArray()));
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
        page.setRecords(getBaseMapper().select(page, queryWrapper));
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
        TaskFormData taskFormData = formService.getTaskFormData(taskId);
        if (taskFormData.getFormKey() != null) {
            Object renderedTaskForm = formService.getRenderedTaskForm(taskId);
            res.set("taskFormData", renderedTaskForm);
        } else {
            res.set("taskFormData", taskFormData);
        }
        res.set("hasFormKey", taskFormData.getFormKey() != null);
        res.set("task", task);
        res.set("taskId", taskId);

        // 流程发起信息
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(task.getProcessDefinitionId()).singleResult();
        boolean hasStartFormKey = processDefinition.hasStartFormKey();
        if (hasStartFormKey) {
            Object renderedStartForm = formService.getRenderedStartForm(task.getProcessDefinitionId());
            res.set("startFormData", renderedStartForm);
        } else {
            StartFormData startTaskFormData = formService.getStartFormData(task.getProcessDefinitionId());
            res.set("startFormData", startTaskFormData);
        }
        res.set("hasStartFormKey", hasStartFormKey);
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
    public void completeTask(String taskId, HttpServletRequest request) {
        TaskFormData taskFormData = formService.getTaskFormData(taskId);
        // 流程定义ID
        Task task = getBaseMapper().selectProcessDefinitionId(taskId, SuspensionStatus.ACTIVATION.getCode());
        if (task == null) {
            throw new EasyException("任务不存在，请检查后重试");
        }
        if (StrUtil.isNotBlank(task.getProcessDefinitionId())) {
            // 检查流程状态
            processDefinitionService.getProcessDefinition(task.getProcessDefinitionId());

            // 获取提交表单数据
            Map<String, String> formValues = FormUtil.getFormData(taskFormData, request);
            formService.submitTaskFormData(taskId, formValues);

            // 自动签收
            processDefinitionService.autoClaimTask(task.getProcessInstanceId());
        }
    }

    @Override
    public void revoke(String processInstanceId, String deleteReason) {
        // 检查是否可以撤销
        Subject subject = SecurityUtils.getSubject();
        Task task = getBaseMapper().selectTask(processInstanceId);
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
        Map<String,Object> shared = new HashMap<>(4);
        shared.put("processDefinitionName", task.getProcessDefinitionName());
        shared.put("processVersion", task.getProcessVersion());
        shared.put("createTime", DateUtil.format(task.getCreateTime(), DatePattern.NORM_DATETIME_MINUTE_PATTERN));
        shared.put("processInstanceId", task.getProcessInstanceId());
        shared.put("businessDetailsUrl",task.getBusinessDetailsUrl());
        shared.put("businessTitle", task.getBusinessTitle());
        shared.put("deleteDate", DateUtil.format(new Date(), DatePattern.NORM_DATETIME_MINUTE_PATTERN));
        shared.put("deleteUser", currentUser.getNickname());
        shared.put("deleteReason", deleteReason);

        SysMessage sysMessage = new SysMessage();
        sysMessage.setTitle("[流程撤销]你发起的[" + task.getProcessDefinitionName() + "]" + task.getBusinessTitle() + "被[" + currentUser.getNickname() + "]撤销");
        // 重要
        sysMessage.setImportant(1);
        sysMessage.setContent(getMessageContent(shared));
        // 接收人
        sysMessage.setReceivers(Collections.singletonList(task.getApplyUserId()));
        // 立即发出
        sysMessage.setStatus(MessageConst.STATUS_HAS_BEEN_SENT);
        // 消息类型 - 通知
        sysMessage.setType(MessageConst.TYPE_NOTICE);
        sysMessageService.saveData(sysMessage);
    }

    /**
     * 通过beetl模板引擎生成消息内容
     *
     * @param shared 变量
     * @return 内容
     */
    private String getMessageContent(Map<String,Object> shared){
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("message/");
        Configuration cfg;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            throw new EasyException("获取defaultConfiguration失败[" + e.getMessage() + "]");
        }
        GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, cfg);
        Template template = groupTemplate.getTemplate("revocation-notice.html");
        groupTemplate.setSharedVars(shared);
        String str = template.render();
        return str;
    }
}
