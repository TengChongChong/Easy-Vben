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
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.sys.common.constant.OpenModeConst;
import com.easy.admin.sys.common.constant.WhetherConst;
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
            // 名称
            if (Validator.isNotEmpty(sysPermission.getTitle())) {
                queryWrapper.like("t.title", sysPermission.getTitle());
            }
            // 标识
            if (Validator.isNotEmpty(sysPermission.getCode())) {
                queryWrapper.like("t.code", sysPermission.getCode());
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
            if (Validator.isNotEmpty(sysPermission.getExternalLink())) {
                if (sysPermission.getExternalLink().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.external", sysPermission.getExternalLink().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.external", sysPermission.getExternalLink());
                }
            }
            // 显示
            if (Validator.isNotEmpty(sysPermission.getShowInMenu())) {
                if (sysPermission.getShowInMenu().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.display", sysPermission.getShowInMenu().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.display", sysPermission.getShowInMenu());
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
        sysPermission.setShowInMenu(WhetherConst.YES);
        sysPermission.setExternalLink(WhetherConst.NO);
        sysPermission.setType(PermissionType.MENU.getCode());
        sysPermission.setOpenMode(OpenModeConst.DEFAULT);
        sysPermission.setOrderNo(baseMapper.getMaxOrderNo(parentId) + 1);
        return sysPermission;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
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
            // 删除缓存的角色数据
            RedisUtil.delByPrefix(RedisPrefix.SYS_ROLE);
        }
        return isSuccess;
    }

    @Override
    public boolean setStatus(String id, String status, String type) {
        UpdateWrapper<SysPermission> setStatus = new UpdateWrapper<>();
        setStatus.set("status", status).eq("id", id);
        boolean isSuccess = update(setStatus);
        if (isSuccess && PermissionType.MENU.getCode().equals(type)) {
            // 如果是菜单，同时修改子级的状态
            UpdateWrapper<SysPermission> setChildStatus = new UpdateWrapper<>();
            setChildStatus.set("status", status).eq("parent_id", id);
            update(setChildStatus);
            // 删除缓存的角色数据
            RedisUtil.delByPrefix(RedisPrefix.SYS_ROLE);
        }
        return isSuccess;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysPermission saveData(SysPermission sysPermission) {
        if (StrUtil.isBlank(sysPermission.getId()) && sysPermission.getOrderNo() == null) {
            sysPermission.setOrderNo(baseMapper.getMaxOrderNo(sysPermission.getParentId()) + 1);
        }

        // 检查菜单path是否已存在
        if (checkHaving(sysPermission.getId(), "path", sysPermission.getPath())) {
            throw new EasyException("已存在地址为 " + sysPermission.getPath() + " 的菜单");
        }

        // 检查菜单name是否已存在
        if (checkHaving(sysPermission.getId(), "name", sysPermission.getName())) {
            throw new EasyException("已存在组件名称为 " + sysPermission.getName() + " 的菜单");
        }

        boolean isSuccess = saveOrUpdate(sysPermission);
        if (isSuccess) {
            // 删除缓存的角色数据
            RedisUtil.delByPrefix(RedisPrefix.SYS_ROLE);
        }
        return sysPermission;
    }

    /**
     * 检查数据是否已经存在
     *
     * @param id    数据id
     * @param field 字段
     * @param value 值
     * @return true/false
     */
    private boolean checkHaving(String id, String field, String value) {
        if (Validator.isNotEmpty(value)) {
            QueryWrapper<SysPermission> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(field, value);
            if (StrUtil.isNotBlank(id)) {
                queryWrapper.ne("id", id);
            }
            long count = baseMapper.selectCount(queryWrapper);
            return count > 0;
        }
        return false;
    }

    @Override
    public boolean saveOrder(List<SysPermission> sysPermissionList) {
        boolean isSuccess = baseMapper.updateOrderBatch(sysPermissionList) > 0;
        if (isSuccess) {
            // 删除缓存的角色数据
            RedisUtil.delByPrefix(RedisPrefix.SYS_ROLE);
        }
        return isSuccess;
    }

    @Override
    public boolean hasMenu(String title) {
        return baseMapper.countByTitle(title) > 0;
    }
}
