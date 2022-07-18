package com.easy.admin.sys.controller;

import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.sys.model.SysImportExcelTemplateDetail;
import com.easy.admin.sys.service.SysImportExcelTemplateDetailService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 导入模板详情
 *
 * @author TengChong
 * @date 2019-04-10
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/import/excel/template/details")
public class SysImportExcelTemplateDetailController extends BaseController {
    /**
     * 导入模板详情 service
     */
    @Autowired
    private SysImportExcelTemplateDetailService service;

    /**
     * 获取已配置字段
     *
     * @param templateId 导入模板id
     * @return List<SysImportExcelTemplateDetails>
     */
    @GetMapping("details/{templateId}")
    @RequiresPermissions("sys:import:excel:template:save")
    public List<SysImportExcelTemplateDetail> selectDetails(@PathVariable("templateId") String templateId) {
        return service.selectDetails(templateId);
    }

    /**
     * 保存
     *
     * @param templateId 导入模板id
     * @param list       表单内容
     * @return true/false
     */
    @PostMapping ("{templateId}")
    @RequiresPermissions("sys:import:excel:template:save")
    public boolean saveData(@PathVariable("templateId") String templateId,
                         @RequestBody(required = false) List<SysImportExcelTemplateDetail> list) {
        return service.saveData(templateId, list);
    }
}
