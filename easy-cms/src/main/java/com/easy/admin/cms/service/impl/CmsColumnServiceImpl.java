package com.easy.admin.cms.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.pinyin.PinyinUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.cms.common.constant.CmsRedisKeyPrefix;
import com.easy.admin.cms.dao.CmsColumnMapper;
import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.cms.service.CmsArticleService;
import com.easy.admin.cms.service.CmsColumnService;
import com.easy.admin.cms.service.CmsColumnUserService;
import com.easy.admin.cms.utils.CmsSiteUtil;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.common.tree.TreeUtil;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.util.SysConfigUtil;
import com.easy.admin.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 栏目
 *
 * @author TengChongChong
 * @date 2021-11-18
 */
@Service
public class CmsColumnServiceImpl extends ServiceImpl<CmsColumnMapper, CmsColumn> implements CmsColumnService {

    @Autowired
    private CmsColumnUserService cmsColumnUserService;

    @Autowired
    private CmsArticleService cmsArticleService;

    @Override
    public List<Tree> selectByPId(String pId) {
        List<Tree> trees;
        String siteId = CmsSiteUtil.getCurrentEditSiteId();
        // 第一次请求,返回项目名称 + 一级菜单 数据
        if (StrUtil.isBlank(pId)) {
            trees = new ArrayList<>();
            // 根节点
            Tree tree = TreeUtil.getBaseNode();
            List<Tree> treeList = baseMapper.selectByPId(siteId, TreeUtil.BASE_ID);
            if (treeList.size() > 0) {
                tree.setIsLeaf(false);
                trees.addAll(treeList);
            } else {
                tree.setIsLeaf(true);
            }
            trees.add(tree);
        } else {
            trees = baseMapper.selectByPId(siteId, pId);
        }
        return trees;
    }

    @Override
    public List<Tree> selectAll(boolean containBaseNode) {
        String siteId = CmsSiteUtil.getCurrentEditSiteId();
        List<Tree> trees = baseMapper.selectAll(siteId, CommonStatus.ENABLE.getCode());
        if(containBaseNode){
            // 根节点
            Tree tree = TreeUtil.getBaseNode();
            trees.add(tree);
        }
        trees.addAll(baseMapper.selectAll(siteId, TreeUtil.BASE_ID));
        return trees;
    }

    @Override
    public List<CmsColumn> selectCmsColumns(String[] ids) {
        return baseMapper.selectColumns(new QueryWrapper<CmsColumn>().in("t.id", ids));
    }

    @Override
    public CmsColumn get(String id) {
        CmsColumn cmsColumn;
        // 表示点击的是根目录
        if (id == null || id.equals(TreeUtil.BASE_ID)) {
            cmsColumn = new CmsColumn();
            cmsColumn.setId(TreeUtil.BASE_ID);
            cmsColumn.setName(SysConfigUtil.getProjectName());
        } else {
            cmsColumn = baseMapper.selectInfo(id);
            if (cmsColumn != null && cmsColumn.getpId().equals(TreeUtil.BASE_ID)) {
                cmsColumn.setParentName(SysConfigUtil.getProjectName());
            }
        }
        return cmsColumn;
    }

    @Override
    public CmsColumn getBySlug(String siteId, String slug) {
        return baseMapper.selectBySlug(siteId, slug);
    }

    @Override
    public CmsColumn add(String pId) {
        if (pId != null) {
            CmsColumn cmsColumn = new CmsColumn();
            cmsColumn.setpId(pId);
            cmsColumn.setStatus(CommonStatus.ENABLE.getCode());
            cmsColumn.setIsRelease(CommonStatus.ENABLE.getCode());
            if (TreeUtil.BASE_ID.equals(pId)) {
                cmsColumn.setParentName(SysConfigUtil.getProjectName());
            } else {
                CmsColumn parentCmsColumn = baseMapper.selectInfo(pId);
                if (parentCmsColumn != null) {
                    cmsColumn.setParentName(parentCmsColumn.getName());
                } else {
                    throw new EasyException("获取父节点信息失败，请重试");
                }
            }
            return cmsColumn;
        } else {
            throw new EasyException("获取父节点信息失败，请重试");
        }
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String id) {
        ToolUtil.checkParams(id);
        // 检查是否有子节点
        QueryWrapper<CmsColumn> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p_id", id);
        int count = count(queryWrapper);
        if (count > 0) {
            throw new EasyException(GlobalException.EXIST_CHILD.getMessage());
        }

        // 检查是否有文章
        count = cmsArticleService.selectCountByColumnId(id);
        if (count > 0) {
            throw new EasyException("当前分类下有" + count + "条文章，请删除后重试");
        }

        boolean isSuccess = removeById(id);
        if (isSuccess) {
            // 同时删除已分配的节点
            cmsColumnUserService.removeByColumnId(id);

            refreshCache(CmsSiteUtil.getCurrentEditSiteId());
        }

        return isSuccess;
    }

