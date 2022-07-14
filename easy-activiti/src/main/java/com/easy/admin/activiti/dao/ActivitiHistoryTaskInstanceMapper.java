package com.easy.admin.activiti.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.activiti.model.ActivitiHistoryTaskInstance;
import com.easy.admin.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 流程历史活动记录
 *
 * @author TengChongChong
 * @date 2020/5/14
 */
public interface ActivitiHistoryTaskInstanceMapper extends BaseMapper<ActivitiHistoryTaskInstance> {

    /**
     * 查询历史任务
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @param historyOrderType 历史排序规则，desc/asc
     * @return 数据列表
     */
    List<ActivitiHistoryTaskInstance> select(
            Page<ActivitiHistoryTaskInstance> page,
            @Param("ew") QueryWrapper<ActivitiHistoryTaskInstance> queryWrapper,
            @Param("historyOrderType") String historyOrderType
    );

}
