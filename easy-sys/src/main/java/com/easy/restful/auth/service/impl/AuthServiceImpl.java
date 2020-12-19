package com.easy.restful.auth.service.impl;

import com.easy.restful.auth.service.AuthService;
import com.easy.restful.sys.model.LoginVO;
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
    public Subject login(LoginVO loginVO) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginVO.getUsername(), loginVO.getPassword(), loginVO.getRememberMe() != null && loginVO.getRememberMe());
        subject.login(token);
        return subject;
    }
}
