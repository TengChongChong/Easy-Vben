package com.easy.admin.auth.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.common.type.PermissionType;
import com.easy.admin.auth.dao.SysPermissionMapper;
import com.easy.admin.auth.model.SysPermission;
import com.easy.admin.auth.service.SysPermissionService;
import com.easy.admin.auth.service.SysRolePermissionService;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.sys.common.constant.OpenModeConst;
import com.easy.admin.sys.common.constant.WhetherConst;
import com.easy.admin.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 权限/菜单
 *
 * @author TengChongChong
 * @date 2018/10/31
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Autowired
    private SysRolePermissionService sysRolePermissionsService;

    @Override
    public List<SysPermission> select(SysPermission sysPermission) {
        QueryWrapper<SysPermission> queryWrapper = new QueryWrapper<>();
        if (sysPermission != null) {
            if (Validator.isNotEmpty(sysPermission.getTitle())) {
                queryWrapper.like("t.title", sysPermission.getTitle());
            }
            // 状态
            if (Validator.isNotEmpty(sysPermission.getStatus())) {
                if (sysPermission.getStatus().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.status", sysPermission.getStatus().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.status", sysPermission.getStatus());
                }
            }
            // 类型
            if (Validator.isNotEmpty(sysPermission.getType())) {
                if (sysPermission.getType().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.type", sysPermission.getType().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.type", sysPermission.getType());
                }
            }
            // 外链
            if (Validator.isNotEmpty(sysPermission.getExternal())) {
                if (sysPermission.getExternal().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.external", sysPermission.getExternal().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.external", sysPermission.getExternal());
                }
            }
            // 显示
            if (Validator.isNotEmpty(sysPermission.getDisplay())) {
                if (sysPermission.getDisplay().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.display", sysPermission.getDisplay().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.display", sysPermission.getDisplay());
                }
            }
            if (Validator.isNotEmpty(sysPermission.getPath())) {
                queryWrapper.like("t.path", sysPermission.getPath());
            }
        }

        return baseMapper.select(queryWrapper);
    }

    @Override
    public List<Tree> selectAll() {
        return baseMapper.selectAll(CommonStatus.ENABLE.getCode());
    }

    @Override
    public SysPermission get(String id) {
        return baseMapper.getById(id);
    }

    @Override
    public SysPermission add(String parentId) {
        SysPermission sysPermission = new SysPermission();
        sysPermission.setParentId(parentId);
        sysPermission.setStatus(CommonStatus.ENABLE.getCode());
        sysPermission.setDisplay(WhetherConst.YES);
        sysPermission.setExternal(WhetherConst.NO);
        sysPermission.setType(PermissionType.CATALOGUE.getCode());
        sysPermission.setOpenMode(OpenModeConst.DEFAULT);
        sysPermission.setOrderNo(baseMapper.getMaxOrderNo(parentId) + 1);
        return sysPermission;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        ToolUtil.checkParams(ids);
        // 检查是否有子权限
        QueryWrapper<SysPermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("parent_id", ids.split(CommonConst.SPLIT));
        long count = count(queryWrapper);
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
    public boolean setStatus(String id, String status, String type) {
        UpdateWrapper<SysPermission> setStatus = new UpdateWrapper<>();
        setStatus.set("status", status).eq("id", id);
        boolean isSuccess = update(setStatus);
        if(isSuccess && PermissionType.MENU.getCode().equals(type)){
            // 如果是菜单，同时修改子级的状态
            UpdateWrapper<SysPermission> setChildStatus = new UpdateWrapper<>();
            setChildStatus.set("status", status).eq("parent_id", id);
            update(setChildStatus);
        }
        return isSuccess;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysPermission saveData(SysPermission sysPermission) {
        ToolUtil.checkParams(sysPermission);

        if (StrUtil.isBlank(sysPermission.getId()) && sysPermission.getOrderNo() == null) {
            sysPermission.setOrderNo(baseMapper.getMaxOrderNo(sysPermission.getParentId()) + 1);
        }

        return (SysPermission) ToolUtil.checkResult(saveOrUpdate(sysPermission), sysPermission);
    }

    @Override
    public boolean saveOrder(List<SysPermission> sysPermissionList) {
        return baseMapper.updateOrderBatch(sysPermissionList) > 0;
    }

    @Override
    public boolean hasMenu(String title) {
        return baseMapper.countByTitle(title) > 0;
    }
}
