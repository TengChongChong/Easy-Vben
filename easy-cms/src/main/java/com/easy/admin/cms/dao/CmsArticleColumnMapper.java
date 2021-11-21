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
     * 删除文章所属分类
     *
     * @param articleId 文章id
     * @return int
     */
    int deleteByArticleId(@Param("articleId") String articleId);
}