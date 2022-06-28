package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息详情
 *
 * @author TengChong
 * @date 2019-06-06
 */
@TableName("sys_message_detail")
public class SysMessageDetail extends Model<SysMessageDetail> implements Serializable {

    /**
     * id
     */
    @TableId(value = "id")
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getReceiverUser() {
        return receiverUser;
    }

    public void setReceiverUser(String receiverUser) {
        this.receiverUser = receiverUser;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }
}
