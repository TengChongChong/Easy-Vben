package com.easy.admin.cms.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.cms.model.CmsMedia;
import com.easy.admin.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 资源
 *
 * @author 系统管理员
 * @date 2023-06-21
 */
public interface CmsMediaMapper extends BaseMapper<CmsMedia> {
    /**
     * 查询数据
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @return List<CmsMedia>
     */
    List<CmsMedia> select(Page<CmsMedia> page, @Param("ew") QueryWrapper<CmsMedia> queryWrapper);

    /**
     * 查询详情
     *
     * @param id id
     * @return CmsMedia
     */
    CmsMedia getById(@Param("id") String id);

}