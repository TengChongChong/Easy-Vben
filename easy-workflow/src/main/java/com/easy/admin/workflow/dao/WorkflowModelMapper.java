package com.easy.admin.workflow.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.workflow.model.vo.WorkflowModelVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 流程模型
 *
 * @author TengChongChong
 * @date 2025-07-14
 **/
public interface WorkflowModelMapper extends BaseMapper<WorkflowModelVO> {

    /**
     * 获取列表数据
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @return 数据列表
     */
    List<WorkflowModelVO> select(Page<WorkflowModelVO> page, @Param("ew") QueryWrapper<WorkflowModelVO> queryWrapper);

    /**
     * 获取列表数据
     *
     * @param key             模型标识
     * @param suspensionState 流程状态
     * @return 流程定义ID
     */
    String selectProcessDefinitionId(@Param("key") String key, @Param("suspensionState") int suspensionState);

    /**
     * 检查流程标识是否存在
     *
     * @param queryWrapper 查询条件
     * @return true/false
     */
    Integer selectCountByKey(@Param("ew") QueryWrapper<WorkflowModelVO> queryWrapper);
}
