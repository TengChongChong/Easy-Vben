package com.easy.restful.sample.controller;

import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.core.annotation.ResponseResult;
import com.easy.restful.sample.model.SampleWorkFlow;
import com.easy.restful.sample.service.SampleWorkFlowService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 流程示例
 *
 * @author TengChong
 * @date 2020-04-26
 */
@RestController
@ResponseResult
@RequestMapping("/auth/sample/work/flow")
public class SampleWorkFlowController {

    /**
     * 流程示例 service
     */
    @Autowired
    private SampleWorkFlowService service;

    /**
     * 列表
     *
     * @param object 查询条件
     * @param page   分页
     * @return Page<SampleWorkFlow>
     */
    @GetMapping()
    @RequiresPermissions("sample:work:flow:select")
    public Page<SampleWorkFlow> select(SampleWorkFlow object, Page<SampleWorkFlow> page) {
        return service.select(object, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return String
     */
    @GetMapping("{id}")
    @RequiresPermissions("sample:work:flow:select")
    public SampleWorkFlow input(Model model, @PathVariable("id") String id) {
        return service.input(id);
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return Tips
     */
    @DeleteMapping("{ids}")
    @RequiresPermissions("sample:work:flow:remove")
    public boolean remove(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return Tips
     */
    @PostMapping()
    @RequiresPermissions("sample:work:flow:save")
    public SampleWorkFlow saveData(@RequestBody @Valid SampleWorkFlow object) {
        return service.saveData(object);
    }
}
