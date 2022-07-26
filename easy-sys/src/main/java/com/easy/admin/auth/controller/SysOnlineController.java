package com.easy.admin.auth.controller;

import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.auth.model.SysUserOnline;
import com.easy.admin.auth.service.SysUserOnlineService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @RequiresPermissions("sys:online:select")
    public List<SysUserOnline> select(SysUserOnline sysUserOnline) {
        return service.select(sysUserOnline);
    }

    /**
     * 踢出用户
     *
     * @param token token
     *
     * @return true/false
     */
    @PostMapping("force/logout/{token}")
    @RequiresPermissions("sys:online:force")
    public boolean forceLogin(@PathVariable("token") String token) {
        return service.forceLogout(token);
    }
}
