package com.easy.admin.cms.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.cms.model.CmsArticle;
import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章管理
 *
 * @author TengChongChong
 * @date 2021-11-19
 */
public interface CmsArticleMapper extends BaseMapper<CmsArticle> {
    /**
     * 获取列表数据
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @param sysFileType  文件类型
     * @return List<CmsArticle>
     */
    List<CmsArticle> select(
            Page<CmsArticle> page,
            @Param("ew") QueryWrapper<CmsArticle> queryWrapper,
            @Param("sysFileType") String sysFileType
    );

    /**
     * 获取列表数据
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @param sysFileType  文件类型
     * @param appendField  追加查询字段
     * @return List<CmsArticle>
     */
    List<CmsArticle> selectForUtil(
            Page<CmsArticle> page,
            @Param("ew") QueryWrapper<CmsArticle> queryWrapper,
            @Param("sysFileType") String sysFileType,
            @Param("appendField") String appendField
    );

    /**
     * 根据栏目ids获取已发布的文章 for 网站发布
     *
     * @param queryWrapper 查询条件
     * @return List<CmsArticle>
     */
    List<CmsArticle> selectArticleByColumnIds(@Param("ew") QueryWrapper<CmsArticle> queryWrapper);

    /**
     * 查询详细信息
     *
     * @param id id
     * @return CmsArticle
     */
    CmsArticle getById(@Param("id") String id);

    /**
     * 根据站点id删除
     *
     * @param siteId 站点id
     * @return true/false
     */
    int deleteBySiteId(@Param("siteId") String siteId);

    /**
     * 查询站点ids
     *
     * @param queryWrapper 查询条件
     * @return 站点ids
     */
    List<String> selectSiteIds(@Param("ew") QueryWrapper<CmsArticle> queryWrapper);

    /**
     * 查询要发布的文章数据
     *
     * @param queryWrapper 查询条件
     * @return 文章数据
     */
    List<CmsArticle> selectCmsArticle(@Param("ew") QueryWrapper<CmsArticle> queryWrapper);

    /**
     * 根据文章ids获取文章所属栏目
     *
     * @param queryWrapper 查询条件
     * @return List<CmsColumn>
     */
    List<CmsColumn> selectColumnIdByArticleId(@Param("ew") QueryWrapper<CmsArticle> queryWrapper);

    /**
     * 根据文章id获取文章所属栏目
     *
     * @param id id
     * @return CmsColumn
     */
    CmsColumn getColumnByArticleId(@Param("id") String id);

    /**
     * 根据栏目id查询文章数量
     *
     * @param columnId 栏目id
     * @return 数量
     */
    int selectCountByColumnId(@Param("columnId") String columnId);

    /**
     * 查询所有已发布文章
     *
     * @param queryWrapper 查询条件
     * @param sysFileType  文件类型
     * @return List<CmsArticle>
     */
    List<CmsArticle> selectAllArticleForElasticsearch(
            @Param("ew") QueryWrapper<CmsArticle> queryWrapper,
            @Param("sysFileType") String sysFileType
    );
}