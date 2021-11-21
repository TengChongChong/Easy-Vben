package com.easy.admin.easyapi.config.web;

import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.util.Response;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 重写返回体
 *
 * @author TengChongChong
 * @date 2020/12/28
 */
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
    /**
     * 请求是否包含注解标记，没有就直接返回
     *
     * @param returnType    methodParameter
     * @param converterType converterType
     * @return true/false
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        // 是包含注解标记
        Boolean needPack = (Boolean) request.getAttribute(CommonConst.RESPONSE_RESULT_ANN);
        return needPack != null && needPack;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Response) {
            // 如果已包装，直接返回
            return body;
        }
        // 如果方法返回为String类型对象，会使用StringHttpMessageConverter，这时候就会报错：类型转换异常
        if (selectedConverterType == StringHttpMessageConverter.class) {
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return Response.success(body).toString();
        }
        return Response.success(body);
    }
}
