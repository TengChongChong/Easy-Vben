package com.easy.restful.sample.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.sample.model.SampleWorkFlow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 流程示例
 *
 * @author TengChong
 * @date 2020-04-26
 */
public interface SampleWorkFlowMapper extends BaseMapper<SampleWorkFlow> {
    /**
     * 获取列表数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return 数据列表
     */
    List<SampleWorkFlow> select(Page<SampleWorkFlow> page, @Param("ew") QueryWrapper<SampleWorkFlow> queryWrapper);

    /**
     * 查询详细信息
     *
     * @param id 数据id
     * @return 详情
     */
    SampleWorkFlow getById(@Param("id") String id);
}