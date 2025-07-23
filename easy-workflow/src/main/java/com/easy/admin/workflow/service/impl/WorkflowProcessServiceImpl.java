package com.easy.admin.workflow.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.config.sa.token.util.SessionUtil;
import com.easy.admin.workflow.constant.ActivitiModelConst;
import com.easy.admin.workflow.dao.WorkflowProcessMapper;
import com.easy.admin.workflow.model.vo.WorkflowProcessVO;
import com.easy.admin.workflow.service.WorkflowModelService;
import com.easy.admin.workflow.service.WorkflowProcessService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * 流程
 *
 * @author TengChongChong
 * @date 2025-07-12
 */
@Slf4j
@Service
public class WorkflowProcessServiceImpl extends ServiceImpl<WorkflowProcessMapper, WorkflowProcessVO> implements WorkflowProcessService {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private WorkflowModelService workflowModelService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Page<WorkflowProcessVO> select(WorkflowProcessVO workflowProcess, Page<WorkflowProcessVO> page) {
        QueryWrapper<WorkflowProcessVO> queryWrapper = new QueryWrapper<>();
        if (workflowProcess != null) {
            if (StrUtil.isNotBlank(workflowProcess.getKey())) {
                queryWrapper.like("arp.key_", workflowProcess.getKey());
            }
            if (StrUtil.isNotBlank(workflowProcess.getName())) {
                queryWrapper.like("arp.name_", workflowProcess.getName());
            }
            if (StrUtil.isNotBlank(workflowProcess.getProcessDefinitionId())) {
                queryWrapper.like("arp.id_", workflowProcess.getProcessDefinitionId());
            }
            if (workflowProcess.getSuspensionState() != null) {
                queryWrapper.like("arp.suspension_state_", workflowProcess.getSuspensionState());
            }
        }
        // 根据流程实例ID排序
        page.setDefaultDesc("ard.deploy_time_");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    @Override
    public boolean remove(String deploymentIds) {
        if (StrUtil.isBlank(deploymentIds)) {
            throw new EasyException("获取数据ids失败");
        }
        List<String> idArray = Arrays.asList(deploymentIds.split(CommonConst.SPLIT));
        idArray.forEach(deploymentId -> repositoryService.deleteDeployment(deploymentId, true));
        return true;
    }

    @Override
    public boolean convertToModel(WorkflowProcessVO workflowProcess) {
        if (StrUtil.isBlank(workflowProcess.getProcessDefinitionId())) {
            throw new EasyException("获取流程id失败");
        }
        if (StrUtil.isBlank(workflowProcess.getKey())) {
            throw new EasyException("标识不能为空");
        }
        if (StrUtil.isBlank(workflowProcess.getName())) {
            throw new EasyException("名称不能为空");
        }
        // 查询流程信息
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(workflowProcess.getProcessDefinitionId()).singleResult();
        // 检查标识是否存在
        if (workflowModelService.checkKeyIsExistence(workflowProcess.getKey(), null)) {
            throw new EasyException("标识已存在，请修改后重试");
        }

        InputStream bpmnStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), processDefinition.getResourceName());
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            // 读取bpmn.xml
            InputStreamReader inputStreamReader = new InputStreamReader(bpmnStream, StandardCharsets.UTF_8);
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStreamReader);
            BpmnModel bpmnModel = new BpmnXMLConverter().convertToBpmnModel(xmlStreamReader);

            // xml 转 json
            BpmnJsonConverter bpmnJsonConverter = new BpmnJsonConverter();
            ObjectNode objectNode = bpmnJsonConverter.convertToJson(bpmnModel);
            // 设置 Model 信息
            Model model = repositoryService.newModel();
            model.setKey(workflowProcess.getKey());
            model.setName(workflowProcess.getName());
            model.setVersion(1);
            // MetaInfo
            ObjectNode modelNode = new ObjectMapper().createObjectNode();
            modelNode.put(ActivitiModelConst.NAME, model.getName());
            modelNode.put(ActivitiModelConst.VERSION, model.getVersion());
            modelNode.put(ActivitiModelConst.DESCRIPTION, workflowProcess.getDescription());
            model.setMetaInfo(modelNode.toString());
            // 保存模型
            repositoryService.saveModel(model);

            // 修改标识、名称、描述信息
            ObjectNode properties = objectMapper.createObjectNode();
            properties.put(ActivitiModelConst.PROPERTIES_PROCESS_ID, model.getKey());
            properties.put(ActivitiModelConst.NAME, model.getName());
            properties.put(ActivitiModelConst.PROPERTIES_PROCESS_AUTHOR, SessionUtil.getCurrentUser().getNickname());
            properties.put(ActivitiModelConst.PROPERTIES_DOCUMENTATION, workflowProcess.getDescription());
            objectNode.set(ActivitiModelConst.PROPERTIES, properties);

            repositoryService.addModelEditorSource(model.getId(), objectNode.toString().getBytes(StandardCharsets.UTF_8));
            return true;
        } catch (XMLStreamException e) {
            log.debug("流程转模型失败[{}]", processDefinition.getId(), e);
            throw new EasyException("流程转模型失败[" + processDefinition.getId() + "]" + e.getMessage());
        }
    }

    @Override
    public InputStream getImageStream(String deploymentId, String resourceName) {
        return repositoryService.getResourceAsStream(deploymentId, resourceName);
    }

    @Override
    public void suspend(String processDefinitionId, boolean suspendProcessInstances) {
        repositoryService.suspendProcessDefinitionById(processDefinitionId);
    }

    @Override
    public void activation(String processDefinitionId, boolean activateProcessInstances) {
        repositoryService.activateProcessDefinitionById(processDefinitionId, activateProcessInstances, null);
    }

    @Override
    public List<Select> selectProcessForSelect() {
        return baseMapper.selectProcessForSelect();
    }
}
