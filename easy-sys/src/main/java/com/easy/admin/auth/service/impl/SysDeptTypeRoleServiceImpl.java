package com.easy.admin.auth.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.dao.SysDeptTypeRoleMapper;
import com.easy.admin.auth.model.SysDeptTypeRole;
import com.easy.admin.auth.model.SysRole;
import com.easy.admin.auth.service.SysDeptTypeRoleService;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.util.ToolUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门类型可选择的角色
 *
 * @author TengChongChong
 * @date 2018/12/3
 */
@Service
public class SysDeptTypeRoleServiceImpl extends ServiceImpl<SysDeptTypeRoleMapper, SysDeptTypeRole> implements SysDeptTypeRoleService {

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean saveDeptTypeRole(String deptTypeId, List<String> roles) {
        ToolUtil.checkParams(deptTypeId);
        // 删除原权限
        remove(new QueryWrapper<SysDeptTypeRole>().eq("dept_type_id", deptTypeId));
        if (Validator.isNotEmpty(roles)) {
            List<SysDeptTypeRole> sysDeptTypeRoles = new ArrayList<>();
            SysDeptTypeRole sysDeptTypeRole;
            for (String roleId : roles) {
                sysDeptTypeRole = new SysDeptTypeRole();
                sysDeptTypeRole.setRoleId(roleId);
                sysDeptTypeRole.setDeptTypeId(deptTypeId);
                sysDeptTypeRoles.add(sysDeptTypeRole);
            }
            saveBatch(sysDeptTypeRoles);
        }
        return true;
    }

    @Override
    public boolean removeDeptTypeRoleByDeptTypeIds(String deptTypeIds) {
        return remove(new QueryWrapper<SysDeptTypeRole>().in("dept_type_id", deptTypeIds.split(CommonConst.SPLIT)));
    }

    @Override
    public boolean removeDeptTypeRole(String roles) {
        return remove(new QueryWrapper<SysDeptTypeRole>().in("role_id", roles.split(CommonConst.SPLIT)));
    }

    @Override
    public List<SysRole> selectRoleByDept(String deptId) {
        return baseMapper.selectRoleByDept(deptId);
    }
}
