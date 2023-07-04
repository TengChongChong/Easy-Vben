package com.easy.admin.generator.model;

import com.easy.admin.generator.constant.GeneratorFileConst;
import com.easy.admin.generator.constant.GeneratorMethodConst;

import java.util.List;

/**
 * 基础信息
 *
 * @author tengchong
 * @date 2022/6/20
 */
public class BasicsConfig {
    /**
     * 数据源
     */
    private String dataSource;
    /**
     * 表
     */
    private String table;
    /**
     * 生成模版 - 列表
     */
    private String listGeneratorTemplate;
    /**
     * 生成模版 - 表单
     */
    private String formGeneratorTemplate;
    /**
     * 生成方法
     */
    private List<String> genMethod;
    /**
     * 生成文件
     */
    private List<String> genFile;
    /**
     * 后端项目路径
     */
    private String backEndPath;
    /**
     * 业务名称
     */
    private String businessName;
    /**
     * 作者
     */
    private String author;
    /**
     * 实体类名称
     */
    private String modelName;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 权限标识
     */
    private String permissionCode;
    /**
     * 包路径
     */
    private String packagePath;
    /**
     * Controller Mapping
     */
    private String controllerMapping;
    /**
     * 前端项目路径
     */
    private String frontEndPath;
    /**
     * 页面路径
     */
    private String viewPath;
    /**
     * api路径
     */
    private String apiPath;

    /**
     * 覆盖已存在文件
     */
    private Boolean overwrite;

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getListGeneratorTemplate() {
        return listGeneratorTemplate;
    }

    public void setListGeneratorTemplate(String listGeneratorTemplate) {
        this.listGeneratorTemplate = listGeneratorTemplate;
    }

    public String getFormGeneratorTemplate() {
        return formGeneratorTemplate;
    }

    public void setFormGeneratorTemplate(String formGeneratorTemplate) {
        this.formGeneratorTemplate = formGeneratorTemplate;
    }

    public List<String> getGenMethod() {
        return genMethod;
    }

    public void setGenMethod(List<String> genMethod) {
        this.genMethod = genMethod;
    }

    public List<String> getGenFile() {
        return genFile;
    }

    public void setGenFile(List<String> genFile) {
        this.genFile = genFile;
    }

    public String getBackEndPath() {
        return backEndPath;
    }

    public void setBackEndPath(String backEndPath) {
        this.backEndPath = backEndPath;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getControllerMapping() {
        return controllerMapping;
    }

    public void setControllerMapping(String controllerMapping) {
        this.controllerMapping = controllerMapping;
    }

    public String getFrontEndPath() {
        return frontEndPath;
    }

    public void setFrontEndPath(String frontEndPath) {
        this.frontEndPath = frontEndPath;
    }

    public String getViewPath() {
        return viewPath;
    }

    public void setViewPath(String viewPath) {
        this.viewPath = viewPath;
    }

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public Boolean getOverwrite() {
        return overwrite;
    }

    public void setOverwrite(Boolean overwrite) {
        this.overwrite = overwrite;
    }

    /**
     * 是否生成新增方法
     *
     * @return true/false
     */
    public boolean isGeneratorMethodsAdd() {
        return this.genMethod != null && this.genMethod.contains(GeneratorMethodConst.ADD);
    }

    /**
     * 是否生成删除方法
     *
     * @return true/false
     */
    public boolean isGeneratorMethodsRemove() {
        return this.genMethod != null && this.genMethod.contains(GeneratorMethodConst.REMOVE);
    }

    /**
     * 是否生成保存方法
     *
     * @return true/false
     */
    public boolean isGeneratorMethodsSave() {
        return this.genMethod != null && this.genMethod.contains(GeneratorMethodConst.SAVE);
    }

    /**
     * 是否生成查询方法
     *
     * @return true/false
     */
    public boolean isGeneratorMethodsSelect() {
        return this.genMethod != null && this.genMethod.contains(GeneratorMethodConst.SELECT);
    }

    /**
     * 是否生成导入数据方法
     *
     * @return true/false
     */
    public boolean isGeneratorMethodsImport() {
        return this.genMethod != null && this.genMethod.contains(GeneratorMethodConst.IMPORT_DATA);
    }

    /**
     * 是否生成导出数据方法
     *
     * @return true/false
     */
    public boolean isGeneratorMethodsExport() {
        return this.genMethod != null && this.genMethod.contains(GeneratorMethodConst.EXPORT_DATA);
    }

    /**
     * 是否生成实体类
     *
     * @return true/false
     */
    public boolean isGeneratorFileModel() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.MODEL);
    }

    /**
     * 是否生成Dao
     *
     * @return true/false
     */
    public boolean isGeneratorFileMapper() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.MAPPER);
    }

    /**
     * 是否生成Mapping
     *
     * @return true/false
     */
    public boolean isGeneratorFileMapping() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.MAPPER);
    }

    /**
     * 是否生成Service
     *
     * @return true/false
     */
    public boolean isGeneratorFileService() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.SERVICE);
    }

    /**
     * 是否生成Service实现类
     *
     * @return true/false
     */
    public boolean isGeneratorFileServiceImpl() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.SERVICE);
    }

    /**
     * 是否生成Controller
     *
     * @return true/false
     */
    public boolean isGeneratorFileController() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.CONTROLLER);
    }

    /**
     * 是否生成列表页
     *
     * @return true/false
     */
    public boolean isGeneratorFileListView() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.LIST_VUE);
    }

    /**
     * 是否生成表单页
     *
     * @return true/false
     */
    public boolean isGeneratorFileInputView() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.INPUT_VUE);
    }

    /**
     * 是否生成接口js
     *
     * @return true/false
     */
    public boolean isGeneratorFileApi() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.API_TS);
    }

    /**
     * 是否生成model.ts
     *
     * @return true/false
     */
    public boolean isGeneratorFileModelTs() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.MODEL_TS);
    }

}
