package com.easy.admin.sys.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.util.ToolUtil;
import com.easy.admin.sys.dao.SysRolePermissionsMapper;
import com.easy.admin.sys.model.SysRolePermissions;
import com.easy.admin.sys.service.SysRolePermissionsService;
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
public class SysRolePermissionsServiceImpl extends ServiceImpl<SysRolePermissionsMapper, SysRolePermissions> implements SysRolePermissionsService {

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean saveRolePermissions(String roleId, List<String> permissions) {
        ToolUtil.checkParams(roleId);
        // 删除原权限
        remove(new QueryWrapper<SysRolePermissions>().eq("role_id", roleId));
        if (Validator.isNotEmpty(permissions)) {
            List<SysRolePermissions> sysRolePermissions = new ArrayList<>();
            SysRolePermissions sysRolePermission;
            for (String permissionId : permissions) {
                sysRolePermission = new SysRolePermissions();
                sysRolePermission.setRoleId(roleId);
                sysRolePermission.setPermissionsId(permissionId);
                sysRolePermissions.add(sysRolePermission);
            }
            saveBatch(sysRolePermissions);
        }
        return true;
    }

    @Override
    public boolean removeRolePermissions(String permissions) {
        return remove(new QueryWrapper<SysRolePermissions>().in("permissions_id", permissions.split(CommonConst.SPLIT)));
    }
}
