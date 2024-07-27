package com.easy.admin.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.common.type.DataPermissionType;
import com.easy.admin.auth.dao.SysRoleDataPermissionMapper;
import com.easy.admin.auth.model.SysRole;
import com.easy.admin.auth.model.SysRoleDataPermission;
import com.easy.admin.auth.service.SysRoleDataPermissionService;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.config.mybatis.plugins.model.DataPermission;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
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

    /**
     * 将角色数据权限汇总，并按照数据范围合并
     *
     * @param roleList 角色
     * @return 数据权限
     */
    @Override
    public List<DataPermission> convertToDataPermission(List<SysRole> roleList) {
        if (roleList == null || roleList.isEmpty()) {
            return Collections.emptyList();
        }
        List<DataPermission> dataPermissionList = new ArrayList<>();
        for (SysRole role : roleList) {
            // 数据权限类型
            DataPermissionType dataPermissionType = DataPermissionType.valueOf(role.getDataPermission().toUpperCase());
            switch (dataPermissionType) {
                case ALL:
                    // 全部数据权限（不做数据权限控制）
                    return Collections.emptyList();
                case CUSTOM:
                    // 自定义数据权限
                    // 查询自定义数据权限
                    List<String> deptIds = selectDeptByRoleId(role.getId());
                    // 检查是否有效
                    if (deptIds != null && !deptIds.isEmpty()) {
                        dataPermissionList.add(new DataPermission(dataPermissionType, deptIds));
                    }
                    break;
                default:
                    if (checkHasDataPermission(dataPermissionList, dataPermissionType)) {
                        dataPermissionList.add(new DataPermission(dataPermissionType));
                    }
            }
        }
        return dataPermissionList;
    }

    /**
     * 检查数据权限是否有必要添加到数据权限集合中
     *
     * @param dataPermissionList 数据权限集合
     * @param dataPermissionType 数据权限
     * @return true/false
     */
    private boolean checkHasDataPermission(List<DataPermission> dataPermissionList, DataPermissionType dataPermissionType) {
        if (dataPermissionList.isEmpty()) {
            return true;
        }
        if (DataPermissionType.SELF.equals(dataPermissionType)) {
            for (DataPermission dataPermission : dataPermissionList) {
                if (dataPermission.getType() == DataPermissionType.SELF || dataPermission.getType() == DataPermissionType.MY_DEPT || dataPermission.getType() == DataPermissionType.MY_AND_SUB_DEPT) {
                    return false;
                }
            }
        } else if (DataPermissionType.MY_DEPT.equals(dataPermissionType)) {
            for (DataPermission dataPermission : dataPermissionList) {
                if (dataPermission.getType() == DataPermissionType.MY_DEPT || dataPermission.getType() == DataPermissionType.MY_AND_SUB_DEPT) {
                    return false;
                }
            }
        } else if (DataPermissionType.MY_AND_SUB_DEPT.equals(dataPermissionType)) {
            for (DataPermission dataPermission : dataPermissionList) {
                if (dataPermission.getType() == DataPermissionType.MY_AND_SUB_DEPT) {
                    return false;
                }
            }
        }

        return true;
    }
}