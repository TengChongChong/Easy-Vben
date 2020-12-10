package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.common.core.util.Response;
import com.easy.restful.sys.model.SysConfig;
import com.easy.restful.sys.service.SysConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 系统参数
 *
 * @author admin
 * @date 2019-03-03 15:52:44
 */
@RestController
@RequestMapping("/auth/sys/config")
public class SysConfigController extends BaseController {

    /**
     * 系统参数 service
     */
    @Autowired
    private SysConfigService service;

    /**
     * 列表
     *
     * @param object 查询条件
     * @param page   分页
     */
    @GetMapping
    @RequiresPermissions("sys:config:select")
    public Response select(SysConfig object, Page<SysConfig> page) {
        return Response.success(service.select(object, page));
    }

    /**
     * 详情
     *
     * @param id id
     */
    @GetMapping("{id}")
    @RequiresPermissions("sys:config:select")
    public Response get(@PathVariable("id") String id) {
        return Response.success(service.get(id));
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     */
    @DeleteMapping("{ids}")
    @RequiresPermissions("sys:config:remove")
    public Response remove(@PathVariable("ids") String ids) {
        return Response.success(service.remove(ids));
    }

    /**
     * 保存
     *
     * @param object 表单内容
     */
    @PostMapping
    @RequiresPermissions("sys:config:save")
    public Response save(@Valid SysConfig object) {
        return Response.success(service.saveData(object));
    }

    /**
     * 刷新缓存中的系统参数
     */
    @PostMapping("refresh/cache")
    @RequiresPermissions("sys:config:save")
    public Response refreshCache() {
        return Response.success(service.refreshCache());
    }
}