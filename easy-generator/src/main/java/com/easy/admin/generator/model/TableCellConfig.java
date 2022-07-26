package com.easy.admin.generator.model;

/**
 * 表格
 *
 * @author tengchong
 * @date 2022/6/20
 */
public class TableCellConfig extends TableField {
    /**
     * 字段类型
     */
    private String propertyType;
    /**
     * 标题
     */
    private String title;
    /**
     * 宽度
     */
    private Integer width;
    /**
     * 字典类型
     */
    private String dictType;
    /**
     * 格式化
     */
    private String format;
    /**
     * 过滤器
     */
    private String filters;
    /**
     * 排序
     */
    private Boolean sorter;
    /**
     * 固定在左侧/右侧
     */
    private String fixed;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public Boolean getSorter() {
        return sorter;
    }

    public void setSorter(Boolean sorter) {
        this.sorter = sorter;
    }

    public String getFixed() {
        return fixed;
    }

    public void setFixed(String fixed) {
        this.fixed = fixed;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }
}
