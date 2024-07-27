package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息详情
 *
 * @author TengChong
 * @date 2019-06-06
 */
@Data
@TableName("sys_message_detail")
public class SysMessageDetail extends Model<SysMessageDetail> implements Serializable {

    /**
     * id
     */
    @TableId
    private String id;

    /**
     * 消息id
     */
    private String messageId;

    /**
     * 接收人
     */
    private String receiverUser;

    /**
     * 阅读时间
     */
    private Date readDate;

    /**
     * 状态
     */
    private String status;
    /**
     * 收藏
     */
    private Integer star;

    //

    /**
     * 接收人所在部门
     */
    @TableField(exist = false)
    private String receiverUserDeptName;
}
