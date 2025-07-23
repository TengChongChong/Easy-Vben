package com.easy.admin.sys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.sys.model.SysQuickNavigation;
import com.easy.admin.sys.model.vo.SysQuickNavigationVO;
import com.easy.admin.sys.service.SysQuickNavigationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 快捷导航
 *
 * @author 系统管理员
 * @date 2025-07-09
 */
@Tag(name = "快捷导航")
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/quick/navigation")
public class SysQuickNavigationController {

    /**
     * 快捷导航 service
     */
    @Autowired
    private SysQuickNavigationService service;

    /**
     * 查询数据
     *
     * @param sysQuickNavigation 查询条件
     * @return List<SysQuickNavigationVO>
     */
    @Operation(summary = "查询数据")
    @GetMapping()
    @SaCheckPermission("sys:quick:navigation:select")
    public List<SysQuickNavigationVO> select(SysQuickNavigationVO sysQuickNavigation) {
        return service.select(sysQuickNavigation);
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return SysQuickNavigationVO
     */
    @Operation(summary = "查询详情")
    @GetMapping("{id}")
    @SaCheckPermission("sys:quick:navigation:select")
    public SysQuickNavigationVO get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增
     *
     * @return SysQuickNavigationVO
     */
    @GetMapping("add")
    @Operation(summary = "新增")
    @SaCheckPermission("sys:quick:navigation:save")
    public SysQuickNavigationVO add() {
        return service.add();
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @Operation(summary = "删除")
    @DeleteMapping("{ids}")
    @SaCheckPermission("sys:quick:navigation:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存/修改
     *
     * @param sysQuickNavigationVO 表单内容
     * @return SysQuickNavigationVO
     */
    @Operation(summary = "保存/修改")
    @PostMapping()
    @SaCheckPermission("sys:quick:navigation:save")
    public SysQuickNavigationVO saveData(@Valid @RequestBody SysQuickNavigationVO sysQuickNavigationVO) {
        return service.saveData(sysQuickNavigationVO);
    }

    /**
     * 保存排序
     *
     * @param sysQuickNavigationList 排序数据
     * @return true/false
     */
    @Operation(summary = "保存排序")
    @PostMapping("order/no")
    @SaCheckPermission("sys:quick:navigation:save")
    public boolean saveOrderNo(@RequestBody List<SysQuickNavigation> sysQuickNavigationList) {
        return service.saveOrderNo(sysQuickNavigationList);
    }


}
