package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.common.tree.Tree;
import com.easy.restful.core.annotation.ResponseResult;
import com.easy.restful.sys.model.DragVO;
import com.easy.restful.sys.model.SysRole;
import com.easy.restful.sys.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 角色管理
 *
 * @author tengchong
 * @date 2018/11/2
 */
@RestController
@ResponseResult
@RequestMapping("/auth/sys/role")
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService service;

    /**
     * 获取角色列表
     *
     * @param pId 父角色id
     * @return List<Tree>
     */
    @GetMapping("pId")
    @RequiresPermissions("sys:role:select")
    public List<Tree> selectByPId(@RequestParam(name = "pId", required = false) String pId) {
        return service.selectByPId(pId);
    }

    /**
     * 获取全部数据
     *
     * @return List<Tree>
     */
    @GetMapping("all")
    @RequiresPermissions("sys:role:select")
    public List<Tree> selectAll() {
        return service.selectAll();
    }

    /**
     * 新增
     *
     * @param pId 上级菜单/权限 id
     * @return SysRole
     */
    @GetMapping("add/{id}")
    public SysRole add(@PathVariable("id") String pId) {
        return service.add(pId);
    }

    /**
     * 删除权限/菜单
     *
     * @param id 角色id
     * @return true/false
     */
    @DeleteMapping("/{id}")
    @RequiresPermissions("sys:role:remove")
    public boolean remove(@PathVariable("id") String id) {
        return service.remove(id);
    }

    /**
     * 批量删除
     *
     * @param ids 角色ids
     * @return true/false
     */
    @DeleteMapping("/batch/{id}")
    @RequiresPermissions("sys:role:remove")
    public boolean batchRemove(@PathVariable("id") String ids) {
        return service.batchRemove(ids);
    }

    /**
     * 设置状态
     *
     * @param ids    角色ids
     * @param status 状态
     * @return true/false
     */
    @PostMapping("/set/{id}/status/{status}")
    @RequiresPermissions("sys:role:status")
    public boolean setStatus(@PathVariable("id") String ids, @PathVariable("status") String status) {
        return service.setStatus(ids, status);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysRole
     */
    @PostMapping
    @RequiresPermissions("sys:role:save")
    public SysRole save(@RequestBody @Valid SysRole object) {
        logger.debug("/auth/sys/role/save/data");
        return service.saveData(object);
    }

    /**
     * 详情
     *
     * @param id 菜单/权限 id
     * @return SysRole
     */
    @GetMapping("{id}")
    public SysRole get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 搜索
     *
     * @param title 标题
     * @return List<Tree>
     */
    @GetMapping("title")
    @RequiresPermissions("sys:role:select")
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
    @RequiresPermissions("sys:role:move")
    public boolean move(@RequestBody DragVO dragVO) {
        return service.move(dragVO.getId(), dragVO.getParent(), dragVO.getOldParent(), dragVO.getPosition(), dragVO.getOldPosition());
    }

    /**
     * 查询所有权限 Activiti
     *
     * @param sysRole  查询条件
     * @param isSelect 是否为查找
     * @return List<SysRole>
     */
    @GetMapping("role")
    public List<SysRole> selectRole(SysRole sysRole, @RequestParam(required = false) boolean isSelect) {
        return service.selectRole(sysRole, isSelect);
    }
}
