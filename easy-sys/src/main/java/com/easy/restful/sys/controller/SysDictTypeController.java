package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.common.core.util.Response;
import com.easy.restful.sys.model.SysDictType;
import com.easy.restful.sys.service.SysDictTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 字典类型
 *
 * @author tengchong
 * @date 2018/11/4
 */
@RestController
@RequestMapping("/auth/sys/dict/type")
public class SysDictTypeController extends BaseController {

    @Autowired
    private SysDictTypeService service;

    /**
     * 列表
     *
     * @param object 查询条件
     */
    @GetMapping
    @RequiresPermissions("sys:dict:type:select")
    public Response select(SysDictType object, Page<SysDictType> page) {
        return Response.success(service.select(object, page));
    }

    /**
     * 查询所有
     *
     */
    @GetMapping("all")
    @RequiresPermissions("sys:dict:type:select")
    public Response selectAll() {
        return Response.success(service.selectAll());
    }

    /**
     * 删除
     *
     * @param ids 字典类型ids
     */
    @DeleteMapping("{ids}")
    @RequiresPermissions("sys:dict:type:remove")
    public Response remove(@PathVariable("ids") String ids) {
        return Response.success(service.remove(ids));
    }

    /**
     * 保存
     *
     * @param object 表单内容
     */
    @PostMapping
    @RequiresPermissions("sys:dict:type:save")
    public Response save(@RequestBody @Valid SysDictType object) {
        return Response.success(service.saveData(object));
    }

}
