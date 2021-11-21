package com.easy.admin.sys.controller;

import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.sys.model.DragVO;
import com.easy.admin.sys.model.SysDeptType;
import com.easy.admin.sys.service.SysDeptTypeService;
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
@RequestMapping("/auth/sys/dept/type")
public class SysDeptTypeController extends BaseController {

    @Autowired
    private SysDeptTypeService service;

    /**
     * 新增
     *
     * @param pId 上级部门类型 id
     * @return SysDeptType
     */
    @GetMapping("add/{id}")
    public SysDeptType add(@PathVariable("id") String pId) {
        return service.add(pId);
    }

    /**
     * 删除
     *
     * @param id 部门类型id
     * @return true/false
     */
    @DeleteMapping("{id}")
    @RequiresPermissions("sys:dept:type:remove")
    public boolean remove(@PathVariable("id") String id) {
        return service.remove(id);
    }

    /**
     * 批量删除
     *
     * @param ids 部门类型ids
     * @return true/false
     */
    @DeleteMapping("batch/{id}")
    @RequiresPermissions("sys:dept:type:remove")
    public boolean batchRemove(@PathVariable("id") String ids) {
        return service.batchRemove(ids);
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
     * 根据pId获取数据
     *
     * @param pId 上级部门类型id
     * @return List<Tree>
     */
    @GetMapping("pId")
    @RequiresPermissions("sys:dept:type:select")
    public List<Tree> selectByPId(@RequestParam(value = "pId", required = false) String pId) {
        return service.selectByPId(pId);
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
     * 搜索
     *
     * @param title 名称
     * @return List<Tree>
     */
    @GetMapping("title")
    @RequiresPermissions("sys:dept:type:select")
    public List<Tree> selectByTitle(@RequestParam(name = "title", required = false) String title) {
        return service.selectByTitle(title);
    }

    /**
     * 检查是否有子类型
     *
     * @param code 部门类型编码
     * @return true/false
     */
    @GetMapping("check/has/child")
    public boolean checkHasChild(@RequestParam("code") String code) {
        return service.checkHasChild(code);
    }

    /**
     * 拖动改变目录或顺序
     *
     * @param dragVO 拖动信息
     * @return true/false
     */
    @PostMapping("move")
    @RequiresPermissions("sys:dept:type:move")
    public boolean move(@RequestBody DragVO dragVO) {
        return service.move(dragVO.getId(), dragVO.getParent(), dragVO.getOldParent(), dragVO.getPosition(), dragVO.getOldPosition());
    }
}
