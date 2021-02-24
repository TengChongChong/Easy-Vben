package com.easy.restful.activiti.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.restful.activiti.constant.ModelConst;
import com.easy.restful.activiti.dao.ProcessMapper;
import com.easy.restful.activiti.model.Process;
import com.easy.restful.activiti.service.ModelService;
import com.easy.restful.activiti.service.ProcessService;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.common.core.common.select.Select;
import com.easy.restful.common.core.constant.CommonConst;
import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.util.ShiroUtil;
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
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * 流程
 *
 * @author tengchong
 * @date 2019-07-12
 */
@Service
public class ProcessServiceImpl extends ServiceImpl<ProcessMapper, Process> implements ProcessService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private ModelService modelService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Page<Process> select(Process process, Page<Process> page) {
        QueryWrapper<Process> queryWrapper = new QueryWrapper<>();
        if (process != null) {
            if (StrUtil.isNotBlank(process.getKey())) {
                queryWrapper.like("arp.key_", process.getKey());
            }
            if (StrUtil.isNotBlank(process.getName())) {
                queryWrapper.like("arp.name_", process.getName());
            }
            if (StrUtil.isNotBlank(process.getProcessDefinitionId())) {
                queryWrapper.like("arp.id_", process.getProcessDefinitionId());
            }
            if (process.getSuspensionState() != null) {
                queryWrapper.like("arp.suspension_state_", process.getSuspensionState());
            }
        }
        // 根据流程实例ID排序
        page.setDefaultDesc("ard.deploy_time_");
        page.setRecords(getBaseMapper().select(page, queryWrapper));
        return page;
    }

    @Override
    public boolean remove(String ids) {
        if (StrUtil.isBlank(ids)) {
            throw new EasyException("获取数据ids失败");
        }
        List<String> idArray = Arrays.asList(ids.split(CommonConst.SPLIT));
        idArray.forEach(id -> repositoryService.deleteDeployment(id, true));
        return true;
    }

    @Override
    public boolean convertToModel(Process process) {
        if (StrUtil.isBlank(process.getProcessDefinitionId())) {
            throw new EasyException("获取流程id失败");
        }
        if (StrUtil.isBlank(process.getKey())) {
            throw new EasyException("标识不能为空");
        }
        if (StrUtil.isBlank(process.getName())) {
            throw new EasyException("名称不能为空");
        }
        // 查询流程信息
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(process.getProcessDefinitionId()).singleResult();
        // 检查标识是否存在
        if (modelService.checkKeyIsExistence(process.getKey(), null)) {
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
            model.setKey(process.getKey());
            model.setName(process.getName());
            model.setVersion(1);
            // MetaInfo
            ObjectNode modelNode = new ObjectMapper().createObjectNode();
            modelNode.put(ModelConst.NAME, model.getName());
            modelNode.put(ModelConst.VERSION, model.getVersion());
            modelNode.put(ModelConst.DESCRIPTION, process.getDescription());
            model.setMetaInfo(modelNode.toString());
            // 保存模型
            repositoryService.saveModel(model);

            // 修改标识、名称、描述信息
            ObjectNode properties = objectMapper.createObjectNode();
            properties.put(ModelConst.PROPERTIES_PROCESS_ID, model.getKey());
            properties.put(ModelConst.NAME, model.getName());
            properties.put(ModelConst.PROPERTIES_PROCESS_AUTHOR, ShiroUtil.getCurrentUser().getNickname());
            properties.put(ModelConst.PROPERTIES_DOCUMENTATION, process.getDescription());
            objectNode.set(ModelConst.PROPERTIES, properties);

            repositoryService.addModelEditorSource(model.getId(), objectNode.toString().getBytes(StandardCharsets.UTF_8));
            return true;
        } catch (XMLStreamException e) {
            logger.debug("流程转模型失败[" + processDefinition.getId() + "]", e);
            throw new EasyException("流程转模型失败[" + processDefinition.getId() + "]" + e.getMessage());
        }
    }

    @Override
    public InputStream getImageStream(String id, String resourceName) {
        return repositoryService.getResourceAsStream(id, resourceName);
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
    public boolean add(String path) {
        File modelFile = new File(path);
        boolean isSuccess = false;
        if (!modelFile.exists()) {
            throw new EasyException("读取模型文件[" + path + "]失败，文件不存在");
        }
        String fileSuffix = modelFile.getName().substring(modelFile.getName().lastIndexOf(".") + 1);
        try {
            if ("bar".equals(fileSuffix) || "zip".equals(fileSuffix)) {
                // 压缩包
                isSuccess = deploymentZip(modelFile);
            } else if ("xml".equals(fileSuffix) || "bpmn".equals(fileSuffix)) {
                // 单个模型文件
                isSuccess = deploymentBpmn(modelFile);
            } else {
                throw new EasyException("请上传正确的模型文件[bar、zip、xml、bpmn]");
            }
        } catch (FileNotFoundException e) {
            // ignore 已经检查过文件是否存在
        }
        if (!isSuccess) {
            throw new EasyException("部署流程失败，请检查模型文件是否符合BPMN 2.0规范");
        }
        return isSuccess;
    }

    /**
     * 根据bpmn文件部署
     *
     * @param modelFile 文件
     * @return true/false （暂时全部返回true）
     */
    private boolean deploymentBpmn(File modelFile) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(modelFile.getPath());
        repositoryService.createDeployment().addInputStream(modelFile.getName(), fileInputStream).deploy();
        // todo: 验证是否部署成功
        return true;
    }

    /**
     * 根据bar/zip文件部署
     *
     * @param modelFile 文件路径
     * @return true/false （暂时全部返回true）
     */
    private boolean deploymentZip(File modelFile) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(modelFile.getPath());
        repositoryService.createDeployment().addZipInputStream(new ZipInputStream(fileInputStream)).deploy();
        return true;
    }

    @Override
    public List<Select> selectProcessForSelect() {
        return getBaseMapper().selectProcessForSelect();
    }
}
