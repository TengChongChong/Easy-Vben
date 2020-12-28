package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.common.core.common.select.Select;
import com.easy.restful.common.core.common.tree.Tree;
import com.easy.restful.core.annotation.ResponseResult;
import com.easy.restful.sys.model.SysDept;
import com.easy.restful.sys.service.SysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 部门管理
 *
 * @author tengchong
 * @date 2018/12/3
 */
@RestController
@ResponseResult
@RequestMapping("/auth/sys/dept")
public class SysDeptController extends BaseController {

    @Autowired
    private SysDeptService service;

    /**
     * 获取指定pId下的数据
     *
     * @param pId pId
     * @return List<Tree>
     */
    @GetMapping("pId")
    @RequiresPermissions("sys:dept:select")
    public List<Tree> selectByPId(@RequestParam(name = "pId", required = false) String pId) {
        return service.selectByPId(pId);
    }

    /**
     * 根据名称搜索
     *
     * @param title 名称
     * @return List<Tree>
     */
    @GetMapping("title")
    @RequiresPermissions("sys:dept:select")
    public List<Tree> selectByTitle(@RequestParam(name = "title", required = false) String title) {
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
     * @param pId      上级 id
     * @param deptType 部门类型
     * @return SysDept
     */
    @GetMapping({"/add/{id}", "/add"})
    public SysDept add(@PathVariable(value = "id", required = false) String pId,
                       @RequestParam(value = "deptType", required = false) String deptType) {
        return service.add(pId, deptType);
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
     * @param pId      上级id
     * @param deptType 类型
     * @return List<Select>
     */
    @GetMapping("dept/type/option")
    public List<Select> selectDeptTypeOption(@RequestParam("pId") String pId, @RequestParam(value = "deptType", required = false) String deptType) {
        return service.selectDeptTypeOption(pId, deptType);
    }

    /**
     * 新增/修改页面获取父部门option
     *
     * @param pId      上级部门id
     * @param deptType 部门类型
     * @return List<Select>
     */
    @GetMapping("up/dept/option")
    public List<Select> selectUpDeptOption(@RequestParam("pId") String pId, @RequestParam(value = "deptType", required = false) String deptType) {
        return service.selectUpDeptOption(pId, deptType);
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
