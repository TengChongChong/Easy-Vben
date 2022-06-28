package com.easy.admin.sample.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.easy.admin.core.annotation.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.easy.admin.common.core.common.pagination.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import com.easy.admin.sample.model.SampleSlaveGeneral;
import com.easy.admin.sample.service.SampleSlaveGeneralService;

/**
 * 从库示例
 *
 * @author 系统管理员
 * @date 2022-06-23
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sample/slave/general")
public class SampleSlaveGeneralController {

    /**
     * 从库示例 service
     */
    @Autowired
    private SampleSlaveGeneralService service;

    /**
     * 列表
     *
     * @param sampleSlaveGeneral 查询条件
     * @return Page<SampleSlaveGeneral>
     */
    @GetMapping()
    @RequiresPermissions("sample:slave:general:select")
    public Page<SampleSlaveGeneral> select(SampleSlaveGeneral sampleSlaveGeneral, Page<SampleSlaveGeneral> page){
        return service.select(sampleSlaveGeneral, page);
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
     * @param sampleSlaveGeneral 表单内容
     * @return SampleSlaveGeneral
     */
    @PostMapping()
    @RequiresPermissions("sample:slave:general:save")
    public SampleSlaveGeneral saveData(@Valid @RequestBody SampleSlaveGeneral sampleSlaveGeneral){
        return service.saveData(sampleSlaveGeneral);
    }

}
