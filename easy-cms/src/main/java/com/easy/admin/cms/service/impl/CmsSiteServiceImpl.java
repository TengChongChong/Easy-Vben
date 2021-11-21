package com.easy.admin.cms.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.cms.dao.CmsSiteMapper;
import com.easy.admin.cms.model.CmsSite;
import com.easy.admin.cms.service.CmsSiteService;
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
 * 站点
 *
 * @author TengChongChong
 * @date 2021-11-18
 */
@Service
public class CmsSiteServiceImpl extends ServiceImpl<CmsSiteMapper, CmsSite> implements CmsSiteService {
//    @Autowired
//    private SysRoleSiteService sysRoleSiteService;

    @Override
    public List<Tree> selectByPId(String pId) {
        List<Tree> trees;
        // 第一次请求,返回项目名称 + 一级菜单 数据
        if (StrUtil.isBlank(pId)) {
            trees = new ArrayList<>();
            // 根节点
            Tree tree = TreeUtil.getBaseNode();
            List<Tree> treeList = getBaseMapper().selectByPId(TreeUtil.BASE_ID);
            if (treeList.size() > 0) {
                tree.setIsLeaf(false);
                trees.addAll(treeList);
            } else {
                tree.setIsLeaf(true);
            }
            trees.add(tree);
        } else {
            trees = getBaseMapper().selectByPId(pId);
        }
        return trees;
    }

    @Override
    public List<Tree> selectAll() {
        List<Tree> trees = getBaseMapper().selectAll(CommonStatus.ENABLE.getCode());
        // 根节点
        Tree tree = TreeUtil.getBaseNode();
        trees.add(tree);
        trees.addAll(getBaseMapper().selectAll(TreeUtil.BASE_ID));
        return trees;
    }

    @Override
    public CmsSite get(String id) {
        CmsSite cmsSite;
        // 表示点击的是根目录
        if (id == null || id.equals(TreeUtil.BASE_ID)) {
            cmsSite = new CmsSite();
            cmsSite.setId(TreeUtil.BASE_ID);
            cmsSite.setName(SysConfigUtil.getProjectName());
        } else {
            cmsSite = getBaseMapper().selectInfo(id);
            if (cmsSite != null && cmsSite.getpId().equals(TreeUtil.BASE_ID)) {
                cmsSite.setParentName(SysConfigUtil.getProjectName());
            }
        }
        return cmsSite;
    }

    @Override
    public CmsSite add(String pId) {
        if (pId != null) {
            CmsSite cmsSite = new CmsSite();
            cmsSite.setpId(pId);
            cmsSite.setStatus(CommonStatus.ENABLE.getCode());
            if (TreeUtil.BASE_ID.equals(pId)) {
                cmsSite.setParentName(SysConfigUtil.getProjectName());
            } else {
                CmsSite parentCmsSite = getBaseMapper().selectInfo(pId);
                if (parentCmsSite != null) {
                    cmsSite.setParentName(parentCmsSite.getName());
                } else {
                    throw new EasyException("获取父权限信息失败，请重试");
                }
            }
            return cmsSite;
        } else {
            throw new EasyException("获取父权限信息失败，请重试");
        }
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String id) {
        ToolUtil.checkParams(id);
        // 检查是否有子权限
        QueryWrapper<CmsSite> queryWrapper = new QueryWrapper<>();
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
        QueryWrapper<CmsSite> queryWrapper = new QueryWrapper<>();
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
        List<CmsSite> cmsSiteList = new ArrayList<>();
        CmsSite cmsSite;
        for (String id : ids.split(CommonConst.SPLIT)) {
            cmsSite = new CmsSite();
            cmsSite.setId(id);
            cmsSite.setStatus(status);
            cmsSiteList.add(cmsSite);
        }
        return ToolUtil.checkResult(updateBatchById(cmsSiteList));
    }

