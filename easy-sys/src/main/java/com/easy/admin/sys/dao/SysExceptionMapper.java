package com.easy.admin.sys.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sys.model.SysException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 异常日志
 *
 * @author TengChong
 * @date 2019-04-08
 */
public interface SysExceptionMapper extends BaseMapper<SysException> {

    /**
     * 查询数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return 数据列表
     */
    List<SysException> select(Page<SysException> page, @Param("ew") QueryWrapper<SysException> queryWrapper);

    /**
     * 查询数据
     *
     * @param id id
     * @return 数据列表
     */
    SysException getById(@Param("id")String id);

}