package com.easy.admin.cms.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HtmlUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.cms.common.status.CmsArticleStatus;
import com.easy.admin.cms.common.type.CmsArticleReleaseType;
import com.easy.admin.cms.common.type.CmsFileType;
import com.easy.admin.cms.dao.CmsArticleMapper;
import com.easy.admin.cms.es.service.ElasticsearchCmsArticleService;
import com.easy.admin.cms.model.CmsArticle;
import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.cms.model.CmsSite;
import com.easy.admin.cms.service.CmsArticleService;
import com.easy.admin.cms.utils.CmsReleaseUtil;
import com.easy.admin.cms.utils.CmsSiteUtil;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.sys.model.SysFile;
import com.easy.admin.sys.model.SysUser;
import com.easy.admin.sys.service.SysFileService;
import com.easy.admin.util.ShiroUtil;
import com.easy.admin.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 文章管理
 *
 * @author TengChongChong
 * @date 2021-11-19
 */
@Service
public class CmsArticleServiceImpl extends ServiceImpl<CmsArticleMapper, CmsArticle> implements CmsArticleService {

    @Autowired
    private SysFileService sysFileService;

    @Autowired
    private ElasticsearchCmsArticleService elasticsearchCmsArticleService;

    /**
     * 列表
     *
     * @param object 查询条
     * @param page   分页
     * @return Page<CmsArticle>
     */
    @Override
    public Page<CmsArticle> select(CmsArticle object, Page<CmsArticle> page) {
        QueryWrapper<CmsArticle> queryWrapper = new QueryWrapper<>();
        if (object == null) {
            object = new CmsArticle();
        }
        // 查询条件
        // 标题
        if (Validator.isNotEmpty(object.getTitle())) {
            queryWrapper.like("t.title", object.getTitle());
        }
        // 栏目Id
        if (Validator.isNotEmpty(object.getColumnId())) {
            queryWrapper.eq("t.column_id", object.getColumnId());
        }
        // 栏目别名
        if (Validator.isNotEmpty(object.getColumnSlug())) {
            queryWrapper.eq("cc.slug", object.getColumnSlug());
        }

        // 信息来源
        if (Validator.isNotEmpty(object.getSource())) {
            queryWrapper.like("t.source", object.getSource());
        }
        // 作者
        if (Validator.isNotEmpty(object.getAuthor())) {
            queryWrapper.like("t.author", object.getAuthor());
        }
        // 状态
        if (Validator.isNotEmpty(object.getStatus())) {
            queryWrapper.eq("t.status", object.getStatus());
        }
        if (StrUtil.isBlank(object.getSiteId())) {
            queryWrapper.eq("t.site_id", CmsSiteUtil.getCurrentEditSiteId());
        } else {
            queryWrapper.eq("t.site_id", object.getSiteId());
        }
        page.setDefaultDesc("t.create_date");
        page.setRecords(baseMapper.select(page, queryWrapper, CmsFileType.ARTICLE_COVER.getCode()));
        return page;
    }

    @Override
    public Page<CmsArticle> selectForUtil(CmsArticle object, Page<CmsArticle> page) {
        QueryWrapper<CmsArticle> queryWrapper = new QueryWrapper<>();
        if (object == null || StrUtil.isBlank(object.getSiteId())) {
            throw new EasyException("请指定站点id");
        }
        // 查询条件
        // 标题
        if (Validator.isNotEmpty(object.getTitle())) {
            queryWrapper.like("t.title", object.getTitle());
        }
        // 栏目Id
        if (Validator.isNotEmpty(object.getColumnId())) {
            queryWrapper.eq("t.column_id", object.getColumnId());
        }
        // 栏目别名
        if (Validator.isNotEmpty(object.getColumnSlug())) {
            queryWrapper.eq("cc.slug", object.getColumnSlug());
        }

        // 信息来源
        if (Validator.isNotEmpty(object.getSource())) {
            queryWrapper.like("t.source", object.getSource());
        }
        // 作者
        if (Validator.isNotEmpty(object.getAuthor())) {
            queryWrapper.like("t.author", object.getAuthor());
        }
        // 站点
        queryWrapper.eq("t.site_id", object.getSiteId());

        // 只查询已发布
        queryWrapper.eq("t.status", CmsArticleStatus.PUBLISHED.getCode());

        page.setDefaultDesc("t.create_date");
        if (page.getPageSize() == -1) {
            page.setRecords(baseMapper.selectForUtil(null, queryWrapper, CmsFileType.ARTICLE_COVER.getCode(), object.getAppendField()));
        } else {
            page.setRecords(baseMapper.selectForUtil(page, queryWrapper, CmsFileType.ARTICLE_COVER.getCode(), object.getAppendField()));
        }
        return page;
    }

    @Override
    public List<CmsArticle> selectArticleByColumnIds(String[] columnIds) {
        QueryWrapper<CmsArticle> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("t.status", CmsArticleStatus.PUBLISHED.getCode());
        queryWrapper.in("t.column_id", Arrays.asList(columnIds));
        return baseMapper.selectArticleByColumnIds(queryWrapper);
    }

    /**
     * 详情
     *
     * @param id id
     * @return CmsArticle
     */
    @Override
    public CmsArticle get(String id) {
        ToolUtil.checkParams(id);
        CmsArticle cmsArticle = baseMapper.getById(id);
        if (cmsArticle != null) {
            // 设置封面
            List<SysFile> coverFiles = sysFileService.select(cmsArticle.getId(), CmsFileType.ARTICLE_COVER.getCode());
            if (coverFiles != null && coverFiles.size() > 0) {
                cmsArticle.setCover(coverFiles.get(0));
            }
        }
        return cmsArticle;
    }

