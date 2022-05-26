package com.easy.admin.auth.controller;

import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.auth.model.SysDept;
import com.easy.admin.auth.service.SysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 部门管理
 *
 * @author TengChongChong
 * @date 2018/12/3
 */
@RestController
@ResponseResult
@RequestMapping("/auth/sys/dept")
public class SysDeptController extends BaseController {

    @Autowired
    private SysDeptService service;

    /**
     * 获取指定parentId下的数据
     *
     * @param parentId parentId
     * @return List<Tree>
     */
    @GetMapping("parentId")
    @RequiresPermissions("sys:dept:select")
    public List<Tree> selectByParentId(@RequestParam(value = "parentId", required = false) String parentId) {
        return service.selectByParentId(parentId);
    }

    /**
     * 根据名称搜索s
     *
     * @param title 名称
     * @return List<Tree>
     */
    @GetMapping("title")
    @RequiresPermissions("sys:dept:select")
    public List<Tree> selectByTitle(@RequestParam("title") String title) {
        return service.selectByTitle(title);
    }

    /**
     * 列表
     *
     * @param object 查询条件
     * @param page   分页
     * @return Page<SysDept>
     */
    @GetMapping
    @RequiresPermissions("sys:dept:select")
    public Page<SysDept> select(SysDept object, Page<SysDept> page) {
        return service.select(object, page);
    }

    /**
     * 新增
     *
     * @param parentId      上级 id
     * @param deptType 部门类型
     * @return SysDept
     */
    @GetMapping({"/add/{id}", "/add"})
    public SysDept add(@PathVariable(value = "id", required = false) String parentId,
                       @RequestParam(value = "deptType", required = false) String deptType) {
        return service.add(parentId, deptType);
    }

    /**
     * 删除
     *
     * @param id id
     * @return true/false
     */
    @DeleteMapping("{id}")
    @RequiresPermissions("sys:dept:remove")
    public boolean remove(@PathVariable("id") String id) {
        return service.remove(id);
    }
    /**
     * 设置状态
     *
     * @param ids 部门类型ids
     * @return true/false
     */
    @PostMapping("{id}/status/{status}")
    @RequiresPermissions("sys:dept:type:status")
    public boolean setStatus(@PathVariable("id") String ids, @PathVariable("status") String status) {
        return service.setStatus(ids, status);
    }
    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysDept
     */
    @PostMapping
    @RequiresPermissions("sys:dept:save")
    public SysDept save(@RequestBody @Valid SysDept object) {
        return service.saveData(object);
    }

    /**
     * 详情
     *
     * @param id id
     * @return SysDept
     */
    @GetMapping("{id}")
    public SysDept get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增/修改页面获取机构类型option
     *
     * @param parentId      上级id
     * @param deptType 类型
     * @return List<Select>
     */
    @GetMapping("dept/type/option")
    public List<Select> selectDeptTypeOption(@RequestParam("parentId") String parentId, @RequestParam(value = "deptType", required = false) String deptType) {
        return service.selectDeptTypeOption(parentId, deptType);
    }

    /**
     * 新增/修改页面获取父部门option
     *
     * @param parentId      上级部门id
     * @param deptType 部门类型
     * @return List<Select>
     */
    @GetMapping("up/dept/option")
    public List<Select> selectUpDeptOption(@RequestParam("parentId") String parentId, @RequestParam(value = "deptType", required = false) String deptType) {
        return service.selectUpDeptOption(parentId, deptType);
    }

    /**
     * 查询部门 Activiti
     *
     * @param sysDept 查询条件
     * @return List<SysDept>
     */
    @GetMapping("/departments")
    public List<SysDept> selectDepartments(SysDept sysDept) {
        return service.selectDepartments(sysDept);
    }
}
