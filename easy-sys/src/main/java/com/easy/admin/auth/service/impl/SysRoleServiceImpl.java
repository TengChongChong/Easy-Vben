package com.easy.admin.auth.service.impl;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.common.constant.SessionConst;
import com.easy.admin.auth.common.constant.SysRoleConst;
import com.easy.admin.auth.common.type.DataPermissionType;
import com.easy.admin.auth.dao.SysRoleMapper;
import com.easy.admin.auth.model.SysRole;
import com.easy.admin.auth.model.vo.SysRoleCacheVO;
import com.easy.admin.auth.model.vo.SysRoleVO;
import com.easy.admin.auth.model.vo.session.SessionUserRoleVO;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.auth.service.*;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.config.mybatis.plugins.model.DataPermission;
import com.easy.admin.config.sa.token.util.SessionUtil;
import com.easy.admin.sys.common.constant.WhetherConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    private SysRoleMenuService sysRoleMenuService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysDeptTypeRoleService sysDeptTypeRoleService;

    @Autowired
    private SysRoleDataPermissionService sysRoleDataPermissionService;

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
        if (!SessionUtil.havRole(SysRoleConst.SYS_ADMIN)) {
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
    public SysRoleVO get(String id) {
        SysRole sysRole = baseMapper.getById(id);
        if (sysRole == null) {
            return null;
        }
        SysRoleVO sysRoleVO = new SysRoleVO();
        BeanUtil.copyProperties(sysRole, sysRoleVO);

        sysRoleVO.setMenuIds(baseMapper.selectMenuIds(id));
        DataPermissionType dataPermissionType = DataPermissionType.valueOf(sysRoleVO.getDataPermission().toUpperCase());
        if (DataPermissionType.CUSTOM.equals(dataPermissionType)) {
            sysRoleVO.setDataPermissionDeptIds(sysRoleDataPermissionService.selectDeptByRoleId(id));
        }
        return sysRoleVO;
    }

    @Override
    public SysRoleVO add() {
        SysRoleVO sysRole = new SysRoleVO();
        sysRole.setStatus(CommonStatus.ENABLE.getCode());
        sysRole.setSys(WhetherConst.NO);
        sysRole.setOrderNo(baseMapper.getMaxOrderNo() + 1);
        sysRole.setMenuIds(Collections.emptyList());
        return sysRole;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
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
            // 删除已经分配给角色的角色权限
            sysRoleMenuService.removeByRoleId(ids);
            // 删除已经分配给用户的角色
            sysUserRoleService.removeUserRole(ids);
            // 删除部门类型可分配的角色
            sysDeptTypeRoleService.removeDeptTypeRole(ids);
            // 删除部门自定义数据权限
            sysRoleDataPermissionService.removeByRoleId(ids);

            for (String id : idList) {
                // 删除缓存的角色数据
                RedisUtil.del(RedisPrefix.SYS_ROLE + id);
            }

            addNeedUpdateRoleAndPermission(idList);
        }
        return isSuccess;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean setStatus(String ids, String status) {
        List<SysRole> roleList = new ArrayList<>();
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));

        SysRole sysRole;
        for (String id : idList) {
            sysRole = new SysRole();
            sysRole.setId(id);
            sysRole.setStatus(status);
            roleList.add(sysRole);
        }
        boolean isSuccess = updateBatchById(roleList);
        if (isSuccess) {
            // 删除缓存的角色数据
            idList.forEach(id -> RedisUtil.del(RedisPrefix.SYS_ROLE + id));
            addNeedUpdateRoleAndPermission(idList);
        }
        return isSuccess;
    }


    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysRoleVO saveData(SysRoleVO sysRoleVO) {
        if (sysRoleVO.getOrderNo() == null) {
            sysRoleVO.setOrderNo(baseMapper.getMaxOrderNo() + 1);
        }
        SysRole sysRole = new SysRole();
        BeanUtil.copyProperties(sysRoleVO, sysRole);

        boolean isSuccess = saveOrUpdate(sysRole);
        if (isSuccess) {
            sysRoleVO.setId(sysRole.getId());
            // 保存角色权限
            sysRoleMenuService.saveRoleMenu(sysRoleVO.getId(), sysRoleVO.getMenuIds());
            // 保存数据权限
            DataPermissionType dataPermissionType = DataPermissionType.valueOf(sysRoleVO.getDataPermission().toUpperCase());
            if (DataPermissionType.CUSTOM.equals(dataPermissionType)) {
                // 保存自定义数据权限
                sysRoleDataPermissionService.saveBatchData(sysRoleVO.getId(), sysRoleVO.getDataPermissionDeptIds());
            } else {
                sysRoleDataPermissionService.removeByRoleId(sysRoleVO.getId());
            }
            // 删除缓存的角色数据
            RedisUtil.del(RedisPrefix.SYS_ROLE + sysRoleVO.getId());
            // 遍历当前在线用户，标记角色权限已变更，下次请求时更新权限数据
            addNeedUpdateRoleAndPermission(Collections.singletonList(sysRoleVO.getId()));
        }
        return sysRoleVO;
    }

    private void addNeedUpdateRoleAndPermission(List<String> roleIds) {
        // 所有 token
        List<String> tokenList = StpUtil.searchSessionId("", 0, -1, true);
        for (String token : tokenList) {
            String realToken = token.contains(":") ? token.substring(token.lastIndexOf(":") + 1) : token;
            SaSession accountSession = StpUtil.getSessionByLoginId(realToken);
            // token 中的用户信息
            SessionUserVO sessionUserVO = (SessionUserVO) accountSession.get(SessionConst.USER_SESSION_KEY);
            if (sessionUserVO != null && isNeedUpdate(sessionUserVO.getRoleList(), roleIds)) {
                // 需要标记待更新
                accountSession.set(SessionConst.NEED_UPDATE_ROLE_AND_PERMISSION, true);
            }
        }
    }

    private boolean isNeedUpdate(List<SessionUserRoleVO> roleList, List<String> roleIds) {
        for (SessionUserRoleVO sessionUserRoleVO : roleList) {
            if (roleIds.contains(sessionUserRoleVO.getId())) {
                return true;
            }
        }
        return false;
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

    @Override
    public synchronized SysRoleCacheVO getSysRoleCache(String id) {
        SysRoleCacheVO sysRoleCache = (SysRoleCacheVO) RedisUtil.get(RedisPrefix.SYS_ROLE + id);
        if (sysRoleCache != null) {
            return sysRoleCache;
        }
        // 从数据库中获取
        SysRole sysRole = baseMapper.getById(id);
        if (sysRole == null) {
            throw new EasyException("角色信息[" + id + "]不存在");
        }

        SysRoleVO sysRoleVO = new SysRoleVO();
        BeanUtil.copyProperties(sysRole, sysRoleVO);
        // 数据权限
        DataPermissionType dataPermissionType = DataPermissionType.valueOf(sysRole.getDataPermission().toUpperCase());
        if (DataPermissionType.CUSTOM.equals(dataPermissionType)) {
            sysRoleVO.setDataPermissionDeptIds(sysRoleDataPermissionService.selectDeptByRoleId(id));
        }

        sysRoleCache = new SysRoleCacheVO(sysRoleVO, sysRoleMenuService.selectSysMenuByRoleId(id));
        // 放到缓存
        RedisUtil.set(RedisPrefix.SYS_ROLE + id, sysRoleCache);
        return sysRoleCache;
    }


    /**
     * 将角色数据权限汇总，并按照数据范围合并
     *
     * @param roleList 角色
     * @return 数据权限
     */
    @Override
    public List<DataPermission> convertToDataPermission(List<SessionUserRoleVO> roleList) {
        if (roleList == null || roleList.isEmpty()) {
            return Collections.emptyList();
        }
        List<DataPermission> dataPermissionList = new ArrayList<>();
        for (SessionUserRoleVO sessionUserRole : roleList) {
            SysRoleCacheVO sysRoleCache = getSysRoleCache(sessionUserRole.getId());

            // 数据权限类型
            DataPermissionType dataPermissionType = DataPermissionType.valueOf(sysRoleCache.getDataPermission().toUpperCase());
            switch (dataPermissionType) {
                case ALL:
                    // 全部数据权限（不做数据权限控制）
                    return Collections.emptyList();
                case CUSTOM:
                    // 自定义数据权限
                    // 查询自定义数据权限
                    List<String> deptIds = sysRoleCache.getDataPermissionDeptIdList();
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

    @Override
    public boolean refresh() {
        // 删除缓存的角色数据
        RedisUtil.delByPrefix(RedisPrefix.SYS_ROLE);
        return true;
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
