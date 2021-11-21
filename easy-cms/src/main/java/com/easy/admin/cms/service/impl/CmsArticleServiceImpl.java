package com.easy.admin.cms.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.cms.common.status.CmsArticleStatus;
import com.easy.admin.cms.common.type.CmsArticleReleaseType;
import com.easy.admin.cms.common.type.CmsFileType;
import com.easy.admin.cms.dao.CmsArticleMapper;
import com.easy.admin.cms.model.CmsArticle;
import com.easy.admin.cms.service.CmsArticleColumnService;
import com.easy.admin.cms.service.CmsArticleService;
import com.easy.admin.cms.utils.CmsSiteUtils;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.sys.model.SysFile;
import com.easy.admin.sys.model.SysUser;
import com.easy.admin.sys.service.SysFileService;
import com.easy.admin.util.ShiroUtil;
import com.easy.admin.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
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
    private CmsArticleColumnService cmsArticleColumnService;

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
        if (object != null) {
            // 查询条件
            // 站点id
            if (Validator.isNotEmpty(object.getSiteId())) {
                queryWrapper.eq("t.site_id", object.getSiteId());
            }
            // 标题
            if (Validator.isNotEmpty(object.getTitle())) {
                queryWrapper.eq("t.title", object.getTitle());
            }
            // 信息来源
            if (Validator.isNotEmpty(object.getSource())) {
                queryWrapper.eq("t.source", object.getSource());
            }
            // 作者
            if (Validator.isNotEmpty(object.getAuthor())) {
                queryWrapper.eq("t.author", object.getAuthor());
            }
            // 状态
            if (Validator.isNotEmpty(object.getStatus())) {
                queryWrapper.eq("t.status", object.getStatus());
            }
        }
        page.setRecords(getBaseMapper().select(page, queryWrapper));
        return page;
    }

    /**
     * 详情
     *
     * @param id id
     * @return CmsArticle
     */
    @Override
    public CmsArticle input(String id) {
        ToolUtil.checkParams(id);
        CmsArticle cmsArticle = getBaseMapper().getById(id);
        if (cmsArticle != null) {
            // 设置封面
            List<SysFile> coverFiles = sysFileService.select(cmsArticle.getId(), CmsFileType.ARTICLE_COVER.getCode());
            if (coverFiles != null && coverFiles.size() > 0) {
                cmsArticle.setCover(coverFiles.get(0));
            }
            // 设置栏目
            List<String> columns = cmsArticleColumnService.selectColumnsByArticleId(cmsArticle.getId());
            if(columns != null && columns.size() > 0){
                cmsArticle.setColumns(CollUtil.join(columns, CommonConst.SPLIT));
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
    public CmsArticle add() {
        SysUser currentUser = ShiroUtil.getCurrentUser();
        CmsArticle object = new CmsArticle();
        object.setAuthor(currentUser.getNickname());
        object.setReleaseType(CmsArticleReleaseType.MANUAL.getCode());
        object.setStatus(CmsArticleStatus.DRAFT.getCode());

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
        return removeByIds(idList);
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
            object.setSiteId(CmsSiteUtils.getCurrentEditSiteId());
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
                sysFileService.saveData(object.getId(), CmsFileType.ARTICLE_COVER.getCode(), object.getCover().getPath());
            }

            // 处理栏目
            // todo: 栏目文章排序
            cmsArticleColumnService.remove(object.getId());
            cmsArticleColumnService.saveData(object.getId(), object.getColumns());
        }

        return object;
    }

}