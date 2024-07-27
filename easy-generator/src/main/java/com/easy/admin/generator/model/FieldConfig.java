package com.easy.admin.generator.model;

import lombok.Data;

/**
 * 表单
 *
 * @author tengchong
 * @date 2022/6/20
 */
@Data
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
}
