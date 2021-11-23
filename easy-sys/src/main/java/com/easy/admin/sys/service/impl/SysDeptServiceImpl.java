package com.easy.admin.sys.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.common.tree.TreeUtil;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.sys.dao.SysDeptMapper;
import com.easy.admin.sys.model.SysDept;
import com.easy.admin.sys.service.SysDeptService;
import com.easy.admin.sys.service.SysDeptTypeService;
import com.easy.admin.sys.service.SysUserService;
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
    private SysDeptTypeService sysDeptTypeService;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public List<Tree> selectByPId(String pId) {
        List<Tree> trees;
        // 第一次请求,返回项目名称 + 一级节点 数据
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
    public List<Tree> selectByTitle(String title) {
        if (Validator.isNotEmpty(title)) {
            return baseMapper.selectByTitle("%" + title + "%");
        } else {
            throw new EasyException("请输入关键字后重试");
        }
    }

    @Override
    public Page<SysDept> select(SysDept sysDept, Page<SysDept> page) {
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
            if (Validator.isNotEmpty(sysDept.getpName())) {
                queryWrapper.like("p.name", sysDept.getpName());
            }
        }
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    @Override
    public SysDept get(String id) {
        ToolUtil.checkParams(id);
        return getById(id);
    }

    @Override
    public String getName(String id) {
        QueryWrapper<SysDept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        queryWrapper.select("name");
        SysDept dept = baseMapper.selectOne(queryWrapper);
        return dept != null ? dept.getName() : "";
    }

    @Override
    public SysDept add(String pId, String deptType) {
        if (Validator.isNotEmpty(pId) || Validator.isNotEmpty(deptType)) {
            SysDept object = new SysDept();
            if (Validator.isNotEmpty(pId)) {
                SysDept parentDept = getById(pId);
                if (parentDept != null) {
                    object.setpId(pId);
                    object.setpName(parentDept.getName());
                    object.setOrderNo(baseMapper.getMaxOrderNo(object.getpId()) + 1);
                }
            }
            if (Validator.isNotEmpty(deptType)) {
                object.setTypeCode(deptType);
            }
            object.setStatus(CommonStatus.ENABLE.getCode());
            return object;
        } else {
            throw new EasyException("获取部门信息失败");
        }
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        ToolUtil.checkParams(ids);
        // 检查是否有子节点
        QueryWrapper<SysDept> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("p_id", ids.split(CommonConst.SPLIT));
        int count = count(queryWrapper);
        if (count > 0) {
            throw new EasyException(GlobalException.EXIST_CHILD.getMessage());
        }
        // 检查部门下是否有用户
        int userCount = sysUserService.countUser(ids);
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
            if (object.getId() != null) {
                queryWrapper.ne("id", object.getId());
            }
            int count = baseMapper.selectCount(queryWrapper);
            if (count > 0) {
                throw new EasyException("已存在编码为[" + object.getCode() + "]的部门，请修改后重试");
            }
        }
        if (StrUtil.isBlank(object.getpId())) {
            object.setpId(TreeUtil.BASE_ID);
        }
        if (object.getOrderNo() == null) {
            object.setOrderNo(baseMapper.getMaxOrderNo(object.getpId()) + 1);
        }
        return (SysDept) ToolUtil.checkResult(saveOrUpdate(object), object);
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
    public List<Select> selectDeptTypeOption(String pId, String deptType) {
        List<Select> option = new ArrayList<>();
        // 获取当前部门下级部门类型
        if (Validator.isNotEmpty(pId) && !pId.equals(TreeUtil.BASE_ID)) {
            SysDept sysDept = getById(pId);
            option = sysDeptTypeService.selectOptionByParentCode(sysDept.getTypeCode());
        }
        // 当前部门类型
        if (Validator.isNotEmpty(deptType)) {
            option = sysDeptTypeService.selectOptionBySameLevel(deptType);
        }
        return option;
    }

    @Override
    public List<Select> selectUpDeptOption(String pId, String deptType) {
        List<Select> option = new ArrayList<>();
        // 获取当前部门下级部门类型
        if (!pId.equals(TreeUtil.BASE_ID)) {
            SysDept sysDept = getById(pId);
            if (Validator.isNotEmpty(deptType)) {

            } else {
                option = baseMapper.selectOptionByTypeCode(sysDept.getTypeCode());
            }
        }
        // 当前部门类型
        if (Validator.isNotEmpty(deptType)) {
            option = baseMapper.selectOptionByParentTypeCode(deptType);
        }
        return option;
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
