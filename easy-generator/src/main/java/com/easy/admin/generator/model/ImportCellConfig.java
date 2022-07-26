package com.easy.admin.generator.model;

/**
 * 导入
 *
 * @author tengchong
 * @date 2022/6/20
 */
public class ImportCellConfig extends TableField {
    /**
     * 字段类型
     */
    private String propertyType;
    /**
     * 标题
     */
    private String title;
    /**
     * 字典类型
     */
    private String dictType;

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }
}
