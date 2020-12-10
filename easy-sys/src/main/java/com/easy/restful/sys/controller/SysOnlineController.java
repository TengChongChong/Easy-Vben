package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.util.Response;
import com.easy.restful.sys.service.SysUserOnlineService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 会话管理
 *
 * @author tengchong
 * @date 2018/9/12
 */
@RestController
@RequestMapping("/auth/sys/online")
public class SysOnlineController extends BaseController {

    @Autowired
    private SysUserOnlineService service;

    /**
     * 获取在线用户
     */
    @GetMapping
    @RequiresPermissions("sys:online:select")
    public Object select() {
        return Response.success(service.select());
    }

    /**
     * 踢出用户
     *
     * @param sessionId 会话id
     */
    @PostMapping("force/logout/{sessionId}")
    @RequiresPermissions("sys:online:force")
    public Object forceLogin(@PathVariable("sessionId") String sessionId) {
        return Response.success(service.forceLogout(sessionId));
    }
}
