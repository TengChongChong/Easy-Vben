package com.easy.admin.auth.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.dao.SysDeptMapper;
import com.easy.admin.auth.model.SysDept;
import com.easy.admin.auth.service.SysDeptService;
import com.easy.admin.auth.service.SysUserService;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 部门管理
 *
 * @author TengChongChong
 * @date 2018/12/3
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public List<Tree> selectAll() {
        return baseMapper.selectAll(CommonStatus.ENABLE.getCode());
    }

    @Override
    public List<SysDept> select(SysDept sysDept) {
        QueryWrapper<SysDept> queryWrapper = new QueryWrapper<>();
        if (sysDept != null) {
            if (Validator.isNotEmpty(sysDept.getName())) {
                queryWrapper.like("t.name", sysDept.getName());
            }
            if (Validator.isNotEmpty(sysDept.getTypeCode())) {
                queryWrapper.eq("t.type_code", sysDept.getTypeCode());
            }
            if (Validator.isNotEmpty(sysDept.getStatus())) {
                queryWrapper.eq("t.status", sysDept.getStatus());
            }
            if (Validator.isNotEmpty(sysDept.getCode())) {
                queryWrapper.like("t.code", sysDept.getCode());
            }
        }
        return baseMapper.select(queryWrapper);
    }

    @Override
    public SysDept get(String id) {
        ToolUtil.checkParams(id);
        return getById(id);
    }

    @Override
    public SysDept add(String parentId, String typeCode) {
        SysDept object = new SysDept();
        if (Validator.isNotEmpty(parentId)) {
            SysDept parentDept = getById(parentId);
            if (parentDept != null) {
                object.setParentId(parentId);
                object.setOrderNo(baseMapper.getMaxOrderNo(object.getParentId()) + 1);
            }
        }
        if (Validator.isNotEmpty(typeCode)) {
            object.setTypeCode(typeCode);
        }
        object.setStatus(CommonStatus.ENABLE.getCode());
        return object;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        ToolUtil.checkParams(ids);
        // 检查是否有子节点
        QueryWrapper<SysDept> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("parent_id", ids.split(CommonConst.SPLIT));
        long count = count(queryWrapper);
        if (count > 0) {
            throw new EasyException(GlobalException.EXIST_CHILD.getMessage());
        }
        // 检查部门下是否有用户
        long userCount = sysUserService.countUser(ids);
        if (userCount > 0) {
            throw new EasyException("所选部门中包含 " + userCount + " 个用户，请移除后重试");
        }
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        return removeByIds(idList);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysDept saveData(SysDept object) {
        // 部门编码不能重复
        if (Validator.isNotEmpty(object.getCode())) {
            QueryWrapper<SysDept> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("code", object.getCode());
            if (StrUtil.isNotBlank(object.getId())) {
                queryWrapper.ne("id", object.getId());
            }
            long count = baseMapper.selectCount(queryWrapper);
            if (count > 0) {
                throw new EasyException("已存在编码为[" + object.getCode() + "]的部门，请修改后重试");
            }
        }
        if(StrUtil.isNotBlank(object.getParentId()) && object.getParentId().equals(object.getId())){
            throw new EasyException("上级部门不能为自己");
        }
        if (object.getOrderNo() == null) {
            object.setOrderNo(baseMapper.getMaxOrderNo(object.getParentId()) + 1);
        }
        return (SysDept) ToolUtil.checkResult(saveOrUpdate(object), object);
    }

    @Override
    public boolean saveOrder(List<SysDept> sysDeptList) {
        return baseMapper.updateOrderBatch(sysDeptList) > 0;
    }

    @Override
    public int selectCountByTypeIds(String typeIds) {
        if (Validator.isNotEmpty(typeIds)) {
            QueryWrapper<SysDept> queryWrapper = new QueryWrapper<>();
            if (typeIds.contains(CommonConst.SPLIT)) {
                queryWrapper.in("dt.id", typeIds.split(CommonConst.SPLIT));
            } else {
                queryWrapper.eq("dt.id", typeIds);
            }
            return baseMapper.selectCountByTypeIds(queryWrapper);
        }
        return 0;
    }

    @Override
    public boolean updateDeptTypeCode(String oldCode, String newCode) {
        SysDept sysDept = new SysDept();
        sysDept.setTypeCode(newCode);
        QueryWrapper<SysDept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type_code", oldCode);
        return update(sysDept, queryWrapper);
    }

    @Override
    public List<SysDept> selectDepartments(SysDept sysDept) {
        QueryWrapper<SysDept> queryWrapper = new QueryWrapper<>();
        if (sysDept != null) {
            if (StrUtil.isNotBlank(sysDept.getName())) {
                queryWrapper.like("sd.name", sysDept.getName());
            }
        }
        queryWrapper.eq("sd.status", CommonStatus.ENABLE.getCode());
        return baseMapper.selectDepartments(queryWrapper);
    }

    @Override
    public boolean setStatus(String ids, String status) {
        ToolUtil.checkParams(ids);
        ToolUtil.checkParams(status);
        List<SysDept> deptList = new ArrayList<>();
        SysDept sysDept;
        for (String id : ids.split(CommonConst.SPLIT)) {
            sysDept = new SysDept();
            sysDept.setId(id);
            sysDept.setStatus(status);
            deptList.add(sysDept);
        }
        return ToolUtil.checkResult(updateBatchById(deptList));
    }
}
