package com.easy.admin.auth.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.auth.model.vo.SysUserVO;
import com.easy.admin.auth.service.SysUserService;
import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户管理
 *
 * @author TengChongChong
 * @date 2018/12/6
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/user")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService service;

    /**
     * 列表
     *
     * @param sysUser 查询条件
     * @return Page<SysUser>
     */
    @GetMapping
    @SaCheckPermission("sys:user:select")
    public Page<SysUserVO> select(SysUserVO sysUser, Page<SysUserVO> page) {
        return service.select(sysUser, page);
    }

    /**
     * 新增
     *
     * @param deptId 部门id
     * @return SysUser
     */
    @GetMapping({"add/{deptId}"})
    @SaCheckPermission("sys:user:save")
    public SysUserVO add(@PathVariable(value = "deptId", required = false) String deptId) {
        return service.add(deptId);
    }

    /**
     * 删除
     *
     * @param id 用户id
     * @return true/false
     */
    @DeleteMapping("{id}")
    @SaCheckPermission("sys:user:remove")
    public boolean remove(@PathVariable("id") String id) {
        return service.remove(id);
    }

    /**
     * 设置状态
     *
     * @param ids    角色ids
     * @param status 状态
     * @return true/false
     */
    @PostMapping("{id}/status/{status}")
    @SaCheckPermission("sys:user:save")
    public boolean setStatus(@PathVariable("id") String ids, @PathVariable("status") String status) {
        return service.setStatus(ids, status);
    }

    /**
     * 重置密码
     *
     * @param ids 用户ids
     * @return 重置后密码
     */
    @PostMapping("reset/password/{ids}")
    @SaCheckPermission("sys:user:save")
    public String resetPassword(@PathVariable("ids") String ids) {
        return service.resetPassword(ids);
    }

    /**
     * 保存
     *
     * @param sysUser 表单内容
     * @return SysUser
     */
    @PostMapping
    @SaCheckPermission("sys:user:save")
    public SysUserVO save(@RequestBody @Valid SysUserVO sysUser) {
        return service.saveData(sysUser, true);
    }

    /**
     * 详情
     *
     * @param id id
     * @return SysUser
     */
    @GetMapping("{id}")
    @SaCheckPermission("sys:user:select")
    public SysUser get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 查询用户，用于用户选择
     *
     * @param keyword  关键字
     * @param range    数据范围，可以选择哪些用户 'all' | 'currentDept' | 'role'
     * @param deptId   部门Id （非必须）
     * @param roleCode 角色标识（非必须）
     * @return Page<SysUser>
     */
    @GetMapping("search")
    public Page<SysUserVO> search(@RequestParam(value = "keyword", required = false) String keyword,
                                  @RequestParam(value = "range", required = false) String range,
                                  @RequestParam(value = "deptId", required = false) String deptId,
                                  @RequestParam(value = "roleCode", required = false) String roleCode,
                                  Page<SysUserVO> page) {
        return service.search(keyword, range, deptId, roleCode, page);
    }

    /**
     * 获取指定用户信息，用于回显已选择的用户
     *
     * @param ids ids
     * @return List<SysUser>
     */
    @GetMapping("users/{ids}")
    @SaCheckPermission("sys:user:select")
    public List<SysUserVO> selectUsersByIds(@PathVariable("ids") String ids) {
        return service.selectUsersByIds(ids);
    }
}
