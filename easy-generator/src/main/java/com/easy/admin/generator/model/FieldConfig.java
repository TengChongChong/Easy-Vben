package com.easy.admin.generator.model;

/**
 * 表单
 *
 * @author tengchong
 * @date 2022/6/20
 */
public class FieldConfig extends TableField {

    /**
     * 字段类型
     */
    private String propertyType;
    /**
     * Label
     */
    private String label;
    /**
     * 组件类型
     */
    private String componentType;
    /**
     * 字典类型
     */
    private String dictType;
    /**
     * 栅格
     */
    private String col;
    /**
     * 匹配方式
     */
    private String matchingMode;
    /**
     * 是否必填
     */
    private Boolean required;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getMatchingMode() {
        return matchingMode;
    }

    public void setMatchingMode(String matchingMode) {
        this.matchingMode = matchingMode;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }
}
