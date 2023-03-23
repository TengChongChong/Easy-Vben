package com.easy.admin.generator.model;

import org.apache.ibatis.type.JdbcType;

/**
 * 字段属性
 *
 * @author tengchong
 * @date 2023/3/23
 */
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public JdbcType getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(JdbcType jdbcType) {
        this.jdbcType = jdbcType;
    }
}
