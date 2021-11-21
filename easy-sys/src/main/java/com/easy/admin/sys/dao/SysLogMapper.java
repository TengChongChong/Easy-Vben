package com.easy.admin.sys.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sys.model.SysLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 日志 
 *
 * @author TengChong
 * @date 2019-06-27
 */
public interface SysLogMapper extends BaseMapper<SysLog> {
    /**
     * 查询数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return 数据列表
     */
    List<SysLog> select(Page<SysLog> page, @Param("ew") QueryWrapper<SysLog> queryWrapper);

    /**
     * 查询数据
     *
     * @param id id
     * @return 数据列表
     */
    SysLog getById(@Param("id")String id);
}