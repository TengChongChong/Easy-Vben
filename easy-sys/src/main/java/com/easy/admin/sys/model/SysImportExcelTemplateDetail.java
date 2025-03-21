package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * 导入模板详情
 *
 * @author TengChong
 * @date 2019-04-10
 */
@Data
@TableName("sys_import_excel_template_detail")
public class SysImportExcelTemplateDetail extends Model<SysImportExcelTemplateDetail> {

    @TableId
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
    private Boolean dataRequired;

    /**
     * 是否唯一
     */
    private Boolean dataOnly;

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

    /**
     * 导入时Excel 字段下标
     */
    @TableField(exist = false)
    private Integer index;
}
