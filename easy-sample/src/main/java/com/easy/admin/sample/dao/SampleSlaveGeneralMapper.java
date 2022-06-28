package com.easy.admin.sample.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.easy.admin.sample.model.SampleSlaveGeneral;

/**
 * 从库示例
 *
 * @author 系统管理员
 * @date 2022-06-23
 */
public interface SampleSlaveGeneralMapper extends BaseMapper<SampleSlaveGeneral> {
    /**
     * 获取列表数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return List<SampleSlaveGeneral>
     */
    List<SampleSlaveGeneral> select(Page<SampleSlaveGeneral> page, @Param("ew") QueryWrapper<SampleSlaveGeneral> queryWrapper);

    /**
     * 查询详细信息
     *
     * @param id id
     * @return SampleSlaveGeneral
     */
    SampleSlaveGeneral getById(@Param("id") String id);

}