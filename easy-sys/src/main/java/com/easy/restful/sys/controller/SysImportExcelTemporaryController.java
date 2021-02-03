package com.easy.restful.sys.controller;

import cn.hutool.json.JSONObject;
import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.core.annotation.ResponseResult;
import com.easy.restful.sys.model.SysImportExcelTemporary;
import com.easy.restful.sys.service.SysImportExcelTemplateDetailsService;
import com.easy.restful.sys.service.SysImportExcelTemporaryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 导入临时表
 * 注: 如提示权限问题需要给用户分配 "系统功能 > 数据导入" 权限
 *
 * @author TengChong
 * @date 2019-04-10
 */
@RestController
@ResponseResult
@RequestMapping("/auth/sys/import/excel/temporary")
public class SysImportExcelTemporaryController extends BaseController {

    /**
     * 导入临时表 service
     */
    @Autowired
    private SysImportExcelTemporaryService service;
    @Autowired
    private SysImportExcelTemplateDetailsService detailsService;

    /**
     * 列表
     *
     * @param object 查询条件
     * @param page   page
     * @return Page<SysImportExcelTemporary>
     */
    @GetMapping()
    @RequiresPermissions("import:data")
    public Page<SysImportExcelTemporary> select(SysImportExcelTemporary object, Page<SysImportExcelTemporary> page) {
        return service.select(object, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return JSONObject
     */
    @GetMapping("{id}")
    @RequiresPermissions("import:data")
    public JSONObject get(@PathVariable("id") String id) {
        JSONObject res = new JSONObject();
        SysImportExcelTemporary temporary = service.get(id);
        res.set("temporary", temporary);
        res.set("details", detailsService.selectDetails(temporary.getTemplateId()));
        return res;
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysImportExcelTemporary
     */
    @PostMapping()
    @RequiresPermissions("import:data")
    public SysImportExcelTemporary saveData(@RequestBody @Valid SysImportExcelTemporary object) {
        return service.saveData(object);
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @DeleteMapping("{ids}")
    @RequiresPermissions("import:data")
    public boolean remove(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 清空指定导入代码中数据
     *
     * @param templateId 模板id
     */
    @DeleteMapping("clean/my/import/{templateId}")
    public void cleanMyImport(@PathVariable("templateId") String templateId) {
        service.cleanMyImport(templateId);
    }
}
