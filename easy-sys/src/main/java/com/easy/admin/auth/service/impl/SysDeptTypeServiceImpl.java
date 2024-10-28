package com.easy.admin.auth.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.dao.SysDeptTypeMapper;
import com.easy.admin.auth.model.SysDeptType;
import com.easy.admin.auth.model.vo.SysDeptTypeVO;
import com.easy.admin.auth.service.SysDeptService;
import com.easy.admin.auth.service.SysDeptTypeRoleService;
import com.easy.admin.auth.service.SysDeptTypeService;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.common.core.util.ToolUtil;
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
    public SysDeptTypeVO get(String id) {
        SysDeptType sysDeptType = baseMapper.getById(id);
        if (sysDeptType == null) {
            return null;
        }
        SysDeptTypeVO sysDeptTypeVO = new SysDeptTypeVO();
        BeanUtil.copyProperties(sysDeptType, sysDeptTypeVO);
        sysDeptTypeVO.setRoleIdList(baseMapper.selectRoles(id));
        return sysDeptTypeVO;
    }

    @Override
    public SysDeptTypeVO add(String parentId) {
        SysDeptTypeVO sysDeptType = new SysDeptTypeVO();
        sysDeptType.setParentId(parentId);
        sysDeptType.setStatus(CommonStatus.ENABLE.getCode());
        sysDeptType.setOrderNo(baseMapper.getMaxOrderNo(parentId) + 1);
        return sysDeptType;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
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
            throw new EasyException("删除的部门类型下有 " + count + " 个部门信息，请删除部门信息后重试");
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
        UpdateWrapper<SysDeptType> updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("id", ids.split(CommonConst.SPLIT));
        updateWrapper.set("status", status);
        return ToolUtil.checkResult(update(updateWrapper));
    }


    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysDeptTypeVO saveData(SysDeptTypeVO sysDeptTypeVO) {
        SysDeptType sysDeptType = new SysDeptType();
        BeanUtil.copyProperties(sysDeptTypeVO, sysDeptType);

        // 是否是修改了编码
        boolean isModifyCode = false;
        SysDeptType oldDeptType = null;
        if (StrUtil.isNotBlank(sysDeptType.getId())) {
            oldDeptType = getById(sysDeptType.getId());
            if (oldDeptType != null) {
                isModifyCode = !oldDeptType.getCode().equals(sysDeptType.getCode());
            }
        }
        // 部门类型代码不能重复
        QueryWrapper<SysDeptType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", sysDeptType.getCode());
        if (Validator.isNotEmpty(sysDeptType.getId())) {
            queryWrapper.ne("id", sysDeptType.getId());
        }
        long count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new EasyException("部门类型代码 " + sysDeptType.getCode() + " 已存在");
        }

        if (sysDeptType.getOrderNo() == null) {
            sysDeptType.setOrderNo(baseMapper.getMaxOrderNo(sysDeptType.getParentId()) + 1);
        }
        boolean isSuccess = saveOrUpdate(sysDeptType);
        if (isSuccess) {
            sysDeptTypeVO.setId(sysDeptType.getId());
            departmentTypeRoleService.saveDeptTypeRole(sysDeptType.getId(), sysDeptTypeVO.getRoleIdList());
            // 如果修改了部门类型代码，需要将sys_dept(部门)表中的typeCode一并修改
            if (isModifyCode) {
                sysDeptService.updateDeptTypeCode(oldDeptType.getCode(), sysDeptType.getCode());
            }
        }
        return sysDeptTypeVO;
    }

    @Override
    public boolean checkDeptTypeIsDisabled(String code) {
        String status = baseMapper.getStatusByCode(code);
        if (StrUtil.isBlank(status)) {
            throw new EasyException("部门类型[" + code + "]被删除，请联系管理员");
        }
        return CommonStatus.DISABLE.getCode().equals(status);
    }

    @Override
    public boolean saveOrder(List<SysDeptType> sysDeptTypeList) {
        return baseMapper.updateOrderBatch(sysDeptTypeList) > 0;
    }
}
