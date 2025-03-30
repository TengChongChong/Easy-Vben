package com.easy.admin.auth.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.dao.SysRoleMenuMapper;
import com.easy.admin.auth.model.SysMenu;
import com.easy.admin.auth.model.SysRoleMenu;
import com.easy.admin.auth.service.SysRoleMenuService;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.constant.CommonConst;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色权限
 *
 * @author TengChongChong
 * @date 2018/11/27
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean saveRoleMenu(String roleId, List<String> menuIds) {
        // 删除原权限
        remove(new QueryWrapper<SysRoleMenu>().eq("role_id", roleId));
        if (Validator.isNotEmpty(menuIds)) {
            List<SysRoleMenu> sysRoleMenuList = new ArrayList<>();
            SysRoleMenu sysRoleMenu;
            for (String menuId : menuIds) {
                sysRoleMenu = new SysRoleMenu();
                sysRoleMenu.setRoleId(roleId);
                sysRoleMenu.setMenuId(menuId);
                sysRoleMenuList.add(sysRoleMenu);
            }
            saveBatch(sysRoleMenuList);
        }
        return true;
    }

    @Override
    public boolean removeByRoleId(String roleIds) {
        return remove(new QueryWrapper<SysRoleMenu>().in("role_id", roleIds.split(CommonConst.SPLIT)));
    }

    @Override
    public boolean removeRoleMenu(String menuIds) {
        return remove(new QueryWrapper<SysRoleMenu>().in("menu_id", menuIds.split(CommonConst.SPLIT)));
    }

    @Override
    public List<SysMenu> selectSysMenuByRoleId(String roleId) {
        return baseMapper.selectSysMenuByRoleId(roleId, CommonStatus.ENABLE.getCode());
    }
}
