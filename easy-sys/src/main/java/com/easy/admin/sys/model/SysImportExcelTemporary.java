package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 导入临时表
 *
 * @author TengChong
 * @date 2019-04-10
 */
@Data
@TableName("sys_import_excel_temporary")
public class SysImportExcelTemporary extends Model<SysImportExcelTemporary> {

    @TableId
    @NotNull(message = "id不能为空")
    private String id;

    /**
     * 模板id
     */
    @NotNull(message = "模板id不能为空")
    private String templateId;

    /**
     * 导入用户id
     */
    private String userId;
    /**
     * 验证状态
     */
    private String verificationStatus;
    /**
     * 验证结果
     */
    private String verificationResults;

    /**
     * 导入字段
     */
    private String field1;

    /**
     * 导入字段
     */
    private String field2;

    /**
     * 导入字段
     */
    private String field3;

    /**
     * 导入字段
     */
    private String field4;

    /**
     * 导入字段
     */
    private String field5;

    /**
     * 导入字段
     */
    private String field6;

    /**
     * 导入字段
     */
    private String field7;

    /**
     * 导入字段
     */
    private String field8;

    /**
     * 导入字段
     */
    private String field9;

    /**
     * 导入字段
     */
    private String field10;

    /**
     * 导入字段
     */
    private String field11;

    /**
     * 导入字段
     */
    private String field12;

    /**
     * 导入字段
     */
    private String field13;

    /**
     * 导入字段
     */
    private String field14;

    /**
     * 导入字段
     */
    private String field15;

    /**
     * 导入字段
     */
    private String field16;

    /**
     * 导入字段
     */
    private String field17;

    /**
     * 导入字段
     */
    private String field18;

    /**
     * 导入字段
     */
    private String field19;

    /**
     * 导入字段
     */
    private String field20;

    /**
     * 导入字段
     */
    private String field21;

    /**
     * 导入字段
     */
    private String field22;

    /**
     * 导入字段
     */
    private String field23;

    /**
     * 导入字段
     */
    private String field24;

    /**
     * 导入字段
     */
    private String field25;

    /**
     * 导入字段
     */
    private String field26;

    /**
     * 导入字段
     */
    private String field27;

    /**
     * 导入字段
     */
    private String field28;

    /**
     * 导入字段
     */
    private String field29;

    /**
     * 导入字段
     */
    private String field30;

    /**
     * 导入字段
     */
    private String field31;

    /**
     * 导入字段
     */
    private String field32;

    /**
     * 导入字段
     */
    private String field33;

    /**
     * 导入字段
     */
    private String field34;

    /**
     * 导入字段
     */
    private String field35;

    /**
     * 导入字段
     */
    private String field36;

    /**
     * 导入字段
     */
    private String field37;

    /**
     * 导入字段
     */
    private String field38;

    /**
     * 导入字段
     */
    private String field39;

    /**
     * 导入字段
     */
    private String field40;

    /**
     * 导入字段
     */
    private String field41;

    /**
     * 导入字段
     */
    private String field42;

    /**
     * 导入字段
     */
    private String field43;

    /**
     * 导入字段
     */
    private String field44;

    /**
     * 导入字段
     */
    private String field45;

    /**
     * 导入字段
     */
    private String field46;

    /**
     * 导入字段
     */
    private String field47;

    /**
     * 导入字段
     */
    private String field48;

    /**
     * 导入字段
     */
    private String field49;

    /**
     * 导入字段
     */
    private String field50;

    //
}
