package com.easy.admin.cms.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.cms.common.status.CmsArticleStatus;
import com.easy.admin.cms.common.type.CmsArticleReleaseType;
import com.easy.admin.cms.common.type.CmsFileType;
import com.easy.admin.cms.dao.CmsArticleMapper;
import com.easy.admin.cms.model.CmsArticle;
import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.cms.service.CmsArticleService;
import com.easy.admin.cms.utils.CmsSiteUtil;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.util.ToolUtil;
import com.easy.admin.file.service.FileInfoService;
import com.easy.admin.file.storage.FileStorageFactory;
import com.easy.admin.file.util.file.EditorUtil;
import com.easy.admin.util.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 文章
 *
 * @author tengchongchong
 * @date 2023-06-21
 */
@Service
public class CmsArticleServiceImpl extends ServiceImpl<CmsArticleMapper, CmsArticle> implements CmsArticleService {

    @Autowired
    private FileInfoService fileInfoService;

    @Autowired
    private FileStorageFactory fileStorageFactory;

    @Override
    public Page<CmsArticle> select(CmsArticle cmsArticle, Page<CmsArticle> page) {
        if (StrUtil.isBlank(CmsSiteUtil.getUserActiveSiteId())) {
            return page;
        }
        QueryWrapper<CmsArticle> queryWrapper = getQueryWrapper(cmsArticle);
        page.setDefaultDesc("t.create_date");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    @Override
    public Page<CmsArticle> selectArticle(CmsArticle cmsArticle, Page<CmsArticle> page) {
        if (StrUtil.isBlank(cmsArticle.getSiteId())) {
            throw new EasyException("请指定站点id");
        }
        QueryWrapper<CmsArticle> queryWrapper = new QueryWrapper<>();
        // 标题
        if (Validator.isNotEmpty(cmsArticle.getTitle())) {
            queryWrapper.like("t.title", cmsArticle.getTitle());
        }
        // 栏目Id
        if (Validator.isNotEmpty(cmsArticle.getColumnId())) {
            queryWrapper.eq("t.column_id", cmsArticle.getColumnId());
        }
        // 栏目别名
        if (Validator.isNotEmpty(cmsArticle.getColumnSlug())) {
            queryWrapper.eq("cc.slug", cmsArticle.getColumnSlug());
        }
        // 站点
        queryWrapper.eq("t.site_id", cmsArticle.getSiteId());
        // 只查询已发布
        queryWrapper.eq("t.status", CmsArticleStatus.PUBLISHED.getCode());
        // 排序方式
        page.setDefaultDesc("t.order_no, t.release_date");

        List<CmsArticle> cmsArticleList = baseMapper.selectArticle(page.getPageSize() == -1 ? null : page, queryWrapper, cmsArticle.getAppendField());
        for (CmsArticle article : cmsArticleList) {
            if (StrUtil.isNotBlank(article.getCoverUrl())) {
                //article.setCoverUrl(FileUtil.getUrl(article.getCoverUrl()));
            }
        }
        page.setRecords(cmsArticleList);
        return page;
    }

    @Override
    public long countByColumnId(String columnIds) {
        QueryWrapper<CmsArticle> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("column_id", columnIds.split(CommonConst.SPLIT));
        return count(queryWrapper);
    }

    @Override
    public long countBySiteId(String siteIds) {
        QueryWrapper<CmsArticle> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("site_id", siteIds.split(CommonConst.SPLIT));
        return count(queryWrapper);
    }

    private QueryWrapper<CmsArticle> getQueryWrapper(CmsArticle cmsArticle) {
        QueryWrapper<CmsArticle> queryWrapper = new QueryWrapper<>();
        if (cmsArticle != null) {
            // 查询条件
            // 标题
            if (Validator.isNotEmpty(cmsArticle.getTitle())) {
                queryWrapper.like("t.title", cmsArticle.getTitle());
            }
            // 副标题
            if (Validator.isNotEmpty(cmsArticle.getSubtitle())) {
                queryWrapper.like("t.subtitle", cmsArticle.getSubtitle());
            }
            // 栏目id
            if (Validator.isNotEmpty(cmsArticle.getColumnId())) {
                queryWrapper.eq("t.column_id", cmsArticle.getColumnId());
            }
            // 信息来源
            if (Validator.isNotEmpty(cmsArticle.getSource())) {
                queryWrapper.like("t.source", cmsArticle.getSource());
            }
            // 作者
            if (Validator.isNotEmpty(cmsArticle.getAuthor())) {
                queryWrapper.like("t.author", cmsArticle.getAuthor());
            }
            // 发布时间 - 开始时间
            if (Validator.isNotEmpty(cmsArticle.getStartReleaseDate())) {
                queryWrapper.ge("t.release_date", cmsArticle.getStartReleaseDate());
            }
            // 发布时间 - 结束时间
            if (Validator.isNotEmpty(cmsArticle.getEndReleaseDate())) {
                queryWrapper.le("t.release_date", cmsArticle.getEndReleaseDate());
            }
            // 下线时间 - 开始时间
            if (Validator.isNotEmpty(cmsArticle.getStartOfflineDate())) {
                queryWrapper.ge("t.offline_date", cmsArticle.getStartOfflineDate());
            }
            // 下线时间 - 结束时间
            if (Validator.isNotEmpty(cmsArticle.getEndOfflineDate())) {
                queryWrapper.le("t.offline_date", cmsArticle.getEndOfflineDate());
            }
            // 状态
            if (Validator.isNotEmpty(cmsArticle.getStatus())) {
                if (cmsArticle.getStatus().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.status", cmsArticle.getStatus().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.status", cmsArticle.getStatus());
                }
            }
        }
        queryWrapper.eq("t.site_id", CmsSiteUtil.getUserActiveSiteId());
        return queryWrapper;
    }