    /**
     * 新增
     *
     * @return CmsArticle
     */
    @Override
    public CmsArticle add(String columnId) {
        SysUser currentUser = ShiroUtil.getCurrentUser();
        CmsArticle object = new CmsArticle();
        object.setAuthor(currentUser.getNickname());
        object.setReleaseType(CmsArticleReleaseType.MANUAL.getCode());
        object.setStatus(CmsArticleStatus.DRAFT.getCode());
        object.setColumnId(columnId);
        // 设置默认值
        return object;
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        ToolUtil.checkParams(ids);
        List<String> idList = Arrays.asList(ids.split(","));
        boolean isSuccess = removeByIds(idList);
        if (isSuccess) {
            String siteId = CmsSiteUtil.getCurrentEditSiteId();
            // 删除封面
            for (String id : idList) {
                sysFileService.delete(id);
                elasticsearchCmsArticleService.deleteDoc(siteId, id);
            }
        }
        return isSuccess;
    }

    @Override
    public boolean removeBySiteId(String siteId) {
        boolean isSuccess = baseMapper.deleteBySiteId(siteId) > 0;
        if(isSuccess){
            elasticsearchCmsArticleService.deleteIndex(siteId);
        }
        return isSuccess;
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return CmsArticle
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public CmsArticle saveData(CmsArticle object) {
        ToolUtil.checkParams(object);
        SysUser currentUser = ShiroUtil.getCurrentUser();
        // 设置站点id
        if (StrUtil.isBlank(object.getSiteId())) {
            object.setSiteId(CmsSiteUtil.getCurrentEditSiteId());
        }

        // 自动摘要
        if(StrUtil.isBlank(object.getExcerpt()) && StrUtil.isNotBlank(object.getContent())){
            object.setExcerpt(StrUtil.maxLength(HtmlUtil.cleanHtmlTag(object.getContent()).trim().replaceAll("&nbsp;", ""), 200));
        }
        if (Validator.isEmpty(object.getId())) {
            // 新增,设置默认值
            object.setStatus(CmsArticleStatus.DRAFT.getCode());
            object.setDeptId(currentUser.getDeptId());
            object.setViewCount(0);
        }
        boolean isSuccess = saveOrUpdate(object);
        if (isSuccess) {
            // 处理封面
            if (object.getCover() != null && StrUtil.isBlank(object.getCover().getId())) {
                // 新上传了封面
                // 删除旧封面
                sysFileService.delete(object.getId(), CmsFileType.ARTICLE_COVER.getCode());
                // 保存新封面
                object.setCover(sysFileService.saveData(object.getId(), CmsFileType.ARTICLE_COVER.getCode(), object.getCover().getPath()));
            }

            // todo: 栏目文章排序
        }

        if(CmsArticleStatus.PUBLISHED.getCode().equals(object.getStatus())){
            // 更新索引
            elasticsearchCmsArticleService.saveOrUpdate(object);
        }

        return object;
    }

    @Override
    public boolean setStatus(String ids, String status) {
        UpdateWrapper<CmsArticle> setStatus = new UpdateWrapper<>();
        setStatus.in("id", Arrays.asList(ids.split(CommonConst.SPLIT)));
        setStatus.set("status", status);
        if (CmsArticleStatus.PUBLISHED.getCode().equals(status)) {
            // 发布
            setStatus.set("release_date", new Date());
        } else {
            setStatus.set("release_date", null);
        }
        boolean isSuccess = update(setStatus);
        if (isSuccess) {
            // 发布站点
            List<String> siteIds = baseMapper.selectSiteIds(new QueryWrapper<CmsArticle>().in("t.id", Arrays.asList(ids.split(CommonConst.SPLIT))));
            if (siteIds != null && siteIds.size() > 0) {
                for (String siteId : siteIds) {
                    CmsReleaseUtil.releaseHome(siteId);
                }
            }
            // 发布栏目
            QueryWrapper<CmsArticle> queryColumns = new QueryWrapper<>();
            queryColumns.in("t.id", Arrays.asList(ids.split(CommonConst.SPLIT)));
            List<CmsColumn> cmsColumns = baseMapper.selectColumnIdByArticleId(queryColumns);
            if (cmsColumns != null && cmsColumns.size() > 0) {
                for (CmsColumn cmsColumn : cmsColumns) {
                    CmsReleaseUtil.releaseColumn(cmsColumn.getSiteId(), cmsColumn.getId());
                }
            }

            List<CmsArticle> cmsArticles = baseMapper.selectCmsArticle(new QueryWrapper<CmsArticle>().in("t.id", Arrays.asList(ids.split(CommonConst.SPLIT))));
            if (cmsArticles != null && cmsArticles.size() > 0) {
                // 发布/撤销文章
                if (CmsArticleStatus.PUBLISHED.getCode().equals(status)) {
                    for (CmsArticle cmsArticle : cmsArticles) {
                        CmsReleaseUtil.releaseArticle(cmsArticle.getSiteId(), cmsArticle.getId());
                    }
                } else {
                    // 撤销删除文件
                    for (CmsArticle cmsArticle : cmsArticles) {
                        CmsSite cmsSite = CmsSiteUtil.getSiteById(cmsArticle.getSiteId());
                        if (cmsSite != null) {
                            FileUtil.del(cmsSite.getDeploymentPath() + File.separator + "article" + File.separator + cmsArticle.getId() + ".html");
                        }
                        elasticsearchCmsArticleService.deleteDoc(cmsArticle.getSiteId(), cmsArticle.getId());
                    }
                }
            }
        }
        return isSuccess;
    }

    @Override
    public CmsColumn getColumnByArticleId(String id) {
        return baseMapper.getColumnByArticleId(id);
    }

    @Override
    public int selectCountByColumnId(String columnId) {
        return baseMapper.selectCountByColumnId(columnId);
    }
}