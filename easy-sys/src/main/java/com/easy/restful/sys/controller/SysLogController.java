package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.common.core.util.Response;
import com.easy.restful.sys.model.SysLog;
import com.easy.restful.sys.service.SysLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 日志 
 *
 * @author TengChong
 * @date 2019-06-27
 */
@RestController
@RequestMapping("/auth/sys/log")
public class SysLogController extends BaseController {

    /**
     * 日志  service
     */
    @Autowired
    private SysLogService service;

    /**
     * 列表
     *
     * @param object 查询条件
     */
    @GetMapping
    @RequiresPermissions("sys:log:select")
    public Response select(SysLog object, Page<SysLog> page){
        return Response.success(service.select(object, page));
    }
    /**
     * 详情
     *
     * @param id id
     * @return String
     */
    @GetMapping("{id}")
    @RequiresPermissions("sys:log:select")
    public Response get(@PathVariable("id") String id) {
        return Response.success(service.get(id));
    }
}
