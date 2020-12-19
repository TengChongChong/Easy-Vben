package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.util.Response;
import com.easy.restful.sys.model.DragVO;
import com.easy.restful.sys.model.SysRole;
import com.easy.restful.sys.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 角色管理
 *
 * @author tengchong
 * @date 2018/11/2
 */
@RestController
@RequestMapping("/auth/sys/role")
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService service;

    /**
     * 获取角色列表
     *
     * @param pId 父角色id
     */
    @GetMapping("pId")
    @RequiresPermissions("sys:role:select")
    public Response selectByPId(@RequestParam(name = "pId", required = false) String pId) {
        return Response.success(service.selectByPId(pId));
    }

    /**
     * 获取全部数据
     */
    @GetMapping("all")
    @RequiresPermissions("sys:role:select")
    public Response selectAll() {
        return Response.success(service.selectAll());
    }

    /**
     * 新增
     *
     * @param pId 上级菜单/权限 id
     */
    @GetMapping("add/{id}")
    public Response add(@PathVariable("id") String pId) {
        return Response.success(service.add(pId));
    }

    /**
     * 删除权限/菜单
     *
     * @param id 角色id
     */
    @DeleteMapping("/{id}")
    @RequiresPermissions("sys:role:remove")
    public Response remove(@PathVariable("id") String id) {
        return Response.success(service.remove(id));
    }

    /**
     * 批量删除
     *
     * @param ids 角色ids
     */
    @DeleteMapping("/batch/{id}")
    @RequiresPermissions("sys:role:remove")
    public Response batchRemove(@PathVariable("id") String ids) {
        return Response.success(service.batchRemove(ids));
    }

    /**
     * 设置状态
     *
     * @param ids    角色ids
     * @param status 状态
     */
    @PostMapping("/set/{id}/status/{status}")
    @RequiresPermissions("sys:role:status")
    public Response setStatus(@PathVariable("id") String ids, @PathVariable("status") String status) {
        return Response.success(service.setStatus(ids, status));
    }

    /**
     * 保存
     *
     * @param object 表单内容
     */
    @PostMapping
    @RequiresPermissions("sys:role:save")
    public Response save(@RequestBody @Valid SysRole object) {
        logger.debug("/auth/sys/role/save/data");
        return Response.success(service.saveData(object));
    }

    /**
     * 详情
     *
     * @param id 菜单/权限 id
     */
    @GetMapping("{id}")
    public Response get(@PathVariable("id") String id) {
        return Response.success(service.get(id));
    }

    /**
     * 搜索
     *
     * @param title 标题
     */
    @GetMapping("title")
    @RequiresPermissions("sys:role:select")
    public Response selectByTitle(@RequestParam(name = "title", required = false) String title) {
        return Response.success(service.selectByTitle(title));
    }

    /**
     * 拖动改变目录或顺序
     *
     * @param dragVO 拖动信息
     */
    @PostMapping("/move")
    @RequiresPermissions("sys:role:move")
    public Response move(@RequestBody DragVO dragVO) {
        return Response.success(service.move(dragVO.getId(), dragVO.getParent(), dragVO.getOldParent(), dragVO.getPosition(), dragVO.getOldPosition()));
    }

    /**
     * 查询所有权限 Activiti
     *
     * @param sysRole  查询条件
     * @param isSelect 是否为查找
     * @return List<SysRole>
     */
    @GetMapping("role")
    public Response selectRole(SysRole sysRole, @RequestParam(required = false) boolean isSelect) {
        return Response.success(service.selectRole(sysRole, isSelect));
    }
}