    @Override
    public List<CmsSite> copyNode(String nodeIds, String targetId) {
        ToolUtil.checkParams(nodeIds);
        ToolUtil.checkParams(targetId);
        // 查询复制的节点
        List<CmsSite> copySite = getBaseMapper().selectBatchIds(Arrays.asList(nodeIds.split(CommonConst.SPLIT)));
        if (copySite != null && !copySite.isEmpty()) {
            CmsSite parentSite = getById(targetId);
            // 目标节点存在
            if (parentSite != null) {
                int maxOrderNo = getBaseMapper().getMaxOrderNo(targetId);
                List<CmsSite> cmsSiteList = new ArrayList<>();
                CmsSite cmsSite;
                for (CmsSite site : copySite) {
                    try {
                        maxOrderNo++;
                        cmsSite = site.clone();
                        cmsSite.setpId(parentSite.getId());
                        cmsSite.setOrderNo(maxOrderNo);
                        cmsSiteList.add(cmsSite);
                    } catch (CloneNotSupportedException e) {
                        throw new EasyException("拷贝对象失败");
                    }
                }
                saveBatch(cmsSiteList);
                return cmsSiteList;
            }
        }
        return CollectionUtil.empty(CmsSite.class);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public CmsSite saveData(CmsSite object) {
        ToolUtil.checkParams(object);

        if (StrUtil.isBlank(object.getId()) && object.getOrderNo() == null) {
            object.setOrderNo(getBaseMapper().getMaxOrderNo(object.getpId()) + 1);
        }

        return (CmsSite) ToolUtil.checkResult(saveOrUpdate(object), object);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean move(String id, String parent, String oldParent, Integer position, Integer oldPosition) {
        if (Validator.isNotEmpty(id) && Validator.isNotEmpty(parent) && Validator.isNotEmpty(oldParent) &&
                Validator.isNotEmpty(position) && Validator.isNotEmpty(oldPosition)) {
            boolean isSuccess;
            // 没有改变所属节点,内部排序
            if (parent.equals(oldParent)) {
                // 拖动影响节点顺序的开始序号
                int str = Math.min(position, oldPosition);
                // 拖动影响顺序节点数量
                int length = Math.abs(position - oldPosition) + 1;
                List<CmsSite> oldCmsSite = getBaseMapper().selectOrderInfo(parent, str, length);
                List<CmsSite> newCmsSite = new ArrayList<>();
                // 是否需要偏移
                boolean needDeviation = false;
                // 偏移量
                int deviation;
                if (position > oldPosition) {
                    deviation = -1;
                } else {
                    deviation = 1;
                }
                for (int i = 0; i < oldCmsSite.size(); i++) {
                    if ((i + str) == position) {
                        newCmsSite.add(new CmsSite(id, oldCmsSite.get(i).getOrderNo()));
                        newCmsSite.add(new CmsSite(oldCmsSite.get(i).getId(), oldCmsSite.get(i + deviation).getOrderNo()));
                        needDeviation = true;
                    } else {
                        if ((i + str) == oldPosition) {
                            needDeviation = true;
                        }
                        if (!id.equals(oldCmsSite.get(i).getId())) {
                            newCmsSite.add(new CmsSite(oldCmsSite.get(i).getId(), oldCmsSite.get(i + (needDeviation ? deviation : 0)).getOrderNo()));
                        }
                    }
                }
                isSuccess = updateBatchById(newCmsSite);
            } else {
                List<CmsSite> oldCmsSite = getBaseMapper().selectOrderInfo(parent, null, null);
                List<CmsSite> newCmsSite = new ArrayList<>();
                // 是否需要偏移
                boolean needDeviation = false;
                // 偏移量
                int deviation = 1;
                // 放到了最后一个
                if (position == oldCmsSite.size()) {
                    if (oldCmsSite.isEmpty()) {
                        newCmsSite.add(new CmsSite(id, parent, 1));
                    } else {
                        newCmsSite.add(new CmsSite(id, parent, oldCmsSite.get(oldCmsSite.size() - 1).getOrderNo() + 1));
                    }
                } else {
                    for (int i = 0; i < oldCmsSite.size(); i++) {
                        if (i == position) {
                            newCmsSite.add(new CmsSite(id, parent, oldCmsSite.get(i).getOrderNo()));
                            newCmsSite.add(new CmsSite(oldCmsSite.get(i).getId(), oldCmsSite.get(i).getOrderNo() + 1));
                            needDeviation = true;
                        } else {
                            newCmsSite.add(new CmsSite(oldCmsSite.get(i).getId(), oldCmsSite.get(i).getOrderNo() + (needDeviation ? deviation : 0)));
                        }
                    }
                }
                isSuccess = updateBatchById(newCmsSite);
            }
            return isSuccess;
        } else {
            throw new EasyException(GlobalException.FAILED_TO_GET_DATA.getMessage());
        }
    }

    @Override
    public List<Tree> selectByTitle(String title) {
        if (Validator.isNotEmpty(title)) {
            return getBaseMapper().selectByTitle("%" + title + "%");
        } else {
            throw new EasyException("请输入关键字后重试");
        }
    }

    @Override
    public boolean checkMenuIsHaving(String name) {
        if (StrUtil.isNotBlank(name)) {
            QueryWrapper<CmsSite> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", name);
            int count = getBaseMapper().selectCount(queryWrapper);
            return count > 0;
        } else {
            throw new EasyException("[checkMenuIsHaving(String name)]站点名称不能为空");
        }
    }

}