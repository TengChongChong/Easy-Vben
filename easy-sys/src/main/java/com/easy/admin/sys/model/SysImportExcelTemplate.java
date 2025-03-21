package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 导入模板
 *
 * @author TengChong
 * @date 2019-04-10
 */
@Data
@TableName("sys_import_excel_template")
public class SysImportExcelTemplate extends Model<SysImportExcelTemplate> {

    @TableId
    private String id;

    /**
     * 模板名称
     */
    @NotBlank(message = "名称不能为空")
    private String name;

    /**
     * 表
     */
    @NotBlank(message = "导入表不能为空")
    private String importTable;

    /**
     * 起始行
     */
    private Integer startRow;

    /**
     * 回调
     */
    private String callback;

    /**
     * 模板代码
     */
    @NotBlank(message = "模板代码不能为空")
    private String importCode;

    /**
     * 权限标识
     * 用于检查当前登录用户是否允许使用此模板
     */
    @NotBlank(message = "权限标识不能为空")
    private String permissionCode;

    /**
     * 备注
     */
    private String remarks;
    /**
     * 状态
     */
    private String status;
    /**
     * 乐观锁
     */
    @Version
    private Integer version;
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    @TableField(fill = FieldFill.INSERT)
    private String createUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date editDate;

}
