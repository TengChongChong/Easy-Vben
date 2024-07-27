package com.easy.admin.generator.model;

import lombok.Data;

/**
 * 导入
 *
 * @author tengchong
 * @date 2022/6/20
 */
@Data
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
}
