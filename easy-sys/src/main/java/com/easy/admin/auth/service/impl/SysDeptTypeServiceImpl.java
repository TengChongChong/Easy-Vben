package com.easy.admin.auth.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.dao.SysDeptTypeMapper;
import com.easy.admin.auth.model.SysDeptType;
import com.easy.admin.auth.service.SysDeptService;
import com.easy.admin.auth.service.SysDeptTypeRoleService;
import com.easy.admin.auth.service.SysDeptTypeService;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 部门类型管理
 *
 * @author TengChongChong
 * @date 2018/12/3
 */
@Service
public class SysDeptTypeServiceImpl extends ServiceImpl<SysDeptTypeMapper, SysDeptType> implements SysDeptTypeService {

    @Autowired
    private SysDeptTypeRoleService departmentTypeRoleService;

    @Autowired
    private SysDeptService sysDeptService;

    @Override
    public List<SysDeptType> select(SysDeptType sysDeptType) {
        QueryWrapper<SysDeptType> queryWrapper = new QueryWrapper<>();
        if (sysDeptType != null) {
            if (Validator.isNotEmpty(sysDeptType.getName())) {
                queryWrapper.like("t.name", sysDeptType.getName());
            }
            if (Validator.isNotEmpty(sysDeptType.getCode())) {
                queryWrapper.like("t.code", sysDeptType.getCode());
            }
            if (Validator.isNotEmpty(sysDeptType.getStatus())) {
                if (sysDeptType.getStatus().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.status", sysDeptType.getStatus().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.status", sysDeptType.getStatus());
                }
            }
        }
        return baseMapper.select(queryWrapper);
    }

    @Override
    public List<Tree> selectAll() {
        return baseMapper.selectAll(CommonStatus.ENABLE.getCode());
    }

    @Override
    public SysDeptType get(String id) {
        SysDeptType sysDeptType = baseMapper.getById(id);
        if (sysDeptType != null) {
            sysDeptType.setRoleIdList(baseMapper.selectRoles(id));
        }
        return sysDeptType;
    }

    @Override
    public SysDeptType add(String parentId) {
        SysDeptType sysDeptType = new SysDeptType();
        sysDeptType.setParentId(parentId);
        sysDeptType.setStatus(CommonStatus.ENABLE.getCode());
        sysDeptType.setOrderNo(baseMapper.getMaxOrderNo(parentId) + 1);
        return sysDeptType;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        ToolUtil.checkParams(ids);
        // 检查是否有子部门
        QueryWrapper<SysDeptType> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("parent_id", ids.split(CommonConst.SPLIT));
        long count = count(queryWrapper);
        if (count > 0) {
            throw new EasyException(GlobalException.EXIST_CHILD.getMessage());
        }
        // 检查部门类型下是否有部门
        count = sysDeptService.selectCountByTypeIds(ids);
        if (count > 0) {
            throw new EasyException("要删除的类型中包含 " + count + " 个部门信息，请删除部门信息后重试");
        }
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        boolean isSuccess = removeByIds(idList);
        if (isSuccess) {
            // 删除部门类型可选择的角色
            departmentTypeRoleService.removeDeptTypeRoleByDeptTypeIds(ids);
        }
        return isSuccess;
    }

    @Override
    public boolean setStatus(String ids, String status) {
        ToolUtil.checkParams(ids);
        ToolUtil.checkParams(status);
        UpdateWrapper<SysDeptType> updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("id", ids.split(CommonConst.SPLIT));
        updateWrapper.set("status", status);
        return ToolUtil.checkResult(update(updateWrapper));
    }


    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysDeptType saveData(SysDeptType object) {
        ToolUtil.checkParams(object);
        // 是否是修改了编码
        boolean isModifyCode = false;
        SysDeptType oldDeptType = null;
        if (StrUtil.isNotBlank(object.getId())) {
            oldDeptType = getById(object.getId());
            if (oldDeptType != null) {
                isModifyCode = !oldDeptType.getCode().equals(object.getCode());
            }
        }
        // 部门类型代码不能重复
        QueryWrapper<SysDeptType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", object.getCode());
        if (Validator.isNotEmpty(object.getId())) {
            queryWrapper.ne("id", object.getId());
        }
        long count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new EasyException("部门类型代码 " + object.getCode() + " 已存在");
        }

        if (object.getOrderNo() == null) {
            object.setOrderNo(baseMapper.getMaxOrderNo(object.getParentId()) + 1);
        }
        boolean isSuccess = saveOrUpdate(object);
        if (isSuccess) {
            departmentTypeRoleService.saveDeptTypeRole(object.getId(), object.getRoleIdList());
            // 如果修改了部门类型代码，需要将sys_dept(部门)表中的typeCode一并修改
            if (isModifyCode) {
                sysDeptService.updateDeptTypeCode(oldDeptType.getCode(), object.getCode());
            }
        }
        return (SysDeptType) ToolUtil.checkResult(isSuccess, object);
    }

    @Override
    public boolean checkDeptTypeIsDisabled(String code) {
        QueryWrapper<SysDeptType> checkDeptTypeIsDisabled = new QueryWrapper<>();
        checkDeptTypeIsDisabled.select("status");
        checkDeptTypeIsDisabled.eq("code", code);
        SysDeptType sysDeptType = getOne(checkDeptTypeIsDisabled);
        if (sysDeptType == null) {
            throw new EasyException("部门类型[" + code + "]被删除，请联系管理员");
        }
        return CommonStatus.DISABLE.getCode().equals(sysDeptType.getStatus());
    }

    @Override
    public boolean saveOrder(List<SysDeptType> sysDeptTypeList) {
        return baseMapper.updateOrderBatch(sysDeptTypeList) > 0;
    }
}
