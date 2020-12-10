package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.common.core.util.Response;
import com.easy.restful.sys.model.SysDict;
import com.easy.restful.sys.service.SysDictService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 字典管理
 *
 * @author tengchong
 * @date 2018/11/4
 */
@RestController
@RequestMapping("/auth/sys/dict")
public class SysDictController extends BaseController {

    @Autowired
    private SysDictService service;

    /**
     * 列表
     *
     * @param object 查询条件
     */
    @GetMapping
    @RequiresPermissions("sys:dict:select")
    public Response select(SysDict object, Page<SysDict> page) {
        return Response.success(service.select(object, page));
    }

    /**
     * 根据字典类型获取字典
     *
     * @param dictType 字典类型
     */
    @GetMapping("dict-type")
    @RequiresPermissions("sys:dict:select")
    public Response selectByDictType(@RequestParam("dictType") String dictType) {
        return Response.success(service.selectByDictType(dictType));
    }

    /**
     * 新增
     *
     * @param pId      上级 id
     * @param dictType 字典类型
     */
    @GetMapping({"/add/{id}", "/add"})
    public Response add(@PathVariable(value = "id", required = false) String pId,
                      @RequestParam(value = "dictType", required = false) String dictType) {
        return Response.success(service.add(pId, dictType));
    }

    /**
     * 删除
     *
     * @param ids 字典ids
     */
    @DeleteMapping("/{ids}")
    @RequiresPermissions("sys:dict:remove")
    public Response remove(@PathVariable("ids") String ids) {
        return Response.success(service.remove(ids));
    }

    /**
     * 保存
     *
     * @param object 表单内容
     */
    @PostMapping
    @RequiresPermissions("sys:dict:save")
    public Response save(@Valid SysDict object) {
        return Response.success(service.saveData(object));
    }

    /**
     * 详情
     *
     * @param id 字典id
     */
    @GetMapping("/{id}")
    public Response get(@PathVariable("id") String id) {
        return Response.success(service.get(id));
    }

    /**
     * 将数据库中字典数据生成成js文件
     */
    @PostMapping("/generate/dict/data")
    @RequiresPermissions("sys:dict:generate")
    public Response generateDictData() {
        return Response.success(service.generateDictData());
    }

}
