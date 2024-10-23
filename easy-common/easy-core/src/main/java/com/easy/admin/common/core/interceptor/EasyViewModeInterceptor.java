package com.easy.admin.common.core.interceptor;

import com.easy.admin.common.core.exception.EasyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 使用模式
 *
 * @author TengChongChong
 * @date 2024-09-18
 **/
@Component
public class EasyViewModeInterceptor implements HandlerInterceptor {

    @Value("${project.view-model}")
    private boolean viewModel = false;

    /**
     * 演示模式允许的 HttpMethod
     */
    private static final List<String> PASS_HTTP_METHOD = Arrays.asList("OPTIONS", "GET");

    /**
     * 演示模式允许的 Url
     */
    private static final List<String> PASS_URL = Arrays.asList(
            "/api/login/account",
            "/api/login/qr/code",
            "/api/login/sms",
            "/api/logout",
            "/api/sys/captcha/check"
    );


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        boolean isPassMethod = PASS_HTTP_METHOD.contains(request.getMethod());
        boolean isPassUrl = PASS_URL.contains(request.getRequestURI());
        if (viewModel && (!isPassMethod && !isPassUrl)) {
            throw new EasyException("演示模式，不允许编辑");
        }
        return true;
    }
}
