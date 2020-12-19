package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.util.Response;
import com.easy.restful.sys.model.DragVO;
import com.easy.restful.sys.model.SysPermissions;
import com.easy.restful.sys.service.SysPermissionsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * 权限管理
 *
 * @author tengchong
 * @date 2018/10/30
 */
@RestController
@RequestMapping("/auth/sys/permissions")
public class SysPermissionsController extends BaseController {

    @Autowired
    private SysPermissionsService service;

    /**
     * 新增
     *
     * @param pId 上级菜单/权限 id
     */
    @GetMapping("/add/{pId}")
    public Response add(@PathVariable("pId") String pId) {
        return Response.success(service.add(pId));
    }

    /**
     * 删除
     *
     * @param id 权限id
     */
    @DeleteMapping("{id}")
    @RequiresPermissions("sys:permissions:remove")
    public Object remove(@PathVariable("id") String id) {
        return Response.success(service.remove(id));
    }

    /**
     * 批量删除
     *
     * @param ids 权限ids
     */
    @DeleteMapping("batch/{ids}")
    @RequiresPermissions("sys:permissions:remove")
    public Object batchRemove(@PathVariable("ids") String ids) {
        return Response.success(service.batchRemove(ids));
    }

    /**
     * 设置状态
     *
     * @param ids    权限ids
     * @param status 状态
     */
    @PostMapping("set/{id}/status/{status}")
    @RequiresPermissions("sys:permissions:status")
    public Object setStatus(@PathVariable("id") String ids, @PathVariable("status") String status) {
        return Response.success(service.setStatus(ids, status));
    }

    /**
     * 复制节点到目标id
     *
     * @param nodeIds  复制的节点ids [1,2,3]
     * @param targetId 目标节点id
     */
    @PostMapping("copy/{nodeIds}/to/{targetId}")
    @RequiresPermissions("sys:permissions:save")
    public Object copyNodes(@PathVariable("nodeIds") String nodeIds, @PathVariable("targetId") String targetId) {
        return Response.success(service.copyNode(nodeIds, targetId));
    }

    /**
     * 保存
     *
     * @param object 表单内容
     */
    @PostMapping
    @RequiresPermissions("sys:permissions:save")
    public Object save(@RequestBody @Valid SysPermissions object) {
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
     * 根据pId获取数据
     *
     * @param pId 父权限id
     * @return List<JsTree>
     */
    @GetMapping("pId")
    @RequiresPermissions("sys:permissions:select")
    public Response selectByPId(@RequestParam(name = "pId", required = false) String pId) {
        return Response.success(service.selectByPId(pId));
    }

    /**
     * 获取全部数据
     *
     * @return List<JsTree>
     */
    @GetMapping("all")
    @RequiresPermissions("sys:permissions:select")
    public Object selectAll() {
        logger.debug("/auth/sys/permissions/select/all");
        return Response.success(service.selectAll());
    }

    /**
     * 搜索
     *
     * @param title 标题
     * @return List<JsTree>
     */
    @GetMapping("title")
    @RequiresPermissions("sys:permissions:select")
    public Object selectByTitle(@RequestParam(name = "title", required = false) String title) {
        logger.debug("/auth/sys/permissions/search");
        return Response.success(service.selectByTitle(title));
    }


    /**
     * 拖动改变目录或顺序
     *
     * @param dragVO 拖动信息
     */
    @PostMapping("/move")
    @RequiresPermissions("sys:permissions:move")
    public Response move(@RequestBody DragVO dragVO) {
        return Response.success(service.move(dragVO.getId(), dragVO.getParent(), dragVO.getOldParent(), dragVO.getPosition(), dragVO.getOldPosition()));
    }

}
