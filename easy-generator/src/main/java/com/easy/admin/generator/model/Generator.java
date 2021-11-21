package com.easy.admin.generator.model;

import cn.hutool.core.date.DateUtil;
import com.easy.admin.generator.constant.GeneratorFileConst;
import com.easy.admin.generator.constant.GeneratorMethodConst;

import java.util.List;

/**
 * 代码生成
 *
 * @author TengChongChong
 * @date 2019-01-08
 */
public class Generator {
    /**
     * 表名
     */
    private String tableName;
    /**
     * 业务名称
     */
    private String businessName;
    /**
     * 实体类名称
     */
    private String modelName;
    /**
     * 作者
     */
    private String author;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 包路径
     */
    private String packagePath;
    /**
     * 权限前缀
     */
    private String permissionsCode;
    /**
     * controller @RequestMapping 注解值
     */
    private String controllerMapping;
    /**
     * 视图路径
     */
    private String viewPath;
    /**
     * 接口路径
     */
    private String apiPath;
    /**
     * 后端项目路径
     */
    private String backEndPath;
    /**
     * 前端项目路径
     */
    private String frontEndPath;

    /**
     * 替换现有文件
     */
    private boolean replace = false;

    /**
     * 创建时间
     */
    private String date = DateUtil.today();

    /**
     * controller 包路径
     */
    private String controllerPackage;
    /**
     * 生成的方法
     */
    private List<String> genMethod;
    /**
     * 生成的文件
     */
    private List<String> genFile;

    /**
     * 查询条件排序
     */
    private List<FieldSet> queryItems;
    /**
     * 列表字段排序
     */
    private List<FieldSet> tableItems;
    /**
     * 表单页面字段排序
     */
    private List<FieldSet> inputItems;

    /**
     * 导入字段排序
     */
    private List<FieldSet> importItems;

    /**
     * 导出字段排序
     */
    private List<FieldSet> exportItems;
    /**
     * 列配置
     */
    private List<FieldSet> fieldSets;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getPermissionsCode() {
        return permissionsCode;
    }

    public void setPermissionsCode(String permissionsCode) {
        this.permissionsCode = permissionsCode;
    }

    public String getControllerMapping() {
        return controllerMapping;
    }

    public void setControllerMapping(String controllerMapping) {
        this.controllerMapping = controllerMapping;
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

    public String getBackEndPath() {
        return backEndPath;
    }

    public void setBackEndPath(String backEndPath) {
        this.backEndPath = backEndPath;
    }

    public String getFrontEndPath() {
        return frontEndPath;
    }

    public void setFrontEndPath(String frontEndPath) {
        this.frontEndPath = frontEndPath;
    }

    public boolean isReplace() {
        return replace;
    }

    public void setReplace(boolean replace) {
        this.replace = replace;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    public void setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
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

    public List<FieldSet> getQueryItems() {
        return queryItems;
    }

    public void setQueryItems(List<FieldSet> queryItems) {
        this.queryItems = queryItems;
    }

    public List<FieldSet> getTableItems() {
        return tableItems;
    }

    public void setTableItems(List<FieldSet> tableItems) {
        this.tableItems = tableItems;
    }

    public List<FieldSet> getInputItems() {
        return inputItems;
    }

    public void setInputItems(List<FieldSet> inputItems) {
        this.inputItems = inputItems;
    }

    public List<FieldSet> getFieldSets() {
        return fieldSets;
    }

    public void setFieldSets(List<FieldSet> fieldSets) {
        this.fieldSets = fieldSets;
    }

    /**
     * 是否生成新增方法
     *
     * @return true/false
     */
    public boolean isGeneratorMethodsAdd(){
        return this.genMethod != null && this.genMethod.contains(GeneratorMethodConst.ADD);
    }
    /**
     * 是否生成删除方法
     *
     * @return true/false
     */
    public boolean isGeneratorMethodsRemove(){
        return this.genMethod != null && this.genMethod.contains(GeneratorMethodConst.REMOVE);
    }
    /**
     * 是否生成保存方法
     *
     * @return true/false
     */
    public boolean isGeneratorMethodsSave(){
        return this.genMethod != null && this.genMethod.contains(GeneratorMethodConst.SAVE);
    }
    /**
     * 是否生成查询方法
     *
     * @return true/false
     */
    public boolean isGeneratorMethodsSelect(){
        return this.genMethod != null && this.genMethod.contains(GeneratorMethodConst.SELECT);
    }
    /**
     * 是否生成导入数据方法
     *
     * @return true/false
     */
    public boolean isGeneratorMethodsImport(){
        return this.genMethod != null && this.genMethod.contains(GeneratorMethodConst.IMPORT_DATA);
    }
    /**
     * 是否生成导出数据方法
     *
     * @return true/false
     */
    public boolean isGeneratorMethodsExport(){
        return this.genMethod != null && this.genMethod.contains(GeneratorMethodConst.EXPORT_DATA);
    }

    /**
     * 是否生成实体类
     *
     * @return true/false
     */
    public boolean isGeneratorFileModel(){
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.MODEL);
    }
    /**
     * 是否生成Dao
     *
     * @return true/false
     */
    public boolean isGeneratorFileDao(){
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.DAO);
    }
    /**
     * 是否生成Mapping
     *
     * @return true/false
     */
    public boolean isGeneratorFileMapping(){
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.MAPPING);
    }
    /**
     * 是否生成Service
     *
     * @return true/false
     */
    public boolean isGeneratorFileService(){
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.SERVICE);
    }
    /**
     * 是否生成Service实现类
     *
     * @return true/false
     */
    public boolean isGeneratorFileServiceImpl(){
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.SERVICE_IMPL);
    }
    /**
     * 是否生成Controller
     *
     * @return true/false
     */
    public boolean isGeneratorFileController(){
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.CONTROLLER);
    }
    /**
     * 是否生成列表页
     *
     * @return true/false
     */
    public boolean isGeneratorFileListView(){
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.LIST_VUE);
    }
    /**
     * 是否生成表单页
     *
     * @return true/false
     */
    public boolean isGeneratorFileInputView(){
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.INPUT_VUE);
    }
    /**
     * 是否生成接口js
     *
     * @return true/false
     */
    public boolean isGeneratorFileApi(){
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.API_JS);
    }

    public List<FieldSet> getImportItems() {
        return importItems;
    }

    public void setImportItems(List<FieldSet> importItems) {
        this.importItems = importItems;
    }

    public List<FieldSet> getExportItems() {
        return exportItems;
    }

    public void setExportItems(List<FieldSet> exportItems) {
        this.exportItems = exportItems;
    }
}
