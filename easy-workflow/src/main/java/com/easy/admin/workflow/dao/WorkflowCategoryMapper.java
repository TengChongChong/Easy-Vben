package com.easy.admin.workflow.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;
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
public interface WorkflowCategoryMapper extends BaseMapper<WorkflowCategory> {

    /**
     * 查询数据（无分页）
     *
     * @param queryWrapper 查询条件
     * @return List<WorkflowCategory>
     */
    List<WorkflowCategoryVO> selectWithoutPage(@Param("ew") QueryWrapper<WorkflowCategory> queryWrapper);

    /**
     * 查询所有数据（Tree）
     * @return List<JsTree>
     */
    List<Tree> selectAll();

    /**
     * 查询详情
     *
     * @param id id
     * @return WorkflowCategory
     */
    WorkflowCategory getById(@Param("id") String id);
    /**
     * 获取parentId下子级最大排序值
     *
     * @param parentId parentId
     * @return int
     */
    int getMaxOrderNo(@Param("parentId") String parentId);
    /**
     * 保存排序&结构
     *
     * @param list 数据
     * @return 更新条数
     */
    Integer updateOrderBatch(List<WorkflowCategory> list);

}