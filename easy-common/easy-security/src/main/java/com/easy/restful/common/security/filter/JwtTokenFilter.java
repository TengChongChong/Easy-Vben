package com.easy.restful.common.security.filter;

import cn.hutool.core.lang.Validator;
import com.easy.restful.common.security.model.SecurityUser;
import com.easy.restful.common.security.util.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    /**
     * 存放Token的Header Key
     */
    public static final String HEADER_STRING = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String token = request.getHeader(HEADER_STRING);
        if (null != token) {
            // 从token中获取用户名
            String username = jwtTokenUtils.getUsernameFromToken(token);
            if (Validator.isNotEmpty(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
                SecurityUser securityUser = (SecurityUser) this.userDetailsService.loadUserByUsername(username);
                if (jwtTokenUtils.validateToken(token, securityUser)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            securityUser, null, securityUser.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                            request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }
}
