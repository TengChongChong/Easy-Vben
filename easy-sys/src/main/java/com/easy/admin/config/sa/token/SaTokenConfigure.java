package com.easy.admin.config.sa.token;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import com.easy.admin.config.sa.token.interceptor.CheckSessionNeedUpdateRoleAndPermissionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SaTokenConfig
 *
 * @author TengChongChong
 * @date 2024-09-03
 **/
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    @Autowired
    private CheckSessionNeedUpdateRoleAndPermissionInterceptor updateRoleAndPermissionInterceptor;

    /**
     * 注册拦截器
     *
     * @param registry InterceptorRegistry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(
                new SaInterceptor(handle -> {
                    StpUtil.checkLogin();
                    updateRoleAndPermissionInterceptor.check();
                })
        ).addPathPatterns("/api/auth/**");
    }

    @Bean
    public SaServletFilter getSaServletFilter() {
        return new SaServletFilter()
                .addInclude("/**")
                // 前置函数：在每次认证函数之前执行
                .setBeforeAuth(obj -> {
                    SaHolder.getResponse()
                            // ---------- 设置跨域响应头 ----------
                            // 允许指定域访问跨域资源
                            .setHeader("Access-Control-Allow-Origin", "*")
                            // 允许所有请求方式
                            .setHeader("Access-Control-Allow-Methods", "*")
                            // 允许的header参数
                            .setHeader("Access-Control-Allow-Headers", "*")
                            // 有效时间
                            .setHeader("Access-Control-Max-Age", "3600");

                    // 如果是预检请求，则立即返回到前端
                    SaRouter.match(SaHttpMethod.OPTIONS).back();
                });
    }
}
