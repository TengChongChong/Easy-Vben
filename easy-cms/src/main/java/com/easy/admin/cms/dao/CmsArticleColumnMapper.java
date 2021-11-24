package com.easy.admin.cms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.cms.model.CmsArticleColumn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章栏目
 *
 * @author TengChongChong
 * @date 2021-11-19
 */
public interface CmsArticleColumnMapper extends BaseMapper<CmsArticleColumn> {

    /**
     * 查询栏目id
     *
     * @param articleId 文章id
     * @return 栏目id
     */
    List<String> selectColumnsByArticleId(@Param("articleId") String articleId);

    /**
     * 根据栏目id查询文章数量
     *
     * @param columnId 栏目id
     * @return 数量
     */
    int selectCountByColumnId(@Param("columnId") String columnId);

    /**
     * 删除文章所属分类
     *
     * @param articleId 文章id
     * @return int
     */
    int deleteByArticleId(@Param("articleId") String articleId);

    /**
     * 根据站点id删除
     *
     * @param siteId 站点id
     * @return true/false
     */
    int deleteBySiteId(@Param("siteId") String siteId);

    /**
     * 根据文章id获取文章所属栏目
     *
     * @param articleId 文章id
     * @return 栏目id
     */
    String getCmsColumnIdByArticleId(@Param("articleId") String articleId);
}