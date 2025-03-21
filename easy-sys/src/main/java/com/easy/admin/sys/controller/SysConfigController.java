package com.easy.admin.sys.controller;

import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.sys.model.SysConfig;
import com.easy.admin.sys.service.SysConfigService;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

/**
 * 系统参数
 *
 * @author admin
 * @date 2019-03-03 15:52:44
 */
@RestController
@ResponseResult
public class SysConfigController extends BaseController {

    /**
     * 系统参数 service
     */
    @Autowired
    private SysConfigService service;

    /**
     * 列表
     *
     * @param sysConfig 查询条件
     * @param page      Page<SysConfig>
     */
    @GetMapping("/api/auth/sys/config")
    @SaCheckPermission("sys:config:select")
    public Page<SysConfig> select(SysConfig sysConfig, Page<SysConfig> page) {
        return service.select(sysConfig, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return SysConfig
     */
    @GetMapping("/api/auth/sys/config/{id}")
    @SaCheckPermission("sys:config:select")
    public SysConfig get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 根据key获取配置
     *
     * @param key key
     * @return SysConfig
     */
    @GetMapping("/api/sys/config/key/{key}")
    public SysConfig getByKey(@PathVariable("key") String key) {
        return service.getByKey(key);
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @DeleteMapping("/api/auth/sys/config/{ids}")
    @SaCheckPermission("sys:config:remove")
    public boolean remove(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param sysConfig 表单内容
     * @return SysConfig
     */
    @PostMapping("/api/auth/sys/config")
    @SaCheckPermission("sys:config:save")
    public SysConfig save(@RequestBody @Valid SysConfig sysConfig) {
        return service.saveData(sysConfig);
    }

    /**
     * 刷新缓存中的系统参数
     *
     * @return true/false
     */
    @PostMapping("/api/auth/sys/config/refresh")
    @SaCheckPermission("sys:config:save")
    public boolean refreshCache() {
        return service.refreshCache();
    }
}