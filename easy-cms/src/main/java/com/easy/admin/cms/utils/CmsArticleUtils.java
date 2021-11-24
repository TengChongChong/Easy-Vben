package com.easy.admin.cms.utils;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.cms.common.status.CmsArticleStatus;
import com.easy.admin.cms.model.CmsArticle;
import com.easy.admin.cms.service.CmsArticleService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 文章工具类
 *
 * @author TengChongChong
 * @date 2021/11/18
 */
@Component
public class CmsArticleUtils {

    private static CmsArticleService cmsArticleService;

    /**
     * 获取文章数据
     *
     * @param siteId     站点id
     * @param columnSlug 栏目别名
     * @param pageSize   页大小
     * @return List<CmsArticle>
     */
    public static List<CmsArticle> selectArticle(String siteId, String columnSlug, long pageSize) {
        Page<CmsArticle> result = cmsArticleService.select(new CmsArticle(siteId, columnSlug, CmsArticleStatus.PUBLISHED.getCode()), new Page<>(1, pageSize));
        return initArticle(result.getRecords());
    }


    /**
     * 格式化标签
     *
     * @param tags tags
     * @return xxx / xxx
     */
    public static String formatTags(String tags) {
        return formatTags(tags, " / ");
    }

    /**
     * 格式化标签
     *
     * @param tags      tags
     * @param separator 分隔符
     * @return xxx / xxx
     */
    public static String formatTags(String tags, String separator) {
        if (StrUtil.isBlank(tags)) {
            return null;
        }
        return tags.replaceAll(CommonConst.SPLIT, separator);
    }

    /**
     * 为文章设置一些属性
     *
     * @param articleList 文章列表
     * @return 文章列表
     */
    private static List<CmsArticle> initArticle(List<CmsArticle> articleList){
        if(articleList == null || articleList.size() == 0){
            return articleList;
        }

        for (CmsArticle cmsArticle : articleList) {
            cmsArticle.setUrl("/article/" + cmsArticle.getId() + ".html");
        }
        return articleList;
    }

    @Autowired
    public void setCmsArticleService(CmsArticleService cmsArticleService) {
        CmsArticleUtils.cmsArticleService = cmsArticleService;
    }

}
