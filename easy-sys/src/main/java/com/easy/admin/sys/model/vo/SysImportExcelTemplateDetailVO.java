package com.easy.admin.sys.model.vo;

/**
 * 数据导入 - 导入规则
 *
 * @author TengChongChong
 * @date 2024-05-14
 **/
public class SysImportExcelTemplateDetailVO {
    /**
     * 数据库字段名
     */
    private String fieldName;

    /**
     * 导入时Excel 字段下标
     */
    private Integer index;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
