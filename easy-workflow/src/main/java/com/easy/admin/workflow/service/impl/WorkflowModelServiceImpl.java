package com.easy.admin.workflow.service.impl;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.config.sa.token.util.SessionUtil;
import com.easy.admin.file.model.FileDownload;
import com.easy.admin.file.service.FileDownloadService;
import com.easy.admin.file.util.file.FileUtil;
import com.easy.admin.workflow.constant.ActivitiModelConst;
import com.easy.admin.workflow.constant.status.WorkflowSuspensionStatus;
import com.easy.admin.workflow.dao.WorkflowModelMapper;
import com.easy.admin.workflow.model.vo.WorkflowModelVO;
import com.easy.admin.workflow.service.WorkflowModelService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.persistence.entity.ModelEntity;
import org.activiti.engine.impl.persistence.entity.ModelEntityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.apache.commons.io.IOUtils;
import org.dromara.x.file.storage.core.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * 流程模型
 *
 * @author TengChongChong
 * @date 2025-07-14
 **/
@Slf4j
@Service
public class WorkflowModelServiceImpl extends ServiceImpl<WorkflowModelMapper, WorkflowModelVO> implements WorkflowModelService {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private FileDownloadService fileDownloadService;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public Page<WorkflowModelVO> select(WorkflowModelVO workflowModel, Page<WorkflowModelVO> page) {
        QueryWrapper<WorkflowModelVO> queryWrapper = new QueryWrapper<>();
        if (workflowModel != null) {
            // 名称
            if (StrUtil.isNotBlank(workflowModel.getName())) {
                queryWrapper.like("arm.name_", workflowModel.getName());
            }
            // key
            if (StrUtil.isNotBlank(workflowModel.getKey())) {
                queryWrapper.like("arm.key_", workflowModel.getKey());
            }
            // category
            if (StrUtil.isNotBlank(workflowModel.getCategory())) {
                queryWrapper.eq("arm.category_", workflowModel.getCategory());
            }
        }
        page.setDefaultDesc("arm.create_time_");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    @Override
    public ModelEntity get(String id) {
        return (ModelEntity) repositoryService.getModel(id);
    }

    @Override
    public ObjectNode getModel(String id) {
        org.activiti.engine.repository.Model model = repositoryService.getModel(id);
        ObjectNode objectNode;
        if (model == null) {
            throw new EasyException("模型信息不存在");
        }
        if (StrUtil.isNotBlank(model.getMetaInfo())) {
            try {
                objectNode = (ObjectNode) objectMapper.readTree(model.getMetaInfo());
            } catch (IOException e) {
                log.debug("读取模型信息失败[{}]", model.getId(), e);
                throw new EasyException("读取模型信息失败[" + model.getId() + "]");
            }
        } else {
            objectNode = objectMapper.createObjectNode();
            objectNode.put("name", model.getName());
        }
        objectNode.put("modelId", model.getId());
        ObjectNode editorJsonNode;
        try {
            editorJsonNode = (ObjectNode) objectMapper.readTree(new String(repositoryService.getModelEditorSource(model.getId()), StandardCharsets.UTF_8));
        } catch (IOException e) {
            log.debug("读取模型信息失败[{}]", model.getId(), e);
            throw new EasyException("读取模型信息失败[" + model.getId() + "]");
        }
        objectNode.set("model", editorJsonNode);
        return objectNode;
    }

    @Override
    public boolean remove(String ids) {
        if (StrUtil.isBlank(ids)) {
            throw new EasyException("获取数据ids失败");
        }
        List<String> idArray = Arrays.asList(ids.split(CommonConst.SPLIT));
        idArray.forEach(id -> repositoryService.deleteModel(id));
        return true;
    }

    @Override
    public ModelEntityImpl saveData(WorkflowModelVO workflowModel) {
        if (StrUtil.isBlank(workflowModel.getKey())) {
            throw new EasyException("流程标识不能为空");
        }
        if (StrUtil.isBlank(workflowModel.getName())) {
            throw new EasyException("流程名称不能为空");
        }
        if (StrUtil.isBlank(workflowModel.getId())) {
            workflowModel.setId(null);
        }
        if (StrUtil.isBlank(workflowModel.getCategory())) {
            workflowModel.setCategory(null);
        }
        if (checkKeyIsExistence(workflowModel.getKey(), workflowModel.getId())) {
            throw new EasyException("流程标识已存在，请修改后重试");
        }
        //流程版本
        int revision = 1;

        ObjectNode modelNode = objectMapper.createObjectNode();
        modelNode.put(ModelDataJsonConstants.MODEL_NAME, workflowModel.getName());
        modelNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, workflowModel.getDescription());
        modelNode.put(ModelDataJsonConstants.MODEL_REVISION, revision);
        workflowModel.setMetaInfo(modelNode.toString());
        // 保存模型信息
        ModelEntityImpl modelEntity = workflowModel.getModelEntity();
        repositoryService.saveModel(modelEntity);
        workflowModel.setId(modelEntity.getId());
        setModelEditorSource(workflowModel);

