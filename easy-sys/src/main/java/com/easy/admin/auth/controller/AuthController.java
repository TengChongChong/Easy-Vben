package com.easy.admin.auth.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.easy.admin.auth.model.vo.LoginResultVO;
import com.easy.admin.auth.model.vo.route.RouteVO;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.auth.service.AuthService;
import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.config.sa.token.model.LoginAccount;
import com.easy.admin.config.sa.token.model.LoginQrCode;
import com.easy.admin.config.sa.token.model.LoginSms;
import com.easy.admin.config.sa.token.util.SessionUtil;
import com.easy.admin.core.annotation.SysLog;
import com.easy.admin.sys.model.vo.SysQuickNavigationVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

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
     * 用户登录 - 用户名+密码
     *
     * @param loginAccount 登录信息
     * @return LoginResultVO
     */
    @Operation(summary = "用户登录 - 用户名+密码参数")
    @PostMapping(value = "/api/login/account")
    @SysLog(modular = "sys", method = "用户登录 - 用户名+密码参数")
    public LoginResultVO loginAccount(@RequestBody @Valid @Parameter(description = "登录参数", required = true) LoginAccount loginAccount) {
        return service.loginAccount(loginAccount);
    }

    /**
     * 用户登录 - 扫码
     *
     * @param loginQrCode 登录信息
     * @return LoginResultVO
     */
    @Operation(summary = "用户登录 - 扫码参数")
    @PostMapping(value = "/api/login/qr/code")
    @SysLog(modular = "sys", method = "用户登录 - 扫码参数")
    public LoginResultVO loginQrCode(@RequestBody @Valid @Parameter(description = "登录参数", required = true) LoginQrCode loginQrCode) {
        return service.loginQrCode(loginQrCode);
    }

    /**
     * 用户登录 - 手机号+短信验证码
     *
     * @param loginSms 登录信息
     * @return LoginResultVO
     */
    @Operation(summary = "用户登录 - 手机号+短信验证码参数")
    @PostMapping(value = "/api/login/sms")
    @SysLog(modular = "sys", method = "用户登录 - 手机号+短信验证码参数")
    public LoginResultVO loginSms(@RequestBody @Valid @Parameter(description = "登录参数", required = true) LoginSms loginSms) {
        return service.loginSms(loginSms);
    }

    /**
     * 获取当前登录用户
     *
     * @return SessionUserVO
     */
    @GetMapping("/api/auth/current/user")
    @SysLog(modular = "sys", method = "获取当前登录用户")
    public SessionUserVO getCurrent() {
        return SessionUtil.getCurrentUser();
    }

    /**
     * 获取当前登录用户路由
     *
     * @return List<RouteVO>
     */
    @GetMapping("/api/auth/current/user/route")
    @SysLog(modular = "sys", method = "获取当前登录用户路由")
    public List<RouteVO> getCurrentUserRoute() {
        return SessionUtil.getCurrentUser().getRouteList();
    }

    /**
     * 获取当前登录用户快捷菜单
     *
     * @return List<SysQuickNavigationVO>
     */
    @GetMapping("/api/auth/current/user/quick/navigation")
    @SysLog(modular = "sys", method = "获取当前登录用户快捷菜单")
    public List<SysQuickNavigationVO> getCurrentUserQuickNavigation() {
        return SessionUtil.getCurrentUser().getQuickNavigationList();
    }

    /**
     * 退出
     */
    @Operation(summary = "退出")
    @PostMapping("/api/logout")
    public void logout() {
        StpUtil.logout();
    }

}
