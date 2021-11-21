package com.easy.admin.sys.controller;

import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.sys.model.SysRole;
import com.easy.admin.sys.service.SysDeptTypeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 部门类型与角色关系
 *
 * @author TengChongChong
 * @date 2018/12/18
 */
@RestController
@ResponseResult
@RequestMapping("/auth/sys/dept/type/role")
public class SysDeptTypeRoleController {

    @Autowired
    private SysDeptTypeRoleService service;

    /**
     * 根据部门id获取部门角色
     *
     * @param deptId 部门id
     * @return List<SysRole>
     */
    @GetMapping
    public List<SysRole> selectRoleByDept(@RequestParam("deptId") String deptId) {
        return service.selectRoleByDept(deptId);
    }
}
