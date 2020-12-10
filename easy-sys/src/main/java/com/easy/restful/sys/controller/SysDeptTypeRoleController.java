package com.easy.restful.sys.controller;

import com.easy.restful.common.core.util.Response;
import com.easy.restful.sys.service.SysDeptTypeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 部门类型与角色关系
 *
 * @author tengchong
 * @date 2018/12/18
 */
@RestController
@RequestMapping("/auth/sys/dept/type/role")
public class SysDeptTypeRoleController {

    @Autowired
    private SysDeptTypeRoleService service;

    /**
     * 根据部门类型
     *
     * @param deptId 部门id
     */
    @GetMapping
    public Response selectRoleByDept(@RequestParam("deptId") String deptId) {
        return Response.success(service.selectRoleByDept(deptId));
    }
}
