package com.easy.admin.cms.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.cms.common.constant.CmsRedisKeyPrefix;
import com.easy.admin.cms.dao.CmsColumnMapper;
import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.cms.service.CmsArticleService;
import com.easy.admin.cms.service.CmsColumnService;
import com.easy.admin.cms.utils.CmsSiteUtil;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.sys.common.constant.ImportConst;
import com.easy.admin.sys.common.constant.WhetherConst;
import com.easy.admin.sys.service.ImportService;
import com.easy.admin.util.ShiroUtil;
import com.easy.admin.util.ToolUtil;
import com.easy.admin.util.office.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 栏目
 *
 * @author 系统管理员
 * @date 2023-06-19
 */
@Service
public class CmsColumnServiceImpl extends ServiceImpl<CmsColumnMapper, CmsColumn> implements CmsColumnService, ImportService {

    @Autowired
    private CmsArticleService cmsArticleService;

    @Override
    public List<CmsColumn> select(CmsColumn cmsColumn) {
        if (StrUtil.isBlank(CmsSiteUtil.getUserActiveSiteId())) {
            return Collections.emptyList();
        }
        QueryWrapper<CmsColumn> queryWrapper = getQueryWrapper(cmsColumn);
        return baseMapper.select(queryWrapper);
    }

    @Override
    public List<Tree> selectAll() {
        return baseMapper.selectAll(CmsSiteUtil.getUserActiveSiteId(), CommonStatus.ENABLE.getCode());
    }

    @Override
    public long countBySiteId(String siteIds) {
        QueryWrapper<CmsColumn> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("site_id", siteIds.split(CommonConst.SPLIT));
        return count(queryWrapper);
    }

