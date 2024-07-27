package com.easy.admin.generator.model;

import lombok.Data;
import org.apache.ibatis.type.JdbcType;

/**
 * 字段属性
 *
 * @author tengchong
 * @date 2023/3/23
 */
@Data
public class MetaInfo {
    /**
     * 长度
     */
    private int length;
    /**
     * 是否可以为空
     */
    private boolean nullable;
    /**
     * 字段注释
     */
    private String remarks;
    /**
     * 默认值
     */
    private String defaultValue;

    private int scale;
    /**
     * 字段类型
     */
    private JdbcType jdbcType;

}
