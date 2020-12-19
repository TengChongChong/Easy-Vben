package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.util.Response;
import com.easy.restful.sys.model.DragVO;
import com.easy.restful.sys.model.SysDeptType;
import com.easy.restful.sys.service.SysDeptTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 部门类型管理
 *
 * @author tengchong
 * @date 2018/12/3
 */
@RestController
@RequestMapping("/auth/sys/dept/type")
public class SysDeptTypeController extends BaseController {

    @Autowired
    private SysDeptTypeService service;

    /**
     * 新增
     *
     * @param pId 上级部门类型 id
     */
    @GetMapping("add/{id}")
    public Response add(@PathVariable("id") String pId) {
        return Response.success(service.add(pId));
    }

    /**
     * 删除
     *
     * @param id 部门类型id
     */
    @DeleteMapping("{id}")
    @RequiresPermissions("sys:dept:type:remove")
    public Response remove(@PathVariable("id") String id) {
        return Response.success(service.remove(id));
    }

    /**
     * 批量删除
     *
     * @param ids 部门类型ids
     */
    @DeleteMapping("batch/{id}")
    @RequiresPermissions("sys:dept:type:remove")
    public Response batchRemove(@PathVariable("id") String ids) {
        return Response.success(service.batchRemove(ids));
    }

    /**
     * 设置状态
     *
     * @param ids 部门类型ids
     */
    @PostMapping("set/{id}/status/{status}")
    @RequiresPermissions("sys:dept:type:status")
    public Response setStatus(@PathVariable("id") String ids, @PathVariable("status") String status) {
        return Response.success(service.setStatus(ids, status));
    }

    /**
     * 保存
     *
     * @param object 表单内容
     */
    @PostMapping
    @RequiresPermissions("sys:dept:type:save")
    public Response save(@RequestBody @Valid SysDeptType object) {
        return Response.success(service.saveData(object));
    }

    /**
     * 详情
     *
     * @param id 部门类型 id
     */
    @GetMapping("{id}")
    public Response get(@PathVariable("id") String id) {
        return Response.success(service.get(id));
    }

    /**
     * 根据pId获取数据
     *
     * @param pId 上级部门类型id
     */
    @GetMapping("pId")
    @RequiresPermissions("sys:dept:type:select")
    public Response selectByPId(@RequestParam(name = "pId", required = false) String pId) {
        return Response.success(service.selectByPId(pId));
    }

    /**
     * 获取全部数据
     */
    @GetMapping("all")
    @RequiresPermissions("sys:dept:type:select")
    public Response selectAll() {
        return Response.success(service.selectAll());
    }

    /**
     * 搜索
     *
     * @param title 名称
     */
    @GetMapping("title")
    @RequiresPermissions("sys:dept:type:select")
    public Response selectByTitle(@RequestParam(name = "title", required = false) String title) {
        logger.debug("/auth/sys/depart/type/search");
        return Response.success(service.selectByTitle(title));
    }

    /**
     * 检查是否有子类型
     *
     * @param code 部门类型编码
     * @return true/false
     */
    @GetMapping("check/has/child")
    public Response checkHasChild(@RequestParam("code") String code) {
        return Response.success(service.checkHasChild(code));
    }

    /**
     * 拖动改变目录或顺序
     *
     * @param dragVO 拖动信息
     */
    @PostMapping("/move")
    @RequiresPermissions("sys:dept:type:move")
    public Response move(@RequestBody DragVO dragVO) {
        return Response.success(service.move(dragVO.getId(), dragVO.getParent(), dragVO.getOldParent(), dragVO.getPosition(), dragVO.getOldPosition()));
    }
}
