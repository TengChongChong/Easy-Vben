package com.easy.admin.cms.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.cms.model.CmsPage;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.tree.Tree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 页面管理
 *
 * @author TengChongChong
 * @date 2021-11-24
 */
public interface CmsPageMapper extends BaseMapper<CmsPage> {
    /**
     * 获取列表数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return List<CmsPage>
     */
    List<CmsPage> select(Page<CmsPage> page, @Param("ew") QueryWrapper<CmsPage> queryWrapper);

    /**
     * 查询所有页面，用于网站发布
     *
     * @param siteId 站点id
     * @param status 状态
     * @return List<Tree>
     */
    List<Tree> selectAll(@Param("siteId")String siteId, @Param("status") String status);

    /**
     * 查询页面数据 for 网站发布
     *
     * @param queryWrapper 查询条件
     * @return List<CmsPage>
     */
    List<CmsPage> selectPages(@Param("ew") QueryWrapper<CmsPage> queryWrapper);

    /**
     * 查询详细信息
     *
     * @param id id
     * @return CmsPage
     */
    CmsPage getById(@Param("id") String id);

    /**
     * 根据别名获取页面
     *
     * @param siteId 站点id
     * @param slug 别名
     * @return CmsPage
     */
    CmsPage getBySlug(@Param("siteId")String siteId, @Param("slug") String slug);

    /**
     * 根据站点id删除
     *
     * @param siteId 站点id
     * @return true/false
     */
    int deleteBySiteId(@Param("siteId") String siteId);
}