package com.easy.admin.sys.controller;

import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.sys.model.SysLog;
import com.easy.admin.sys.service.SysLogService;
import cn.dev33.satoken.annotation.SaCheckPermission;
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
    @SaCheckPermission("sys:log:select")
    public Page<SysLog> select(SysLog sysLog, Page<SysLog> page) {
        return service.select(sysLog, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return SysLog
     */
    @GetMapping("{id}")
    @SaCheckPermission("sys:log:select")
    public SysLog get(@PathVariable("id") String id) {
        return service.get(id);
    }
}
