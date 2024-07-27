package com.easy.admin.generator.model;

import lombok.Data;

/**
 * 表格
 *
 * @author tengchong
 * @date 2022/6/20
 */
@Data
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
}
