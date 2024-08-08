package com.easy.admin.auth.service;

import com.easy.admin.auth.model.dto.LoginDTO;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import org.apache.shiro.subject.Subject;

/**
 * 会话
 *
 * @author TengChongChong
 * @date 2020/9/29
 */
public interface AuthService {

    /**
     * 登录
     *
     * @param loginDTO 登录信息
     * @return Subject
     */
    Subject login(LoginDTO loginDTO);

    /**
     * 获取当前登录用户
     *
     * @return SessionUserVO
     */
    SessionUserVO getCurrentUser();
}
