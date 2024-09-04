package com.easy.admin.auth.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.easy.admin.auth.model.SysUserOnline;
import com.easy.admin.auth.service.SysUserOnlineService;
import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 会话管理
 *
 * @author TengChongChong
 * @date 2018/9/12
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/online")
public class SysOnlineController extends BaseController {

    @Autowired
    private SysUserOnlineService service;

    /**
     * 获取在线用户
     *
     * @return List<SysUserOnline>
     */
    @GetMapping
    @SaCheckPermission("sys:online:select")
    public Page<SysUserOnline> select(SysUserOnline sysUserOnline, Page<SysUserOnline> page) {
        return service.select(sysUserOnline, page);
    }

    /**
     * 踢出用户
     *
     * @param token token
     * @return true/false
     */
    @PostMapping("force/logout/{token}")
    @SaCheckPermission("sys:online:force")
    public boolean forceLogin(@PathVariable("token") String token) {
        return service.forceLogout(token);
    }
}
