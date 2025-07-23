package com.easy.admin.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.dao.SysRoleQuickNavigationMapper;
import com.easy.admin.auth.model.SysRoleQuickNavigation;
import com.easy.admin.auth.service.SysRoleQuickNavigationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色快捷导航
 *
 * @author 系统管理员
 * @date 2025-07-09
 */
@Service
public class SysRoleQuickNavigationServiceImpl extends ServiceImpl<SysRoleQuickNavigationMapper, SysRoleQuickNavigation> implements SysRoleQuickNavigationService {


    @Override
    public List<String> selectByRoleId(String roleId) {
        QueryWrapper<SysRoleQuickNavigation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", roleId);
        return baseMapper.selectWithoutPage(queryWrapper);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean removeByRoleId(String roleId) {
        return remove(new QueryWrapper<SysRoleQuickNavigation>().eq("role_id", roleId));
    }

    @Override
    public boolean removeByNavigationId(String navigationId) {
        return remove(new QueryWrapper<SysRoleQuickNavigation>().eq("navigation_id", navigationId));
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean saveBatchData(String roleId, List<String> navigationIdList) {
        removeByRoleId(roleId);
        if (navigationIdList == null || navigationIdList.isEmpty()) {
            return true;
        }
        List<SysRoleQuickNavigation> sysRoleQuickNavigationList = new ArrayList<>();
        for (String navigationId : navigationIdList) {
            SysRoleQuickNavigation sysRoleQuickNavigation = new SysRoleQuickNavigation();
            sysRoleQuickNavigation.setNavigationId(navigationId);
            sysRoleQuickNavigation.setRoleId(roleId);
            sysRoleQuickNavigationList.add(sysRoleQuickNavigation);
        }
        return saveBatch(sysRoleQuickNavigationList);
    }
}