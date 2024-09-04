package com.easy.admin.sys.controller;

import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.sys.model.SysException;
import com.easy.admin.sys.service.SysExceptionService;
import cn.dev33.satoken.annotation.SaCheckPermission;
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
     * @param sysException 查询条件
     * @return Page<SysException>
     */
    @GetMapping
    @SaCheckPermission("sys:exception:select")
    public Page<SysException> select(SysException sysException, Page<SysException> page) {
        return service.select(sysException, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return SysException
     */
    @GetMapping("{id}")
    @SaCheckPermission("sys:exception:select")
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
    @SaCheckPermission("sys:exception:remove")
    public boolean remove(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }
}
