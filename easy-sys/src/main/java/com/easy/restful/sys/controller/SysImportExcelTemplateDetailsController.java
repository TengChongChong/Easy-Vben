package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.core.annotation.ResponseResult;
import com.easy.restful.sys.model.Column;
import com.easy.restful.sys.model.SysImportExcelTemplateDetails;
import com.easy.restful.sys.service.SysImportExcelTemplateDetailsService;
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
@RequestMapping("/auth/sys/import/excel/template/details")
public class SysImportExcelTemplateDetailsController extends BaseController {
    /**
     * 导入模板详情 service
     */
    @Autowired
    private SysImportExcelTemplateDetailsService service;

    /**
     * 获取已配置字段
     *
     * @param templateId 导入模板id
     * @return List<SysImportExcelTemplateDetails>
     */
    @GetMapping("details/{templateId}")
    @RequiresPermissions("sys:import:excel:template:save")
    public List<SysImportExcelTemplateDetails> selectDetails(@PathVariable("templateId") String templateId) {
        return service.selectDetails(templateId);
    }

    /**
     * 根据模板代码获取表格表头
     *
     * @param templateId 模板id
     * @return List<Column>
     */
    @GetMapping("table/head/{templateId}")
    public List<Column> selectTableHeadByTemplateCode(@PathVariable("templateId") String templateId){
        return service.selectTableHeadByTemplateCode(templateId);
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
                         @RequestBody(required = false) List<SysImportExcelTemplateDetails> list) {
        return service.saveData(templateId, list);
    }
}
