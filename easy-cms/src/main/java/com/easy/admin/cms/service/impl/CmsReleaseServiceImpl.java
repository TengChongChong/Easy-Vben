package com.easy.admin.cms.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.cms.common.constant.CmsRedisKeyPrefix;
import com.easy.admin.cms.common.status.CmsReleaseStatus;
import com.easy.admin.cms.common.type.CmsPageType;
import com.easy.admin.cms.common.type.CmsReleaseType;
import com.easy.admin.cms.config.beetl.BeetlConfiguration;
import com.easy.admin.cms.dao.CmsReleaseMapper;
import com.easy.admin.cms.es.service.ElasticsearchCmsArticleService;
import com.easy.admin.cms.model.*;
import com.easy.admin.cms.service.*;
import com.easy.admin.cms.utils.CmsColumnUtil;
import com.easy.admin.cms.utils.CmsSiteUtil;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.common.tree.TreeUtil;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.config.properties.ProjectProperties;
import com.easy.admin.util.ToolUtil;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 发布
 *
 * @author tengchong
 * @date 2021/11/24
 */
@Service
public class CmsReleaseServiceImpl extends ServiceImpl<CmsReleaseMapper, CmsRelease> implements CmsReleaseService {

    @Autowired
    private ProjectProperties projectProperties;

    @Autowired
    private CmsRouteService cmsRouteService;

    @Autowired
    private CmsPageService cmsPageService;

    @Autowired
    private CmsColumnService cmsColumnService;

    @Autowired
    private CmsArticleService cmsArticleService;

    @Autowired
    private CmsReleaseQueueService cmsReleaseQueueService;

    @Autowired
    private ElasticsearchCmsArticleService elasticsearchCmsArticleService;

    @Autowired
    private BeetlConfiguration beetlConfiguration;

    @Override
    public Page<CmsRelease> select(CmsRelease object, Page<CmsRelease> page) {
        QueryWrapper<CmsRelease> queryWrapper = new QueryWrapper<>();
        if (object != null) {
            // 查询条件
            // 状态
            if (Validator.isNotEmpty(object.getStatus())) {
                queryWrapper.eq("t.status", object.getStatus());
            }
        }
        if (object == null || StrUtil.isBlank(object.getSiteId())) {
            queryWrapper.eq("t.site_id", CmsSiteUtil.getCurrentEditSiteId());
        } else {
            queryWrapper.eq("t.site_id", object.getSiteId());
        }
        page.setDefaultDesc("t.create_date");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;

    }

    @Override
    public List<Tree> selectReleaseAssets() {
        List<Tree> columnTreeList = cmsColumnService.selectAll(false);
        List<Tree> pageTreeList = cmsPageService.selectAll();

        List<Tree> assets = new ArrayList<>();

        String baseSiteId = "0", basePageId = "ignore_page_0", baseColumnId = "ignore_column_0";

        // 网站 base
        CmsSite cmsSite = CmsSiteUtil.getCurrentEditSite();
        assets.add(new Tree(baseSiteId, "#", cmsSite.getName()));
        // 页面文件夹以及公共页面
        assets.add(new Tree(basePageId, baseSiteId, CmsReleaseType.PAGE.getMessage()));
        assets.add(new Tree(CmsPageType.INDEX.getCode(), basePageId, CmsPageType.INDEX.getMessage(), CmsReleaseType.PAGE.getCode()));
        assets.add(new Tree(CmsPageType.SEARCH.getCode(), basePageId, CmsPageType.SEARCH.getMessage(), CmsReleaseType.PAGE.getCode()));
        // 栏目文件夹
        assets.add(new Tree(baseColumnId, baseSiteId, CmsReleaseType.COLUMN.getMessage()));

        if (pageTreeList != null && pageTreeList.size() > 0) {
            for (Tree tree : pageTreeList) {
                tree.setParentId(basePageId);
                tree.setType(CmsReleaseType.PAGE.getCode());
                assets.add(tree);
            }
        }

        if (columnTreeList != null && columnTreeList.size() > 0) {
            for (Tree tree : columnTreeList) {
                tree.setParentId(TreeUtil.BASE_ID.equals(tree.getParentId()) ? baseColumnId : tree.getParentId());
                tree.setType(CmsReleaseType.COLUMN.getCode());
                assets.add(tree);
            }
        }

        return assets;
    }

