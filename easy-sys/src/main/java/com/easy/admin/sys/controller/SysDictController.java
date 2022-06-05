package com.easy.admin.sys.controller;

import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.sys.model.SysDict;
import com.easy.admin.sys.service.SysDictService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 字典管理
 *
 * @author TengChongChong
 * @date 2018/11/4
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/dict")
public class SysDictController extends BaseController {

    @Autowired
    private SysDictService service;

    /**
     * 列表
     *
     * @param object 查询条件
     * @return Page<SysDict>
     */
    @GetMapping
    @RequiresPermissions("sys:dict:select")
    public Page<SysDict> select(SysDict object, Page<SysDict> page) {
        return service.select(object, page);
    }

    /**
     * 根据字典类型获取字典
     *
     * @param dictType 字典类型
     * @return List<Select>
     */
    @GetMapping("dict-type")
    @RequiresPermissions("sys:dict:select")
    public List<Select> selectByDictType(@RequestParam(value = "dictType", required = false) String dictType) {
        return service.selectByDictType(dictType);
    }

    /**
     * 新增
     *
     * @param parentId 上级 id
     * @param dictType 字典类型
     * @return SysDict
     */
    @GetMapping({"/add/{id}", "/add"})
    public SysDict add(@PathVariable(value = "id", required = false) String parentId,
                       @RequestParam(value = "dictType", required = false) String dictType) {
        return service.add(parentId, dictType);
    }

    /**
     * 删除
     *
     * @param ids 字典ids
     * @return true/false
     */
    @DeleteMapping("{ids}")
    @RequiresPermissions("sys:dict:remove")
    public boolean remove(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysDict
     */
    @PostMapping
    @RequiresPermissions("sys:dict:save")
    public SysDict save(@RequestBody @Valid SysDict object) {
        return service.saveData(object);
    }

    /**
     * 详情
     *
     * @param id 字典id
     * @return SysDict
     */
    @GetMapping("{id}")
    public SysDict get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 查询所有字典，前端需缓存此数据，仅在页面首次加载时获取
     *
     * @return List<SysDict>
     */
    @GetMapping("all")
    public List<SysDict> selectAll() {
        return service.selectAll();
    }

    /**
     * 刷新缓存数据
     */
    @PostMapping("refresh")
    public boolean refresh() {
        return service.refresh();
    }

}