        return modelEntity;
    }

    private void setModelEditorSource(WorkflowModelVO workflowModel) {
        if (workflowModel.getModelFile() != null) {
            byte[] bytes = FileUtil.getFileBytes(workflowModel.getModelFile());
            InputStream bpmnStream = new ByteArrayInputStream(bytes);
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            // 读取bpmn.xml
            InputStreamReader inputStreamReader = new InputStreamReader(bpmnStream, StandardCharsets.UTF_8);
            XMLStreamReader xmlStreamReader;
            BpmnModel bpmnModel;
            try {
                xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStreamReader);
                bpmnModel = new BpmnXMLConverter().convertToBpmnModel(xmlStreamReader);
                bpmnModel.getMainProcess();
            } catch (XMLStreamException xmlStreamException) {
                throw new EasyException("保存模型信息失败" + xmlStreamException.getMessage());
            } finally {
                IoUtil.close(inputStreamReader);
                IoUtil.close(bpmnStream);
            }

            // xml 转 json
            BpmnJsonConverter bpmnJsonConverter = new BpmnJsonConverter();
            ObjectNode objectNode = bpmnJsonConverter.convertToJson(bpmnModel);

            // 修改标识、名称、描述信息
            ObjectNode properties = objectMapper.createObjectNode();
            properties.put(ActivitiModelConst.PROPERTIES_PROCESS_ID, workflowModel.getKey());
            properties.put(ActivitiModelConst.NAME, workflowModel.getName());
            properties.put(ActivitiModelConst.PROPERTIES_PROCESS_AUTHOR, SessionUtil.getCurrentUser().getNickname());
            properties.put(ActivitiModelConst.PROPERTIES_DOCUMENTATION, workflowModel.getDescription());
            objectNode.set(ActivitiModelConst.PROPERTIES, properties);
            repositoryService.addModelEditorSource(workflowModel.getId(), objectNode.toString().getBytes(StandardCharsets.UTF_8));
        } else {
            // ModelEditorSource
            String modelId = workflowModel.getId();
            // 流程属性
            ObjectNode properties = objectMapper.createObjectNode();
            properties.put(ActivitiModelConst.PROPERTIES_PROCESS_ID, workflowModel.getKey());
            properties.put(ActivitiModelConst.NAME, workflowModel.getName());
            properties.put(ActivitiModelConst.PROPERTIES_PROCESS_AUTHOR, SessionUtil.getCurrentUser().getNickname());
            properties.put(ActivitiModelConst.PROPERTIES_DOCUMENTATION, workflowModel.getDescription());

            ObjectNode editorNode = objectMapper.createObjectNode();
            editorNode.put(ActivitiModelConst.ID, "canvas");
            editorNode.put("resourceId", "canvas");
            editorNode.set(ActivitiModelConst.PROPERTIES, properties);

            ObjectNode stencilSetNode = objectMapper.createObjectNode();
            stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
            editorNode.set("stencilset", stencilSetNode);

            repositoryService.addModelEditorSource(modelId, editorNode.toString().getBytes(StandardCharsets.UTF_8));
        }
    }

    @Override
    public void saveModel(String id, String name, String description, String jsonXml) {
        Model model = repositoryService.getModel(id);
        if (model == null) {
            throw new EasyException("获取模型信息失败[modelId = " + id + "]");
        }
        ObjectNode modelJson;
        try {
            modelJson = (ObjectNode) objectMapper.readTree(model.getMetaInfo());
        } catch (IOException e) {
            throw new EasyException("获取模型MetaInfo失败");
        }
        modelJson.put(ModelDataJsonConstants.MODEL_NAME, name);
        modelJson.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
        model.setMetaInfo(modelJson.toString());
        model.setName(name);
        model.setVersion(model.getVersion() + 1);
        // 保存
        repositoryService.saveModel(model);
        //try {
        repositoryService.addModelEditorSource(model.getId(), jsonXml.getBytes(StandardCharsets.UTF_8));
        //InputStream svgStream = new ByteArrayInputStream(svgXml.getBytes(StandardCharsets.UTF_8));
        //TranscoderInput input = new TranscoderInput(svgStream);
        //
        //PNGTranscoder transcoder = new PNGTranscoder();
        //ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //TranscoderOutput output = new TranscoderOutput(outStream);
        //
        //transcoder.transcode(input, output);
        //final byte[] result = outStream.toByteArray();
        //repositoryService.addModelEditorSourceExtra(model.getId(), result);
        //outStream.close();

        //} catch (IOException | TranscoderException e) {
        //    log.info("保存模型信息失败", e);
        //    throw new EasyException(e.getMessage());
        //}
    }

    @Override
    public String getStencilset() {
        InputStream stencilSetStream = this.getClass().getClassLoader().getResourceAsStream("stencilset.json");
        if (stencilSetStream == null) {
            throw new EasyException("读取stencilset.json失败");
        }
        try {
            return IOUtils.toString(stencilSetStream, "utf-8");
        } catch (Exception e) {
            throw new ActivitiException("读取失败", e);
        }
    }

    @Override
    public boolean deploymentProcess(String id) {
        if (StrUtil.isBlank(id)) {
            throw new EasyException("获取模型id信息失败");
        }
        // 获取模型信息
        org.activiti.engine.repository.Model model = repositoryService.getModel(id);
        if (model == null) {
            throw new EasyException("模型信息不存在");
        }
        byte[] bytes = repositoryService.getModelEditorSource(id);
        if (bytes == null) {
            throw new EasyException("模型信息为空");
        }
        // 读取模型信息
        JsonNode jsonNode;
        try {
            jsonNode = new ObjectMapper().readTree(bytes);
        } catch (IOException e) {
            log.debug("读取模型信息失败", e);
            throw new EasyException("读取模型信息失败" + e.getMessage());
        }
        if (jsonNode == null) {
            throw new EasyException("读取模型信息失败");
        }
        // 验证模型结构
        BpmnModel bpmnModel = new BpmnJsonConverter().convertToBpmnModel(jsonNode);
        if (bpmnModel.getProcesses().isEmpty()) {
            throw new EasyException("请至少设计一条主线流程");
        }
        byte[] modelBytes = new BpmnXMLConverter().convertToXML(bpmnModel);
        // 部署流程
        String processName = model.getKey() + ".bpmn20.xml";
        Deployment deployment = repositoryService.createDeployment().key(model.getKey()).name(model.getName())
                .addString(processName, new String(modelBytes, StandardCharsets.UTF_8))
                .deploy();
        // 设置模型关联的流程id
        model.setDeploymentId(deployment.getId());
        repositoryService.saveModel(model);
        return true;
    }

    @Override
    public boolean checkKeyIsExistence(String key, String id) {
        QueryWrapper<WorkflowModelVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("key_", key);
        if (StrUtil.isNotBlank(id)) {
            queryWrapper.ne("id_", id);
        }
        return baseMapper.selectCountByKey(queryWrapper) > 0;
    }

    @Override
    public String selectProcessDefinitionId(String key) {
        String processDefinitionId = baseMapper.selectProcessDefinitionId(key, WorkflowSuspensionStatus.ACTIVATION.getCode());
        if (StrUtil.isBlank(processDefinitionId)) {
            throw new EasyException("流程不存在或未部署，请联系系统管理员");
        }
        return processDefinitionId;
    }

    @Override
    public String export(String id) {
        org.activiti.engine.repository.Model model = repositoryService.getModel(id);
        BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
        JsonNode editorNode = null;
        try {
            editorNode = new ObjectMapper().readTree(repositoryService.getModelEditorSource(model.getId()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editorNode);
        BpmnXMLConverter xmlConverter = new BpmnXMLConverter();
        byte[] bpmnModelXmlByte = xmlConverter.convertToXML(bpmnModel);

        InputStream inputStream = new ByteArrayInputStream(bpmnModelXmlByte);

        FileInfo fileInfo = FileUtil.upload(
                inputStream,
                model.getName() + "(" + model.getKey() + ") v." + model.getVersion() + ".bpmn20.xml",
                IdUtil.randomUUID() + ".bpmn20.xml"
        );

        //FileInfo fileInfo = fileStorageService.of(inputStream)
        //        .setPath(FileUtil.getTemporaryPath())
        //        .setSaveFilename(model.getName() + "(" + model.getKey() + ") v." + model.getVersion() + ".bpmn20.xml")
        //        .setName(IdUtil.randomUUID() + ".bpmn20.xml")
        //        .upload();

        // 保存下载信息
        return fileDownloadService.saveData(new FileDownload(fileInfo.getId())).getId();
    }
}