    @Override
    public CmsRelease saveRelease(CmsRelease cmsRelease) {
        ToolUtil.checkParams(cmsRelease);
        // 是否未指定发布资源
        boolean noCheckAssets = (cmsRelease.getColumnIds() == null || cmsRelease.getColumnIds().length() == 0) && (cmsRelease.getPageIds() == null || cmsRelease.getPageIds().length() == 0);
        if (noCheckAssets) {
            // 未选择要发布的资源
            throw new EasyException("请选择要发布的资源");
        }

        // 发布不可修改
        if (StrUtil.isNotBlank(cmsRelease.getId())) {
            return cmsRelease;
        }
        cmsRelease.setSiteId(CmsSiteUtil.getCurrentEditSiteId());
        cmsRelease.setStatus(CmsReleaseStatus.TO_BE_RELEASED.getCode());
        cmsRelease.setDone(0L);
        cmsRelease.setFail(0L);
        cmsRelease.setId(UUID.randomUUID().toString(true));

        // 保存列队数据
        List<CmsReleaseQueue> queueList = new ArrayList<>();
        if (StrUtil.isNotBlank(cmsRelease.getPageIds())) {
            queueList.addAll(cmsReleaseQueueService.generatePageQueue(cmsRelease.getId(), cmsRelease.getSiteId(), cmsRelease.getPageIds().split(",")));
        }

        if (StrUtil.isNotBlank(cmsRelease.getColumnIds())) {
            queueList.addAll(cmsReleaseQueueService.generateColumnQueue(cmsRelease.getId(), cmsRelease.getSiteId(), cmsRelease.getColumnIds().split(","), "1".equals(cmsRelease.getReleaseArticle())));
        }
        cmsReleaseQueueService.saveQueue(queueList);

        cmsRelease.setTotal((long) queueList.size());
        save(cmsRelease);
        return cmsRelease;
    }

    @Override
    @Async("asyncExecutor")
    public void startRelease(String id, String siteId) {
        // 更新任务状态为发布中
        baseMapper.setStartStatus(id, CmsReleaseStatus.PUBLISHING.getCode(), new Date());
        RedisUtil.set(getReleaseStatusKey(id), CmsReleaseStatus.PUBLISHING.getCode());
        // 发布资源
        releaseAssets(siteId);
        // 待发布列队
        List<CmsReleaseQueue> queueList = cmsReleaseQueueService.selectQueue(id, CmsReleaseStatus.TO_BE_RELEASED.getCode());
        if (queueList != null && queueList.size() > 0) {
            // 发布
            release(id, queueList);
        }
    }

    @Override
    public boolean releaseQueue(String id) {
        CmsReleaseQueue queue = cmsReleaseQueueService.getQueueById(id);
        release(queue);
        // 更新数据状态
        boolean isSuccess = cmsReleaseQueueService.setStatus(id, CmsReleaseStatus.PUBLISHED.getCode());
        if (isSuccess) {
            // 更新任务汇总数据
            UpdateWrapper<CmsRelease> updateStatistics = new UpdateWrapper<>();
            updateStatistics.eq("id", queue.getpId())
                    .set("done", cmsReleaseQueueService.selectCount(queue.getpId(), CmsReleaseStatus.PUBLISHED.getCode()))
                    .set("fail", cmsReleaseQueueService.selectCount(queue.getpId(), CmsReleaseStatus.FAIL.getCode()));
            update(updateStatistics);
        }
        return isSuccess;
    }

    @Override
    public JSONObject cancelRelease(String id) {
        RedisUtil.set(getReleaseStatusKey(id), CmsReleaseStatus.CANCELLED.getCode());
        return getReleaseProgress(id);
    }

    @Override
    public JSONObject getReleaseProgress(String id) {
        JSONObject res = new JSONObject();
        String status = (String) RedisUtil.get(getReleaseStatusKey(id));
        if (StrUtil.isBlank(status) || !CmsReleaseStatus.PUBLISHING.getCode().equals(status)) {
            // 状态为空或者不是发布中，说明任务已停止，从数据库中获取进度
            CmsRelease cmsRelease = baseMapper.getReleaseProgress(id);
            res.set("isEnd", true);
            res.set("done", cmsRelease.getDone());
            res.set("fail", cmsRelease.getFail());
        } else {
            Long done = (Long) RedisUtil.get(getReleaseDoneKey(id));
            Long fail = (Long) RedisUtil.get(getReleaseFailKey(id));
            res.set("isEnd", false);
            res.set("done", done == null ? 0L : done);
            res.set("fail", fail == null ? 0L : fail);
        }
        return res;
    }

