package com.easy.admin.sys.controller;

import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.sys.model.SysDictType;
import com.easy.admin.sys.service.SysDictTypeService;
import io.swagger.v3.oas.annotations.Operation;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 字典类型
 *
 * @author TengChongChong
 * @date 2018/11/4
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/dict/type")
public class SysDictTypeController extends BaseController {

    @Autowired
    private SysDictTypeService service;

    /**
     * 列表
     *
     * @param sysDictType 查询条件
     * @return Page<SysDictType>
     */
    @GetMapping
    @SaCheckPermission("sys:dict:select")
    public Page<SysDictType> select(SysDictType sysDictType, Page<SysDictType> page) {
        return service.select(sysDictType, page);
    }

    /**
     * 查询所有
     *
     * @return List<Select>
     */
    @GetMapping("all")
    public List<Select> selectAll() {
        return service.selectAll();
    }

    /**
     * 详情
     *
     * @param id 字典id
     * @return SysDictType
     */
    @GetMapping("{id}")
    public SysDictType get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增
     *
     * @return SysDictType
     */
    @GetMapping("add")
    public SysDictType add() {
        return service.add();
    }

    /**
     * 删除
     *
     * @param ids 字典类型ids
     * @return true/false
     */
    @DeleteMapping("{ids}")
    @SaCheckPermission("sys:dict:remove")
    public boolean remove(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param sysDictType 表单内容
     * @return SysDictType
     */
    @PostMapping
    @SaCheckPermission("sys:dict:save")
    public SysDictType save(@RequestBody @Valid SysDictType sysDictType) {
        return service.saveData(sysDictType);
    }

    /**
     * 导出数据
     *
     * @param sysDictType 查询条件
     * @return 文件下载id
     */
    @Operation(summary = "导出数据")
    @GetMapping("export/data")
    @SaCheckPermission("sys:dict:select")
    public String exportData(SysDictType sysDictType) {
        return service.exportData(sysDictType);
    }
}
