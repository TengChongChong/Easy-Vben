package com.easy.admin.sample.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.easy.admin.common.core.annotation.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import com.easy.admin.common.core.common.pagination.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import com.easy.admin.sample.model.vo.SampleGeneralVO;
import com.easy.admin.sample.service.SampleGeneralService;

/**
 * 代码生成示例
 *
 * @author 系统管理员
 * @date 2025-03-21
 */
@Tag(name = "代码生成示例")
@RestController
@ResponseResult
@RequestMapping("/api/auth/sample/general")
public class SampleGeneralController {

    /**
     * 代码生成示例 service
     */
    @Autowired
    private SampleGeneralService service;

    /**
     * 查询数据
     *
     * @param sampleGeneral 查询条件
     * @param page 分页
     * @return Page<SampleGeneralVO>
     */
    @Operation(summary ="查询数据")
    @GetMapping()
    @SaCheckPermission("sample:general:select")
    public Page<SampleGeneralVO> select(SampleGeneralVO sampleGeneral, Page<SampleGeneralVO> page){
        return service.select(sampleGeneral, page);
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return SampleGeneralVO
     */
    @Operation(summary ="查询详情")
    @GetMapping("{id}")
    @SaCheckPermission("sample:general:select")
    public SampleGeneralVO get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增
     *
     * @return SampleGeneralVO
     */
    @GetMapping("add")
    @Operation(summary ="新增")
    @SaCheckPermission("sample:general:save")
    public SampleGeneralVO add() {
        return service.add();
    }
    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @Operation(summary ="删除")
    @DeleteMapping("{ids}")
    @SaCheckPermission("sample:general:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存/修改
     *
     * @param sampleGeneralVO 表单内容
     * @return SampleGeneralVO
     */
    @Operation(summary ="保存/修改")
    @PostMapping()
    @SaCheckPermission("sample:general:save")
    public SampleGeneralVO saveData(@Valid @RequestBody SampleGeneralVO sampleGeneralVO){
        return service.saveData(sampleGeneralVO);
    }
    /**
     * 导出数据
     *
     * @param sampleGeneral 查询条件
     * @return 文件下载id
     */
    @Operation(summary ="导出数据")
    @GetMapping("export/data")
    @SaCheckPermission("sample:general:select")
    public String exportData(SampleGeneralVO sampleGeneral){
        return service.exportData(sampleGeneral);
    }

}
