package com.easy.admin.sample.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.config.mybatis.annotation.EasyDataScope;
import com.easy.admin.sample.model.SampleGeneral;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 代码生成示例
 *
 * @author 系统管理员
 * @date 2023-12-27
 */
@Mapper
public interface SampleGeneralMapper extends BaseMapper<SampleGeneral> {
    /**
     * 查询数据
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @return List<SampleGeneral>
     */
    @EasyDataScope(businessTableAlias = "t")
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