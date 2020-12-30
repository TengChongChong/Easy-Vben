package com.easy.restful.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.restful.sys.model.SysMessageDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 消息详情 
 *
 * @author TengChong
 * @date 2019-06-06
 */
public interface SysMessageDetailsMapper extends BaseMapper<SysMessageDetails> {

    /**
     * 根据消息id查询收信人列表
     *
     * @param messageId 消息id
     * @return List<String>
     */
    List<String> selectReceiverUser(@Param("messageId") String messageId);
}