package com.easy.restful.sys.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.restful.common.core.common.tree.Tree;
import com.easy.restful.common.core.common.tree.TreeUtil;
import com.easy.restful.common.core.constant.CommonConst;
import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.common.core.exception.GlobalException;
import com.easy.restful.sys.common.constant.OpeningModeConst;
import com.easy.restful.sys.common.status.PermissionsHideStatus;
import com.easy.restful.sys.common.status.PermissionsStatus;
import com.easy.restful.sys.common.type.PermissionsType;
import com.easy.restful.sys.dao.SysPermissionsMapper;
import com.easy.restful.sys.model.SysPermissions;
import com.easy.restful.sys.service.SysPermissionsService;
import com.easy.restful.sys.service.SysRolePermissionsService;
import com.easy.restful.util.SysConfigUtil;
import com.easy.restful.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 权限/菜单
 *
 * @author tengchong
 * @date 2018/10/31
 */
@Service
public class SysPermissionsServiceImpl extends ServiceImpl<SysPermissionsMapper, SysPermissions> implements SysPermissionsService {

    @Autowired
    private SysRolePermissionsService sysRolePermissionsService;

    @Override
    public List<Tree> selectByPId(String pId) {
        List<Tree> trees;
        // 第一次请求,返回项目名称 + 一级菜单 数据
        if (pId == null || pId.equals(TreeUtil.BASE_ID)) {
            trees = new ArrayList<>();
            // 根节点
            Tree tree = TreeUtil.getBaseNode();
            trees.add(tree);
            trees.addAll(getBaseMapper().selectByPId(TreeUtil.BASE_ID));
        } else {
            trees = getBaseMapper().selectByPId(pId);
        }
        return trees;
    }

    @Override
    public List<Tree> selectAll() {
        List<Tree> trees = getBaseMapper().selectAll(PermissionsStatus.ENABLE.getCode());
        // 根节点
        Tree tree = TreeUtil.getBaseNode();
        trees.add(tree);
        trees.addAll(getBaseMapper().selectAll(TreeUtil.BASE_ID));
        return trees;
    }

    @Override
    public SysPermissions get(String id) {
        SysPermissions sysPermissions;
        // 表示点击的是根目录
        if (id == null || id.equals(TreeUtil.BASE_ID)) {
            sysPermissions = new SysPermissions();
            sysPermissions.setId(TreeUtil.BASE_ID);
            sysPermissions.setName(SysConfigUtil.getProjectName());
        } else {
            sysPermissions = getBaseMapper().selectInfo(id);
            if (sysPermissions != null && sysPermissions.getpId().equals(TreeUtil.BASE_ID)) {
                sysPermissions.setpName(SysConfigUtil.getProjectName());
            }
        }
        return sysPermissions;
    }

