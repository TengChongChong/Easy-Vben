package com.easy.admin.sys.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.common.tree.TreeUtil;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.sys.dao.SysRoleMapper;
import com.easy.admin.sys.model.SysRole;
import com.easy.admin.sys.service.SysDeptTypeRoleService;
import com.easy.admin.sys.service.SysRolePermissionsService;
import com.easy.admin.sys.service.SysRoleService;
import com.easy.admin.sys.service.SysUserRoleService;
import com.easy.admin.util.SysConfigUtil;
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
    private SysRolePermissionsService sysRolePermissionsService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysDeptTypeRoleService sysDeptTypeRoleService;

    @Override
    public List<Tree> selectByPId(String pId) {
        List<Tree> trees;
        // 第一次请求,返回项目名称 + 一级角色 数据
        if (StrUtil.isBlank(pId)) {
            trees = new ArrayList<>();
            // 根节点
            Tree tree = TreeUtil.getBaseNode();
            List<Tree> treeList = baseMapper.selectByPId(TreeUtil.BASE_ID);
            if (treeList.size() > 0) {
                tree.setIsLeaf(false);
                trees.addAll(treeList);
            } else {
                tree.setIsLeaf(true);
            }
            trees.add(tree);
        } else {
            trees = baseMapper.selectByPId(pId);
        }
        return trees;
    }

    @Override
    public List<Tree> selectAll() {
        List<Tree> trees = baseMapper.selectAll(CommonStatus.ENABLE.getCode());
        Tree tree = TreeUtil.getBaseNode();
        trees.add(tree);
        return trees;
    }

    @Override
    public SysRole get(String id) {
        SysRole sysRole;
        // 表示点击的是根目录
        if (id == null || id.equals(TreeUtil.BASE_ID)) {
            sysRole = new SysRole();
            sysRole.setId(TreeUtil.BASE_ID);
            sysRole.setName(SysConfigUtil.getProjectName());
        } else {
            sysRole = baseMapper.selectInfo(id);
            if (sysRole != null) {
                if (sysRole.getpId().equals(TreeUtil.BASE_ID)) {
                    sysRole.setpName(SysConfigUtil.getProjectName());
                }
                sysRole.setPermissions(baseMapper.selectPermissions(id));
            }
        }
        return sysRole;
    }

    @Override
    public SysRole add(String pId) {
        if (pId != null) {
            SysRole sysRole = new SysRole();
            sysRole.setpId(pId);
            sysRole.setStatus(CommonStatus.ENABLE.getCode());
            if (TreeUtil.BASE_ID.equals(pId)) {
                sysRole.setpName(SysConfigUtil.getProjectName());
            } else {
                SysRole parentSysRole = baseMapper.selectInfo(pId);
                if (parentSysRole != null) {
                    sysRole.setpName(parentSysRole.getName());
                } else {
                    throw new EasyException("获取父角色信息失败，请重试");
                }
            }
            return sysRole;
        } else {
            throw new EasyException("获取父角色信息失败，请重试");
        }
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String id) {
        ToolUtil.checkParams(id);
        // 检查是否有子节点
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p_id", id);
        int count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new EasyException(GlobalException.EXIST_CHILD.getMessage());
        }
        boolean isSuccess = removeById(id);
        if (isSuccess) {
            // 删除已经分配给用户的角色
            sysUserRoleService.deleteUserRole(String.valueOf(id));
            // 删除部门类型可分配的角色
            sysDeptTypeRoleService.removeDeptTypeRole(String.valueOf(id));
        }
        return isSuccess;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean batchRemove(String ids) {
        ToolUtil.checkParams(ids);
        // 检查是否有子节点
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("p_id", ids.split(CommonConst.SPLIT));
        int count = count(queryWrapper);
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
            object.setOrderNo(baseMapper.getMaxOrderNo(object.getpId()) + 1);
        }
        boolean isSuccess = saveOrUpdate(object);
        if (isSuccess) {
            // 删除授权信息,下次请求资源重新授权
            RedisUtil.delByPrefix(RedisPrefix.SHIRO_AUTHORIZATION);
            sysRolePermissionsService.saveRolePermissions(object.getId(), object.getPermissions());
        }
        return (SysRole) ToolUtil.checkResult(isSuccess, object);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean move(String id, String parent, String oldParent, Integer position, Integer oldPosition) {
        if (Validator.isNotEmpty(id) && Validator.isNotEmpty(parent) && Validator.isNotEmpty(oldParent) &&
                Validator.isNotEmpty(position) && Validator.isNotEmpty(oldPosition)) {
            boolean isSuccess;
            // 没有改变所属节点,内部排序
            if (parent.equals(oldParent)) {
                // 拖动影响节点顺序的开始序号
                int str = Math.min(position, oldPosition);
                // 拖动影响顺序节点数量
                int length = Math.abs(position - oldPosition) + 1;
                List<SysRole> oldSysRole = baseMapper.selectOrderInfo(parent, str, length);
                List<SysRole> newSysRole = new ArrayList<>();
                // 是否需要偏移
                boolean needDeviation = false;
                // 偏移量
                int deviation;
                if (position > oldPosition) {
                    deviation = -1;
                } else {
                    deviation = 1;
                }
                for (int i = 0; i < oldSysRole.size(); i++) {
                    if ((i + str) == position) {
                        newSysRole.add(new SysRole(id, oldSysRole.get(i).getOrderNo()));
                        newSysRole.add(new SysRole(oldSysRole.get(i).getId(), oldSysRole.get(i + deviation).getOrderNo()));
                        needDeviation = true;
                    } else {
                        if ((i + str) == oldPosition) {
                            needDeviation = true;
                        }
                        if (!id.equals(oldSysRole.get(i).getId())) {
                            newSysRole.add(new SysRole(oldSysRole.get(i).getId(), oldSysRole.get(i + (needDeviation ? deviation : 0)).getOrderNo()));
                        }
                    }
                }
                isSuccess = updateBatchById(newSysRole);
            } else {
                List<SysRole> oldSysRole = baseMapper.selectOrderInfo(parent, null, null);
                List<SysRole> newSysRole = new ArrayList<>();
                // 是否需要偏移
                boolean needDeviation = false;
                // 偏移量
                int deviation = 1;
                // 放到了最后一个
                if (position == oldSysRole.size()) {
                    if (oldSysRole.isEmpty()) {
                        newSysRole.add(new SysRole(id, parent, 1));
                    } else {
                        newSysRole.add(new SysRole(id, parent, oldSysRole.get(oldSysRole.size() - 1).getOrderNo() + 1));
                    }
                } else {
                    for (int i = 0; i < oldSysRole.size(); i++) {
                        if (i == position) {
                            newSysRole.add(new SysRole(id, parent, oldSysRole.get(i).getOrderNo()));
                            newSysRole.add(new SysRole(oldSysRole.get(i).getId(), oldSysRole.get(i).getOrderNo() + 1));
                            needDeviation = true;
                        } else {
                            newSysRole.add(new SysRole(oldSysRole.get(i).getId(), oldSysRole.get(i).getOrderNo() + (needDeviation ? deviation : 0)));
                        }
                    }
                }
                isSuccess = updateBatchById(newSysRole);
            }
            return isSuccess;
        } else {
            throw new EasyException(GlobalException.FAILED_TO_GET_DATA.getMessage());
        }
    }

    @Override
    public List<Tree> selectByTitle(String title) {
        if (Validator.isNotEmpty(title)) {
            return baseMapper.selectByTitle("%" + title + "%");
        } else {
            throw new EasyException("请输入关键字后重试");
        }
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
    public List<SysRole> selectRole(SysRole sysRole, boolean isSelect) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("t.status", CommonStatus.ENABLE.getCode());
        // 如果是查询用于显示已选择的角色列表，必须传入id
        boolean isInvalid = !isSelect && (sysRole == null || StrUtil.isBlank(sysRole.getId()));
        if(isInvalid){
            return CollectionUtil.empty(SysRole.class);
        }
        if(sysRole != null && StrUtil.isNotBlank(sysRole.getId())){
            if (sysRole.getId().contains(CommonConst.SPLIT)) {
                queryWrapper.in("t.id", sysRole.getId().split(CommonConst.SPLIT));
            } else {
                queryWrapper.eq("t.id", sysRole.getId());
            }
        }
        return baseMapper.selectRole(queryWrapper);
    }
}
