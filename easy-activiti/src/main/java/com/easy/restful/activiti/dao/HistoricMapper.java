package com.easy.restful.activiti.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.restful.activiti.model.Historic;
import com.easy.restful.activiti.model.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 流程历史活动记录
 *
 * @author tengchong
 * @date 2020/5/7
 */
public interface HistoricMapper extends BaseMapper<Historic> {
    /**
     * 获取列表数据
     *
     * @param queryWrapper 查询条件
     * @return 数据列表
     */
    List<Historic> select(@Param("ew") QueryWrapper<Historic> queryWrapper);

    /**
     * 根据业务id查询流程实例
     *
     * @param businessKey 业务id
     * @return 流程实例
     */
    Task selectTask(@Param("businessKey") String businessKey);
}