    @Override
    public CmsArticle get(String id) {
        ToolUtil.checkParams(id);
        CmsArticle cmsArticle = baseMapper.getById(id);
        if (cmsArticle != null) {
            // 封面
            cmsArticle.setCover(fileInfoService.selectOne(id, CmsFileType.ARTICLE_COVER.getCode()));
        }
        return cmsArticle;
    }

    @Override
    public CmsArticle add() {
        CmsArticle cmsArticle = new CmsArticle();
        // 设置默认值
        cmsArticle.setStatus(CmsArticleStatus.DRAFT.getCode());
        cmsArticle.setAuthor(ShiroUtil.getCurrentUser().getNickname());
        return cmsArticle;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        ToolUtil.checkParams(ids);
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        boolean isSuccess = removeByIds(idList);
        if (isSuccess) {
            fileInfoService.delete(ids);
        }
        return isSuccess;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public CmsArticle saveData(CmsArticle cmsArticle) {
        if (Validator.isEmpty(cmsArticle.getId())) {
            // 新增,设置默认值
            cmsArticle.setSiteId(CmsSiteUtil.getUserActiveSiteId());
            // 状态
            cmsArticle.setStatus(CmsArticleStatus.DRAFT.getCode());
        }
        // 处理内容
        cmsArticle.setContent(EditorUtil.moveToFormal(cmsArticle.getContent()));
        // 手动发布
        cmsArticle.setReleaseType(CmsArticleReleaseType.MANUAL.getCode());
        boolean isSuccess = saveOrUpdate(cmsArticle);
        if (isSuccess) {
            // 处理封面
            handleCover(cmsArticle);
        }
        return cmsArticle;
    }

    /**
     * 保存文章封面
     *
     * @param cmsArticle 文章信息
     */
    private void handleCover(CmsArticle cmsArticle) {
        if (cmsArticle.getCover() != null && fileStorageFactory.getFileStorage().inTemporaryPath(cmsArticle.getCover().getObjectName())) {
            fileInfoService.delete(cmsArticle.getId(), CmsFileType.ARTICLE_COVER.getCode());
            fileInfoService.saveData(cmsArticle.getId(), CmsFileType.ARTICLE_COVER.getCode(), cmsArticle.getCover());
        }
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
            // todo: 发布站点
            // todo: 发布栏目
        }
        return isSuccess;
    }

    @Override
    public List<CmsArticle> selectArticleByColumnIds(String[] columnIds) {
        QueryWrapper<CmsArticle> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("t.status", CmsArticleStatus.PUBLISHED.getCode());
        queryWrapper.in("t.column_id", Arrays.asList(columnIds));
        return baseMapper.selectArticleByColumnIds(queryWrapper);
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