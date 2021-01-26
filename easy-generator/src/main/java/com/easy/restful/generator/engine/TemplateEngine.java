package com.easy.restful.generator.engine;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.generator.constant.GeneratorFileConst;
import com.easy.restful.generator.constant.GeneratorImportConst;
import com.easy.restful.generator.constant.GeneratorTemplateConst;
import com.easy.restful.generator.engine.config.*;
import com.easy.restful.generator.model.Generator;
import com.easy.restful.generator.util.GeneratorHtmlUtil;
import com.easy.restful.generator.util.GeneratorJavaUtil;
import com.easy.restful.generator.util.GeneratorJsUtil;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 模板引擎
 *
 * @author tengchong
 * @date 2019-01-08
 */
public class TemplateEngine {
    /**
     * 生成参数
     */
    protected Generator generator;
    /**
     * controller 配置
     */
    protected ControllerConfig controllerConfig;
    /**
     * dao 配置
     */
    protected DaoConfig daoConfig;
    /**
     * service 配置
     */
    protected ServiceConfig serviceConfig;
    /**
     * service impl 配置
     */
    protected ServiceImplConfig serviceImplConfig;
    /**
     * model 配置
     */
    protected ModelConfig modelConfig;
    /**
     * mapper 配置
     */
    protected MappingConfig mappingConfig;
    /**
     * 静态文件 配置
     */
    protected StaticConfig staticConfig;

    private final TableInfo tableInfo;

    private GroupTemplate groupTemplate;

    public TemplateEngine(Generator generator, TableInfo tableInfo) {
        this.generator = generator;
        this.tableInfo = tableInfo;
        if (generator.isGeneratorFileController()) {
            this.controllerConfig = new ControllerConfig(generator);
        }
        if (generator.isGeneratorFileDao()) {
            this.daoConfig = new DaoConfig(generator);
        }
        if (generator.isGeneratorFileService()) {
            this.serviceConfig = new ServiceConfig(generator);
        }
        if (generator.isGeneratorFileServiceImpl()) {
            this.serviceImplConfig = new ServiceImplConfig(generator);
        }
        if (generator.isGeneratorFileModel()) {
            this.modelConfig = new ModelConfig(generator);
        }
        if (generator.isGeneratorFileMapping()) {
            this.mappingConfig = new MappingConfig(generator);
        }
        this.staticConfig = new StaticConfig(generator);
        initBeetlEngine();
    }

    /**
     * 使用beetl解析
     */
    private void initBeetlEngine() {
        Properties properties = new Properties();
        properties.put("RESOURCE.root", "");
        properties.put("DELIMITER_STATEMENT_START", "<%");
        properties.put("DELIMITER_STATEMENT_END", "%>");
        properties.put("HTML_TAG_FLAG", "##");
        Configuration configuration = null;
        try {
            configuration = new Configuration(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
        groupTemplate = new GroupTemplate(resourceLoader, configuration);
        // 拓展
        groupTemplate.registerFunctionPackage("GeneratorHtmlUtil", GeneratorHtmlUtil.class);
        groupTemplate.registerFunctionPackage("GeneratorJavaUtil", GeneratorJavaUtil.class);
        groupTemplate.registerFunctionPackage("GeneratorJsUtil", GeneratorJsUtil.class);
        groupTemplate.registerFunctionPackage("strUtil", StrUtil.class);
        groupTemplate.registerFunctionPackage("arrayUtil", ArrayUtil.class);

        groupTemplate.setSharedVars(getVars(GeneratorImportConst.class));

    }

    /**
     * 通用注释
     *
     * @return JSONObject
     */
    private JSONObject commonComment() {
        JSONObject commonComment = new JSONObject(4);
        commonComment.set("createUser", "创建人id");
        commonComment.set("createDate", "创建时间");
        commonComment.set("editUser", "编辑人id");
        commonComment.set("editDate", "编辑时间");
        return commonComment;
    }

    private void configTemplate(Template template) {
        template.binding("config", generator);
        template.binding("controller", controllerConfig);
        template.binding("dao", daoConfig);
        template.binding("service", serviceConfig);
        template.binding("serviceImpl", serviceImplConfig);
        template.binding("model", modelConfig);
        template.binding("mapping", mappingConfig);
        template.binding("tableInfo", tableInfo);
        template.binding("staticConfig", staticConfig);
        template.binding("commonComment", commonComment());
    }

    public void start() {
        for (String fileName : generator.getGenFile()) {
            switch (fileName) {
                case GeneratorFileConst.MODEL:
                    generatorFile(GeneratorTemplateConst.MODEL, modelConfig.getPath());
                    break;
                case GeneratorFileConst.DAO:
                    generatorFile(GeneratorTemplateConst.DAO, daoConfig.getPath());
                    break;
                case GeneratorFileConst.MAPPING:
                    generatorFile(GeneratorTemplateConst.MAPPING, mappingConfig.getPath());
                    break;
                case GeneratorFileConst.SERVICE:
                    generatorFile(GeneratorTemplateConst.SERVICE, serviceConfig.getPath());
                    break;
                case GeneratorFileConst.SERVICE_IMPL:
                    generatorFile(GeneratorTemplateConst.SERVICE_IMPL, serviceImplConfig.getPath());
                    break;
                case GeneratorFileConst.CONTROLLER:
                    generatorFile(GeneratorTemplateConst.CONTROLLER, controllerConfig.getPath());
                    break;
                case GeneratorFileConst.LIST_VUE:
                    generatorFile(GeneratorTemplateConst.LIST_VUE, staticConfig.getListVuePath());
                    break;
                case GeneratorFileConst.INPUT_VUE:
                    generatorFile(GeneratorTemplateConst.INPUT_VUE, staticConfig.getInputVuePath());
                    break;
                case GeneratorFileConst.API_JS:
                    generatorFile(GeneratorTemplateConst.API_JS, staticConfig.getApiJsPath());
                    break;
                default:
                    break;
            }
        }
    }

    protected void generatorFile(String template, String filePath) {
        Template pageTemplate = groupTemplate.getTemplate(template);
        configTemplate(pageTemplate);
        File file = new File(filePath);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            if (!parentFile.mkdirs()) {
                throw new EasyException("文件夹创建失败[" + parentFile.getPath() + "]");
            }
        }
        if (generator.isReplace() || !file.exists()) {
            // 如果勾选了"覆盖已有文件" 或 文件不存在
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file);
                pageTemplate.renderTo(fileOutputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取类中的变量
     *
     * @param c class
     * @return map
     */
    private Map<String, Object> getVars(Class c){
        Field[] fields = c.getFields();
        Map<String, Object> property = new HashMap<>(fields.length);
        for( Field field : fields ){
            try {
                property.put(field.getName(), field.get(c));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Map<String, Object> clazz = new HashMap<>(1);
        clazz.put(c.getSimpleName(), property);
        return clazz;
    }
}
