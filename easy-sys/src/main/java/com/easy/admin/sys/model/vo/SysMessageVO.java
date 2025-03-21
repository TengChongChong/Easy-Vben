package com.easy.admin.sys.model.vo;

import com.easy.admin.sys.model.SysMessage;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * 消息
 *
 * @author TengChongChong
 * @date 2024-11-29
 **/
@Data
public class SysMessageVO extends SysMessage {

    /**
     * 收藏
     */
    private String star;
    /**
     * 发送人昵称
     */
    private String nickname;
    /**
     * 详情中的状态
     */
    private String detailsStatus;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 收信人
     */
    @NotEmpty(message = "收信人不能为空")
    private List<String> receivers;

    /**
     * 收信->id
     */
    private String messageId;

    /**
     * 收信->阅读时间
     */
    private String readDate;

    /**
     * 发送时间 - 开始
     */
    private Date startSendDate;
    /**
     * 发送时间 - 结束
     */
    private Date endSendDate;
}
