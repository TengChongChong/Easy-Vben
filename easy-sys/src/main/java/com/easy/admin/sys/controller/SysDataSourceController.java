package com.easy.admin.sys.controller;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.sys.model.SysDataSource;
import com.easy.admin.sys.service.SysDataSourceService;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 数据源管理
 *
 * @author TengChongChong
 * @date 2021-12-18
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/data/source")
public class SysDataSourceController {

    /**
     * 数据源管理 service
     */
    @Autowired
    private SysDataSourceService service;

    /**
     * 列表
     *
     * @param sysDataSource 查询条件
     * @return Page<SysDataSource>
     */
    @GetMapping()
    @SaCheckPermission("sys:data:source:select")
    public Page<SysDataSource> select(SysDataSource sysDataSource, Page<SysDataSource> page) {
        return service.select(sysDataSource, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return SysDataSource
     */
    @GetMapping("{id}")
    @SaCheckPermission("sys:data:source:select")
    public SysDataSource get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增
     *
     * @return SysDataSource
     */
    @GetMapping("add")
    @SaCheckPermission("sys:data:source:save")
    public SysDataSource add() {
        return service.add();
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @DeleteMapping("{ids}")
    @SaCheckPermission("sys:data:source:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param sysDataSource 表单内容
     * @return SysDataSource
     */
    @PostMapping()
    @SaCheckPermission("sys:data:source:save")
    public SysDataSource saveData(@Valid @RequestBody SysDataSource sysDataSource) {
        return service.saveData(sysDataSource);
    }

    /**
     * 获取数据源
     *
     * @return List<Select>
     */
    @GetMapping("select/options")
    @SaCheckPermission("sys:data:source:select")
    public List<Select> selectOptions() {
        return service.selectOptions();
    }
}
