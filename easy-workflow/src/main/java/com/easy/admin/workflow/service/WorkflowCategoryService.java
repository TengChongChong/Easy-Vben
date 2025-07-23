package com.easy.admin.workflow.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.workflow.model.WorkflowCategory;
import com.easy.admin.workflow.model.vo.WorkflowCategoryVO;

/**
 * 流程分类
 *
 * @author 系统管理员
 * @date 2025-07-12
 */
public interface WorkflowCategoryService extends IService<WorkflowCategory> {

    /**
     * 查询数据（无分页）
     *
     * @param workflowCategory 查询条件
     * @return List<WorkflowCategoryVO>
     */
    List<WorkflowCategoryVO> select(WorkflowCategoryVO workflowCategory);

    /**
     * 查询所有数据（Tree）
     *
     * @return List<Tree>
     */
    List<Tree> selectAll();

    /**
     * 查询详情
     *
     * @param id id
     * @return WorkflowCategoryVO
     */
    WorkflowCategoryVO get(String id);

    /**
     * 新增或新增下级
     * @param parentId 上级id
     * @return WorkflowCategoryVO
     */
    WorkflowCategoryVO add(String parentId);

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 保存排序
     *
     * @param workflowCategoryList 排序
     * @return true/false
     */
    boolean saveOrder(List<WorkflowCategory> workflowCategoryList);

    /**
     * 保存/修改
     *
     * @param workflowCategoryVO 表单内容
     * @return WorkflowCategoryVO
     */
    WorkflowCategoryVO saveData(WorkflowCategoryVO workflowCategoryVO);
}