    private QueryWrapper<CmsColumn> getQueryWrapper(CmsColumn cmsColumn) {
        QueryWrapper<CmsColumn> queryWrapper = new QueryWrapper<>();
        if (cmsColumn != null) {
            // 查询条件
            // 名称
            if (Validator.isNotEmpty(cmsColumn.getName())) {
                queryWrapper.like("t.name", cmsColumn.getName());
            }
            // 别名
            if (Validator.isNotEmpty(cmsColumn.getSlug())) {
                queryWrapper.like("t.slug", cmsColumn.getSlug());
            }
            // 是否可以发布文章
            if (Validator.isNotEmpty(cmsColumn.getIsRelease())) {
                if (cmsColumn.getIsRelease().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.is_release", cmsColumn.getIsRelease().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.is_release", cmsColumn.getIsRelease());
                }
            }
            // 状态
            if (Validator.isNotEmpty(cmsColumn.getStatus())) {
                if (cmsColumn.getStatus().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.status", cmsColumn.getStatus().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.status", cmsColumn.getStatus());
                }
            }
        }
        queryWrapper.eq("t.site_id", CmsSiteUtil.getUserActiveSiteId());
        return queryWrapper;
    }

    @Override
    public CmsColumn get(String id) {
        return baseMapper.getById(id);
    }

    @Override
    public CmsColumn getCmsColumnUseCache(String siteId, String id) {
        CmsColumn cmsColumn = (CmsColumn) RedisUtil.get(CmsRedisKeyPrefix.COLUMN + siteId + ":" + id);
        if (cmsColumn == null) {
            cmsColumn = get(id);
            RedisUtil.set(CmsRedisKeyPrefix.COLUMN + cmsColumn.getSiteId() + ":" + cmsColumn.getId(), cmsColumn);
            RedisUtil.set(CmsRedisKeyPrefix.COLUMN + cmsColumn.getSiteId() + ":" + cmsColumn.getSlug(), cmsColumn);
        }
        return cmsColumn;
    }

    @Override
    public CmsColumn getBySlug(String siteId, String slug) {
        return baseMapper.selectBySlug(siteId, slug);
    }

    @Override
    public CmsColumn add(String parentId) {
        CmsColumn cmsColumn = new CmsColumn();
        // 设置默认值
        if (Validator.isNotEmpty(parentId)) {
            CmsColumn parentCmsColumn = getById(parentId);
            if (parentCmsColumn != null) {
                cmsColumn.setParentId(parentId);
                cmsColumn.setOrderNo(baseMapper.getMaxOrderNo(parentId) + 1);
            }
        }
        // 可以发布文章
        cmsColumn.setIsRelease(WhetherConst.YES);
        // 启用
        cmsColumn.setStatus(CommonStatus.ENABLE.getCode());
        return cmsColumn;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        // 检查是否有子栏目
        QueryWrapper<CmsColumn> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("parent_id", ids.split(CommonConst.SPLIT));
        long count = count(queryWrapper);
        if (count > 0) {
            throw new EasyException(GlobalException.EXIST_CHILD.getMessage());
        }
        // 检查是否有文章
        long articleCount = cmsArticleService.countByColumnId(ids);
        if (articleCount > 0) {
            throw new EasyException("删除的栏目下包含" + articleCount + "篇文章，请移除后重试");
        }

        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        // 查询需要移除的缓存信息
        QueryWrapper<CmsColumn> delQueryWrapper = new QueryWrapper<>();
        delQueryWrapper.select("id, slug, site_id").in("id", idList);
        List<CmsColumn> cmsColumnList = list(delQueryWrapper);

        boolean isSuccess = removeByIds(idList);
        if (isSuccess) {
            // 移除相关信息
            for (CmsColumn cmsColumn : cmsColumnList) {
                RedisUtil.del(CmsRedisKeyPrefix.COLUMN + cmsColumn.getSiteId() + ":" + cmsColumn.getId());
                RedisUtil.del(CmsRedisKeyPrefix.COLUMN + cmsColumn.getSiteId() + ":" + cmsColumn.getSlug());
            }
        }
        return isSuccess;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public CmsColumn saveData(CmsColumn cmsColumn) {
        ToolUtil.checkParams(cmsColumn);
        // 新增时设置排序值
        if (StrUtil.isBlank(cmsColumn.getId())) {
            cmsColumn.setSiteId(CmsSiteUtil.getUserActiveSiteId());
            if (cmsColumn.getOrderNo() == null) {
                cmsColumn.setOrderNo(baseMapper.getMaxOrderNo(cmsColumn.getParentId()) + 1);
            }
        }

        // 统一小写空格替换为 "-"
        cmsColumn.setSlug(cmsColumn.getSlug().toLowerCase().replaceAll(" ", "-"));
        // 检查别名是否重复
        checkSlug(cmsColumn);
        boolean isSuccess = saveOrUpdate(cmsColumn);
        if (isSuccess) {
            RedisUtil.del(CmsRedisKeyPrefix.COLUMN + cmsColumn.getSiteId() + ":" + cmsColumn.getId());
            RedisUtil.del(CmsRedisKeyPrefix.COLUMN + cmsColumn.getSiteId() + ":" + cmsColumn.getSlug());
            return cmsColumn;
        } else {
            throw new EasyException(GlobalException.LOCK_ERROR);
        }
    }

    /**
     * 检查别名是否重复
     *
     * @param cmsColumn 表单信息
     */
    private void checkSlug(CmsColumn cmsColumn) {
        QueryWrapper<CmsColumn> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("slug", cmsColumn.getSlug());
        if (Validator.isNotEmpty(cmsColumn.getId())) {
            queryWrapper.ne("id", cmsColumn.getId());
        }
        // 站点内栏目别名禁止重复
        queryWrapper.eq("site_id", cmsColumn.getSiteId());
        long count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new EasyException("栏目别名 " + cmsColumn.getSlug() + " 已存在");
        }
    }

    @Override
    public boolean saveOrder(List<CmsColumn> cmsColumnList) {
        return baseMapper.updateOrderBatch(cmsColumnList) > 0;
    }

    /**
     * 验证数据，插入临时表后调用
     * 注: 返回false会触发异常回滚
     *
     * @param templateId 模板id
     * @param userId     用户id
     * @return true/false
     */
    @Override
    public boolean verificationData(String templateId, String userId) {
        baseMapper.updateDuplicateData(templateId, ImportConst.VERIFICATION_STATUS_FAIL);
        return true;
    }

    /**
     * 导入前回调，插入正式表之前会调用此方法，建议导入正式表之前使用次方法再次验证数据，防止验证 ~ 导入之间数据发送变动
     * 注: 返回false会触发异常回滚
     *
     * @param templateId 模板id
     * @param userId     用户id
     * @return true/false
     */
    @Override
    public boolean beforeImport(String templateId, String userId) {
        return verificationData(templateId, userId);
    }

    /**
     * 导入后回调，插入正式表后会调用此方法
     * 注: 返回false会触发异常回滚
     *
     * @return true/false
     */
    @Override
    public boolean afterImport() {
        // 1.关联父栏目
        List<CmsColumn> cmsColumnList = baseMapper.selectNeedUpdateParentInfo();
        updateBatchById(cmsColumnList);
        // 2.设置创建时间等信息
        baseMapper.updateAfterImport(ShiroUtil.getCurrentUser().getId(), new Date());
        return true;
    }

    @Override
    public List<CmsColumn> selectCmsColumns(String[] ids) {
        return baseMapper.selectColumns(new QueryWrapper<CmsColumn>().in("t.id", ids));
    }

    @Override
    public String exportData(CmsColumn cmsColumn) {
        if (StrUtil.isBlank(cmsColumn.getSiteId())) {
            throw new EasyException("请选择站点后重试");
        }
        QueryWrapper<CmsColumn> queryWrapper = getQueryWrapper(cmsColumn);
        List<CmsColumn> list = baseMapper.exportData(queryWrapper);
        return ExcelUtil.writeAndGetDownloadId("栏目", "栏目", list, CmsColumn.class);
    }

}