package com.easy.restful.sys.service;

import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.sys.model.SysMessage;

/**
 * 消息
 *
 * @author TengChong
 * @date 2019-06-02
 */
public interface SysMessageService {
    /**
     * 列表
     *
     * @param object 查询条件
     * @param page   分页
     * @return Page<SysMessage>
     */
    Page<SysMessage> select(SysMessage object, Page<SysMessage> page);

    /**
     * 收信列表
     *
     * @param object 查询条件
     * @param page   分页
     * @return Page<SysMessage>
     */
    Page<SysMessage> selectReceive(SysMessage object, Page<SysMessage> page);

    /**
     * 详情
     *
     * @param id id
     * @return SysMessage
     */
    SysMessage get(String id);

    /**
     * 详情
     *
     * @param id id
     * @return SysMessage
     */
    SysMessage getBySysMessageId(String id);

    /**
     * 新增
     *
     * @return SysMessage
     */
    SysMessage add();

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 保存
     *
     * @param object 表单内容
     * @return 保存后信息
     */
    SysMessage saveData(SysMessage object);

    /**
     * 发送
     *
     * @param ids 消息ids
     * @return true/false
     */
    boolean send(String ids);

    /**
     * 获取当前登录用户查询未读消息数量
     *
     * @return 未读消息数量
     */
    int selectUnreadCount();

}
