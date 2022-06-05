package com.easy.admin.auth.controller;

import com.easy.admin.auth.model.SysDeptType;
import com.easy.admin.auth.service.SysDeptTypeService;
import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.core.annotation.ResponseResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 部门类型管理
 *
 * @author TengChongChong
 * @date 2018/12/3
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/dept/type")
public class SysDeptTypeController extends BaseController {

    @Autowired
    private SysDeptTypeService service;

    /**
     * 查询数据
     *
     * @param sysDeptType 查询条件
     * @return Page<SysDeptType>
     */
    @GetMapping()
    @RequiresPermissions("sys:dept:type:select")
    public List<SysDeptType> select(SysDeptType sysDeptType) {
        return service.select(sysDeptType);
    }

    /**
     * 新增
     *
     * @param parentId 上级部门类型 id
     * @return SysDeptType
     */
    @GetMapping({"add/{id}", "add"})
    public SysDeptType add(@PathVariable(value = "id", required = false) String parentId) {
        return service.add(parentId);
    }

    /**
     * 批量删除
     *
     * @param ids 部门类型ids
     * @return true/false
     */
    @DeleteMapping("{id}")
    @RequiresPermissions("sys:dept:type:remove")
    public boolean remove(@PathVariable("id") String ids) {
        return service.remove(ids);
    }

    /**
     * 设置状态
     *
     * @param ids 部门类型ids
     * @return true/false
     */
    @PostMapping("{id}/status/{status}")
    @RequiresPermissions("sys:dept:type:save")
    public boolean setStatus(@PathVariable("id") String ids, @PathVariable("status") String status) {
        return service.setStatus(ids, status);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysDeptType
     */
    @PostMapping
    @RequiresPermissions("sys:dept:type:save")
    public SysDeptType save(@RequestBody @Valid SysDeptType object) {
        return service.saveData(object);
    }

    /**
     * 详情
     *
     * @param id 部门类型 id
     * @return SysDeptType
     */
    @GetMapping("{id}")
    public SysDeptType get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 获取全部数据
     *
     * @return List<Tree>
     */
    @GetMapping("all")
    @RequiresPermissions("sys:dept:type:select")
    public List<Tree> selectAll() {
        return service.selectAll();
    }


    /**
     * 保存排序
     *
     * @param sysDeptTypeList 排序
     * @return true/false
     */
    @PostMapping("order")
    @RequiresPermissions("sys:dept:type:save")
    public boolean saveOrder(@RequestBody List<SysDeptType> sysDeptTypeList){
        return service.saveOrder(sysDeptTypeList);
    }
}
