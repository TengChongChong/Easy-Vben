package com.easy.restful.auth.service;

import com.easy.restful.sys.model.LoginVO;
import org.apache.shiro.subject.Subject;

/**
 * 会话
 *
 * @author tengchong
 * @date 2020/9/29
 */
public interface AuthService {

    /**
     * 登录
     *
     * @param loginVO 登录信息
     * @return Subject
     */
    Subject login(LoginVO loginVO);
}
