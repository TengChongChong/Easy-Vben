package com.easy.admin.generator.model;

/**
 * 列配置
 *
 * @author TengChongChong
 * @date 2019-01-10
 */
public class FieldSet {
    /**
     * 列名称
     */
    private String columnName;
    /**
     * 类型
     */
    private String columnType;
    /**
     * 是否key
     */
    private String keyFlag;
    /**
     * 注释
     */
    private String columnComment;
    /**
     * 属性名称
     */
    private String propertyName;
    /**
     * 属性类型
     */
    private String propertyType;

    /**
     * 是否显示在list 表格字段中
     */
    private boolean showInList;
    /**
     * 是否显示在list查询条件区域
     */
    private boolean showInSearch;
    /**
     * 是否显示在input页面
     */
    private boolean showInInput;
    /**
     * 是否必填
     */
    private boolean required;
    /**
     * 表单验证
     */
    private String validate;
    /**
     * input页面提示文字
     */
    private String remarks;
    /**
     * 输入框类型
     */
    private String elementType;
    /**
     * 匹配方式
     */
    private String matchingMode;
    /**
     * 字典类型
     */
    private String dictType;
    /**
     * 在栅格中占多少位置
     */
    private String inputGrid;
    /**
     * 是否使用新行
     */
    private boolean newRow;
    /**
     * list 标题
     */
    private String title;
    /**
     * input 输入框名称
     */
    private String label;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public boolean getShowInList() {
        return showInList;
    }

    public void setShowInList(boolean showInList) {
        this.showInList = showInList;
    }

    public boolean getShowInSearch() {
        return showInSearch;
    }

    public void setShowInSearch(boolean showInSearch) {
        this.showInSearch = showInSearch;
    }

    public boolean getShowInInput() {
        return showInInput;
    }

    public void setShowInInput(boolean showInInput) {
        this.showInInput = showInInput;
    }

    public boolean getRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getMatchingMode() {
        return matchingMode;
    }

    public void setMatchingMode(String matchingMode) {
        this.matchingMode = matchingMode;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getInputGrid() {
        return inputGrid;
    }

    public void setInputGrid(String inputGrid) {
        this.inputGrid = inputGrid;
    }

    public boolean getNewRow() {
        return newRow;
    }

    public void setNewRow(boolean newRow) {
        this.newRow = newRow;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getKeyFlag() {
        return keyFlag;
    }

    public void setKeyFlag(String keyFlag) {
        this.keyFlag = keyFlag;
    }
}
