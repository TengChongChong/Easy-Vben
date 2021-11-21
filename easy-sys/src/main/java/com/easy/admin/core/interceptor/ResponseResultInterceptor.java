package com.easy.admin.core.interceptor;

import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.core.annotation.ResponseResult;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 解析@ResponseResult注解
 *
 * @author TengChongChong
 * @date 2020/12/28
 */
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {

    /**
     * 缓存检查结果，避免每次请求都要反射一下
     */
    Map<String, Boolean> cache = new HashMap<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 请求的方法
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            if (classHasAnnotation(handlerMethod.getBeanType()) || methodHasAnnotation(handlerMethod.getMethod())) {
                setAttribute(request);
            }
        }
        return true;
    }

    /**
     * class上是否有ResponseResult注解
     *
     * @param clazz class
     * @return true/false
     */
    private boolean classHasAnnotation(Class<?> clazz) {
        String cacheKey = getKey(clazz.toString());
        return cache.computeIfAbsent(cacheKey, k -> clazz.isAnnotationPresent(ResponseResult.class));
    }

    /**
     * method上是否有ResponseResult注解
     *
     * @param method method
     * @return true/false
     */
    private boolean methodHasAnnotation(Method method) {
        String cacheKey = getKey(method.toString());
        return cache.computeIfAbsent(cacheKey, k -> method.isAnnotationPresent(ResponseResult.class));
    }

    private String getKey(String key) {
        return key.replace(" ", "");
    }

    /**
     * 在HttpServletRequest中设置标记，标记此请求响应时需要包装
     *
     * @param request HttpServletRequest
     */
    private void setAttribute(HttpServletRequest request) {
        request.setAttribute(CommonConst.RESPONSE_RESULT_ANN, true);
    }
}
