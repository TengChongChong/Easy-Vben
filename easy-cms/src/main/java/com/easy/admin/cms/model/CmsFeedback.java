package com.easy.admin.cms.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 用户反馈
 *
 * @author tengchongchong
 * @date 2023-07-10
 */
@Data
@TableName("cms_feedback")
public class CmsFeedback extends Model<CmsFeedback> {

    /**
     * 主键
     */
    @TableId
    private String id;
    /**
     * 站点id
     */
    private String siteId;
    /**
     * 昵称
     */
    @Excel(name = "昵称", width = 15, orderNum = "1")
    @NotBlank(message = "昵称不能为空")
    private String nickname;
    /**
     * 邮箱
     */
    @Excel(name = "邮箱", width = 15, orderNum = "2")
    private String email;
    /**
     * 手机号
     */
    @Excel(name = "手机号", width = 15, orderNum = "3")
    private String phoneNumber;
    /**
     * 内容
     */
    @Excel(name = "内容", width = 25, orderNum = "4")
    @NotBlank(message = "内容不能为空")
    private String content;
    /**
     * 状态
     */
    @Excel(name = "状态", width = 9, orderNum = "5")
    private String status;
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
