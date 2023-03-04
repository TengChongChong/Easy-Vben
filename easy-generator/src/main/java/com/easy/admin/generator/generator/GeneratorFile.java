package com.easy.admin.generator.generator;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.system.SystemUtil;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.generator.constant.GeneratorConst;
import com.easy.admin.generator.constant.GeneratorImportConst;
import com.easy.admin.generator.model.GeneratorConfig;
import com.easy.admin.generator.util.*;
import com.easy.admin.sys.common.constant.SysConst;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * 生成文件
 *
 * @author tengchong
 * @date 2022/6/20
 */
public class GeneratorFile {

    private GroupTemplate groupTemplate;

    private Template pageTemplate;

    /**
     * 模版
     */
    protected String template;

    /**
     * 生成信息
     */
    protected GeneratorConfig generatorConfig;

    /**
     * 表信息
     */
    protected TableInfo tableInfo;

    /**
     * 需要导入的包
     */
    protected List<Class<?>> imports;

    /**
     * 生成文件路径
     */
    protected String filePath;

    /**
     * 后端根目录
     */
    protected String backEndPathBasePath;

    /**
     * 构造
     *
     * @param generatorConfig 生成配置
     * @param tableInfo       表信息
     */
    public GeneratorFile(GeneratorConfig generatorConfig, TableInfo tableInfo) {
        this.generatorConfig = generatorConfig;
        this.tableInfo = tableInfo;
        this.imports = new ArrayList<>();
        initBeetlEngine();
        initBackEndPathBasePath();
        init();

        this.pageTemplate = this.groupTemplate.getTemplate(template);
        configTemplate();
        binding();
    }

    /**
     * 初始化
     */
    public void init() {

    }

    public void binding() {

    }

    /**
     * 初始化后端Base Path
     */
    public void initBackEndPathBasePath() {
        if (StrUtil.isNotBlank(generatorConfig.getBasicsConfig().getPackagePath())) {
            this.backEndPathBasePath = generatorConfig.getBasicsConfig().getBackEndPath() +
                    GeneratorConst.JAVA_PATH +
                    (SystemUtil.getOsInfo().isWindows() ? generatorConfig.getBasicsConfig().getPackagePath().replaceAll("\\.", "\\\\") : generatorConfig.getBasicsConfig().getPackagePath().replaceAll("\\.", File.separator)) +
                    File.separator;
        }
    }

    /**
     * 生成文件
     */
    public void generator() {
        File file = new File(filePath);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            if (!parentFile.mkdirs()) {
                throw new EasyException("文件夹创建失败[" + parentFile.getPath() + "]");
            }
        }
        // 如果勾选了"覆盖已有文件" 或 文件不存在
        boolean needGenerator = (generatorConfig.getBasicsConfig().getOverwrite() != null && generatorConfig.getBasicsConfig().getOverwrite()) || !file.exists();
        if (needGenerator) {
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
        this.groupTemplate = new GroupTemplate(resourceLoader, configuration);
        // 拓展
        this.groupTemplate.registerFunctionPackage("GeneratorUtil", GeneratorUtil.class);
        this.groupTemplate.registerFunctionPackage("GeneratorJavaUtil", GeneratorJavaUtil.class);
        this.groupTemplate.registerFunctionPackage("GeneratorTsUtil", GeneratorTsUtil.class);
        this.groupTemplate.registerFunctionPackage("GeneratorVueUtil", GeneratorVueUtil.class);
        this.groupTemplate.registerFunctionPackage("GeneratorXmlUtil", GeneratorXmlUtil.class);

        this.groupTemplate.registerFunctionPackage("strUtil", StrUtil.class);
        this.groupTemplate.registerFunctionPackage("arrayUtil", ArrayUtil.class);
        // 常量
        this.groupTemplate.setSharedVars(getVars(GeneratorImportConst.class));
    }

    private void configTemplate() {
        this.pageTemplate.binding("isMaster", SysConst.projectProperties.getDynamicPrimary().equals(generatorConfig.getBasicsConfig().getDataSource()));
        this.pageTemplate.binding("commonComment", commonComment());
        this.pageTemplate.binding("basicsConfig", generatorConfig.getBasicsConfig());
        this.pageTemplate.binding("queryConfig", generatorConfig.getQueryConfig());
        this.pageTemplate.binding("tableConfig", generatorConfig.getTableConfig());
        this.pageTemplate.binding("inputConfig", generatorConfig.getInputConfig());
        this.pageTemplate.binding("importConfig", generatorConfig.getImportConfig());
        this.pageTemplate.binding("exportConfig", generatorConfig.getExportConfig());
        this.pageTemplate.binding("tableInfo", tableInfo);
        this.pageTemplate.binding("imports", imports);
        this.pageTemplate.binding("date", DateUtil.today());
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

    /**
     * 获取类中的变量
     *
     * @param c class
     * @return map
     */
    private Map<String, Object> getVars(Class c) {
        Field[] fields = c.getFields();
        Map<String, Object> property = new HashMap<>(fields.length);
        for (Field field : fields) {
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

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public GeneratorConfig getGeneratorConfig() {
        return generatorConfig;
    }

    public void setGeneratorConfig(GeneratorConfig generatorConfig) {
        this.generatorConfig = generatorConfig;
    }

    public List<Class<?>> getImports() {
        return imports;
    }

    public void setImports(List<Class<?>> imports) {
        this.imports = imports;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public GroupTemplate getGroupTemplate() {
        return groupTemplate;
    }

    public void setGroupTemplate(GroupTemplate groupTemplate) {
        this.groupTemplate = groupTemplate;
    }

    public Template getPageTemplate() {
        return pageTemplate;
    }

    public void setPageTemplate(Template pageTemplate) {
        this.pageTemplate = pageTemplate;
    }
}
