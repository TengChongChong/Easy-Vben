package com.easy.restful.activiti.service.impl;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.restful.activiti.constant.VariableConst;
import com.easy.restful.activiti.dao.ProcessDefinitionMapper;
import com.easy.restful.activiti.model.Process;
import com.easy.restful.activiti.service.ProcessDefinitionService;
import com.easy.restful.common.core.constant.CommonConst;
import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.sys.model.SysUser;
import com.easy.restful.sys.service.SysRoleService;
import com.easy.restful.util.ShiroUtil;
import org.activiti.engine.FormService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.StartFormData;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 启动流程
 *
 * @author tengchong
 * @date 2020/3/26
 */
@Service
public class ProcessDefinitionServiceImpl extends ServiceImpl<ProcessDefinitionMapper, Process> implements ProcessDefinitionService {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private FormService formService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private org.activiti.engine.TaskService taskService;

    @Override
    public JSONObject readStartForm(String processDefinitionId) {
        JSONObject res = new JSONObject();
        ProcessDefinition processDefinition = getProcessDefinition(processDefinitionId);
        boolean hasStartFormKey = processDefinition.hasStartFormKey();

        // 是否有hasStartFormKey属性
        if (hasStartFormKey) {
            Object renderedStartForm = formService.getRenderedStartForm(processDefinitionId);
            res.set("startFormData", renderedStartForm);
        } else {
            // 动态表单
            StartFormData startFormData = formService.getStartFormData(processDefinitionId);
            res.set("startFormData", startFormData);
        }

        res.set("processDefinitionId", processDefinitionId);
        res.set("hasStartFormKey", hasStartFormKey);
        res.set("processDefinition", processDefinition);
        return res;
    }

    @Override
    public String startProcessInstance(String processDefinitionId, String businessKey, String businessTitle, String businessDetailsUrl, HttpServletRequest request) {
        if (checkBusinessKey(businessKey)) {
            throw new EasyException("[" + businessTitle + "]已提交过申请，请勿重复提交");
        }
        ProcessDefinition processDefinition = getProcessDefinition(processDefinitionId);
        // 获取提交表单数据
        Map<String, Object> formValues;

        boolean hasStartFormKey = processDefinition.hasStartFormKey();
        // 获取表单数据
        if (hasStartFormKey) {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Set<Map.Entry<String, String[]>> entrySet = parameterMap.entrySet();
            formValues = new HashMap<>(entrySet.size());
            for (Map.Entry<String, String[]> entry : entrySet) {
                String key = entry.getKey();
                formValues.put(key, entry.getValue()[0]);
            }
        } else {
            // 动态表单
            StartFormData startFormData = formService.getStartFormData(processDefinitionId);
            formValues = new HashMap<>(startFormData.getFormProperties().size());
            for (FormProperty formProperty : startFormData.getFormProperties()) {
                formValues.put(formProperty.getId(), request.getParameter(formProperty.getId()));
            }
        }
        SysUser currentUser = ShiroUtil.getCurrentUser();
        // 当前用户
        identityService.setAuthenticatedUserId(currentUser.getId());

        // 设置流程额外的属性
        formValues.put(VariableConst.BUSINESS_TITLE, businessTitle);
        formValues.put(VariableConst.BUSINESS_DETAILS_URL, businessDetailsUrl);
        formValues = setUserInfo(formValues, currentUser);
        // 提交表单字段并启动一个新的流程实例
        // submitStartFormData接收的参数为Map<String, String>类型，这里需要转一下
        ProcessInstance processInstance = formService.submitStartFormData(processDefinitionId, businessKey, toStringMap(formValues));
        autoClaimTask(processInstance.getId());
        return processInstance.getId();
    }

    /**
     * 将Map<String, Object>转为Map<String, String>
     *
     * @param result 需转换map
     * @return 转换后map
     */
    private Map<String, String> toStringMap(Map<String, Object> result) {
        Map<String, String> formData = new HashMap<>(result.size());
        for (Map.Entry mapStr : result.entrySet()) {
            formData.put(mapStr.getKey().toString(), (String) result.get(mapStr.getKey().toString()));
        }
        return formData;

    }