    /**
     * 发布任务列队
     *
     * @param id        id
     * @param queueList 列队
     */
    private void release(String id, List<CmsReleaseQueue> queueList) {
        Long done = 0L, fail = 0L;
        for (CmsReleaseQueue queue : queueList) {
            if (!checkReleaseStatus(id)) {
                break;
            }
            long startTime = System.currentTimeMillis();
            try {
                // 发布
                release(queue);
                // 更新进度
                done++;
                RedisUtil.set(getReleaseDoneKey(id), done);
                queue.setStatus(CmsReleaseStatus.PUBLISHED.getCode());
                queue.setDuration(System.currentTimeMillis() - startTime);
            } catch (RuntimeException e) {
                fail++;
                RedisUtil.set(getReleaseFailKey(id), fail);
                queue.setStatus(CmsReleaseStatus.FAIL.getCode());
                queue.setDuration(System.currentTimeMillis() - startTime);
                queue.setReceipt(e.getMessage());
            }
        }

        // 更新任务状态
        cmsReleaseQueueService.updateQueue(queueList);
        RedisUtil.del(getReleaseStatusKey(id));
        RedisUtil.del(getReleaseDoneKey(id));
        RedisUtil.del(getReleaseFailKey(id));
        if ((done + fail) == queueList.size()) {
            baseMapper.setEndStatus(id, CmsReleaseStatus.PUBLISHED.getCode(), new Date(), done, fail);
        } else {
            // 中止
            baseMapper.setEndStatus(id, CmsReleaseStatus.CANCELLED.getCode(), new Date(), done, fail);
        }
    }

    /**
     * 发布单个任务
     *
     * @param queue 任务详情
     */
    private void release(CmsReleaseQueue queue) {
        CmsReleaseType cmsReleaseType = CmsReleaseType.getCmsReleaseType(queue.getType());
        if (cmsReleaseType != null) {
            try {
                switch (cmsReleaseType) {
                    case PAGE:
                        releasePage(queue.getSiteId(), queue.getDataId());
                        break;
                    case COLUMN:
                        releaseColumn(queue.getSiteId(), queue.getDataId());
                        break;
                    case ARTICLE:
                        releaseArticle(queue.getSiteId(), queue.getDataId());
                        break;
                    default:
                }
            } catch (RuntimeException e) {
                throw new EasyException(e.getMessage());
            }
        }
    }

    /**
     * 检查发布任务状态
     *
     * @param id 任务id
     */
    private boolean checkReleaseStatus(String id) {
        return CmsReleaseStatus.PUBLISHING.getCode().equals(RedisUtil.get(getReleaseStatusKey(id)));
    }

    private String getReleaseStatusKey(String id) {
        return CmsRedisKeyPrefix.RELEASE_STATUS + id;
    }

    private String getReleaseDoneKey(String id) {
        return CmsRedisKeyPrefix.RELEASE_DONE + id;
    }

    private String getReleaseFailKey(String id) {
        return CmsRedisKeyPrefix.RELEASE_FAIL + id;
    }

