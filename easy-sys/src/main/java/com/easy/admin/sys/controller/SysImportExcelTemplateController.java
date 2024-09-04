package com.easy.admin.sys.controller;

import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.sys.model.SysImportExcelTemplate;
import com.easy.admin.sys.service.SysImportExcelTemplateService;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 导入模板
 *
 * @author TengChong
 * @date 2019-04-10
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/import/excel/template")
public class SysImportExcelTemplateController extends BaseController {

    /**
     * 导入模板 service
     */
    @Autowired
    private SysImportExcelTemplateService service;

    /**
     * 列表
     *
     * @param sysImportExcelTemplate 查询条件
     * @param page                   page
     * @return Page<SysImportExcelTemplate>
     */
    @GetMapping()
    @SaCheckPermission("sys:import:excel:template:select")
    public Page<SysImportExcelTemplate> select(SysImportExcelTemplate sysImportExcelTemplate, Page<SysImportExcelTemplate> page) {
        return service.select(sysImportExcelTemplate, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return SysImportExcelTemplate
     */
    @GetMapping("{id}")
    @SaCheckPermission("sys:import:excel:template:select")
    public SysImportExcelTemplate get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @DeleteMapping("{ids}")
    @SaCheckPermission("sys:import:excel:template:remove")
    public boolean remove(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param sysImportExcelTemplate 表单内容
     * @return SysImportExcelTemplate
     */
    @PostMapping()
    @SaCheckPermission("sys:import:excel:template:save")
    public SysImportExcelTemplate saveData(@RequestBody @Valid SysImportExcelTemplate sysImportExcelTemplate) {
        return service.saveData(sysImportExcelTemplate);
    }

    /**
     * 下载导入模板
     *
     * @param importCode 模板代码
     * @return 文件下载id
     */
    @GetMapping("template/{importCode}")
    @SaCheckPermission("sys:import:excel:template:select")
    public String downloadTemplate(@PathVariable("importCode") String importCode,
                                   HttpServletRequest request) {
        return service.downloadTemplate(importCode, request);
    }
}
