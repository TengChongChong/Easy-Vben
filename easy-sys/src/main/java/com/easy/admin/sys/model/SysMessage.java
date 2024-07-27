package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 通知
 *
 * @author TengChong
 * @date 2019-06-02
 */
@Data
@TableName("sys_message")
public class SysMessage extends Model<SysMessage> implements Serializable {

    /**
     * id
     */
    @TableId
    private String id;

    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    private String title;

    /**
     * 副标题(保留字段)
     */
    private String subtitle;

    /**
     * 内容
     */
    private String content;

    /**
     * 状态
     */
    private String status;

    /**
     * 发送时间
     */
    private Date sendDate;

    /**
     * 图标(保留字段)
     */
    private String icon;

    /**
     * 重要
     */
    private String important;

    /**
     * 类型
     */
    private String type;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;

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

    //

    /**
     * 收藏
     */
    @TableField(exist = false)
    private String star;
    /**
     * 发送人昵称
     */
    @TableField(exist = false)
    private String nickname;
    /**
     * 详情中的状态
     */
    @TableField(exist = false)
    private String detailsStatus;
    /**
     * 用户头像
     */
    @TableField(exist = false)
    private String avatar;
    /**
     * 收信人
     */
    @NotEmpty(message = "收信人不能为空")
    @TableField(exist = false)
    private List<String> receivers;

    /**
     * 收信->id
     */
    @TableField(exist = false)
    private String messageId;

    /**
     * 收信->阅读时间
     */
    @TableField(exist = false)
    private String readDate;

    /**
     * 发送时间 - 开始
     */
    @TableField(exist = false)
    private Date startSendDate;
    /**
     * 发送时间 - 结束
     */
    @TableField(exist = false)
    private Date endSendDate;
}
