package com.easy.admin.activiti.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.activiti.constant.ActivitiModelConst;
import com.easy.admin.activiti.dao.ActivitiProcessMapper;
import com.easy.admin.activiti.model.ActivitiProcess;
import com.easy.admin.activiti.service.ActivitiModelService;
import com.easy.admin.activiti.service.ActivitiProcessService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.util.ShiroUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @date 2019-07-12
 */
@Service
public class ActivitiProcessServiceImpl extends ServiceImpl<ActivitiProcessMapper, ActivitiProcess> implements ActivitiProcessService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private ActivitiModelService activitiModelService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Page<ActivitiProcess> select(ActivitiProcess activitiProcess, Page<ActivitiProcess> page) {
        QueryWrapper<ActivitiProcess> queryWrapper = new QueryWrapper<>();
        if (activitiProcess != null) {
            if (StrUtil.isNotBlank(activitiProcess.getKey())) {
                queryWrapper.like("arp.key_", activitiProcess.getKey());
            }
            if (StrUtil.isNotBlank(activitiProcess.getName())) {
                queryWrapper.like("arp.name_", activitiProcess.getName());
            }
            if (StrUtil.isNotBlank(activitiProcess.getProcessDefinitionId())) {
                queryWrapper.like("arp.id_", activitiProcess.getProcessDefinitionId());
            }
            if (activitiProcess.getSuspensionState() != null) {
                queryWrapper.like("arp.suspension_state_", activitiProcess.getSuspensionState());
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
    public boolean convertToModel(ActivitiProcess activitiProcess) {
        if (StrUtil.isBlank(activitiProcess.getProcessDefinitionId())) {
            throw new EasyException("获取流程id失败");
        }
        if (StrUtil.isBlank(activitiProcess.getKey())) {
            throw new EasyException("标识不能为空");
        }
        if (StrUtil.isBlank(activitiProcess.getName())) {
            throw new EasyException("名称不能为空");
        }
        // 查询流程信息
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(activitiProcess.getProcessDefinitionId()).singleResult();
        // 检查标识是否存在
        if (activitiModelService.checkKeyIsExistence(activitiProcess.getKey(), null)) {
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
            model.setKey(activitiProcess.getKey());
            model.setName(activitiProcess.getName());
            model.setVersion(1);
            // MetaInfo
            ObjectNode modelNode = new ObjectMapper().createObjectNode();
            modelNode.put(ActivitiModelConst.NAME, model.getName());
            modelNode.put(ActivitiModelConst.VERSION, model.getVersion());
            modelNode.put(ActivitiModelConst.DESCRIPTION, activitiProcess.getDescription());
            model.setMetaInfo(modelNode.toString());
            // 保存模型
            repositoryService.saveModel(model);

            // 修改标识、名称、描述信息
            ObjectNode properties = objectMapper.createObjectNode();
            properties.put(ActivitiModelConst.PROPERTIES_PROCESS_ID, model.getKey());
            properties.put(ActivitiModelConst.NAME, model.getName());
            properties.put(ActivitiModelConst.PROPERTIES_PROCESS_AUTHOR, ShiroUtil.getCurrentUser().getNickname());
            properties.put(ActivitiModelConst.PROPERTIES_DOCUMENTATION, activitiProcess.getDescription());
            objectNode.set(ActivitiModelConst.PROPERTIES, properties);

            repositoryService.addModelEditorSource(model.getId(), objectNode.toString().getBytes(StandardCharsets.UTF_8));
            return true;
        } catch (XMLStreamException e) {
            logger.debug("流程转模型失败[" + processDefinition.getId() + "]", e);
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
