package com.easy.admin.cms.service;

import java.util.List;

/**
 * 文章栏目
 *
 * @author TengChongChong
 * @date 2021-11-19
 */
public interface CmsArticleColumnService {
    /**
     * 查询栏目id
     *
     * @param articleId 文章id
     * @return 栏目id
     */
    List<String> selectColumnsByArticleId(String articleId);

    /**
     * 保存文章栏目
     *
     * @param articleId   文章id
     * @param columnArray 栏目array
     * @return true/false
     */
    boolean saveData(String articleId, String[] columnArray);

    /**
     * 保存文章栏目
     *
     * @param articleId 文章id
     * @param columns   栏目ids
     * @return true/false
     */
    boolean saveData(String articleId, String columns);

    /**
     * 删除文章所属栏目数据
     *
     * @param articleId 文章id
     * @return true/false
     */
    boolean remove(String articleId);
}
