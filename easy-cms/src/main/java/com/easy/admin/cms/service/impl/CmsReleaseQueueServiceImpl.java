package com.easy.admin.cms.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.cms.common.type.CmsPageType;
import com.easy.admin.cms.common.type.CmsReleaseType;
import com.easy.admin.cms.dao.CmsReleaseQueueMapper;
import com.easy.admin.cms.model.CmsArticle;
import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.cms.model.CmsPage;
import com.easy.admin.cms.model.CmsReleaseQueue;
import com.easy.admin.cms.service.CmsArticleService;
import com.easy.admin.cms.service.CmsColumnService;
import com.easy.admin.cms.service.CmsPageService;
import com.easy.admin.cms.service.CmsReleaseQueueService;
import com.easy.admin.common.core.common.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 发布列队
 *
 * @author TengChongChong
 * @date 2021-11-24
 */
@Service
public class CmsReleaseQueueServiceImpl extends ServiceImpl<CmsReleaseQueueMapper, CmsReleaseQueue> implements CmsReleaseQueueService {

    @Autowired
    private CmsPageService cmsPageService;

    @Autowired
    private CmsColumnService cmsColumnService;

    @Autowired
    private CmsArticleService cmsArticleService;

    @Override
    public List<CmsReleaseQueue> selectQueue(String pId, String status) {
        return baseMapper.selectQueue(pId, status);
    }

    @Override
    public CmsReleaseQueue getQueueById(String id) {
        return baseMapper.getQueueById(id);
    }

    @Override
    public boolean setStatus(String id, String status) {
        UpdateWrapper<CmsReleaseQueue> setStatus = new UpdateWrapper<>();
        setStatus.set("status", status).eq("id", id);
        return update(setStatus);
    }

    @Override
    public Page<CmsReleaseQueue> select(CmsReleaseQueue object, Page<CmsReleaseQueue> page) {
        QueryWrapper<CmsReleaseQueue> queryWrapper = new QueryWrapper<>();
        if (object != null) {
            // 查询条件
            // 任务id
            if (Validator.isNotEmpty(object.getpId())) {
                queryWrapper.eq("t.p_id", object.getpId());
            }
            // 标题
            if (Validator.isNotEmpty(object.getTitle())) {
                queryWrapper.like("t.title", object.getTitle());
            }
            // 状态
            if (Validator.isNotEmpty(object.getStatus())) {
                queryWrapper.eq("t.status", object.getStatus());
            }
        }
        page.setDefaultDesc("t.type");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    @Override
    public List<CmsReleaseQueue> generatePageQueue(String pId, String siteId, String[] pageIds) {
        List<CmsReleaseQueue> queueList = new ArrayList<>();
        List<CmsPage> cmsPageList = cmsPageService.selectPages(pageIds);
        if (cmsPageList != null && cmsPageList.size() > 0) {
            for (CmsPage cmsPage : cmsPageList) {
                queueList.add(new CmsReleaseQueue(
                        pId,
                        CmsReleaseType.PAGE.getCode(),
                        siteId,
                        cmsPage.getId(),
                        cmsPage.getTitle()
                ));
            }
        }


        // 遍历id，获取默认页面列队
        for (String pageId : pageIds) {
            CmsPageType cmsPageType = CmsPageType.getCmsPageType(pageId);
            if (cmsPageType != null) {
                CmsReleaseQueue cmsReleaseQueue = new CmsReleaseQueue(
                        pId,
                        CmsReleaseType.PAGE.getCode(),
                        siteId,
                        cmsPageType.getCode(),
                        null
                );
                switch (cmsPageType) {
                    case INDEX:
                        cmsReleaseQueue.setTitle("首页");
                        break;
                    case SEARCH:
                        cmsReleaseQueue.setTitle("搜索");
                        break;
                    case ERROR_404:
                        cmsReleaseQueue.setTitle("404");
                        break;
                    default:
                        cmsReleaseQueue.setTitle("未知标题");
                }
                queueList.add(cmsReleaseQueue);
            }
        }
        return queueList;
    }

    @Override
    public List<CmsReleaseQueue> generateColumnQueue(String pId, String siteId, String[] columnIds, boolean releaseArticle) {
        List<CmsColumn> cmsColumnList = cmsColumnService.selectCmsColumns(columnIds);
        if (cmsColumnList == null || cmsColumnList.size() == 0) {
            // 未查询到栏目数据
            return Collections.emptyList();
        }
        List<CmsReleaseQueue> queueList = new ArrayList<>();
        for (CmsColumn cmsColumn : cmsColumnList) {
            queueList.add(new CmsReleaseQueue(
                    pId,
                    CmsReleaseType.COLUMN.getCode(),
                    cmsColumn.getSiteId(),
                    cmsColumn.getId(),
                    cmsColumn.getName()
            ));
        }
        if (!releaseArticle) {
            return queueList;
        }
        // 需要发布栏目下文章
        List<CmsArticle> cmsArticleList = cmsArticleService.selectArticleByColumnIds(columnIds);
        if (cmsArticleList == null || cmsArticleList.size() == 0) {
            return queueList;
        }

        for (CmsArticle cmsArticle : cmsArticleList) {
            queueList.add(new CmsReleaseQueue(
                    pId,
                    CmsReleaseType.ARTICLE.getCode(),
                    cmsArticle.getSiteId(),
                    cmsArticle.getId(),
                    cmsArticle.getTitle()
            ));
        }

        return queueList;
    }

    @Override
    public List<CmsReleaseQueue> saveQueue(List<CmsReleaseQueue> queueList) {
        saveBatch(queueList);
        return queueList;
    }

    @Override
    public List<CmsReleaseQueue> updateQueue(List<CmsReleaseQueue> queueList) {
        saveOrUpdateBatch(queueList);
        return queueList;
    }

    @Override
    public long selectCount(String pId, String status) {
        return baseMapper.selectDoneCount(pId, status);
    }
}