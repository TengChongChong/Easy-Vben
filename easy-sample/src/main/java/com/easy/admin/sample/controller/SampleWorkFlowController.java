package com.easy.admin.sample.controller;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.sample.model.SampleWorkFlow;
import com.easy.admin.sample.service.SampleWorkFlowService;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 流程示例
 *
 * @author tengchongchong
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
    @SaCheckPermission("sample:work:flow:select")
    public Page<SampleWorkFlow> select(SampleWorkFlow sampleWorkFlow, Page<SampleWorkFlow> page) {
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
    @SaCheckPermission("sample:work:flow:save")
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
    @SaCheckPermission("sample:work:flow:remove")
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
    @SaCheckPermission("sample:work:flow:save")
    public SampleWorkFlow saveData(@Valid @RequestBody SampleWorkFlow sampleWorkFlow) {
        return service.saveData(sampleWorkFlow);
    }

    /**
     * 导出数据
     *
     * @param sampleWorkFlow 查询条件
     * @return 文件下载id
     */
    @GetMapping("export/data")
    @SaCheckPermission("sample:work:flow:select")
    public String exportData(SampleWorkFlow sampleWorkFlow) {
        return service.exportData(sampleWorkFlow);
    }

}
