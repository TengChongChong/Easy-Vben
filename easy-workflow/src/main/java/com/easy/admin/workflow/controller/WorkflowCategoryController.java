package com.easy.admin.workflow.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.easy.admin.common.core.annotation.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import com.easy.admin.common.core.common.tree.Tree;
import org.springframework.web.bind.annotation.GetMapping;
import com.easy.admin.common.core.common.pagination.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import com.easy.admin.workflow.model.WorkflowCategory;
import com.easy.admin.workflow.model.vo.WorkflowCategoryVO;
import com.easy.admin.workflow.service.WorkflowCategoryService;

/**
 * 流程分类
 *
 * @author 系统管理员
 * @date 2025-07-12
 */
@Tag(name = "流程分类")
@RestController
@ResponseResult
@RequestMapping("/api/auth/workflow/category")
public class WorkflowCategoryController {

    /**
     * 流程分类 service
     */
    @Autowired
    private WorkflowCategoryService service;

    /**
     * 查询数据（无分页）
     *
     * @param workflowCategory 查询条件
     * @return List<WorkflowCategoryVO>
     */
    @Operation(summary ="查询数据（无分页）")
    @GetMapping()
    @SaCheckPermission("workflow:category:select")
    public List<WorkflowCategoryVO> select(WorkflowCategoryVO workflowCategory){
        return service.select(workflowCategory);
    }

    /**
     * 查询所有数据（Tree）
     *
     * @return List<Tree>
     */
    @Operation(summary ="查询所有数据（Tree）")
    @GetMapping("all")
    @SaCheckPermission("workflow:category:select")
    public List<Tree> selectAll() {
        return service.selectAll();
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return WorkflowCategoryVO
     */
    @Operation(summary ="查询详情")
    @GetMapping("{id}")
    @SaCheckPermission("workflow:category:select")
    public WorkflowCategoryVO get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增或新增下级
     *
     * @param parentId 上级id
     * @return WorkflowCategoryVO
     */
    @Operation(summary ="新增或新增下级")
    @GetMapping({"/add/{parentId}", "/add"})
    @SaCheckPermission("workflow:category:save")
    public WorkflowCategoryVO add(@PathVariable(value = "parentId", required = false) String parentId) {
        return service.add(parentId);
    }
    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @Operation(summary ="删除")
    @DeleteMapping("{ids}")
    @SaCheckPermission("workflow:category:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存/修改
     *
     * @param workflowCategoryVO 表单内容
     * @return WorkflowCategoryVO
     */
    @Operation(summary ="保存/修改")
    @PostMapping()
    @SaCheckPermission("workflow:category:save")
    public WorkflowCategoryVO saveData(@Valid @RequestBody WorkflowCategoryVO workflowCategoryVO){
        return service.saveData(workflowCategoryVO);
    }
    /**
     * 保存排序&结构
     *
     * @param workflowCategoryList 排序&结构
     * @return true/false
     */
    @PostMapping("order")
    @SaCheckPermission("workflow:category:save")
    public boolean saveOrder(@RequestBody List<WorkflowCategory> workflowCategoryList){
        return service.saveOrder(workflowCategoryList);
    }
}