    @Override
    public JSONObject startProcessInstance(String processDefinitionId, String businessKey, String businessTitle,
                                           String businessDetailsUrl, String extentParams) {
        if (checkBusinessKey(businessKey)) {
            throw new EasyException("[" + businessTitle + "]已提交过申请，请勿重复提交");
        }
        SysUser currentUser = ShiroUtil.getCurrentUser();
        JSONObject result = new JSONObject();
        ProcessDefinition processDefinition = getProcessDefinition(processDefinitionId);
        boolean hasStartFormKey = processDefinition.hasStartFormKey();
        if (hasStartFormKey) {
            // 有外置表单
            result.set("hasStartForm", true);
            result.set("url", "/read/start/form/" + processDefinitionId);
            return result;
        }
        StartFormData startFormData = formService.getStartFormData(processDefinitionId);
        if (startFormData.getFormProperties() != null && startFormData.getFormProperties().size() > 0) {
            // 有动态表单
            result.set("hasStartForm", true);
            result.set("url", "/read/start/form/" + processDefinitionId);
            return result;
        }
        // 没有表单，启动流程
        result.set("hasStartForm", false);
        // 当前用户
        identityService.setAuthenticatedUserId(currentUser.getId());
        // 流程变量
        Map<String, Object> variables = new HashMap<>();
        if(StrUtil.isNotBlank(extentParams)){
            // 扩展参数必须是JSON格式
            variables = new JSONObject(extentParams);
        }
        variables.put(VariableConst.BUSINESS_TITLE, businessTitle);
        variables.put(VariableConst.BUSINESS_DETAILS_URL, businessDetailsUrl);
        variables = setUserInfo(variables, currentUser);
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId(), businessKey, variables);
        result.set("processInstanceId", processInstance.getId());
        autoClaimTask(processInstance.getId());
        return result;
    }

    /**
     * 检查任务是否满足自动签收条件
     * 如下一个节点角色+候选人总共为1个用户则自动签收
     *
     * @param processInstanceId 流程实例ID
     * @return true/false
     */
    @Override
    public boolean autoClaimTask(String processInstanceId) {
        String taskId = getBaseMapper().selectTaskId(processInstanceId);
        if(StrUtil.isNotBlank(taskId)){
            // 查询可以签收此任务的所有用户列表，去重计数
            List<String> candidateList = getBaseMapper().selectCandidate(taskId);
            if (candidateList.size() == 1) {
                // 只有一个候选人
                taskService.claim(taskId, candidateList.get(0));
                return true;
            }
        }
        return false;
    }

    /**
     * 设置一些用户信息，角色、机构、用户基本信息等
     *
     * @param variables   流程参数
     * @param currentUser 当前用户
     * @return 流程参数
     */
    private Map<String, Object> setUserInfo(Map<String, Object> variables, SysUser currentUser) {
        // 流程发起人ID
        variables.put(VariableConst.APPLY_USER_ID, currentUser.getId());
        // 流程发起人昵称
        variables.put(VariableConst.APPLY_USER_NICKNAME, currentUser.getNickname());
        // 流程发起人所在部门ID
        variables.put(VariableConst.DEPT_ID, currentUser.getDeptId());
        // 流程发起人所在部门type code
        variables.put(VariableConst.DEPT_TYPE_CODE, currentUser.getDept().getTypeCode());
        // 流程发起人所在部门type 名称
        variables.put(VariableConst.DEPT_TYPE_NAME, currentUser.getDept().getTypeName());
        // 流程发起人所在部门名称
        variables.put(VariableConst.DEPT_NAME, currentUser.getDept().getName());
        // 流程发起人所属角色 eg: role1,role2,role3
        variables.put(VariableConst.USER_ROLE_CODES, ArrayUtil.join(currentUser.getRoles().toArray(), CommonConst.SPLIT));
        // 设置角色快速判断参数，如isRole1、isRole2等，如果角色标识使用:隔开，则改为驼峰命名 eg: sys:admin => isSysAdmin
        for (String role : currentUser.getRoles()) {
            variables.put(convertRoleCode(role), CommonConst.TRUE);
        }
        // 将此用户没有的角色也设置参数，防止使用时参数不存在
        List<String> allRoleCode = sysRoleService.selectAllRoleCodes();
        String[] currentUserRoleCodes = ArrayUtil.toArray(currentUser.getRoles(), String.class);
        for (String role : allRoleCode) {
            if (!ArrayUtil.contains(currentUserRoleCodes, role)) {
                variables.put(convertRoleCode(role), CommonConst.FALSE);
            }
        }
        return variables;
    }

    /**
     * 转换角色标识
     *
     * @param roleCode 角色标识 eg: sys:admin
     * @return 转换后的标识 eg: isSysAdmin
     */
    private String convertRoleCode(String roleCode) {
        // 角色分隔符
        String roleSplit = ":";
        StringBuilder tempRole = new StringBuilder();
        tempRole.append("is");
        if (roleCode.contains(roleSplit)) {
            for (String role : roleCode.split(roleSplit)) {
                tempRole.append(StrUtil.upperFirst(role));
            }
        } else {
            tempRole.append(StrUtil.upperFirst(roleCode));
        }
        return tempRole.toString();
    }

    /**
     * 根据流程id获取流程
     *
     * @param processDefinitionId 流程定义ID
     * @return ProcessDefinition
     */
    @Override
    public ProcessDefinition getProcessDefinition(String processDefinitionId) {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
        if (processDefinition == null) {
            throw new EasyException("流程[" + processDefinitionId + "]不存在，请检查此流程状态");
        }

        if(processDefinition.isSuspended()){
            throw new EasyException("流程[" + processDefinition.getName() + "]已挂起，请联系管理员");
        }
        return processDefinition;
    }

    /**
     * 检查业务数据是否提交过流程，一条数据只能提交一次
     *
     * @param businessKey 业务数据id
     * @return true/false
     */
    private boolean checkBusinessKey(String businessKey) {
        return getBaseMapper().countBusinessKey(businessKey) > 0;
    }

}
