package com.easy.admin.activiti.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.activiti.constant.ActivitiModelConst;
import com.easy.admin.activiti.constant.status.ActivitiSuspensionStatus;
import com.easy.admin.activiti.dao.ActivitiModelMapper;
import com.easy.admin.activiti.model.ActivitiModel;
import com.easy.admin.activiti.service.ActivitiModelService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.sys.model.SysDownload;
import com.easy.admin.sys.service.SysDownloadService;
import com.easy.admin.util.ShiroUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.persistence.entity.ModelEntity;
import org.activiti.engine.repository.Deployment;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.commons.io.IOUtils;
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

import static org.activiti.editor.constants.ModelDataJsonConstants.MODEL_DESCRIPTION;
import static org.activiti.editor.constants.ModelDataJsonConstants.MODEL_NAME;

/**
 * Activiti 流程模型
 * 部分代码来源于 Activiti（StencilsetRestResource.java、ModelEditorJsonRestResource.java、ModelSaveRestResource.java）
 *
 * @author TengChongChong
 * @date 2019-07-02
 */
@Service
public class ActivitiModelServiceImpl extends ServiceImpl<ActivitiModelMapper, ActivitiModel> implements ActivitiModelService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private SysDownloadService sysDownloadService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Page<ActivitiModel> select(ActivitiModel activitiModel, Page<ActivitiModel> page) {
        QueryWrapper<ActivitiModel> queryWrapper = new QueryWrapper<>();
        if (activitiModel != null) {
            // 名称
            if (StrUtil.isNotBlank(activitiModel.getName())) {
                queryWrapper.like("arm.name_", activitiModel.getName());
            }
            // key
            if (StrUtil.isNotBlank(activitiModel.getKey())) {
                queryWrapper.like("arm.key_", activitiModel.getKey());
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
                logger.debug("读取模型信息失败[{}]", model.getId(), e);
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
            logger.debug("读取模型信息失败[{}]", model.getId(), e);
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
    public ModelEntity saveData(ActivitiModel activitiModel) {
        if (StrUtil.isBlank(activitiModel.getKey())) {
            throw new EasyException("标识不能为空");
        }
        if (StrUtil.isBlank(activitiModel.getName())) {
            throw new EasyException("名称不能为空");
        }
        if (StrUtil.isBlank(activitiModel.getId())) {
            activitiModel.setId(null);
        }
        if (StrUtil.isBlank(activitiModel.getCategory())) {
            activitiModel.setCategory(null);
        }
        if (checkKeyIsExistence(activitiModel.getKey(), activitiModel.getId())) {
            throw new EasyException("标识已存在，请修改后重试");
        }
        //流程版本
        int revision = 1;

        ObjectNode modelNode = objectMapper.createObjectNode();
        modelNode.put(ModelDataJsonConstants.MODEL_NAME, activitiModel.getName());
        modelNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, activitiModel.getDescription());
        modelNode.put(ModelDataJsonConstants.MODEL_REVISION, revision);
        activitiModel.setMetaInfo(modelNode.toString());
        // 保存模型信息
        ModelEntity modelEntity = activitiModel.getModelEntity();
        repositoryService.saveModel(modelEntity);
        activitiModel.setId(modelEntity.getId());
        setModelEditorSource(activitiModel);

        return modelEntity;
    }

    private void setModelEditorSource(ActivitiModel activitiModel) {
        if (StrUtil.isNotBlank(activitiModel.getPath())) {
            InputStream bpmnStream;
            try {
                bpmnStream = new FileInputStream(activitiModel.getPath());
            } catch (FileNotFoundException e) {
                throw new EasyException("读取模型文件失败，文件不存在");
            }
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            // 读取bpmn.xml
            InputStreamReader inputStreamReader = new InputStreamReader(bpmnStream, StandardCharsets.UTF_8);
            XMLStreamReader xmlStreamReader;
            try {
                xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStreamReader);
            } catch (XMLStreamException xmlStreamException) {
                throw new EasyException("保存模型信息失败" + xmlStreamException.getMessage());
            }
            BpmnModel bpmnModel = new BpmnXMLConverter().convertToBpmnModel(xmlStreamReader);
            bpmnModel.getMainProcess();

            // xml 转 json
            BpmnJsonConverter bpmnJsonConverter = new BpmnJsonConverter();
            ObjectNode objectNode = bpmnJsonConverter.convertToJson(bpmnModel);

            // 修改标识、名称、描述信息
            ObjectNode properties = objectMapper.createObjectNode();
            properties.put(ActivitiModelConst.PROPERTIES_PROCESS_ID, activitiModel.getKey());
            properties.put(ActivitiModelConst.NAME, activitiModel.getName());
            properties.put(ActivitiModelConst.PROPERTIES_PROCESS_AUTHOR, ShiroUtil.getCurrentUser().getNickname());
            properties.put(ActivitiModelConst.PROPERTIES_DOCUMENTATION, activitiModel.getDescription());
            objectNode.set(ActivitiModelConst.PROPERTIES, properties);
            repositoryService.addModelEditorSource(activitiModel.getId(), objectNode.toString().getBytes(StandardCharsets.UTF_8));
        } else {
            // ModelEditorSource
            String modelId = activitiModel.getId();
            // 流程属性
            ObjectNode properties = objectMapper.createObjectNode();
            properties.put(ActivitiModelConst.PROPERTIES_PROCESS_ID, activitiModel.getKey());
            properties.put(ActivitiModelConst.NAME, activitiModel.getName());
            properties.put(ActivitiModelConst.PROPERTIES_PROCESS_AUTHOR, ShiroUtil.getCurrentUser().getNickname());
            properties.put(ActivitiModelConst.PROPERTIES_DOCUMENTATION, activitiModel.getDescription());

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
    public void saveModel(String id, String name, String description, String jsonXml, String svgXml) {
        org.activiti.engine.repository.Model model = repositoryService.getModel(id);
        if (model == null) {
            throw new EasyException("获取模型信息失败[modelId = " + id + "]");
        }
        ObjectNode modelJson;
        try {
            modelJson = (ObjectNode) objectMapper.readTree(model.getMetaInfo());
        } catch (IOException e) {
            throw new EasyException("获取模型MetaInfo失败");
        }
        modelJson.put(MODEL_NAME, name);
        modelJson.put(MODEL_DESCRIPTION, description);
        model.setMetaInfo(modelJson.toString());
        model.setName(name);
        model.setVersion(model.getVersion() + 1);
        // 保存
        repositoryService.saveModel(model);
        try {
            repositoryService.addModelEditorSource(model.getId(), jsonXml.getBytes(StandardCharsets.UTF_8));
            InputStream svgStream = new ByteArrayInputStream(svgXml.getBytes(StandardCharsets.UTF_8));
            TranscoderInput input = new TranscoderInput(svgStream);

            PNGTranscoder transcoder = new PNGTranscoder();
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            TranscoderOutput output = new TranscoderOutput(outStream);

            transcoder.transcode(input, output);
            final byte[] result = outStream.toByteArray();
            repositoryService.addModelEditorSourceExtra(model.getId(), result);
            outStream.close();

        } catch (IOException | TranscoderException e) {
            logger.info("保存模型信息失败", e);
            throw new EasyException(e.getMessage());
        }
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
            logger.debug("读取模型信息失败", e);
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
        // todo: 这里设置的name没有生效
        Deployment deployment = repositoryService.createDeployment().name(model.getName())
                .addString(processName, new String(modelBytes, StandardCharsets.UTF_8))
                .deploy();
        // 设置模型关联的流程id
        model.setDeploymentId(deployment.getId());
        repositoryService.saveModel(model);
        return true;
    }

    @Override
    public boolean checkKeyIsExistence(String key, String id) {
        QueryWrapper<ActivitiModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("key_", key);
        if (StrUtil.isNotBlank(id)) {
            queryWrapper.ne("id_", id);
        }
        return baseMapper.selectCountByKey(queryWrapper) > 0;
    }

    @Override
    public String selectProcessDefinitionId(String key) {
        String processDefinitionId = baseMapper.selectProcessDefinitionId(key, ActivitiSuspensionStatus.ACTIVATION.getCode());
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
        // 写入文件
        String bpmnPath = com.easy.admin.util.file.FileUtil.getTemporaryPath() + IdUtil.randomUUID() + ".bpmn20.xml";
        FileUtil.writeBytes(bpmnModelXmlByte, new File(bpmnPath));

        SysDownload sysDownload = new SysDownload();
        sysDownload.setName(model.getName() + "(" + model.getKey() + ") v." + +model.getVersion() + ".bpmn20.xml");
        sysDownload.setPath(bpmnPath);
        return sysDownloadService.saveData(sysDownload).getId();
    }
}
