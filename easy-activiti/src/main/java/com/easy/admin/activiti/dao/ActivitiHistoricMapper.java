package com.easy.admin.activiti.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.activiti.model.ActivitiHistoric;
import com.easy.admin.activiti.model.ActivitiTask;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 流程历史活动记录
 *
 * @author TengChongChong
 * @date 2020/5/7
 */
public interface ActivitiHistoricMapper extends BaseMapper<ActivitiHistoric> {
    /**
     * 获取列表数据
     *
     * @param queryWrapper 查询条件
     * @return 数据列表
     */
    List<ActivitiHistoric> select(@Param("ew") QueryWrapper<ActivitiHistoric> queryWrapper);

    /**
     * 根据业务id查询流程实例
     *
     * @param businessKey 业务id
     * @return 流程实例
     */
    ActivitiTask selectTask(@Param("businessKey") String businessKey);
}
