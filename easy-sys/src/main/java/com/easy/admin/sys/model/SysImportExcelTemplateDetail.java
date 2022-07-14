package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.easy.admin.util.office.ImportExportUtil;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 导入模板详情
 *
 * @author TengChong
 * @date 2019-04-10
 */
@TableName("sys_import_excel_template_detail")
public class SysImportExcelTemplateDetail extends Model<SysImportExcelTemplateDetail> {

    @TableId(value = "id")
    private String id;

    /**
     * 模板id
     */
    @NotNull(message = "模板id不能为空")
    private String templateId;

    /**
     * 数据库字段名
     */
    @NotBlank(message = "数据库字段名不能为空")
    private String fieldName;

    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    private String title;

    /**
     * 字段长度
     */
    private Integer fieldLength;

    /**
     * 字段类型
     */
    @NotBlank(message = "字段类型不能为空")
    private String fieldType;

    /**
     * 替换表(小写)
     */
    private String replaceTable;

    /**
     * 替换表-名称
     */
    private String replaceTableFieldName;

    /**
     * 替换表-值
     */
    private String replaceTableFieldValue;

    /**
     * 替换表-字典类型
     */
    private String replaceTableDictType;

    /**
     * 排序值
     */
    @NotNull(message = "排序值不能为空")
    private Integer orderNo;

    /**
     * 是否必填
     */
    private Boolean required;

    /**
     * 是否唯一
     */
    private Boolean only;
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    @TableField(fill = FieldFill.INSERT)
    private String createUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date editDate;

    //
    /**
     * 是否是日期
     */
    @TableField(exist = false)
    private boolean isDate;
    /**
     * 是否是数字
     */
    @TableField(exist = false)
    private boolean isNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(Integer fieldLength) {
        this.fieldLength = fieldLength;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getReplaceTable() {
        return replaceTable;
    }

    public void setReplaceTable(String replaceTable) {
        this.replaceTable = replaceTable;
    }

    public String getReplaceTableFieldName() {
        return replaceTableFieldName;
    }

    public void setReplaceTableFieldName(String replaceTableFieldName) {
        this.replaceTableFieldName = replaceTableFieldName;
    }

    public String getReplaceTableFieldValue() {
        return replaceTableFieldValue;
    }

    public void setReplaceTableFieldValue(String replaceTableFieldValue) {
        this.replaceTableFieldValue = replaceTableFieldValue;
    }

    public String getReplaceTableDictType() {
        return replaceTableDictType;
    }

    public void setReplaceTableDictType(String replaceTableDictType) {
        this.replaceTableDictType = replaceTableDictType;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getEditUser() {
        return editUser;
    }

    public void setEditUser(String editUser) {
        this.editUser = editUser;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Boolean getOnly() {
        return only;
    }

    public void setOnly(Boolean only) {
        this.only = only;
    }

    /**
     * 是否日期格式
     *
     * @return true/false
     */
    public boolean getIsDate() {
        return ImportExportUtil.isDate(this.fieldType);
    }

    /**
     * 是否数字
     *
     * @return true/false
     */
    public boolean getIsNumber() {
        return ImportExportUtil.isInteger(this.fieldType) ||
                ImportExportUtil.isLong(this.fieldType) ||
                ImportExportUtil.isDouble(this.fieldType);
    }

}
