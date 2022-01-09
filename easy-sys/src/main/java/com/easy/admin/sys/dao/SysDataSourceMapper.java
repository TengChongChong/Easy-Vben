package com.easy.admin.sys.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sys.model.SysDataSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据源管理
 *
 * @author TengChongChong
 * @date 2021-12-18
 */
public interface SysDataSourceMapper extends BaseMapper<SysDataSource> {
    /**
     * 获取列表数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return List<SysDataSource>
     */
    List<SysDataSource> select(Page<SysDataSource> page, @Param("ew") QueryWrapper<SysDataSource> queryWrapper);


    /**
     * 获取所有数据源
     *
     * @param queryWrapper 查询条件
     * @return List<SysDataSource>
     */
    List<SysDataSource> selectAll(@Param("ew") QueryWrapper<SysDataSource> queryWrapper);


    /**
     * 查询详细信息
     *
     * @param id id
     * @return SysDataSource
     */
    SysDataSource getById(@Param("id") String id);

    /**
     * 查询数据源名称
     *
     * @param queryWrapper 查询条件
     * @return List<String>
     */
    List<String> selectName(@Param("ew") QueryWrapper<SysDataSource> queryWrapper);

}