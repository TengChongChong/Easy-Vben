package com.easy.admin.sys.controller;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.sys.model.SysDataSource;
import com.easy.admin.sys.service.SysDataSourceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
     * @param object 查询条件
     * @return Page<SysDataSource>
     */
    @GetMapping()
    @RequiresPermissions("sys:data:source:select")
    public Page<SysDataSource> select(SysDataSource object, Page<SysDataSource> page){
        return service.select(object, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return SysDataSource
     */
    @GetMapping("{id}")
    @RequiresPermissions("sys:data:source:select")
    public SysDataSource get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增
     *
     * @return SysDataSource
     */
    @GetMapping("add")
    @RequiresPermissions("sys:data:source:save")
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
    @RequiresPermissions("sys:data:source:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysDataSource
     */
    @PostMapping()
    @RequiresPermissions("sys:data:source:save")
    public SysDataSource saveData(@Valid @RequestBody SysDataSource object){
        return service.saveData(object);
    }

    /**
     * 获取数据源
     *
     * @return List<Select>
     */
    @GetMapping("select/options")
    @RequiresPermissions("sys:data:source:select")
    public List<Select> selectOptions(){
        return service.selectOptions();
    }
}
