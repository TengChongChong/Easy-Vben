package com.easy.admin.sys.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sys.model.SysMessageDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 消息详情 
 *
 * @author TengChong
 * @date 2019-06-06
 */
public interface SysMessageDetailMapper extends BaseMapper<SysMessageDetail> {

    /**
     * 查看消息读取情况
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return List<SysMessageDetail>
     */
    List<SysMessageDetail> selectMessageReceiverUserDetail(Page<SysMessageDetail> page, @Param("ew") QueryWrapper<SysMessageDetail> queryWrapper);

    /**
     * 根据消息id查询收信人列表
     *
     * @param messageId 消息id
     * @return List<String>
     */
    List<String> selectReceiverUser(@Param("messageId") String messageId);
}