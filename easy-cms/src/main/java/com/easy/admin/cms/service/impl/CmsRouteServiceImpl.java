package com.easy.admin.cms.service.impl;

import com.easy.admin.cms.config.beetl.BeetlProperties;
import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.cms.model.CmsPage;
import com.easy.admin.cms.model.CmsSite;
import com.easy.admin.cms.service.CmsRouteService;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.config.properties.ProjectProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 * CMS 路由
 *
 * @author tengchong
 * @date 2021/11/23
 */
@Service
public class CmsRouteServiceImpl implements CmsRouteService {

    @Autowired
    private BeetlProperties beetlProperties;

    @Autowired
    private ProjectProperties projectProperties;

    /**
     * 主题目录
     */
    private static final String ROOT_PATH = "themes/";

    @Override
    public String getIndexViewPath(CmsSite cmsSite) {
        String path = ROOT_PATH + cmsSite.getTheme() + "/index.html";
        if (checkExists(path)) {
            return path;
        }
        throw new EasyException("主题缺失首页视图文件（/index.html）");
    }

    @Override
    public String getColumnListViewPath(CmsSite cmsSite, CmsColumn cmsColumn) {
        // 默认栏目列表 /column/column-xxx.html
        String path = ROOT_PATH + cmsSite.getTheme() + "/column/column-" + cmsColumn.getSlug() + ".html";
        if (checkExists(path)) {
            return path;
        }
        // 默认栏目列表 /column/column.html
        path = ROOT_PATH + cmsSite.getTheme() + "/column/column.html";
        if (checkExists(path)) {
            return path;
        }
        throw new EasyException("主题缺失栏目视图文件（/column/column.html或/column/column-" + cmsColumn.getSlug() + ".html）");
    }

    @Override
    public String getArticleViewPath(CmsSite cmsSite, CmsColumn cmsColumn) {
        // 默认栏目列表 /article/article-xxx.html
        String path;
        if (cmsColumn != null) {
            path = ROOT_PATH + cmsSite.getTheme() + "/article/article-" + cmsColumn.getSlug() + ".html";
            if (checkExists(path)) {
                return path;
            }
        }
        // 默认栏目列表 /article/article.html
        path = ROOT_PATH + cmsSite.getTheme() + "/article/article.html";
        if (checkExists(path)) {
            return path;
        }
        throw new EasyException("主题缺失栏目视图文件（/article/article.html或/article/article-" + cmsColumn.getSlug() + ".html）");
    }

    @Override
    public String getPageViewPath(CmsSite cmsSite, CmsPage cmsPage) {
        if(cmsPage == null){
            throw new EasyException("页面不存在");
        }
        String path = ROOT_PATH + cmsSite.getTheme() + "/page/" + cmsPage.getTemplate();
        if (checkExists(path)) {
            return path;
        }
        throw new EasyException("主题缺失页面视图文件（/page/" + cmsPage.getTemplate() + "）");
    }

    @Override
    public void setCommonAttribute(Model model, CmsSite cmsSite) {
        // 主题base path
        model.addAttribute("themeUrl", "/static/" + cmsSite.getTheme());
        model.addAttribute("baseUrl", projectProperties.getProjectUrl());

        // 站点
        model.addAttribute("site", cmsSite);
    }

    /**
     * 检查视图文件是否存在
     *
     * @param path 视图文件路径
     * @return true/false
     */
    private boolean checkExists(String path) {
        return getClass().getClassLoader().getResourceAsStream(path) != null;
    }
}
