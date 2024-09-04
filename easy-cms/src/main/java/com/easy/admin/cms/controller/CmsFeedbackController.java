package com.easy.admin.cms.controller;

import com.easy.admin.cms.model.CmsFeedback;
import com.easy.admin.cms.service.CmsFeedbackService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.annotation.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户反馈
 *
 * @author tengchongchong
 * @date 2023-07-10
 */
@Tag(name = "用户反馈")
@RestController
@ResponseResult
public class CmsFeedbackController {

    /**
     * 用户反馈 service
     */
    @Autowired
    private CmsFeedbackService service;

    /**
     * 查询数据
     *
     * @param cmsFeedback 查询条件
     * @param page        分页
     * @return Page<CmsFeedback>
     */
    @Operation(summary = "查询数据")
    @GetMapping("/api/auth/cms/feedback")
    @SaCheckPermission("cms:feedback:select")
    public Page<CmsFeedback> select(CmsFeedback cmsFeedback, Page<CmsFeedback> page) {
        return service.select(cmsFeedback, page);
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return CmsFeedback
     */
    @Operation(summary = "查询详情")
    @GetMapping("/api/auth/cms/feedback/{id}")
    @SaCheckPermission("cms:feedback:select")
    public CmsFeedback get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @Operation(summary = "删除")
    @DeleteMapping("/api/auth/cms/feedback/{ids}")
    @SaCheckPermission("cms:feedback:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存/修改
     *
     * @param cmsFeedback 表单内容
     * @return CmsFeedback
     */
    @Operation(summary = "保存/修改")
    @PostMapping("/api/cms/feedback")
    @SaCheckPermission("cms:feedback:save")
    public CmsFeedback saveData(@Valid @RequestBody CmsFeedback cmsFeedback) {
        return service.saveData(cmsFeedback);
    }

    /**
     * 导出数据
     *
     * @param cmsFeedback 查询条件
     * @return 文件下载id
     */
    @Operation(summary = "导出数据")
    @GetMapping("/api/auth/cms/feedback/export/data")
    @SaCheckPermission("cms:feedback:select")
    public String exportData(CmsFeedback cmsFeedback) {
        return service.exportData(cmsFeedback);
    }

}
