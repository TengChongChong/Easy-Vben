package com.easy.restful.common.security.filter;

import cn.hutool.core.util.StrUtil;
import com.easy.restful.common.core.util.Tips;
import com.easy.restful.common.security.constant.JwtConst;
import com.easy.restful.common.security.exception.EasyTokenException;
import com.easy.restful.common.security.model.SecurityUser;
import com.easy.restful.common.security.util.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Jwt 过滤器
 *
 * @author tengchong
 * @date 2020/7/8
 */
@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String token = request.getHeader(JwtConst.HEADER_STRING);
        if (StrUtil.isNotBlank(token)) {
            try {
                // 过期会抛出ExpiredJwtException，所以这里不做判断
                jwtTokenUtils.isTokenExpired(token);
            } catch (EasyTokenException e) {
                Tips.response(response, e.getCode(), e.getMessage());
                return;
            }

            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                // 解析token放到SecurityContextHolder中
                SecurityUser securityUser = jwtTokenUtils.convert(token);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        securityUser, null, securityUser.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }
}
