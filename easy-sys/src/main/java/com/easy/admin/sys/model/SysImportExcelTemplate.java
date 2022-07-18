package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * 导入模板
 *
 * @author TengChong
 * @date 2019-04-10
 */
 @TableName("sys_import_excel_template")
public class SysImportExcelTemplate extends Model<SysImportExcelTemplate> {

    @TableId(value = "id")
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
     * 乐观锁
     */
    @Version
    private Integer version;
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    @TableField(fill = FieldFill.INSERT)
    private  String createUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private  String editUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date editDate;

    //
    /**
     * 导入配置
     */
    @TableField(exist=false)
    private List<SysImportExcelTemplateDetail> detailList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getImportTable() {
        return importTable;
    }

    public void setImportTable(String importTable) {
        this.importTable = importTable;
    }
    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }
    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }
    public String getImportCode() {
        return importCode;
    }

    public void setImportCode(String importCode) {
        this.importCode = importCode;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public  String getCreateUser() {
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<SysImportExcelTemplateDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<SysImportExcelTemplateDetail> detailList) {
        this.detailList = detailList;
    }
}
