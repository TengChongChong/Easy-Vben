package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.common.core.util.Response;
import com.easy.restful.sys.model.SysException;
import com.easy.restful.sys.service.SysExceptionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 异常日志
 *
 * @author TengChong
 * @date 2019-04-08
 */
@RestController
@RequestMapping("/auth/sys/exception")
public class SysExceptionController extends BaseController {

    /**
     * 异常日志 service
     */
    @Autowired
    private SysExceptionService service;

    /**
     * 列表
     *
     * @param object 查询条件
     */
    @GetMapping
    @RequiresPermissions("sys:exception:select")
    public Response select(SysException object, Page<SysException> page){
        return Response.success(service.select(object, page));
    }

    /**
     * 详情
     *
     * @param id id
     */
    @GetMapping("{id}")
    @RequiresPermissions("sys:exception:select")
    public Response get(@PathVariable("id") String id) {
        return Response.success(service.get(id));
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     */
    @DeleteMapping("{ids}")
    @RequiresPermissions("sys:exception:remove")
    public Response remove(@PathVariable("ids") String ids) {
        return Response.success(service.remove(ids));
    }
    /**
     * 保存
     *
     * @param object 表单内容
     */
    @PostMapping
    @RequiresPermissions("sys:exception:save")
    public Response save(SysException object){
        return Response.success(service.saveData(object));
    }
}
