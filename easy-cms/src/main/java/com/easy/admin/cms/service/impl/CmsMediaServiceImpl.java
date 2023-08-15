package com.easy.admin.cms.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.cms.common.type.CmsFileType;
import com.easy.admin.cms.dao.CmsMediaMapper;
import com.easy.admin.cms.model.CmsMedia;
import com.easy.admin.cms.service.CmsMediaService;
import com.easy.admin.cms.utils.CmsSiteUtil;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.sys.service.SysFileService;
import com.easy.admin.util.ToolUtil;
import com.easy.admin.util.file.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 资源
 *
 * @author 系统管理员
 * @date 2023-06-21
 */
@Service
public class CmsMediaServiceImpl extends ServiceImpl<CmsMediaMapper, CmsMedia> implements CmsMediaService {

    @Autowired
    private SysFileService sysFileService;

    @Override
    public Page<CmsMedia> select(CmsMedia cmsMedia, Page<CmsMedia> page) {
        if (StrUtil.isBlank(CmsSiteUtil.getUserActiveSiteId())) {
            return page;
        }
        QueryWrapper<CmsMedia> queryWrapper = getQueryWrapper(cmsMedia);
        page.setDefaultDesc("t.create_date");
        List<CmsMedia> cmsMediaList = baseMapper.select(page, queryWrapper);
        for (CmsMedia media : cmsMediaList) {
            if (StrUtil.isNotBlank(media.getFileUrl())) {
                media.setFileUrl(FileUtil.getUrl(media.getFileUrl()));
            }
        }
        page.setRecords(cmsMediaList);
        return page;
    }

    private QueryWrapper<CmsMedia> getQueryWrapper(CmsMedia cmsMedia) {
        QueryWrapper<CmsMedia> queryWrapper = new QueryWrapper<>();
        if (cmsMedia != null) {
            // 查询条件
            // 名称
            if (Validator.isNotEmpty(cmsMedia.getName())) {
                queryWrapper.like("t.name", cmsMedia.getName());
            }
            // 类型
            if (Validator.isNotEmpty(cmsMedia.getType())) {
                if (cmsMedia.getType().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.type", cmsMedia.getType().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.type", cmsMedia.getType());
                }
            }
        }
        queryWrapper.eq("t.site_id", CmsSiteUtil.getUserActiveSiteId());
        return queryWrapper;
    }

    @Override
    public long countBySiteId(String siteIds) {
        QueryWrapper<CmsMedia> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("site_id", siteIds.split(CommonConst.SPLIT));
        return count(queryWrapper);
    }

    @Override
    public CmsMedia get(String id) {
        ToolUtil.checkParams(id);
        CmsMedia cmsMedia = baseMapper.getById(id);
        if (cmsMedia != null) {
            cmsMedia.setFile(sysFileService.selectOne(id, CmsFileType.MEDIA_FILE.getCode()));
        }
        return cmsMedia;
    }

    @Override
    public CmsMedia add() {
        CmsMedia cmsMedia = new CmsMedia();
        // 设置默认值
        return cmsMedia;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        ToolUtil.checkParams(ids);
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        boolean isSuccess = removeByIds(idList);
        if (isSuccess) {
            sysFileService.delete(ids);
        }
        return isSuccess;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public CmsMedia saveData(CmsMedia cmsMedia) {
        ToolUtil.checkParams(cmsMedia);
        if (Validator.isEmpty(cmsMedia.getId())) {
            // 新增,设置默认值
            cmsMedia.setSiteId(CmsSiteUtil.getUserActiveSiteId());
        }
        boolean isSuccess = saveOrUpdate(cmsMedia);
        if (isSuccess) {
            // 处理封面
            handleFile(cmsMedia);
        }
        return cmsMedia;
    }

    /**
     * 保存资源库文件
     *
     * @param cmsMedia 资源库信息
     */
    private void handleFile(CmsMedia cmsMedia) {
        if (cmsMedia.getFile() != null && StrUtil.isNotBlank(cmsMedia.getFile().getUrl()) && FileUtil.inTemporaryPath(cmsMedia.getFile().getUrl())) {
            sysFileService.delete(cmsMedia.getId(), CmsFileType.MEDIA_FILE.getCode());
            cmsMedia.getFile().setPath(FileUtil.getPath(cmsMedia.getFile().getUrl()));
            cmsMedia.getFile().setParentId(cmsMedia.getId());
            cmsMedia.getFile().setType(CmsFileType.MEDIA_FILE.getCode());
            sysFileService.saveData(cmsMedia.getFile());
        }
    }
}