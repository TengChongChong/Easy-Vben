package com.easy.admin.auth.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.util.ToolUtil;
import com.easy.admin.auth.dao.SysRolePermissionMapper;
import com.easy.admin.auth.model.SysRolePermission;
import com.easy.admin.auth.service.SysRolePermissionService;
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
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements SysRolePermissionService {

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean saveRolePermissions(String roleId, List<String> permissions) {
        ToolUtil.checkParams(roleId);
        // 删除原权限
        remove(new QueryWrapper<SysRolePermission>().eq("role_id", roleId));
        if (Validator.isNotEmpty(permissions)) {
            List<SysRolePermission> sysRolePermissions = new ArrayList<>();
            SysRolePermission sysRolePermission;
            for (String permissionId : permissions) {
                sysRolePermission = new SysRolePermission();
                sysRolePermission.setRoleId(roleId);
                sysRolePermission.setPermissionId(permissionId);
                sysRolePermissions.add(sysRolePermission);
            }
            saveBatch(sysRolePermissions);
        }
        return true;
    }

    @Override
    public boolean removeRolePermissions(String permissions) {
        return remove(new QueryWrapper<SysRolePermission>().in("permission_id", permissions.split(CommonConst.SPLIT)));
    }
}
