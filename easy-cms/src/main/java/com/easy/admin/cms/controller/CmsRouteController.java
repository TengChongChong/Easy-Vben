package com.easy.admin.cms.controller;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.cms.model.CmsArticle;
import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.cms.model.CmsPage;
import com.easy.admin.cms.model.CmsSite;
import com.easy.admin.cms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * CMS 路由
 *
 * @author tengchong
 * @date 2023-07-03
 */
@Controller
@RequestMapping("/cms/route")
public class CmsRouteController {

    @Autowired
    private CmsRouteService service;

    @Autowired
    private CmsSiteService cmsSiteService;

    @Autowired
    private CmsColumnService cmsColumnService;

    @Autowired
    private CmsArticleService cmsArticleService;

    @Autowired
    private CmsPageService cmsPageService;

    /**
     * 首页
     *
     * @param model  model
     * @param siteId 站点id
     * @return view
     */
    @GetMapping("{siteId}")
    public String index(Model model, @PathVariable("siteId") String siteId) {
        CmsSite cmsSite = cmsSiteService.getCmsSiteUseCache(siteId);
        service.setCommonAttribute(model, cmsSite);
        model.addAttribute("title", cmsSite.getName());
        model.addAttribute("currentPage", "page-index");
        return service.getIndexViewPath(cmsSite);
    }

    /**
     * 栏目列表
     *
     * @param model    model
     * @param siteId   站点id
     * @param columnId 栏目id
     * @return view
     */
    @GetMapping("{siteId}/column/{columnId}")
    public String column(Model model, @PathVariable("siteId") String siteId, @PathVariable("columnId") String columnId) {
        CmsSite cmsSite = cmsSiteService.getCmsSiteUseCache(siteId);
        service.setCommonAttribute(model, cmsSite);

        CmsColumn cmsColumn = cmsColumnService.getCmsColumnUseCache(siteId, columnId);
        model.addAttribute("column", cmsColumn);
        model.addAttribute("currentPage", "column-" + cmsColumn.getSlug());
        model.addAttribute("title", cmsColumn.getName() + " | " + cmsSite.getName());

        return service.getColumnListViewPath(cmsSite, cmsColumn);
    }

    /**
     * 文章详情
     *
     * @param model     model
     * @param siteId    站点id
     * @param articleId 栏目id
     * @return view
     */
    @GetMapping("{siteId}/article/{articleId}")
    public String article(Model model, @PathVariable("siteId") String siteId, @PathVariable("articleId") String articleId) {
        CmsSite cmsSite = cmsSiteService.getCmsSiteUseCache(siteId);
        service.setCommonAttribute(model, cmsSite);

        CmsArticle cmsArticle = cmsArticleService.get(articleId);
        model.addAttribute("article", cmsArticle);

        CmsColumn cmsColumn = cmsColumnService.getCmsColumnUseCache(siteId, cmsArticle.getColumnId());
        model.addAttribute("column", cmsColumn);
        model.addAttribute("currentPage", "column-" + cmsColumn.getSlug());

        model.addAttribute("title", cmsArticle.getTitle() + " | " + cmsSite.getName());
        if (StrUtil.isNotBlank(cmsArticle.getKeyword())) {
            model.addAttribute("keyword", cmsArticle.getKeyword());
        }
        if (StrUtil.isNotBlank(cmsArticle.getDescription())) {
            model.addAttribute("description", cmsArticle.getDescription());
        }
        return service.getArticleViewPath(cmsSite, cmsColumn);
    }

    /**
     * 页面
     *
     * @param model  model
     * @param siteId 站点id
     * @param pageId 页面id
     * @return view
     */
    @GetMapping("{siteId}/page/{pageId}")
    public String page(Model model, @PathVariable("siteId") String siteId, @PathVariable("pageId") String pageId) {
        CmsSite cmsSite = cmsSiteService.getCmsSiteUseCache(siteId);
        service.setCommonAttribute(model, cmsSite);

        CmsPage cmsPage = cmsPageService.get(pageId);
        model.addAttribute("page", cmsPage);
        model.addAttribute("currentPage", "page-" + cmsPage.getSlug());
        model.addAttribute("title", cmsPage.getTitle() + " | " + cmsSite.getName());

        return service.getPageViewPath(cmsSite, cmsPage);
    }
}
