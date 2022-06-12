package com.easy.admin.sys.controller;

import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.sys.model.SysException;
import com.easy.admin.sys.service.SysExceptionService;
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
@ResponseResult
@RequestMapping("/api/auth/sys/exception")
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
     * @return Page<SysException>
     */
    @GetMapping
    @RequiresPermissions("sys:exception:select")
    public Page<SysException> select(SysException object, Page<SysException> page) {
        return service.select(object, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return SysException
     */
    @GetMapping("{id}")
    @RequiresPermissions("sys:exception:select")
    public SysException get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @DeleteMapping("{ids}")
    @RequiresPermissions("sys:exception:remove")
    public boolean remove(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }
}
