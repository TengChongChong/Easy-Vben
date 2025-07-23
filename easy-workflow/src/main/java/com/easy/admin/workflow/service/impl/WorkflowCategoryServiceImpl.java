package com.easy.admin.workflow.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.workflow.dao.WorkflowCategoryMapper;
import com.easy.admin.workflow.model.WorkflowCategory;
import com.easy.admin.workflow.model.vo.WorkflowCategoryVO;
import com.easy.admin.workflow.service.WorkflowCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 流程分类
 *
 * @author 系统管理员
 * @date 2025-07-12
 */
@Service
public class WorkflowCategoryServiceImpl extends ServiceImpl<WorkflowCategoryMapper, WorkflowCategory> implements WorkflowCategoryService {


    @Override
    public List<WorkflowCategoryVO> select(WorkflowCategoryVO workflowCategory) {
        QueryWrapper<WorkflowCategory> queryWrapper = getQueryWrapper(workflowCategory);
        return baseMapper.selectWithoutPage(queryWrapper);
    }

    @Override
    public List<Tree> selectAll() {
        return baseMapper.selectAll();
    }

    private QueryWrapper<WorkflowCategory> getQueryWrapper(WorkflowCategoryVO workflowCategory) {
        QueryWrapper<WorkflowCategory> queryWrapper = new QueryWrapper<>();
        if (workflowCategory != null) {
            // 查询条件
            // 分类名称
            if (Validator.isNotEmpty(workflowCategory.getName())) {
                queryWrapper.like("t.name", workflowCategory.getName());
            }
            // 分类编码
            if (Validator.isNotEmpty(workflowCategory.getCode())) {
                queryWrapper.like("t.code", workflowCategory.getCode());
            }
            // 状态
            if (Validator.isNotEmpty(workflowCategory.getStatus())) {
                if (workflowCategory.getStatus().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.status", workflowCategory.getStatus().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.status", workflowCategory.getStatus());
                }
            }
        }
        return queryWrapper;
    }

    @Override
    public WorkflowCategoryVO get(String id) {
        WorkflowCategory workflowCategory = baseMapper.getById(id);
        if (workflowCategory == null) {
            return null;
        }
        WorkflowCategoryVO workflowCategoryVO = new WorkflowCategoryVO();
        BeanUtil.copyProperties(workflowCategory, workflowCategoryVO);
        // 查询其他相关业务数据
        return workflowCategoryVO;
    }

    @Override
    public WorkflowCategoryVO add(String parentId) {
        WorkflowCategoryVO workflowCategory = new WorkflowCategoryVO();
        // 设置默认值
        if (Validator.isNotEmpty(parentId)) {
            WorkflowCategory parentWorkflowCategory = getById(parentId);
            if (parentWorkflowCategory != null) {
                workflowCategory.setParentId(parentId);
                //workflowCategory.setOrderNo(baseMapper.getMaxOrderNo(parentId) + 1);
            }
        }
        workflowCategory.setOrderNo(baseMapper.getMaxOrderNo(parentId) + 1);
        workflowCategory.setStatus(CommonStatus.ENABLE.getCode());
        return workflowCategory;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        // todo: 检查分类下是否包含流程模型
        return removeByIds(idList);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public WorkflowCategoryVO saveData(WorkflowCategoryVO workflowCategoryVO) {
        if (Validator.isEmpty(workflowCategoryVO.getId())) {
            // 新增,设置默认值
        }
        // 新增时设置排序值
        if (StrUtil.isBlank(workflowCategoryVO.getId()) && workflowCategoryVO.getOrderNo() == null) {
            workflowCategoryVO.setOrderNo(baseMapper.getMaxOrderNo(workflowCategoryVO.getParentId()) + 1);
        }
        WorkflowCategory workflowCategory = new WorkflowCategory();
        BeanUtil.copyProperties(workflowCategoryVO, workflowCategory);
        boolean isSuccess = saveOrUpdate(workflowCategory);
        if (!isSuccess) {
            throw new EasyException(GlobalException.LOCK_ERROR);
        }
        // 同步保存后的id到VO
        workflowCategoryVO.setId(workflowCategory.getId());

        // 保存其他相关业务数据

        return workflowCategoryVO;
    }

    @Override
    public boolean saveOrder(List<WorkflowCategory> workflowCategoryList) {
        return baseMapper.updateOrderBatch(workflowCategoryList) > 0;
    }
}