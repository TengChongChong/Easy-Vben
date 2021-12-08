package com.easy.admin.cms.utils;

import com.easy.admin.cms.service.CmsReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * CMS发布，为了解决循环依赖问题
 *
 * @author tengchong
 * @date 2021/11/26
 */
@Component
public class CmsReleaseUtil {
    private CmsReleaseUtil() {}

    private static CmsReleaseService service;


    /**
     * 发布资源
     *
     * @param siteId 站点id
     * @return true/false
     */
    public static boolean releaseAssets(String siteId){
        return service.releaseAssets(siteId);
    }

    /**
     * 发布首页
     *
     * @param siteId 站点id
     * @return true/false
     */
    public static boolean releaseHome(String siteId){
        return service.releaseHome(siteId);
    }

    /**
     * 发布页面
     *
     * @param siteId 站点id
     * @param id   id
     * @return true/false
     */
    public static boolean releasePage(String siteId, String id){
        return service.releasePage(siteId, id);
    }

    /**
     * 发布栏目列表
     *
     * @param siteId 站点id
     * @param slug   别名
     * @return true/false
     */
    public static boolean releaseColumn(String siteId, String slug){
        return service.releaseColumn(siteId, slug);
    }

    /**
     * 发布栏目列表
     *
     * @param siteId   站点id
     * @param columnId 栏目id
     * @return true/false
     */
    public static boolean releaseColumnById(String siteId, String columnId){
        return service.releaseColumnById(siteId, columnId);
    }

    /**
     * 发布文章
     *
     * @param siteId    站点id
     * @param articleId 文章id
     * @return true/false
     */
    public static boolean releaseArticle(String siteId, String articleId){
        return service.releaseArticle(siteId, articleId);
    }

    @Autowired
    public void setService(CmsReleaseService service) {
        CmsReleaseUtil.service = service;
    }
}
