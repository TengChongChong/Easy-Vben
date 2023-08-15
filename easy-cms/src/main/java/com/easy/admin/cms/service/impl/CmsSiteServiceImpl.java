package com.easy.admin.cms.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.cms.common.constant.CmsRedisKeyPrefix;
import com.easy.admin.cms.dao.CmsSiteMapper;
import com.easy.admin.cms.model.CmsSite;
import com.easy.admin.cms.service.CmsArticleService;
import com.easy.admin.cms.service.CmsColumnService;
import com.easy.admin.cms.service.CmsMediaService;
import com.easy.admin.cms.service.CmsSiteService;
import com.easy.admin.cms.utils.CmsSiteUtil;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.util.ToolUtil;
import com.easy.admin.util.office.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 站点
 *
 * @author 系统管理员
 * @date 2023-06-19
 */
@Service
public class CmsSiteServiceImpl extends ServiceImpl<CmsSiteMapper, CmsSite> implements CmsSiteService {

    @Autowired
    private CmsArticleService cmsArticleService;
    @Autowired
    private CmsColumnService cmsColumnService;
    @Autowired
    private CmsMediaService cmsMediaService;

    @Override
    public List<CmsSite> select(CmsSite cmsSite) {
        QueryWrapper<CmsSite> queryWrapper = getQueryWrapper(cmsSite);
        return baseMapper.select(queryWrapper);
    }

    @Override
    public List<Tree> selectAll() {
        return baseMapper.selectAll();
    }

    @Override
    public List<CmsSite> selectAllSite() {
        return baseMapper.selectAllSite(CommonStatus.ENABLE.getCode());
    }

    private QueryWrapper<CmsSite> getQueryWrapper(CmsSite cmsSite) {
        QueryWrapper<CmsSite> queryWrapper = new QueryWrapper<>();
        if (cmsSite != null) {
            // 查询条件
            // 名称
            if (Validator.isNotEmpty(cmsSite.getName())) {
                queryWrapper.like("t.name", cmsSite.getName());
            }
            // 关键字
            if (Validator.isNotEmpty(cmsSite.getKeyword())) {
                queryWrapper.like("t.keyword", cmsSite.getKeyword());
            }
            // 描述
            if (Validator.isNotEmpty(cmsSite.getDescription())) {
                queryWrapper.like("t.description", cmsSite.getDescription());
            }
            // 域名
            if (Validator.isNotEmpty(cmsSite.getDomainName())) {
                queryWrapper.like("t.domain_name", cmsSite.getDomainName());
            }
            // 部署路径
            if (Validator.isNotEmpty(cmsSite.getDeploymentPath())) {
                queryWrapper.like("t.deployment_path", cmsSite.getDeploymentPath());
            }
            // 主题名称
            if (Validator.isNotEmpty(cmsSite.getTheme())) {
                queryWrapper.like("t.theme", cmsSite.getTheme());
            }
            // 状态
            if (Validator.isNotEmpty(cmsSite.getStatus())) {
                if (cmsSite.getStatus().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.status", cmsSite.getStatus().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.status", cmsSite.getStatus());
                }
            }
        }
        return queryWrapper;
    }

    @Override
    public CmsSite get(String id) {
        return baseMapper.getById(id);
    }

    @Override
    public CmsSite getCmsSiteUseCache(String id) {
        CmsSite cmsSite = (CmsSite) RedisUtil.get(CmsRedisKeyPrefix.SITE + id);
        if (cmsSite == null) {
            cmsSite = get(id);
            RedisUtil.set(CmsRedisKeyPrefix.SITE + cmsSite.getId(), cmsSite);
        }
        return cmsSite;
    }

    @Override
    public CmsSite add(String parentId) {
        CmsSite cmsSite = new CmsSite();
        // 设置默认值
        if (Validator.isNotEmpty(parentId)) {
            CmsSite parentCmsSite = getById(parentId);
            if (parentCmsSite != null) {
                cmsSite.setParentId(parentId);
                cmsSite.setOrderNo(baseMapper.getMaxOrderNo(parentId) + 1);
            }
        }
        cmsSite.setStatus(CommonStatus.ENABLE.getCode());
        return cmsSite;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        // 检查是否有子站点
        QueryWrapper<CmsSite> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("parent_id", ids.split(CommonConst.SPLIT));
        long count = count(queryWrapper);
        if (count > 0) {
            throw new EasyException(GlobalException.EXIST_CHILD.getMessage());
        }
        // 检查是否有栏目、文章、媒体数据
        checkSiteData(ids);

        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        boolean isSuccess = removeByIds(idList);
        if (isSuccess) {
            for (String id : idList) {
                RedisUtil.del(CmsRedisKeyPrefix.SITE + id);
            }
        }
        return isSuccess;
    }

    /**
     * 检查站点是否有数据，如有数据不允许删除
     *
     * @param ids 站点ids
     */
    private void checkSiteData(String ids) {
        long columnCount = cmsColumnService.countBySiteId(ids);
        if (columnCount > 0) {
            throw new EasyException("删除的站点下包含" + columnCount + "个栏目，请移除后重试");
        }
        long articleCount = cmsArticleService.countBySiteId(ids);
        if (articleCount > 0) {
            throw new EasyException("删除的站点下包含" + articleCount + "篇文章，请移除后重试");
        }
        long mediaCount = cmsMediaService.countBySiteId(ids);
        if (mediaCount > 0) {
            throw new EasyException("删除的站点下包含" + mediaCount + "个资源，请移除后重试");
        }
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public CmsSite saveData(CmsSite cmsSite) {
        ToolUtil.checkParams(cmsSite);
        // 新增时设置排序值
        if (StrUtil.isBlank(cmsSite.getId()) && cmsSite.getOrderNo() == null) {
            cmsSite.setOrderNo(baseMapper.getMaxOrderNo(cmsSite.getParentId()) + 1);
        }
        boolean isSuccess = saveOrUpdate(cmsSite);
        if (isSuccess) {
            RedisUtil.del(CmsRedisKeyPrefix.SITE + cmsSite.getId());
            return cmsSite;
        } else {
            throw new EasyException(GlobalException.LOCK_ERROR);
        }
    }

    @Override
    public boolean setUserActiveSite(CmsSite cmsSite) {
        CmsSiteUtil.setUserActiveSite(cmsSite);
        return true;
    }

    @Override
    public CmsSite getUserActiveSite() {
        return CmsSiteUtil.getUserActiveSite();
    }

    @Override
    public boolean saveOrder(List<CmsSite> cmsSiteList) {
        return baseMapper.updateOrderBatch(cmsSiteList) > 0;
    }

    @Override
    public String exportData(CmsSite cmsSite) {
        QueryWrapper<CmsSite> queryWrapper = getQueryWrapper(cmsSite);
        List<CmsSite> list = baseMapper.exportData(queryWrapper);
        return ExcelUtil.writeAndGetDownloadId("站点", "站点", list, CmsSite.class);
    }
}