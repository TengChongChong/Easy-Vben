package com.easy.admin.sys.controller;

import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.sys.model.SysDictType;
import com.easy.admin.sys.service.SysDictTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 字典类型
 *
 * @author TengChongChong
 * @date 2018/11/4
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/dict/type")
public class SysDictTypeController extends BaseController {

    @Autowired
    private SysDictTypeService service;

    /**
     * 列表
     *
     * @param object 查询条件
     * @return Page<SysDictType>
     */
    @GetMapping
    @RequiresPermissions("sys:dict:type:select")
    public Page<SysDictType> select(SysDictType object, Page<SysDictType> page) {
        return service.select(object, page);
    }

    /**
     * 查询所有
     *
     * @return List<Select>
     */
    @GetMapping("all")
    public List<Select> selectAll() {
        return service.selectAll();
    }

    /**
     * 详情
     *
     * @param id 字典id
     * @return SysDictType
     */
    @GetMapping("{id}")
    public SysDictType get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增
     *
     * @return SysDictType
     */
    @GetMapping("add")
    public SysDictType add() {
        return service.add();
    }

    /**
     * 删除
     *
     * @param ids 字典类型ids
     * @return true/false
     */
    @DeleteMapping("{ids}")
    @RequiresPermissions("sys:dict:type:remove")
    public boolean remove(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysDictType
     */
    @PostMapping
    @RequiresPermissions("sys:dict:type:save")
    public SysDictType save(@RequestBody @Valid SysDictType object) {
        return service.saveData(object);
    }

}
