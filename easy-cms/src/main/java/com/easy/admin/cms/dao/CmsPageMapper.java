package com.easy.admin.cms.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.cms.model.CmsPage;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.tree.Tree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 页面
 *
 * @author 系统管理员
 * @date 2023-06-27
 */
public interface CmsPageMapper extends BaseMapper<CmsPage> {
    /**
     * 查询数据
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @return List<CmsPage>
     */
    List<CmsPage> select(Page<CmsPage> page, @Param("ew") QueryWrapper<CmsPage> queryWrapper);

    /**
     * 查询所有页面，用于网站发布
     *
     * @param siteId 站点id
     * @return List<Tree>
     */
    List<Tree> selectAll(@Param("siteId") String siteId);

    /**
     * 查询详情
     *
     * @param id id
     * @return CmsPage
     */
    CmsPage getById(@Param("id") String id);

    /**
     * 查询页面数据 for 网站发布
     *
     * @param queryWrapper 查询条件
     * @return List<CmsPage>
     */
    List<CmsPage> selectPages(@Param("ew") QueryWrapper<CmsPage> queryWrapper);
}