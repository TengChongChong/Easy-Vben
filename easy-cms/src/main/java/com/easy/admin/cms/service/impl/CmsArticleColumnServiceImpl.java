package com.easy.admin.cms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.cms.dao.CmsArticleColumnMapper;
import com.easy.admin.cms.model.CmsArticleColumn;
import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.cms.service.CmsArticleColumnService;
import com.easy.admin.cms.utils.CmsColumnUtil;
import com.easy.admin.common.core.constant.CommonConst;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章栏目
 *
 * @author TengChongChong
 * @date 2021-11-19
 */
@Service
public class CmsArticleColumnServiceImpl extends ServiceImpl<CmsArticleColumnMapper, CmsArticleColumn> implements CmsArticleColumnService {
    @Override
    public List<String> selectColumnsByArticleId(String articleId) {
        return baseMapper.selectColumnsByArticleId(articleId);
    }

    @Override
    public int selectCountByColumnId(String columnId) {
        return baseMapper.selectCountByColumnId(columnId);
    }

    @Override
    public boolean saveData(String articleId, String[] columnArray) {
        List<CmsArticleColumn> cmsArticleColumnList = new ArrayList<>();
        for (String columnId : columnArray) {
            cmsArticleColumnList.add(new CmsArticleColumn(articleId, columnId));
        }
        return saveBatch(cmsArticleColumnList);
    }

    @Override
    public boolean saveData(String articleId, String columns) {
        if (StrUtil.isBlank(columns)) {
            return false;
        }
        return saveData(articleId, columns.split(CommonConst.SPLIT));
    }

    @Override
    public boolean remove(String articleId) {
        return baseMapper.deleteByArticleId(articleId) > 0;
    }

    @Override
    public boolean removeBySiteId(String siteId) {
        return baseMapper.deleteBySiteId(siteId) > 0;
    }
    @Override
    public CmsColumn getCmsColumnByArticleId(String siteId, String articleId) {
        String columnId = baseMapper.getCmsColumnIdByArticleId(articleId);
        return CmsColumnUtil.getById(siteId, columnId);
    }

    @Override
    public List<CmsColumn> selectColumnByArticleId(String articleIds) {
        return baseMapper.selectColumnByArticleId(new QueryWrapper<CmsArticleColumn>().in("cac.article_id", articleIds.split(CommonConst.SPLIT)));
    }
}