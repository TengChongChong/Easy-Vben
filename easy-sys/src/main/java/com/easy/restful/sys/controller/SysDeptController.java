package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.common.core.util.Response;
import com.easy.restful.sys.model.SysDept;
import com.easy.restful.sys.service.SysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 部门管理
 *
 * @author tengchong
 * @date 2018/12/3
 */
@RestController
@RequestMapping("/auth/sys/dept")
public class SysDeptController extends BaseController {

    @Autowired
    private SysDeptService service;

    /**
     * 获取指定pId下的数据
     *
     * @param pId pId
     */
    @GetMapping("pId")
    @RequiresPermissions("sys:dept:select")
    public Response selectByPId(@RequestParam(name = "pId", required = false) String pId) {
        return Response.success(service.selectByPId(pId));
    }

    /**
     * 根据名称搜索
     *
     * @param title 名称
     */
    @GetMapping("title")
    @RequiresPermissions("sys:dept:select")
    public Response selectByTitle(@RequestParam(name = "title", required = false) String title) {
        return Response.success(service.selectByTitle(title));
    }

    /**
     * 列表
     *
     * @param object 查询条件
     * @param page   分页
     */
    @GetMapping
    @RequiresPermissions("sys:dept:select")
    public Response select(SysDept object, Page<SysDept> page) {
        return Response.success(service.select(object, page));
    }

    /**
     * 新增
     *
     * @param pId      上级 id
     * @param deptType 部门类型
     */
    @GetMapping({"/add/{id}", "/add"})
    public Response add(@PathVariable(value = "id", required = false) String pId,
                        @RequestParam(value = "deptType", required = false) String deptType) {
        return Response.success(service.add(pId, deptType));
    }

    /**
     * 删除
     *
     * @param id id
     */
    @DeleteMapping("{id}")
    @RequiresPermissions("sys:dept:remove")
    public Response remove(@PathVariable("id") String id) {
        return Response.success(service.remove(id));
    }

    /**
     * 保存
     *
     * @param object 表单内容
     */
    @PostMapping
    @RequiresPermissions("sys:dept:save")
    public Response save(@Valid SysDept object) {
        return Response.success(service.saveData(object));
    }

    /**
     * 详情
     *
     * @param id id
     */
    @GetMapping("{id}")
    public Response get(@PathVariable("id") String id) {
        return Response.success(service.get(id));
    }

    /**
     * 新增/修改页面获取机构类型option
     *
     * @param pId        上级id
     * @param deptType 类型
     * @return option
     */
    @GetMapping("dept/type/option")
    public Response selectDeptTypeOption(@RequestParam("pId") String pId,@RequestParam(value = "deptType", required = false) String deptType){
        return Response.success(service.selectDeptTypeOption(pId, deptType));
    }

    /**
     * 新增/修改页面获取父部门option
     *
     * @param pId      上级部门id
     * @param deptType 部门类型
     * @return List<Select>
     */
    @GetMapping("up/dept/option")
    public Response selectUpDeptOption(@RequestParam("pId") String pId,@RequestParam(value = "deptType", required = false) String deptType){
        return Response.success(service.selectUpDeptOption(pId, deptType));
    }

    /**
     * 查询部门 Activiti
     *
     * @param sysDept 查询条件
     */
    @GetMapping("/departments")
    public Response selectDepartments(SysDept sysDept) {
        return Response.success(service.selectDepartments(sysDept));
    }
}