    @Override
    public boolean removeBySiteId(String siteId) {
        boolean isSuccess = baseMapper.deleteBySiteId(siteId) > 0;
        if (isSuccess) {
            refreshCache(CmsSiteUtil.getCurrentEditSiteId());
        }
        return isSuccess;
    }

    @Override
    public boolean setStatus(String ids, String status) {
        ToolUtil.checkParams(ids);
        ToolUtil.checkParams(status);
        List<CmsColumn> cmsColumnList = new ArrayList<>();
        CmsColumn cmsColumn;
        for (String id : ids.split(CommonConst.SPLIT)) {
            cmsColumn = new CmsColumn();
            cmsColumn.setId(id);
            cmsColumn.setStatus(status);
            cmsColumnList.add(cmsColumn);
        }
        boolean isSuccess = updateBatchById(cmsColumnList);
        if (isSuccess) {
            refreshCache(CmsSiteUtil.getCurrentEditSiteId());
        }
        return isSuccess;
    }

    @Override
    public List<CmsColumn> copyNode(String nodeIds, String targetId) {
        ToolUtil.checkParams(nodeIds);
        ToolUtil.checkParams(targetId);
        // 查询复制的节点
        List<CmsColumn> copyColumn = baseMapper.selectBatchIds(Arrays.asList(nodeIds.split(CommonConst.SPLIT)));
        if (copyColumn != null && !copyColumn.isEmpty()) {
            String siteId = CmsSiteUtil.getCurrentEditSiteId();
            CmsColumn parentColumn = getById(targetId);
            // 目标节点存在
            if (parentColumn != null) {
                int maxOrderNo = baseMapper.getMaxOrderNo(siteId, targetId);
                List<CmsColumn> cmsColumnList = new ArrayList<>();
                CmsColumn cmsColumn;
                int index = 0;
                for (CmsColumn column : copyColumn) {
                    try {
                        cmsColumn = column.clone();
                        cmsColumn.setId(null);
                        maxOrderNo++;
                        cmsColumn.setpId(parentColumn.getId());
                        cmsColumn.setOrderNo(maxOrderNo);
                        cmsColumn.setSlug("copy-" + cmsColumn.getSlug() + "-" + System.currentTimeMillis() + index);
                        cmsColumnList.add(cmsColumn);
                        index++;
                    } catch (CloneNotSupportedException e) {
                        throw new EasyException("拷贝对象失败");
                    }
                }
                boolean isSuccess = saveBatch(cmsColumnList);
                if (isSuccess) {
                    refreshCache(CmsSiteUtil.getCurrentEditSiteId());
                }
                return cmsColumnList;
            }
        }
        return CollectionUtil.empty(CmsColumn.class);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public CmsColumn saveData(CmsColumn object) {
        ToolUtil.checkParams(object);
        String siteId = CmsSiteUtil.getCurrentEditSiteId();
        if (StrUtil.isBlank(object.getId()) && object.getOrderNo() == null) {
            object.setOrderNo(baseMapper.getMaxOrderNo(siteId, object.getpId()) + 1);
        }
        if (StrUtil.isBlank(object.getSiteId())) {
            object.setSiteId(CmsSiteUtil.getCurrentEditSiteId());
        }
        if (StrUtil.isBlank(object.getSlug())) {
            object.setSlug(PinyinUtil.getPinyin(object.getName()));
        }
        // 统一小写空格替换为 "-"
        object.setSlug(object.getSlug().toLowerCase().replaceAll(" ", "-"));
        // 检查别名是否重复
        checkSlug(object);

        boolean isSuccess = saveOrUpdate(object);
        if (isSuccess) {
            refreshCache(CmsSiteUtil.getCurrentEditSiteId());
        }
        return object;
    }

    /**
     * 检查别名是否重复
     *
     * @param object 表单信息
     */
    private void checkSlug(CmsColumn object) {
        QueryWrapper<CmsColumn> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("slug", object.getSlug());
        if (Validator.isNotEmpty(object.getId())) {
            queryWrapper.ne("id", object.getId());
        }
        // 站点内栏目别名禁止重复
        queryWrapper.eq("site_id", object.getSiteId());
        int count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new EasyException("栏目别名 " + object.getSlug() + " 已存在");
        }
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean move(String id, String parent, String oldParent, Integer position, Integer oldPosition) {
        if (Validator.isNotEmpty(id) && Validator.isNotEmpty(parent) && Validator.isNotEmpty(oldParent) &&
                Validator.isNotEmpty(position) && Validator.isNotEmpty(oldPosition)) {
            boolean isSuccess;
            String siteId = CmsSiteUtil.getCurrentEditSiteId();
            // 没有改变所属节点,内部排序
            if (parent.equals(oldParent)) {
                // 拖动影响节点顺序的开始序号
                int str = Math.min(position, oldPosition);
                // 拖动影响顺序节点数量
                int length = Math.abs(position - oldPosition) + 1;
                List<CmsColumn> oldCmsColumn = baseMapper.selectOrderInfo(siteId, parent, str, length);
                List<CmsColumn> newCmsColumn = new ArrayList<>();
                // 是否需要偏移
                boolean needDeviation = false;
                // 偏移量
                int deviation;
                if (position > oldPosition) {
                    deviation = -1;
                } else {
                    deviation = 1;
                }
                for (int i = 0; i < oldCmsColumn.size(); i++) {
                    if ((i + str) == position) {
                        newCmsColumn.add(new CmsColumn(id, oldCmsColumn.get(i).getOrderNo()));
                        newCmsColumn.add(new CmsColumn(oldCmsColumn.get(i).getId(), oldCmsColumn.get(i + deviation).getOrderNo()));
                        needDeviation = true;
                    } else {
                        if ((i + str) == oldPosition) {
                            needDeviation = true;
                        }
                        if (!id.equals(oldCmsColumn.get(i).getId())) {
                            newCmsColumn.add(new CmsColumn(oldCmsColumn.get(i).getId(), oldCmsColumn.get(i + (needDeviation ? deviation : 0)).getOrderNo()));
                        }
                    }
                }
                isSuccess = updateBatchById(newCmsColumn);
            } else {
                List<CmsColumn> oldCmsColumn = baseMapper.selectOrderInfo(siteId, parent, null, null);
                List<CmsColumn> newCmsColumn = new ArrayList<>();
                // 是否需要偏移
                boolean needDeviation = false;
                // 偏移量
                int deviation = 1;
                // 放到了最后一个
                if (position == oldCmsColumn.size()) {
                    if (oldCmsColumn.isEmpty()) {
                        newCmsColumn.add(new CmsColumn(id, parent, 1));
                    } else {
                        newCmsColumn.add(new CmsColumn(id, parent, oldCmsColumn.get(oldCmsColumn.size() - 1).getOrderNo() + 1));
                    }
                } else {
                    for (int i = 0; i < oldCmsColumn.size(); i++) {
                        if (i == position) {
                            newCmsColumn.add(new CmsColumn(id, parent, oldCmsColumn.get(i).getOrderNo()));
                            newCmsColumn.add(new CmsColumn(oldCmsColumn.get(i).getId(), oldCmsColumn.get(i).getOrderNo() + 1));
                            needDeviation = true;
                        } else {
                            newCmsColumn.add(new CmsColumn(oldCmsColumn.get(i).getId(), oldCmsColumn.get(i).getOrderNo() + (needDeviation ? deviation : 0)));
                        }
                    }
                }
                isSuccess = updateBatchById(newCmsColumn);
            }
            if (isSuccess) {
                refreshCache(CmsSiteUtil.getCurrentEditSiteId());
            }
            return isSuccess;
        } else {
            throw new EasyException(GlobalException.FAILED_TO_GET_DATA.getMessage());
        }
    }

    @Override
    public List<Tree> selectByTitle(String title) {
        if (Validator.isNotEmpty(title)) {
            String siteId = CmsSiteUtil.getCurrentEditSiteId();
            return baseMapper.selectByTitle(siteId, "%" + title + "%");
        } else {
            throw new EasyException("请输入关键字后重试");
        }
    }

    @Override
    public boolean checkMenuIsHaving(String name) {
        if (StrUtil.isNotBlank(name)) {
            QueryWrapper<CmsColumn> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", name);
            int count = baseMapper.selectCount(queryWrapper);
            return count > 0;
        } else {
            throw new EasyException("[checkMenuIsHaving(String name)]站点名称不能为空");
        }
    }

    @Override
    public boolean refreshCache(String siteId) {
        // 清除之前的
        String keyPrefix = CmsRedisKeyPrefix.COLUMN;
        if(StrUtil.isNotBlank(siteId)){
            keyPrefix = keyPrefix + siteId + ":";
        }
        RedisUtil.delByPrefix(keyPrefix);

        List<CmsColumn> columnList = baseMapper.selectAllColumn(siteId, CommonStatus.ENABLE.getCode());
        if (columnList != null && columnList.size() > 0) {
            for (CmsColumn cmsColumn : columnList) {
                RedisUtil.set(CmsRedisKeyPrefix.COLUMN + cmsColumn.getSiteId() + ":" + cmsColumn.getId(), cmsColumn, 0);
                RedisUtil.set(CmsRedisKeyPrefix.COLUMN + cmsColumn.getSiteId() + ":" + cmsColumn.getSlug(), cmsColumn, 0);
            }
        }
        return true;
    }
}