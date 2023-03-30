package com.easy.admin.generator.model;

import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
/**
 * 表字段
 *
 * @author tengchong
 * @date 2022/7/26
 */
public class TableField {
    private boolean keyFlag;
    private boolean keyIdentityFlag;
    private String name;
    private String propertyName;
    private IColumnType columnType;
    private String comment;
    private String columnName;

    private MetaInfo metaInfo;

    public boolean isKeyFlag() {
        return keyFlag;
    }

    public void setKeyFlag(boolean keyFlag) {
        this.keyFlag = keyFlag;
    }

    public boolean isKeyIdentityFlag() {
        return keyIdentityFlag;
    }

    public void setKeyIdentityFlag(boolean keyIdentityFlag) {
        this.keyIdentityFlag = keyIdentityFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public IColumnType getColumnType() {
        return columnType;
    }

    public void setColumnType(IColumnType columnType) {
        this.columnType = columnType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public MetaInfo getMetaInfo() {
        return metaInfo;
    }

    public void setMetaInfo(MetaInfo metaInfo) {
        this.metaInfo = metaInfo;
    }
}
