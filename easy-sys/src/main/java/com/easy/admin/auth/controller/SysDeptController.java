package com.easy.admin.auth.controller;

import com.easy.admin.auth.model.SysDept;
import com.easy.admin.auth.service.SysDeptService;
import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.core.annotation.ResponseResult;
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
@RequestMapping("/api/auth/sys/dept")
public class SysDeptController extends BaseController {

    @Autowired
    private SysDeptService service;

    /**
     * 列表
     *
     * @param object 查询条件
     * @return List<SysDept>
     */
    @GetMapping
    @RequiresPermissions("sys:dept:select")
    public List<SysDept> select(SysDept object) {
        return service.select(object);
    }

    /**
     * 获取全部数据
     *
     * @return List<Tree>
     */
    @GetMapping("all")
    public List<Tree> selectAll() {
        return service.selectAll();
    }

    /**
     * 新增
     *
     * @param parentId      上级 id
     * @param typeCode 部门类型
     * @return SysDept
     */
    @GetMapping({"/add/{id}", "/add"})
    @RequiresPermissions("sys:dept:save")
    public SysDept add(@PathVariable(value = "id", required = false) String parentId,
                       @RequestParam(value = "typeCode", required = false) String typeCode) {
        return service.add(parentId, typeCode);
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
    @RequiresPermissions("sys:dept:save")
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
     * 保存排序
     *
     * @param sysDeptList 排序
     * @return true/false
     */
    @PostMapping("order")
    @RequiresPermissions("sys:dept:save")
    public boolean saveOrder(@RequestBody List<SysDept> sysDeptList){
        return service.saveOrder(sysDeptList);
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
