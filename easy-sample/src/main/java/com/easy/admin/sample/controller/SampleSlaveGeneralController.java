package com.easy.admin.sample.controller;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.sample.model.SampleSlaveGeneral;
import com.easy.admin.sample.service.SampleSlaveGeneralService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 从库示例
 *
 * @author 系统管理员
 * @date 2021-12-20
 */
@RestController
@ResponseResult
@RequestMapping("/auth/sample/slave/general")
public class SampleSlaveGeneralController {

    /**
     * 从库示例 service
     */
    @Autowired
    private SampleSlaveGeneralService service;

    /**
     * 列表
     *
     * @param object 查询条件
     * @return Page<SampleSlaveGeneral>
     */
    @GetMapping()
    @RequiresPermissions("sample:slave:general:select")
    public Page<SampleSlaveGeneral> select(SampleSlaveGeneral object, Page<SampleSlaveGeneral> page){
        return service.select(object, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return SampleSlaveGeneral
     */
    @GetMapping("{id}")
    @RequiresPermissions("sample:slave:general:select")
    public SampleSlaveGeneral get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增
     *
     * @return SampleSlaveGeneral
     */
    @GetMapping("add")
    @RequiresPermissions("sample:slave:general:save")
    public SampleSlaveGeneral add() {
        return service.add();
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @DeleteMapping("{ids}")
    @RequiresPermissions("sample:slave:general:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SampleSlaveGeneral
     */
    @PostMapping()
    @RequiresPermissions("sample:slave:general:save")
    public SampleSlaveGeneral saveData(@Valid @RequestBody SampleSlaveGeneral object){
        return service.saveData(object);
    }

}
