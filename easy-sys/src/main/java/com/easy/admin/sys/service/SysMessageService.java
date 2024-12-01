package com.easy.admin.sys.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sys.model.SysMessage;
import com.easy.admin.sys.model.vo.SysMessageVO;

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
     * @param sysMessage 查询条件
     * @param page       分页
     * @return Page<SysMessage>
     */
    Page<SysMessage> select(SysMessageVO sysMessage, Page<SysMessage> page);

    /**
     * 收信列表
     *
     * @param sysMessage 查询条件
     * @param page       分页
     * @return Page<SysMessage>
     */
    Page<SysMessageVO> selectReceive(SysMessageVO sysMessage, Page<SysMessageVO> page);

    /**
     * 详情
     *
     * @param id id
     * @return SysMessage
     */
    SysMessageVO get(String id);

    /**
     * 详情
     *
     * @param id id
     * @return SysMessage
     */
    SysMessageVO info(String id);

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
     * @param sysMessage 表单内容
     * @return 保存后信息
     */
    SysMessageVO saveData(SysMessageVO sysMessage);

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
