package com.easy.admin.cms.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 站点
 *
 * @author tengchongchong
 * @date 2023-06-19
 */
@Data
@TableName("cms_site")
public class CmsSite extends Model<CmsSite> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private String id;
    /**
     * 父id
     */
    private String parentId;
    /**
     * 名称
     */
    @Excel(name = "名称", width = 25, orderNum = "0")
    @NotBlank(message = "名称不能为空")
    private String name;
    /**
     * 关键字
     */
    @Excel(name = "关键字", width = 25, orderNum = "1")
    private String keyword;
    /**
     * 描述
     */
    @Excel(name = "描述", width = 25, orderNum = "2")
    private String description;
    /**
     * 域名
     */
    @Excel(name = "域名", width = 25, orderNum = "3")
    @NotBlank(message = "域名不能为空")
    private String domainName;
    /**
     * 部署路径
     */
    @Excel(name = "部署路径", width = 25, orderNum = "4")
    @NotBlank(message = "部署路径不能为空")
    private String deploymentPath;
    /**
     * 主题名称
     */
    @Excel(name = "主题名称", width = 15, orderNum = "5")
    private String theme;
    /**
     * 状态
     */
    @Excel(name = "状态", width = 9, orderNum = "6")
    private String status;
    /**
     * 排序值
     */
    @Excel(name = "排序值", width = 10, orderNum = "7")
    private Integer orderNo;
    /**
     * 租户Id
     */
    private String tenantId;
    /**
     * 乐观锁
     */
    @Version
    private Integer version;
    /**
     * 部门id
     */
    @TableField(fill = FieldFill.INSERT)
    private String deptId;
    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createUser;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUser;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date editDate;

    // 非表字段

}
