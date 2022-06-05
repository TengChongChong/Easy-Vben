package com.easy.admin.sys.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sys.model.SysConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统参数
 *
 * @author admin
 * @date 2019-03-03 15:52:44
 */
public interface SysConfigMapper extends BaseMapper<SysConfig> {
    /**
     * 获取列表数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return List<SysConfig>
     */
    List<SysConfig> select(Page<SysConfig> page, @Param("ew") QueryWrapper<SysConfig> queryWrapper);

}