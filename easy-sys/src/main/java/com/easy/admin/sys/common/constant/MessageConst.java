package com.easy.admin.sys.common.constant;

/**
 * 消息
 *
 * @author TengChongChong
 * @date 2019-06-07
 */
public class MessageConst {

    private MessageConst() {}

    //==== 页面nav
    /**
     * 收信箱
     */
    public static final String INBOX = "inbox";
    /**
     * 草稿箱
     */
    public static final String DRAFTS = "drafts";
    /**
     * 已发送
     */
    public static final String HAS_BEEN_SENT = "hasBeenSent";
    /**
     * 标星
     */
    public static final String INSTAR_SIGNBOX = "starSign";
    /**
     * 回收站
     */
    public static final String RECYCLE_BIN = "recycleBin";

    //==== 消息类型
    /**
     * 消息类型-通知
     */
    public static final String TYPE_NOTICE = "notice";
    /**
     * 消息类型-事件
     */
    public static final String TYPE_EVENT = "event";
    /**
     * 消息类型-日志
     */
    public static final String TYPE_JOURNAL = "journal";

    //==== 重要
    /**
     * 不重要
     */
    public static final String IMPORTANT_NO = "0";
    /**
     * 重要
     */
    public static final String IMPORTANT_YES = "1";

    //==== 状态
    /**
     * 草稿
     */
    public static final String STATUS_DRAFT = "0";
    /**
     * 已发送
     */
    public static final String STATUS_HAS_BEEN_SENT = "1";
    /**
     * 已撤销
     */
    public static final String STATUS_RESCINDED = "-1";

    //==== 标星
    /**
     * 标星
     */
    public static final int STAR_YES = 1;
    /**
     * 未标星
     */
    public static final int STAR_NO = 0;

    //==== 收信状态
    /**
     * 已读
     */
    public static final String RECEIVE_STATUS_ALREADY_READ = "1";
    /**
     * 未读
     */
    public static final String RECEIVE_STATUS_UNREAD = "0";

}
