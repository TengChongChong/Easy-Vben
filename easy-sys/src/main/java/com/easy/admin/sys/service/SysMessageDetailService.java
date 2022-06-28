package com.easy.admin.sys.service;

import java.util.List;

/**
 * 消息详情
 *
 * @author TengChong
 * @date 2019-06-06
 */
public interface SysMessageDetailService {
    /**
     * 根据消息id查询收信人列表
     *
     * @param messageId 消息id
     * @return List<String>
     */
    List<String> selectReceiverUser(String messageId);

    /**
     * 根据消息id删除
     *
     * @param messageIds 消息ids
     * @return 是否成功
     */
    boolean remove(String messageIds);

    /**
     * 根据接收消息id删除
     *
     * @param ids              消息ids
     * @return true/false
     */
    boolean removeByIds(String ids);

    /**
     * 保存
     *
     * @param messageId 消息id
     * @param receivers  收信人
     * @return true/false
     */
    boolean saveData(String messageId, List<String> receivers);

    /**
     * 设置消息标星/取消标星
     *
     * @param id   消息id
     * @param type true/false 是否标星
     * @return true/false
     */
    boolean setStar(String id, boolean type);

    /**
     * 设置消息已读
     *
     * @param ids 消息ids
     * @return true/false
     */
    boolean setRead(String ids);

}
