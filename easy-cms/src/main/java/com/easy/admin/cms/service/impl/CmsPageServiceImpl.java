package com.easy.admin.cms.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.cms.config.beetl.BeetlProperties;
import com.easy.admin.cms.dao.CmsPageMapper;
import com.easy.admin.cms.model.CmsPage;
import com.easy.admin.cms.model.CmsSite;
import com.easy.admin.cms.service.CmsPageService;
import com.easy.admin.cms.utils.CmsSiteUtil;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 页面
 *
 * @author 系统管理员
 * @date 2023-06-27
 */
@Service
public class CmsPageServiceImpl extends ServiceImpl<CmsPageMapper, CmsPage> implements CmsPageService {

    @Autowired
    private BeetlProperties beetlProperties;

    @Override
    public Page<CmsPage> select(CmsPage cmsPage, Page<CmsPage> page) {
        if (StrUtil.isBlank(CmsSiteUtil.getUserActiveSiteId())) {
            return page;
        }
        QueryWrapper<CmsPage> queryWrapper = getQueryWrapper(cmsPage);
        page.setDefaultDesc("t.create_date");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    private QueryWrapper<CmsPage> getQueryWrapper(CmsPage cmsPage) {
        QueryWrapper<CmsPage> queryWrapper = new QueryWrapper<>();
        if (cmsPage != null) {
            // 查询条件
            // 标题
            if (Validator.isNotEmpty(cmsPage.getTitle())) {
                queryWrapper.like("t.title", cmsPage.getTitle());
            }
            // 别名
            if (Validator.isNotEmpty(cmsPage.getSlug())) {
                queryWrapper.like("t.slug", cmsPage.getSlug());
            }
            // 模板
            if (Validator.isNotEmpty(cmsPage.getTemplate())) {
                queryWrapper.like("t.template", cmsPage.getTemplate());
            }
            // 状态
            if (Validator.isNotEmpty(cmsPage.getStatus())) {
                if (cmsPage.getStatus().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.status", cmsPage.getStatus().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.status", cmsPage.getStatus());
                }
            }
        }
        queryWrapper.eq("t.site_id", CmsSiteUtil.getUserActiveSiteId());
        return queryWrapper;
    }

    @Override
    public List<Tree> selectAll() {
        return baseMapper.selectAll(CmsSiteUtil.getUserActiveSiteId());
    }

    @Override
    public CmsPage get(String id) {
        ToolUtil.checkParams(id);
        return baseMapper.getById(id);
    }

    @Override
    public CmsPage add() {
        CmsPage cmsPage = new CmsPage();
        // 设置默认值
        return cmsPage;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        ToolUtil.checkParams(ids);
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        return removeByIds(idList);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public CmsPage saveData(CmsPage cmsPage) {
        ToolUtil.checkParams(cmsPage);
        if (Validator.isEmpty(cmsPage.getId())) {
            // 新增,设置默认值
            cmsPage.setSiteId(CmsSiteUtil.getUserActiveSiteId());
            cmsPage.setStatus(CommonStatus.ENABLE.getCode());
        }
        // 检查别名是否重复
        checkSlug(cmsPage);
        return (CmsPage) ToolUtil.checkResult(saveOrUpdate(cmsPage), cmsPage);
    }

    /**
     * 检查别名是否重复
     *
     * @param cmsPage 表单信息
     */
    private void checkSlug(CmsPage cmsPage) {
        QueryWrapper<CmsPage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("slug", cmsPage.getSlug());
        if (Validator.isNotEmpty(cmsPage.getId())) {
            queryWrapper.ne("id", cmsPage.getId());
        }
        // 站点内栏目别名禁止重复
        queryWrapper.eq("site_id", cmsPage.getSiteId());
        long count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new EasyException("页面别名 " + cmsPage.getSlug() + " 已存在");
        }
    }

    @Override
    public List<Select> selectThemePageTemplate() {
        File themeRoot = new File(beetlProperties.getThemeRoot());
        if (!themeRoot.exists() || !themeRoot.isDirectory()) {
            return Collections.emptyList();
        }

        CmsSite cmsSite = CmsSiteUtil.getUserActiveSite();
        if (StrUtil.isBlank(cmsSite.getTheme())) {
            throw new EasyException("当前站点未设置主题目录");
        }

        // 页面模板路径
        File pageDirectory = new File(beetlProperties.getThemeRoot() + cmsSite.getTheme() + File.separator + "page");
        if (!pageDirectory.exists() || !pageDirectory.isDirectory()) {
            return Collections.emptyList();
        }
        List<Select> themeArray = new ArrayList<>();
        for (File file : pageDirectory.listFiles()) {
            themeArray.add(new Select(file.getName(), file.getName()));
        }
        return themeArray;
    }

    public List<CmsPage> selectPages(String[] ids) {
        QueryWrapper<CmsPage> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("t.id", ids);
        queryWrapper.eq("t.status", CommonStatus.ENABLE.getCode());
        return baseMapper.selectPages(queryWrapper);
    }
}