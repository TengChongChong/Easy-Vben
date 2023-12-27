package com.easy.admin.sample.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.easy.admin.sample.model.SampleGeneral;

/**
 * 代码生成示例
 *
 * @author 系统管理员
 * @date 2023-12-27
 */
public interface SampleGeneralMapper extends BaseMapper<SampleGeneral> {
    /**
     * 查询数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return List<SampleGeneral>
     */
    List<SampleGeneral> select(Page<SampleGeneral> page, @Param("ew") QueryWrapper<SampleGeneral> queryWrapper);
    /**
     * 查询详情
     *
     * @param id id
     * @return SampleGeneral
     */
    SampleGeneral getById(@Param("id") String id);

    /**
     * 查询导出数据
     *
     * @param queryWrapper 查询条件
     * @return List<SampleGeneral>
     */
    List<SampleGeneral> exportData(@Param("ew") QueryWrapper<SampleGeneral> queryWrapper);
}