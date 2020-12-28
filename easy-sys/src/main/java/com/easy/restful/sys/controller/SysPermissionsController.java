package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.common.tree.Tree;
import com.easy.restful.core.annotation.ResponseResult;
import com.easy.restful.sys.model.DragVO;
import com.easy.restful.sys.model.SysPermissions;
import com.easy.restful.sys.service.SysPermissionsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * 权限管理
 *
 * @author tengchong
 * @date 2018/10/30
 */
@RestController
@ResponseResult
@RequestMapping("/auth/sys/permissions")
public class SysPermissionsController extends BaseController {

    @Autowired
    private SysPermissionsService service;

    /**
     * 新增
     *
     * @param pId 上级菜单/权限 id
     * @return SysPermissions
     */
    @GetMapping("/add/{pId}")
    public SysPermissions add(@PathVariable("pId") String pId) {
        return service.add(pId);
    }

    /**
     * 删除
     *
     * @param id 权限id
     * @return true/false
     */
    @DeleteMapping("{id}")
    @RequiresPermissions("sys:permissions:remove")
    public boolean remove(@PathVariable("id") String id) {
        return service.remove(id);
    }

    /**
     * 批量删除
     *
     * @param ids 权限ids
     * @return true/false
     */
    @DeleteMapping("batch/{ids}")
    @RequiresPermissions("sys:permissions:remove")
    public boolean batchRemove(@PathVariable("ids") String ids) {
        return service.batchRemove(ids);
    }

    /**
     * 设置状态
     *
     * @param ids    权限ids
     * @param status 状态
     * @return true/false
     */
    @PostMapping("set/{id}/status/{status}")
    @RequiresPermissions("sys:permissions:status")
    public boolean setStatus(@PathVariable("id") String ids, @PathVariable("status") String status) {
        return service.setStatus(ids, status);
    }

    /**
     * 复制节点到目标id
     *
     * @param nodeIds  复制的节点ids [1,2,3]
     * @param targetId 目标节点id
     * @return List<SysPermissions>
     */
    @PostMapping("copy/{nodeIds}/to/{targetId}")
    @RequiresPermissions("sys:permissions:save")
    public List<SysPermissions> copyNodes(@PathVariable("nodeIds") String nodeIds, @PathVariable("targetId") String targetId) {
        return service.copyNode(nodeIds, targetId);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysPermissions
     */
    @PostMapping
    @RequiresPermissions("sys:permissions:save")
    public SysPermissions save(@RequestBody @Valid SysPermissions object) {
        return service.saveData(object);
    }

    /**
     * 详情
     *
     * @param id 菜单/权限 id
     * @return SysPermissions
     */
    @GetMapping("{id}")
    public SysPermissions get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 根据pId获取数据
     *
     * @param pId 父权限id
     * @return List<JsTree>
     */
    @GetMapping("pId")
    @RequiresPermissions("sys:permissions:select")
    public List<Tree> selectByPId(@RequestParam(name = "pId", required = false) String pId) {
        return service.selectByPId(pId);
    }

    /**
     * 获取全部数据
     *
     * @return List<JsTree>
     */
    @GetMapping("all")
    @RequiresPermissions("sys:permissions:select")
    public List<Tree> selectAll() {
        return service.selectAll();
    }

    /**
     * 搜索
     *
     * @param title 标题
     * @return List<JsTree>
     */
    @GetMapping("title")
    @RequiresPermissions("sys:permissions:select")
    public List<Tree> selectByTitle(@RequestParam(name = "title", required = false) String title) {
        return service.selectByTitle(title);
    }


    /**
     * 拖动改变目录或顺序
     *
     * @param dragVO 拖动信息
     * @return true/false
     */
    @PostMapping("/move")
    @RequiresPermissions("sys:permissions:move")
    public boolean move(@RequestBody DragVO dragVO) {
        return service.move(dragVO.getId(), dragVO.getParent(), dragVO.getOldParent(), dragVO.getPosition(), dragVO.getOldPosition());
    }

}
