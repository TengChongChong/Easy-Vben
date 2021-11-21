package com.easy.admin.cms.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.pinyin.PinyinUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.cms.dao.CmsColumnMapper;
import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.cms.service.CmsColumnService;
import com.easy.admin.cms.utils.CmsSiteUtils;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.common.tree.TreeUtil;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.util.SysConfigUtil;
import com.easy.admin.util.ToolUtil;
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

    @Override
    public List<Tree> selectByPId(String pId) {
        List<Tree> trees;
        String siteId = CmsSiteUtils.getCurrentEditSiteId();
        // 第一次请求,返回项目名称 + 一级菜单 数据
        if (StrUtil.isBlank(pId)) {
            trees = new ArrayList<>();
            // 根节点
            Tree tree = TreeUtil.getBaseNode();
            List<Tree> treeList = getBaseMapper().selectByPId(siteId, TreeUtil.BASE_ID);
            if (treeList.size() > 0) {
                tree.setIsLeaf(false);
                trees.addAll(treeList);
            } else {
                tree.setIsLeaf(true);
            }
            trees.add(tree);
        } else {
            trees = getBaseMapper().selectByPId(siteId, pId);
        }
        return trees;
    }

    @Override
    public List<Tree> selectAll() {
        String siteId = CmsSiteUtils.getCurrentEditSiteId();
        List<Tree> trees = getBaseMapper().selectAll(siteId, CommonStatus.ENABLE.getCode());
        // 根节点
        Tree tree = TreeUtil.getBaseNode();
        trees.add(tree);
        trees.addAll(getBaseMapper().selectAll(siteId, TreeUtil.BASE_ID));
        return trees;
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
            cmsColumn = getBaseMapper().selectInfo(id);
            if (cmsColumn != null && cmsColumn.getpId().equals(TreeUtil.BASE_ID)) {
                cmsColumn.setParentName(SysConfigUtil.getProjectName());
            }
        }
        return cmsColumn;
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
                CmsColumn parentCmsColumn = getBaseMapper().selectInfo(pId);
                if (parentCmsColumn != null) {
                    cmsColumn.setParentName(parentCmsColumn.getName());
                } else {
                    throw new EasyException("获取父权限信息失败，请重试");
                }
            }
            return cmsColumn;
        } else {
            throw new EasyException("获取父权限信息失败，请重试");
        }
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String id) {
        ToolUtil.checkParams(id);
        // 检查是否有子权限
        QueryWrapper<CmsColumn> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p_id", id);
        int count = count(queryWrapper);
        if (count > 0) {
            throw new EasyException(GlobalException.EXIST_CHILD.getMessage());
        }
        boolean isSuccess = removeById(id);
        if (isSuccess) {
            // todo:同时删除已分配的权限

        }

        return isSuccess;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean batchRemove(String ids) {
        ToolUtil.checkParams(ids);
        // 检查是否有子权限
        QueryWrapper<CmsColumn> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("p_id", ids.split(CommonConst.SPLIT));
        int count = count(queryWrapper);
        if (count > 0) {
            throw new EasyException(GlobalException.EXIST_CHILD.getMessage());
        }
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        boolean isSuccess = removeByIds(idList);
        if (isSuccess) {
            // todo:同时删除已分配的权限
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
        return ToolUtil.checkResult(updateBatchById(cmsColumnList));
    }

    @Override
    public List<CmsColumn> copyNode(String nodeIds, String targetId) {
        ToolUtil.checkParams(nodeIds);
        ToolUtil.checkParams(targetId);
        // 查询复制的节点
        List<CmsColumn> copyColumn = getBaseMapper().selectBatchIds(Arrays.asList(nodeIds.split(CommonConst.SPLIT)));
        if (copyColumn != null && !copyColumn.isEmpty()) {
            String siteId = CmsSiteUtils.getCurrentEditSiteId();
            CmsColumn parentColumn = getById(targetId);
            // 目标节点存在
            if (parentColumn != null) {
                int maxOrderNo = getBaseMapper().getMaxOrderNo(siteId, targetId);
                List<CmsColumn> cmsColumnList = new ArrayList<>();
                CmsColumn cmsColumn;
                for (CmsColumn column : copyColumn) {
                    try {
                        cmsColumn = column.clone();
                        cmsColumn.setId(null);
                        maxOrderNo++;
                        cmsColumn.setpId(parentColumn.getId());
                        cmsColumn.setOrderNo(maxOrderNo);
                        cmsColumnList.add(cmsColumn);
                    } catch (CloneNotSupportedException e) {
                        throw new EasyException("拷贝对象失败");
                    }
                }
                saveBatch(cmsColumnList);
                return cmsColumnList;
            }
        }
        return CollectionUtil.empty(CmsColumn.class);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public CmsColumn saveData(CmsColumn object) {
        ToolUtil.checkParams(object);
        String siteId = CmsSiteUtils.getCurrentEditSiteId();
        if (StrUtil.isBlank(object.getId()) && object.getOrderNo() == null) {
            object.setOrderNo(getBaseMapper().getMaxOrderNo(siteId, object.getpId()) + 1);
        }
        if(StrUtil.isBlank(object.getSiteId())){
            object.setSiteId(CmsSiteUtils.getCurrentEditSiteId());
        }
        if(StrUtil.isBlank(object.getSlug())){
            object.setSlug(PinyinUtil.getPinyin(object.getName()).replaceAll(" ", "-"));
        }

        return (CmsColumn) ToolUtil.checkResult(saveOrUpdate(object), object);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean move(String id, String parent, String oldParent, Integer position, Integer oldPosition) {
        if (Validator.isNotEmpty(id) && Validator.isNotEmpty(parent) && Validator.isNotEmpty(oldParent) &&
                Validator.isNotEmpty(position) && Validator.isNotEmpty(oldPosition)) {
            boolean isSuccess;
            String siteId = CmsSiteUtils.getCurrentEditSiteId();
            // 没有改变所属节点,内部排序
            if (parent.equals(oldParent)) {
                // 拖动影响节点顺序的开始序号
                int str = Math.min(position, oldPosition);
                // 拖动影响顺序节点数量
                int length = Math.abs(position - oldPosition) + 1;
                List<CmsColumn> oldCmsColumn = getBaseMapper().selectOrderInfo(siteId, parent, str, length);
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
                List<CmsColumn> oldCmsColumn = getBaseMapper().selectOrderInfo(siteId, parent, null, null);
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
            return isSuccess;
        } else {
            throw new EasyException(GlobalException.FAILED_TO_GET_DATA.getMessage());
        }
    }

    @Override
    public List<Tree> selectByTitle(String title) {
        if (Validator.isNotEmpty(title)) {
            String siteId = CmsSiteUtils.getCurrentEditSiteId();
            return getBaseMapper().selectByTitle(siteId, "%" + title + "%");
        } else {
            throw new EasyException("请输入关键字后重试");
        }
    }

    @Override
    public boolean checkMenuIsHaving(String name) {
        if (StrUtil.isNotBlank(name)) {
            QueryWrapper<CmsColumn> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", name);
            int count = getBaseMapper().selectCount(queryWrapper);
            return count > 0;
        } else {
            throw new EasyException("[checkMenuIsHaving(String name)]站点名称不能为空");
        }
    }


}