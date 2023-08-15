package com.easy.admin.cms.service;

import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.cms.model.CmsPage;
import com.easy.admin.cms.model.CmsSite;
import org.springframework.ui.Model;

/**
 * CMS 路由
 *
 * @author tengchong
 * @date 2023-07-03
 */
public interface CmsRouteService {

    /**
     * 获取首页视图文件路径
     *
     * @param cmsSite 站点
     * @return view path
     */
    String getIndexViewPath(CmsSite cmsSite);

    /**
     * 获取栏目列表视图文件路径
     *
     * @param cmsSite   站点
     * @param cmsColumn 栏目
     * @return view path
     */
    String getColumnListViewPath(CmsSite cmsSite, CmsColumn cmsColumn);

    /**
     * 获取文章详情视图文件路径
     *
     * @param cmsSite   站点
     * @param cmsColumn 栏目
     * @return view path
     */
    String getArticleViewPath(CmsSite cmsSite, CmsColumn cmsColumn);

    /**
     * 获取页面视图文件路径
     *
     * @param cmsSite 站点
     * @param cmsPage 页面
     * @return view path
     */
    String getPageViewPath(CmsSite cmsSite, CmsPage cmsPage);

    /**
     * 设置公共变量
     *
     * @param model   model
     * @param cmsSite 站点
     */
    void setCommonAttribute(Model model, CmsSite cmsSite);
}
