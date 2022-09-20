package com.easy.admin.auth.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.common.constant.SysRoleConst;
import com.easy.admin.auth.dao.SysRoleMapper;
import com.easy.admin.auth.model.SysRole;
import com.easy.admin.auth.service.SysDeptTypeRoleService;
import com.easy.admin.auth.service.SysRolePermissionService;
import com.easy.admin.auth.service.SysRoleService;
import com.easy.admin.auth.service.SysUserRoleService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.sys.common.constant.WhetherConst;
import com.easy.admin.util.ShiroUtil;
import com.easy.admin.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 角色管理
 *
 * @author TengChongChong
 * @date 2018/11/2
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRolePermissionService sysRolePermissionsService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysDeptTypeRoleService sysDeptTypeRoleService;

    @Override
    public Page<SysRole> select(SysRole sysRole, Page<SysRole> page) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        if (sysRole != null) {
            if (Validator.isNotEmpty(sysRole.getName())) {
                queryWrapper.like("t.name", sysRole.getName());
            }
            if (Validator.isNotEmpty(sysRole.getCode())) {
                queryWrapper.like("t.code", sysRole.getCode());
            }
            if (Validator.isNotEmpty(sysRole.getStatus())) {
                if (sysRole.getStatus().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.status", sysRole.getStatus().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.status", sysRole.getStatus());
                }
            }
            if (Validator.isNotEmpty(sysRole.getSys())) {
                if (sysRole.getSys().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.sys", sysRole.getSys().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.sys", sysRole.getSys());
                }
            }
        }
        // 非系统管理员，仅显示非系统数据
        if (!ShiroUtil.havRole(SysRoleConst.SYS_ADMIN)) {
            queryWrapper.eq("t.sys", WhetherConst.NO);
        }
        page.setDefaultAsc("t.order_no");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    @Override
    public List<SysRole> selectAll() {
        return baseMapper.selectAll(CommonStatus.ENABLE.getCode());
    }

    @Override
    public SysRole get(String id) {
        SysRole sysRole = baseMapper.getById(id);
        if(sysRole != null){
            sysRole.setPermissionIds(baseMapper.selectPermissions(id));
        }
        return sysRole;
    }

    @Override
    public SysRole add() {
        SysRole sysRole = new SysRole();
        sysRole.setStatus(CommonStatus.ENABLE.getCode());
        sysRole.setSys(WhetherConst.NO);
        sysRole.setOrderNo(baseMapper.getMaxOrderNo() + 1);
        sysRole.setPermissionIds(new ArrayList<>());
        return sysRole;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        ToolUtil.checkParams(ids);
        // 检查是否有子节点
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("parent_id", ids.split(CommonConst.SPLIT));
        long count = count(queryWrapper);
        if (count > 0) {
            throw new EasyException(GlobalException.EXIST_CHILD.getMessage());
        }
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        boolean isSuccess = removeByIds(idList);
        if (isSuccess) {
            // 删除已经分配给用户的角色
            sysUserRoleService.deleteUserRole(ids);
            // 删除部门类型可分配的角色
            sysDeptTypeRoleService.removeDeptTypeRole(ids);
        }
        return isSuccess;
    }

    @Override
    public boolean setStatus(String ids, String status) {
        ToolUtil.checkParams(ids);
        ToolUtil.checkParams(status);
        List<SysRole> roleList = new ArrayList<>();
        SysRole sysRole;
        for (String id : ids.split(CommonConst.SPLIT)) {
            sysRole = new SysRole();
            sysRole.setId(id);
            sysRole.setStatus(status);
            roleList.add(sysRole);
        }
        return ToolUtil.checkResult(updateBatchById(roleList));
    }


    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysRole saveData(SysRole object) {
        ToolUtil.checkParams(object);
        if (object.getOrderNo() == null) {
            object.setOrderNo(baseMapper.getMaxOrderNo() + 1);
        }
        boolean isSuccess = saveOrUpdate(object);
        if (isSuccess) {
            // 删除授权信息,下次请求资源重新授权
            RedisUtil.delByPrefix(RedisPrefix.SHIRO_AUTHORIZATION);
            sysRolePermissionsService.saveRolePermissions(object.getId(), object.getPermissionIds());
        }
        return (SysRole) ToolUtil.checkResult(isSuccess, object);
    }

    @Override
    public List<String> selectRoleCodeByUserId(String userId) {
        return baseMapper.selectRoleCodeByUserId(userId);
    }

    @Override
    public List<String> selectAllRoleCodes() {
        return baseMapper.selectAllRoleCodes();
    }

    @Override
    public List<SysRole> selectRoleByDept(String deptId) {
        return sysDeptTypeRoleService.selectRoleByDept(deptId);
    }

    @Override
    public List<SysRole> selectRole(SysRole sysRole, boolean isSelect) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("t.status", CommonStatus.ENABLE.getCode());
        // 如果是查询用于显示已选择的角色列表，必须传入id
        boolean isInvalid = !isSelect && (sysRole == null || StrUtil.isBlank(sysRole.getId()));
        if (isInvalid) {
            return null;
        }
        if (sysRole != null && StrUtil.isNotBlank(sysRole.getId())) {
            if (sysRole.getId().contains(CommonConst.SPLIT)) {
                queryWrapper.in("t.id", sysRole.getId().split(CommonConst.SPLIT));
            } else {
                queryWrapper.eq("t.id", sysRole.getId());
            }
        }
        return baseMapper.selectRole(queryWrapper);
    }
}
