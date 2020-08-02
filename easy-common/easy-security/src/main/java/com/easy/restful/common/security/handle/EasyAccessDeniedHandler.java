package com.easy.restful.common.security.handle;

import cn.hutool.http.HttpStatus;
import com.easy.restful.common.core.util.Tips;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 无权限 handle
 *
 * @author tengchong
 * @date 2020/7/31
 */
@Component
public class EasyAccessDeniedHandler implements AccessDeniedHandler {
    /**
     * 拒绝访问
     */
    private static final String ACCESS_DENIED = "300403";

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setStatus(HttpStatus.HTTP_FORBIDDEN);
        Tips.response(response, ACCESS_DENIED, "拒绝访问（[" + request.getMethod() + "]" + request.getRequestURI() + "）");
    }
}
