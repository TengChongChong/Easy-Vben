package com.easy.admin.sys.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.common.tree.TreeUtil;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.sys.dao.SysDeptTypeMapper;
import com.easy.admin.sys.model.SysDeptType;
import com.easy.admin.sys.service.SysDeptService;
import com.easy.admin.sys.service.SysDeptTypeRoleService;
import com.easy.admin.sys.service.SysDeptTypeService;
import com.easy.admin.util.SysConfigUtil;
import com.easy.admin.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    public boolean checkHasChild(String code) {
        return baseMapper.selectChildCount(code) > 0;
    }

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
    public List<Tree> selectAll() {
        List<Tree> trees = baseMapper.selectAll(CommonStatus.ENABLE.getCode());
        Tree tree = new Tree();
        tree.setId(TreeUtil.BASE_ID);
        tree.setIcon(CommonConst.DEFAULT_FOLDER_ICON);
        tree.setTitle(SysConfigUtil.getProjectName());
        trees.add(tree);
        return trees;
    }

    @Override
    public SysDeptType get(String id) {
        SysDeptType sysDeptType;
        // 表示点击的是根目录
        if (id == null || id.equals(TreeUtil.BASE_ID)) {
            sysDeptType = new SysDeptType();
            sysDeptType.setId(TreeUtil.BASE_ID);
            sysDeptType.setName(SysConfigUtil.getProjectName());
        } else {
            sysDeptType = baseMapper.selectInfo(id);
            if (sysDeptType != null) {
                if (sysDeptType.getpId().equals(TreeUtil.BASE_ID)) {
                    sysDeptType.setpName(SysConfigUtil.getProjectName());
                }
                sysDeptType.setRoles(baseMapper.selectRoles(id));
            }
        }
        return sysDeptType;
    }

    @Override
    public SysDeptType add(String pId) {
        if (pId != null) {
            SysDeptType sysDeptType = new SysDeptType();
            sysDeptType.setpId(pId);
            sysDeptType.setStatus(CommonStatus.ENABLE.getCode());
            if (TreeUtil.BASE_ID.equals(pId)) {
                sysDeptType.setpName(SysConfigUtil.getProjectName());
            } else {
                SysDeptType parentSysDeptType = getById(pId);
                if (parentSysDeptType != null) {
                    sysDeptType.setpName(parentSysDeptType.getName());
                }
            }
            return sysDeptType;
        } else {
            throw new EasyException("获取父部门类型信息失败，请重试");
        }
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String id) {
        ToolUtil.checkParams(id);
        // 检查是否有子部门类型
        QueryWrapper<SysDeptType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p_id", id);
        int count = count(queryWrapper);
        if (count > 0) {
            throw new EasyException(GlobalException.EXIST_CHILD.getMessage());
        }
        // 检查部门类型下是否有部门
        count = sysDeptService.selectCountByTypeIds(id);
        if (count > 0) {
            throw new EasyException("要删除的类型中包含 " + count + " 个部门信息，请删除部门信息后重试");
        }
        boolean isSuccess = removeById(id);
        if (isSuccess) {
            // 删除部门类型可选择的角色
            departmentTypeRoleService.removeDeptTypeRole(id);
        }
        return isSuccess;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean batchRemove(String ids) {
        ToolUtil.checkParams(ids);
        // 检查是否有子部门
        QueryWrapper<SysDeptType> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("p_id", ids.split(CommonConst.SPLIT));
        int count = count(queryWrapper);
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
        if (object.getId() != null) {
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
        int count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new EasyException("部门类型代码 " + object.getCode() + " 已存在");
        }

        if (object.getOrderNo() == null) {
            object.setOrderNo(baseMapper.getMaxOrderNo(object.getpId()) + 1);
        }
        boolean isSuccess = saveOrUpdate(object);
        if (isSuccess) {
            departmentTypeRoleService.saveDeptTypeRole(object.getId(), object.getRoles());
            // 如果修改了部门类型代码，需要将sys_dept(部门)表中的typeCode一并修改
            if (isModifyCode) {
                sysDeptService.updateDeptTypeCode(oldDeptType.getCode(), object.getCode());
            }
        }
        return (SysDeptType) ToolUtil.checkResult(isSuccess, object);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean move(String id, String parent, String oldParent, Integer position, Integer oldPosition) {
        if (Validator.isNotEmpty(id) && Validator.isNotEmpty(parent) && Validator.isNotEmpty(oldParent) &&
                Validator.isNotEmpty(position) && Validator.isNotEmpty(oldPosition)) {
            // 如部门类型下有部门信息,不允许拖动
            // 会导致部门数据上下层级错误
            int count = sysDeptService.selectCountByTypeIds(String.valueOf(id));
            if (count > 0) {
                throw new EasyException("要拖动的类型中包含 " + count + " 个部门信息，请删除部门信息后重试");
            }

            boolean isSuccess;
            // 没有改变所属节点,内部排序
            if (parent.equals(oldParent)) {
                // 拖动影响节点顺序的开始序号
                int str = Math.min(position, oldPosition);
                // 拖动影响顺序节点数量
                int length = Math.abs(position - oldPosition) + 1;
                List<SysDeptType> oldSysDeptType = baseMapper.selectOrderInfo(parent, str, length);
                List<SysDeptType> newSysDeptType = new ArrayList<>();
                // 是否需要偏移
                boolean needDeviation = false;
                // 偏移量
                int deviation;
                if (position > oldPosition) {
                    deviation = -1;
                } else {
                    deviation = 1;
                }
                for (int i = 0; i < oldSysDeptType.size(); i++) {
                    if ((i + str) == position) {
                        newSysDeptType.add(new SysDeptType(id, oldSysDeptType.get(i).getOrderNo()));
                        newSysDeptType.add(new SysDeptType(oldSysDeptType.get(i).getId(), oldSysDeptType.get(i + deviation).getOrderNo()));
                        needDeviation = true;
                    } else {
                        if ((i + str) == oldPosition) {
                            needDeviation = true;
                        }
                        if (!id.equals(oldSysDeptType.get(i).getId())) {
                            newSysDeptType.add(new SysDeptType(oldSysDeptType.get(i).getId(), oldSysDeptType.get(i + (needDeviation ? deviation : 0)).getOrderNo()));
                        }
                    }
                }
                isSuccess = updateBatchById(newSysDeptType);
            } else {
                List<SysDeptType> oldSysDeptType = baseMapper.selectOrderInfo(parent, null, null);
                List<SysDeptType> newSysDeptType = new ArrayList<>();
                // 是否需要偏移
                boolean needDeviation = false;
                // 偏移量
                int deviation = 1;
                // 放到了最后一个
                if (position == oldSysDeptType.size()) {
                    if (oldSysDeptType.isEmpty()) {
                        newSysDeptType.add(new SysDeptType(id, parent, 1));
                    } else {
                        newSysDeptType.add(new SysDeptType(id, parent, oldSysDeptType.get(oldSysDeptType.size() - 1).getOrderNo() + 1));
                    }
                } else {
                    for (int i = 0; i < oldSysDeptType.size(); i++) {
                        if (i == position) {
                            newSysDeptType.add(new SysDeptType(id, parent, oldSysDeptType.get(i).getOrderNo()));
                            newSysDeptType.add(new SysDeptType(oldSysDeptType.get(i).getId(), oldSysDeptType.get(i).getOrderNo() + 1));
                            needDeviation = true;
                        } else {
                            newSysDeptType.add(new SysDeptType(oldSysDeptType.get(i).getId(), oldSysDeptType.get(i).getOrderNo() + (needDeviation ? deviation : 0)));
                        }
                    }
                }
                isSuccess = updateBatchById(newSysDeptType);
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
    public List<Select> selectOptionBySameLevel(String code) {
        if (Validator.isNotEmpty(code)) {
            return baseMapper.selectOptionBySameLevel(code);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Select> selectOptionByParentCode(String parentCode) {
        if (Validator.isNotEmpty(parentCode)) {
            return baseMapper.selectOptionByParentCode(parentCode);
        } else {
            return Collections.emptyList();
        }
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
}
