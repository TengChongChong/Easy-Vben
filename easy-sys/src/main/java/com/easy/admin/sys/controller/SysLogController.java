package com.easy.admin.sys.controller;

import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.sys.model.SysLog;
import com.easy.admin.sys.service.SysLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志 
 *
 * @author TengChong
 * @date 2019-06-27
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/log")
public class SysLogController extends BaseController {

    /**
     * 日志  service
     */
    @Autowired
    private SysLogService service;

    /**
     * 列表
     *
     * @param sysLog 查询条件
     * @return Page<SysLog>
     */
    @GetMapping
    @RequiresPermissions("sys:log:select")
    public Page<SysLog> select(SysLog sysLog, Page<SysLog> page){
        return service.select(sysLog, page);
    }
    /**
     * 详情
     *
     * @param id id
     * @return SysLog
     */
    @GetMapping("{id}")
    @RequiresPermissions("sys:log:select")
    public SysLog get(@PathVariable("id") String id) {
        return service.get(id);
    }
}
