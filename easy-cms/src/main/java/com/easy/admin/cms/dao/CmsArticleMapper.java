package com.easy.admin.cms.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.cms.model.CmsArticle;
import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章
 *
 * @author 系统管理员
 * @date 2023-06-21
 */
public interface CmsArticleMapper extends BaseMapper<CmsArticle> {
    /**
     * 查询数据
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @return List<CmsArticle>
     */
    List<CmsArticle> select(Page<CmsArticle> page, @Param("ew") QueryWrapper<CmsArticle> queryWrapper);

    /**
     * 查询文章数据，用于网站预览&发布
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @param appendField  追加查询字段
     * @return List<CmsArticle>
     */
    List<CmsArticle> selectArticle(
            Page<CmsArticle> page,
            @Param("ew") QueryWrapper<CmsArticle> queryWrapper,
            @Param("appendField") String appendField
    );

    /**
     * 查询详情
     *
     * @param id id
     * @return CmsArticle
     */
    CmsArticle getById(@Param("id") String id);

    /**
     * 根据栏目ids获取已发布的文章 for 网站发布
     *
     * @param queryWrapper 查询条件
     * @return List<CmsArticle>
     */
    List<CmsArticle> selectArticleByColumnIds(@Param("ew") QueryWrapper<CmsArticle> queryWrapper);

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


}