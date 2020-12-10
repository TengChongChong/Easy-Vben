package com.easy.restful.auth.service.impl;

import cn.hutool.core.util.StrUtil;
import com.easy.restful.auth.service.AuthService;
import com.easy.restful.common.core.exception.EasyException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * 会话
 *
 * @author tengchong
 * @date 2020/9/29
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public Subject login(String username, String password, String rememberMe) {
        if(StrUtil.isBlank(username)){
            throw new EasyException("请输入账号");
        }
        if(StrUtil.isBlank(password)){
            throw new EasyException("请输入密码");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        subject.login(token);
        return subject;
    }
}
