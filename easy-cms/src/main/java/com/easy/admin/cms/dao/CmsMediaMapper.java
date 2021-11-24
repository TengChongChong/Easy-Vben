package com.easy.admin.cms.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.cms.model.CmsMedia;
import com.easy.admin.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 资源管理
 *
 * @author TengChongChong
 * @date 2021-11-21
 */
public interface CmsMediaMapper extends BaseMapper<CmsMedia> {
    /**
     * 获取列表数据
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @param sysFileType  文件类型
     * @return List<CmsMedia>
     */
    List<CmsMedia> select(Page<CmsMedia> page, @Param("ew") QueryWrapper<CmsMedia> queryWrapper, @Param("sysFileType") String sysFileType);

    /**
     * 查询详细信息
     *
     * @param id id
     * @return CmsMedia
     */
    CmsMedia getById(@Param("id") String id);

    /**
     * 根据站点id删除
     *
     * @param siteId 站点id
     * @return true/false
     */
    int deleteBySiteId(@Param("siteId") String siteId);
}