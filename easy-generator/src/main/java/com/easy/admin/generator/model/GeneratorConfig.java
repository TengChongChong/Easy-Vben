package com.easy.admin.generator.model;


import java.util.List;

/**
 * 生成配置
 *
 * @author tengchong
 * @date 2022/6/20
 */
public class GeneratorConfig {
    /**
     * 基础
     */
    BasicsConfig basicsConfig;
    /**
     * 查询条件
     */
    List<FieldConfig> queryConfig;
    /**
     * 列表
     */
    List<TableCellConfig> tableConfig;
    /**
     * 表单
     */
    List<FieldConfig> inputConfig;
    /**
     * 导入
     */
    List<ImportCellConfig> importConfig;
    /**
     * 导出
     */
    List<TableCellConfig> exportConfig;

    public BasicsConfig getBasicsConfig() {
        return basicsConfig;
    }

    public void setBasicsConfig(BasicsConfig basicsConfig) {
        this.basicsConfig = basicsConfig;
    }

    public List<FieldConfig> getQueryConfig() {
        return queryConfig;
    }

    public void setQueryConfig(List<FieldConfig> queryConfig) {
        this.queryConfig = queryConfig;
    }

    public List<TableCellConfig> getTableConfig() {
        return tableConfig;
    }

    public void setTableConfig(List<TableCellConfig> tableConfig) {
        this.tableConfig = tableConfig;
    }

    public List<FieldConfig> getInputConfig() {
        return inputConfig;
    }

    public void setInputConfig(List<FieldConfig> inputConfig) {
        this.inputConfig = inputConfig;
    }

    public List<ImportCellConfig> getImportConfig() {
        return importConfig;
    }

    public void setImportConfig(List<ImportCellConfig> importConfig) {
        this.importConfig = importConfig;
    }

    public List<TableCellConfig> getExportConfig() {
        return exportConfig;
    }

    public void setExportConfig(List<TableCellConfig> exportConfig) {
        this.exportConfig = exportConfig;
    }

    public boolean isGeneratorMethod(String method){
        return basicsConfig.getGenMethod() != null && basicsConfig.getGenMethod().contains(method);
    }
}
