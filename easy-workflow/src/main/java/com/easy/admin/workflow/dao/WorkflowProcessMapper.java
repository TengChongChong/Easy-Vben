package com.easy.admin.workflow.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.workflow.model.vo.WorkflowProcessVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 流程管理
 *
 * @author TengChongChong
 * @date 2025-07-12
 */
public interface WorkflowProcessMapper extends BaseMapper<WorkflowProcessVO> {
    /**
     * 获取列表数据
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @return 数据列表
     */
    List<WorkflowProcessVO> select(Page<WorkflowProcessVO> page, @Param("ew") QueryWrapper<WorkflowProcessVO> queryWrapper);

    /**
     * 查询详情
     *
     * @param id 流程实例ID
     * @return 流程详情
     */
    WorkflowProcessVO getById(@Param("id") String id);

    /**
     * 查询流程数据用于放到select的option中
     *
     * @return 数据集合
     */
    List<Select> selectProcessForSelect();
}
