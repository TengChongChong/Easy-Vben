package com.easy.admin.sys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.sys.model.SysDict;
import com.easy.admin.sys.model.vo.SysDictVO;
import com.easy.admin.sys.service.SysDictService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
 * 字典管理
 *
 * @author TengChongChong
 * @date 2018/11/4
 */
@RestController
@ResponseResult
public class SysDictController extends BaseController {

    @Autowired
    private SysDictService service;

    /**
     * 列表
     *
     * @param sysDict 查询条件
     * @return Page<SysDict>
     */
    @GetMapping("/api/auth/sys/dict")
    @SaCheckPermission("sys:dict:select")
    public Page<SysDictVO> select(SysDictVO sysDict, Page<SysDictVO> page) {
        return service.select(sysDict, page);
    }

    /**
     * 根据字典类型获取字典
     *
     * @param dictType 字典类型
     * @return List<Select>
     */
    @GetMapping("/api/auth/sys/dict/dict-type")
    @SaCheckPermission("sys:dict:select")
    public List<Select> selectByDictType(@RequestParam(value = "dictType", required = false) String dictType) {
        return service.selectByDictType(dictType);
    }

    /**
     * 新增
     *
     * @param parentId 上级 id
     * @param dictType 字典类型
     * @return SysDict
     */
    @GetMapping({"/api/auth/sys/dict/add/{id}", "/api/auth/sys/dict/add"})
    public SysDict add(@PathVariable(value = "id", required = false) String parentId,
                       @RequestParam(value = "dictType", required = false) String dictType) {
        return service.add(parentId, dictType);
    }

    /**
     * 删除
     *
     * @param ids 字典ids
     * @return true/false
     */
    @DeleteMapping("/api/auth/sys/dict/{ids}")
    @SaCheckPermission("sys:dict:remove")
    public boolean remove(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param sysDict 表单内容
     * @return SysDict
     */
    @PostMapping("/api/auth/sys/dict")
    @SaCheckPermission("sys:dict:save")
    public SysDict save(@RequestBody @Valid SysDict sysDict) {
        return service.saveData(sysDict);
    }

    /**
     * 详情
     *
     * @param id 字典id
     * @return SysDict
     */
    @GetMapping("/api/auth/sys/dict/{id}")
    public SysDict get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 查询所有字典，前端需缓存此数据，仅在页面首次加载时获取
     *
     * @return List<SysDict>
     */
    @GetMapping({"/api/sys/dict/all", "/api/auth/sys/dict/all"})
    public List<SysDict> selectAll() {
        return service.selectAll();
    }

    /**
     * 刷新缓存数据
     */
    @PostMapping("/api/auth/sys/dict/refresh")
    public boolean refresh() {
        return service.refresh();
    }

    /**
     * 导出数据
     *
     * @param sysDict 查询条件
     * @return 文件下载id
     */
    @Operation(summary = "导出数据")
    @GetMapping("/api/auth/sys/dict/export/data")
    @SaCheckPermission("sys:dict:select")
    public String exportData(SysDict sysDict) {
        return service.exportData(sysDict);
    }
}
