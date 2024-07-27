package com.easy.admin.cms.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 栏目
 *
 * @author tengchongchong
 * @date 2023-06-19
 */
@Data
@TableName("cms_column")
public class CmsColumn extends Model<CmsColumn> {

    /**
     * 主键
     */
    @TableId
    private String id;
    /**
     * 站点id
     */
    @Excel(name = "站点id", width = 20, orderNum = "0")
    private String siteId;
    /**
     * 父id
     */
    @Excel(name = "父栏目别名", width = 20, orderNum = "1")
    private String parentId;
    /**
     * 名称
     */
    @Excel(name = "名称", width = 20, orderNum = "2")
    @NotBlank(message = "名称不能为空")
    private String name;
    /**
     * 别名
     */
    @Excel(name = "别名", width = 15, orderNum = "3")
    @NotBlank(message = "别名不能为空")
    private String slug;
    /**
     * 类型
     */
    private String type;
    /**
     * 是否可以发布文章
     */
    @Excel(name = "是否可以发布文章", width = 25, orderNum = "4")
    @NotBlank(message = "是否可以发布文章不能为空")
    private String isRelease;
    /**
     * 封面比例-宽
     */
    private Integer coverProportionWidth;
    /**
     * 封面比例-宽
     */
    private Integer coverProportionHeight;
    /**
     * 描述
     */
    @Excel(name = "描述", width = 25, orderNum = "7")
    private String description;
    /**
     * 备注
     */
    @Excel(name = "备注", width = 25, orderNum = "8")
    private String remarks;
    /**
     * 排序值
     */
    @Excel(name = "排序值", width = 10, orderNum = "9")
    private Integer orderNo;
    /**
     * 状态
     */
    @Excel(name = "状态", width = 9, orderNum = "10")
    @NotBlank(message = "状态不能为空")
    private String status;
    /**
     * 乐观锁
     */
    @Version
    private Integer version;
    /**
     * 部门id
     */
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
