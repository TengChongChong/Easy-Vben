package com.easy.admin.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.dao.SysRoleDataPermissionMapper;
import com.easy.admin.auth.model.SysRoleDataPermission;
import com.easy.admin.auth.service.SysRoleDataPermissionService;
import com.easy.admin.common.core.constant.CommonConst;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色数据权限
 *
 * @author 系统管理员
 * @date 2024-07-22
 */
@Service
public class SysRoleDataPermissionServiceImpl extends ServiceImpl<SysRoleDataPermissionMapper, SysRoleDataPermission> implements SysRoleDataPermissionService {

    @Override
    public List<String> selectDeptByRoleId(String roleId) {
        QueryWrapper<SysRoleDataPermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", roleId);
        return baseMapper.selectWithoutPage(queryWrapper);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean removeByRoleId(String roleIds) {
        return remove(new QueryWrapper<SysRoleDataPermission>().in("role_id", roleIds.split(CommonConst.SPLIT)));
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean saveBatchData(String roleId, List<String> deptIds) {
        removeByRoleId(roleId);

        List<SysRoleDataPermission> sysRoleDataPermissionList = new ArrayList<>();
        for (String deptId : deptIds) {
            sysRoleDataPermissionList.add(new SysRoleDataPermission(roleId, deptId));
        }
        return saveBatch(sysRoleDataPermissionList);
    }
}