    @Override
    public SysPermissions add(String pId) {
        if (pId != null) {
            SysPermissions sysPermissions = new SysPermissions();
            sysPermissions.setpId(pId);
            sysPermissions.setStatus(PermissionsStatus.ENABLE.getCode());
            sysPermissions.setHide(PermissionsHideStatus.ENABLE.getCode());
            sysPermissions.setType(PermissionsType.MENU.getCode());
            sysPermissions.setTarget(OpeningModeConst.DEFAULT);
            if (TreeUtil.BASE_ID.equals(pId)) {
                sysPermissions.setpName(SysConfigUtil.getProjectName());
            } else {
                SysPermissions parentSysPermissions = getBaseMapper().selectInfo(pId);
                if (parentSysPermissions != null) {
                    sysPermissions.setpName(parentSysPermissions.getName());
                } else {
                    throw new EasyException("获取父权限信息失败，请重试");
                }
            }
            return sysPermissions;
        } else {
            throw new EasyException("获取父权限信息失败，请重试");
        }
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String id) {
        ToolUtil.checkParams(id);
        // 检查是否有子权限
        QueryWrapper<SysPermissions> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p_id", id);
        int count = count(queryWrapper);
        if (count > 0) {
            throw new EasyException(GlobalException.EXIST_CHILD.getMessage());
        }
        boolean isSuccess = removeById(id);
        if (isSuccess) {
            // 同时删除已分配的权限
            sysRolePermissionsService.removeRolePermissions(String.valueOf(id));
        }

        return isSuccess;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean batchRemove(String ids) {
        ToolUtil.checkParams(ids);
        // 检查是否有子权限
        QueryWrapper<SysPermissions> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("p_id", ids.split(CommonConst.SPLIT));
        int count = count(queryWrapper);
        if (count > 0) {
            throw new EasyException(GlobalException.EXIST_CHILD.getMessage());
        }
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        boolean isSuccess = removeByIds(idList);
        if (isSuccess) {
            // 同时删除已分配的权限
            sysRolePermissionsService.removeRolePermissions(ids);
        }
        return isSuccess;
    }

    @Override
    public boolean setStatus(String ids, String status) {
        ToolUtil.checkParams(ids);
        ToolUtil.checkParams(status);
        List<SysPermissions> permissionsList = new ArrayList<>();
        SysPermissions sysPermissions;
        for (String id : ids.split(CommonConst.SPLIT)) {
            sysPermissions = new SysPermissions();
            sysPermissions.setId(id);
            sysPermissions.setStatus(status);
            permissionsList.add(sysPermissions);
        }
        return ToolUtil.checkResult(updateBatchById(permissionsList));
    }

    @Override
    public List<SysPermissions> copyNode(String nodeIds, String targetId) {
        ToolUtil.checkParams(nodeIds);
        ToolUtil.checkParams(targetId);
        // 查询复制的节点
        List<SysPermissions> copyPermissions = getBaseMapper().selectBatchIds(Arrays.asList(nodeIds.split(CommonConst.SPLIT)));
        if (copyPermissions != null && !copyPermissions.isEmpty()) {
            SysPermissions parentPermission = getById(targetId);
            // 目标节点存在
            if (parentPermission != null) {
                int maxOrderNo = getBaseMapper().getMaxOrderNo(targetId);
                List<SysPermissions> sysPermissionsList = new ArrayList<>();
                SysPermissions sysPermissions;
                for (SysPermissions permission : copyPermissions) {
                    sysPermissions = new SysPermissions();
                    maxOrderNo++;
                    sysPermissions.setOrderNo(maxOrderNo);
                    sysPermissions.setIcon(permission.getIcon());
                    sysPermissions.setType(permission.getType());
                    sysPermissions.setTips(permission.getTips());
                    sysPermissions.setName(permission.getName());
                    sysPermissions.setStatus(permission.getStatus());
                    sysPermissions.setPath(permission.getPath());
                    sysPermissions.setComponent(permission.getComponent());
                    sysPermissions.setHide(permission.getHide());
                    sysPermissions.setpId(parentPermission.getId());
                    sysPermissions.setTarget(permission.getTarget());
                    if (Validator.isNotEmpty(permission.getCode())) {
                        try {
                            // code默认为 父code + 最后一个:后面的字符
                            String pCode = parentPermission.getCode();
                            if (pCode.endsWith(":list")) {
                                pCode = pCode.substring(0, pCode.indexOf(":list"));
                            }
                            if (pCode.endsWith(":view")) {
                                pCode = pCode.substring(0, pCode.indexOf(":view"));
                            }
                            sysPermissions.setCode(pCode +
                                    permission.getCode().substring(permission.getCode().lastIndexOf(":")));
                        } catch (Exception e) {
                            sysPermissions.setCode(permission.getCode());
                        }
                    }
                    sysPermissionsList.add(sysPermissions);
                }
                saveBatch(sysPermissionsList);
                return sysPermissionsList;
            }
        }
        return CollectionUtil.empty(SysPermissions.class);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysPermissions saveData(SysPermissions object) {
        ToolUtil.checkParams(object);

        if (StrUtil.isBlank(object.getId()) && object.getOrderNo() == null) {
            object.setOrderNo(getBaseMapper().getMaxOrderNo(object.getpId()) + 1);
        }

        return (SysPermissions) ToolUtil.checkResult(saveOrUpdate(object), object);
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
                List<SysPermissions> oldSysPermissions = getBaseMapper().selectOrderInfo(parent, str, length);
                List<SysPermissions> newSysPermissions = new ArrayList<>();
                // 是否需要偏移
                boolean needDeviation = false;
                // 偏移量
                int deviation;
                if (position > oldPosition) {
                    deviation = -1;
                } else {
                    deviation = 1;
                }
                for (int i = 0; i < oldSysPermissions.size(); i++) {
                    if ((i + str) == position) {
                        newSysPermissions.add(new SysPermissions(id, oldSysPermissions.get(i).getOrderNo()));
                        newSysPermissions.add(new SysPermissions(oldSysPermissions.get(i).getId(), oldSysPermissions.get(i + deviation).getOrderNo()));
                        needDeviation = true;
                    } else {
                        if ((i + str) == oldPosition) {
                            needDeviation = true;
                        }
                        if (!id.equals(oldSysPermissions.get(i).getId())) {
                            newSysPermissions.add(new SysPermissions(oldSysPermissions.get(i).getId(), oldSysPermissions.get(i + (needDeviation ? deviation : 0)).getOrderNo()));
                        }
                    }
                }
                isSuccess = updateBatchById(newSysPermissions);
            } else {
                List<SysPermissions> oldSysPermissions = getBaseMapper().selectOrderInfo(parent, null, null);
                List<SysPermissions> newSysPermissions = new ArrayList<>();
                // 是否需要偏移
                boolean needDeviation = false;
                // 偏移量
                int deviation = 1;
                // 放到了最后一个
                if (position == oldSysPermissions.size()) {
                    if (oldSysPermissions.isEmpty()) {
                        newSysPermissions.add(new SysPermissions(id, parent, 1));
                    } else {
                        newSysPermissions.add(new SysPermissions(id, parent, oldSysPermissions.get(oldSysPermissions.size() - 1).getOrderNo() + 1));
                    }
                } else {
                    for (int i = 0; i < oldSysPermissions.size(); i++) {
                        if (i == position) {
                            newSysPermissions.add(new SysPermissions(id, parent, oldSysPermissions.get(i).getOrderNo()));
                            newSysPermissions.add(new SysPermissions(oldSysPermissions.get(i).getId(), oldSysPermissions.get(i).getOrderNo() + 1));
                            needDeviation = true;
                        } else {
                            newSysPermissions.add(new SysPermissions(oldSysPermissions.get(i).getId(), oldSysPermissions.get(i).getOrderNo() + (needDeviation ? deviation : 0)));
                        }
                    }
                }
                isSuccess = updateBatchById(newSysPermissions);
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
            QueryWrapper<SysPermissions> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", name);
            queryWrapper.eq("type", PermissionsType.MENU.getCode());
            int count = getBaseMapper().selectCount(queryWrapper);
            return count > 0;
        } else {
            throw new EasyException("[checkMenuIsHaving(String name)]菜单名称不能为空");
        }
    }
}
