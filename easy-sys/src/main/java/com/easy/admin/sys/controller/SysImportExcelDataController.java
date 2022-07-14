package com.easy.admin.sys.controller;

import cn.hutool.json.JSONObject;
import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.sys.model.SysImportExcelTemplate;
import com.easy.admin.sys.model.SysImportSummary;
import com.easy.admin.sys.service.SysImportExcelDataService;
import com.easy.admin.sys.service.SysImportExcelTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 数据导入
 *
 * @author TengChongChong
 * @date 2019-04-17
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/import/excel/data")
public class SysImportExcelDataController extends BaseController {

    @Autowired
    private SysImportExcelDataService service;

    @Autowired
    private SysImportExcelTemplateService importExcelTemplateService;

    /**
     * 获取导入模板信息
     *
     * @param importCode 模板代码
     * @return SysImportExcelTemplate
     */
    @GetMapping("{importCode}")
    public SysImportExcelTemplate getImportExcelTemplate(@PathVariable("importCode") String importCode) {
        return importExcelTemplateService.getByImportCode(importCode);
    }

    /**
     * 检查上次导入数据
     *
     * @param templateId 模板id
     * @return true/false
     */
    @GetMapping("check/last/data/{templateId}")
    public boolean checkLastData(@PathVariable("templateId") String templateId){
        return service.checkLastData(templateId);
    }

    /**
     * 验证并解析文件
     *
     * @param templateId 模板id
     * @param json       {path:xxx}
     * @return true/false
     */
    @PostMapping("analysis/{templateId}")
    public boolean analysis(@PathVariable("templateId") String templateId, @RequestBody JSONObject json) {
        return service.analysis(templateId, json.getStr("path"));
    }

    /**
     * 查询指定导入汇总信息
     *
     * @param templateId 模板id
     * @return SysImportSummary
     */
    @GetMapping("summary/{templateId}")
    public SysImportSummary selectSummary(@PathVariable("templateId") String templateId) {
        return service.selectSummary(templateId);
    }

    /**
     * 插入数据
     *
     * @param templateId 模板id
     */
    @PostMapping("data/{templateId}")
    public int insertData(@PathVariable("templateId") String templateId) {
        return service.insertData(templateId);
    }

    /**
     * 导出验证失败数据
     *
     * @param templateId 模板id
     * @param request    request
     * @return 文件下载id
     */
    @GetMapping("export/verification/fail/data/{templateId}")
    public String exportVerificationFailData(@PathVariable("templateId") String templateId,
                                                                         HttpServletRequest request) {
        return service.exportVerificationFailData(templateId, request);
    }
}
