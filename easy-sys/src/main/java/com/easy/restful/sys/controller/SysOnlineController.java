package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.core.annotation.ResponseResult;
import com.easy.restful.sys.model.SysUserOnline;
import com.easy.restful.sys.service.SysUserOnlineService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会话管理
 *
 * @author tengchong
 * @date 2018/9/12
 */
@RestController
@ResponseResult
@RequestMapping("/auth/sys/online")
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
    public List<SysUserOnline> select() {
        return service.select();
    }

    /**
     * 踢出用户
     *
     * @param sessionId 会话id
     *
     * @return @return true/false
     */
    @PostMapping("force/logout/{sessionId}")
    @RequiresPermissions("sys:online:force")
    public boolean forceLogin(@PathVariable("sessionId") String sessionId) {
        return service.forceLogout(sessionId);
    }
}
