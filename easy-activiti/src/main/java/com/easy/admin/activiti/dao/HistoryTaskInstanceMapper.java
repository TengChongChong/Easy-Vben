package com.easy.admin.activiti.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.activiti.model.HistoryTaskInstance;
import com.easy.admin.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 流程历史活动记录
 *
 * @author TengChongChong
 * @date 2020/5/14
 */
public interface HistoryTaskInstanceMapper extends BaseMapper<HistoryTaskInstance> {

    /**
     * 查询历史任务
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @param historyOrderType 历史排序规则，desc/asc
     * @return 数据列表
     */
    List<HistoryTaskInstance> select(
            Page<HistoryTaskInstance> page,
            @Param("ew") QueryWrapper<HistoryTaskInstance> queryWrapper,
            @Param("historyOrderType") String historyOrderType
    );

}
