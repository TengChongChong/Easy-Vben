package com.easy.admin.auth.controller;

import com.easy.admin.auth.model.dto.LoginDTO;
import com.easy.admin.auth.model.vo.route.RouteVO;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.auth.service.AuthService;
import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.core.annotation.SysLog;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 会话
 *
 * @author TengChongChong
 * @date 2020/9/26
 */
@Tag(name = "会话管理", description = "用户登录、用户退出")
@RestController
@ResponseResult
public class AuthController {

    @Autowired
    private AuthService service;

    /**
     * 登录
     *
     * @param loginDTO loginDTO
     * @return token
     */
    @Operation(summary = "登录")
    @PostMapping(value = "/api/login")
    @SysLog(modular = "sys", method = "用户登录")
    public String login(@RequestBody @Valid @Parameter(description = "登录参数", required = true) LoginDTO loginDTO) {
        Subject subject = service.login(loginDTO);
        return subject.getSession().getId().toString();
    }

    /**
     * 获取当前登录用户
     *
     * @return SessionUserVO
     */
    @RequiresPermissions("auth:current:user")
    @GetMapping("/api/auth/current/user")
    @SysLog(modular = "sys", method = "获取当前登录用户")
    public SessionUserVO getCurrent() {
        return service.getCurrentUser();
    }

    /**
     * 获取当前登录用户路由
     *
     * @return List<RouteVO>
     */
    @GetMapping("/api/auth/current/user/route")
    @SysLog(modular = "sys", method = "获取当前登录用户路由")
    public List<RouteVO> getCurrentUserRoute() {
        return service.getCurrentUser().getRouteList();
    }

    /**
     * 退出
     */
    @Operation(summary = "退出")
    @PostMapping("/api/logout")
    public void logout() {
        SecurityUtils.getSubject().logout();
    }

}
