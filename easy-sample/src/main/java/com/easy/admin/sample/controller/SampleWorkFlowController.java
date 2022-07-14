package com.easy.admin.sample.controller;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.sample.model.SampleWorkFlow;
import com.easy.admin.sample.service.SampleWorkFlowService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 流程示例
 *
 * @author 系统管理员
 * @date 2022-07-08
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sample/work/flow")
public class SampleWorkFlowController {

    /**
     * 流程示例 service
     */
    @Autowired
    private SampleWorkFlowService service;

    /**
     * 列表
     *
     * @param sampleWorkFlow 查询条件
     * @return Page<SampleWorkFlow>
     */
    @GetMapping()
    @RequiresPermissions("sample:work:flow:select")
    public Page<SampleWorkFlow> select(SampleWorkFlow sampleWorkFlow, Page<SampleWorkFlow> page){
        return service.select(sampleWorkFlow, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return SampleWorkFlow
     */
    @GetMapping("{id}")
    public SampleWorkFlow get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增
     *
     * @return SampleWorkFlow
     */
    @GetMapping("add")
    @RequiresPermissions("sample:work:flow:save")
    public SampleWorkFlow add() {
        return service.add();
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @DeleteMapping("{ids}")
    @RequiresPermissions("sample:work:flow:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param sampleWorkFlow 表单内容
     * @return SampleWorkFlow
     */
    @PostMapping()
    @RequiresPermissions("sample:work:flow:save")
    public SampleWorkFlow saveData(@Valid @RequestBody SampleWorkFlow sampleWorkFlow){
        return service.saveData(sampleWorkFlow);
    }

    /**
     * 导出数据
     *
     * @param sampleWorkFlow 查询条件
     * @return 文件下载id
     */
    @GetMapping("export/data")
    @RequiresPermissions("sample:work:flow:select")
    public String exportData(SampleWorkFlow sampleWorkFlow){
        return service.exportData(sampleWorkFlow);
    }

}
