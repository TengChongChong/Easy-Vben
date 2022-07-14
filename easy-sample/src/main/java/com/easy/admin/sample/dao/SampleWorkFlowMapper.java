package com.easy.admin.sample.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sample.model.SampleWorkFlow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 流程示例
 *
 * @author 系统管理员
 * @date 2022-07-08
 */
public interface SampleWorkFlowMapper extends BaseMapper<SampleWorkFlow> {
    /**
     * 获取列表数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return List<SampleWorkFlow>
     */
    List<SampleWorkFlow> select(Page<SampleWorkFlow> page, @Param("ew") QueryWrapper<SampleWorkFlow> queryWrapper);

    /**
     * 查询详细信息
     *
     * @param id id
     * @return SampleWorkFlow
     */
    SampleWorkFlow getById(@Param("id") String id);

    /**
     * 获取列表数据
     *
     * @param queryWrapper 查询条件
     * @return List<SampleWorkFlow>
     */
    List<SampleWorkFlow> exportData(@Param("ew") QueryWrapper<SampleWorkFlow> queryWrapper);
}