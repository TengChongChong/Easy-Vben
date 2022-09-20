package com.easy.admin.auth.controller;

import com.easy.admin.auth.service.AuthService;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.core.annotation.SysLog;
import com.easy.admin.sys.model.LoginVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
     * @param loginVO loginVO
     * @return token
     */
    @Operation(summary ="登录")
    @PostMapping(value = "/api/login")
    @SysLog(modular = "sys", method = "用户登录")
    public String login(@RequestBody @Valid @Parameter(description = "登录参数", required = true) LoginVO loginVO) {
        Subject subject = service.login(loginVO);
        return subject.getSession().getId().toString();
    }

    /**
     * 退出
     */
    @Operation(summary ="退出")
    @PostMapping("/api/logout")
    public void logout() {
        SecurityUtils.getSubject().logout();
    }

}