    @Override
    public boolean releaseAssets(String siteId) {
        CmsSite cmsSite = CmsSiteUtil.getSiteById(siteId);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource resource = resolver.getResource("themes/" + cmsSite.getTheme() + "/assets");
            FileUtil.copy(resource.getFile(), new File(cmsSite.getDeploymentPath()), true);
        } catch (RuntimeException | IOException e) {
            throw new EasyException("拷贝主题资源目录失败" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean releaseHome(String siteId) {
        Map<String, Object> params = new HashMap<>();

        CmsSite cmsSite = CmsSiteUtil.getSiteById(siteId);
        setCommonAttribute(params, cmsSite);

        // 页面 title
        params.put("title", cmsSite.getName());
        params.put("currentPage", "page-index");
        generateFile(params, cmsRouteService.getIndexViewPath(cmsSite), getHomeFilePath(cmsSite));
        return true;
    }

    @Override
    public boolean releasePage(String siteId, String id) {
        CmsPageType cmsPageType = CmsPageType.getCmsPageType(id);
        if (cmsPageType != null) {
            switch (cmsPageType) {
                case INDEX:
                    releaseHome(siteId);
                    break;
                case SEARCH:
                    // todo: 待完善
                case ERROR_404:
                    // todo: 待完善
                    break;
                default:
            }
            return true;
        }

        Map<String, Object> params = new HashMap<>();

        CmsSite cmsSite = CmsSiteUtil.getSiteById(siteId);
        setCommonAttribute(params, cmsSite);

        CmsPage cmsPage = cmsPageService.get(id);
        params.put("page", cmsPage);
        params.put("currentPage", "page-" + cmsPage.getSlug());

        params.put("title", cmsPage.getTitle() + " | " + cmsSite.getName());

        generateFile(params, cmsRouteService.getPageViewPath(cmsSite, cmsPage), getPageFilePath(cmsSite, cmsPage));
        return true;
    }

    @Override
    public boolean releaseColumn(String siteId, String slug) {
        return releaseColumn(CmsSiteUtil.getSiteById(siteId), CmsColumnUtil.getBySlug(siteId, slug));
    }

    @Override
    public boolean releaseColumnById(String siteId, String columnId) {
        return releaseColumn(CmsSiteUtil.getSiteById(siteId), CmsColumnUtil.getById(siteId, columnId));
    }

    private boolean releaseColumn(CmsSite cmsSite, CmsColumn cmsColumn) {
        Map<String, Object> params = new HashMap<>();

        setCommonAttribute(params, cmsSite);

        params.put("column", cmsColumn);
        params.put("currentPage", "column-" + cmsColumn.getSlug());

        params.put("title", cmsColumn.getName() + " | " + cmsSite.getName());

        generateFile(params, cmsRouteService.getColumnListViewPath(cmsSite, cmsColumn), getColumnFilePath(cmsSite, cmsColumn));
        return true;
    }

    @Override
    public boolean releaseArticle(String siteId, String articleId) {
        Map<String, Object> params = new HashMap<>();

        CmsSite cmsSite = CmsSiteUtil.getSiteById(siteId);
        setCommonAttribute(params, cmsSite);

        CmsColumn cmsColumn = cmsArticleService.getColumnByArticleId(articleId);
        params.put("column", cmsColumn);
        params.put("currentPage", "column-" + cmsColumn.getSlug());

        CmsArticle cmsArticle = cmsArticleService.get(articleId);
        params.put("article", cmsArticle);

        params.put("title", cmsArticle.getTitle() + " | " + cmsSite.getName());

        // 更新索引
        elasticsearchCmsArticleService.saveOrUpdate(cmsArticle);

        generateFile(params, cmsRouteService.getArticleViewPath(cmsSite, cmsColumn), getArticleFilePath(cmsSite, cmsArticle));
        return true;
    }

    /**
     * 获取首页文件存放路径
     *
     * @param cmsSite 站点
     * @return path
     */
    private String getHomeFilePath(CmsSite cmsSite) {
        String parentPath = checkDir(cmsSite.getDeploymentPath());
        return parentPath + "index.html";
    }

    /**
     * 获取页面文件存放路径
     *
     * @param cmsSite 站点
     * @param cmsPage 页面
     * @return path
     */
    private String getPageFilePath(CmsSite cmsSite, CmsPage cmsPage) {
        String parentPath = checkDir(cmsSite.getDeploymentPath() + File.separator + "page");
        return parentPath + cmsPage.getSlug() + ".html";
    }

    /**
     * 获取栏目文件存放路径
     *
     * @param cmsSite   站点
     * @param cmsColumn 栏目
     * @return path
     */
    private String getColumnFilePath(CmsSite cmsSite, CmsColumn cmsColumn) {
        String parentPath = checkDir(cmsSite.getDeploymentPath() + File.separator + "column");
        return parentPath + cmsColumn.getSlug() + ".html";
    }

    /**
     * 获取文章文件存放路径
     *
     * @param cmsSite    站点
     * @param cmsArticle 文章
     * @return path
     */
    private String getArticleFilePath(CmsSite cmsSite, CmsArticle cmsArticle) {
        String parentPath = checkDir(cmsSite.getDeploymentPath() + File.separator + "article");
        return parentPath + cmsArticle.getId() + ".html";
    }

    /**
     * 检查目录是否存在，不存在则新建
     *
     * @param path 目录
     * @return 目录
     */
    private String checkDir(String path) {
        File parentFolder = new File(path);
        if (!parentFolder.exists()) {
            parentFolder.mkdirs();
        }
        return parentFolder.getPath() + File.separator;
    }

    /**
     * 设置一些公共的变量
     *
     * @param params  变量
     * @param cmsSite 站点
     */
    private void setCommonAttribute(Map<String, Object> params, CmsSite cmsSite) {
        // 主题base path
        params.put("themeUrl", "");
        params.put("baseUrl", projectProperties.getProjectUrl());

        // 站点
        params.put("site", cmsSite);
    }

    /**
     * 生成页面
     *
     * @param params       变量
     * @param templatePath 页面模板
     * @param filePath     页面路径
     */
    private void generateFile(Map<String, Object> params, String templatePath, String filePath) {
        String content = analysisPage(params, templatePath);
        FileUtil.writeUtf8String(content, filePath);
    }

    /**
     * 解析页面
     *
     * @param params       变量
     * @param templatePath 页面模板
     * @return 页面内容
     */
    private String analysisPage(Map<String, Object> params, String templatePath) {
        long startTime = System.currentTimeMillis();
        GroupTemplate groupTemplate = beetlConfiguration.getGroupTemplate();
        // 发布模式
        params.put("release-pattern", true);
        //获取模板
        Template template = groupTemplate.getTemplate(templatePath);
        template.binding(params);
        //渲染结果
        String content = template.render();
        content += "<!-- 发布时间：" + DateUtil.now() + "，耗时：" + (System.currentTimeMillis() - startTime) / 1000.0 + "s -->";
        return content;
    }
}
