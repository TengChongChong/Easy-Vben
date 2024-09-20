package com.easy.admin.config.sa.token.interceptor;

import cn.dev33.satoken.session.SaSession;
import com.easy.admin.auth.common.constant.SessionConst;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.config.sa.token.service.SaTokenService;
import com.easy.admin.config.sa.token.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 检查当前会话权限是否需要更新
 *
 * @author TengChongChong
 * @date 2024-09-20
 **/
@Component
public class CheckSessionNeedUpdateRoleAndPermissionInterceptor {

    @Autowired
    private SaTokenService saTokenService;

    public void check() {
        SaSession session = SessionUtil.getTokenSession();
        if (session.has(SessionConst.NEED_UPDATE_ROLE_AND_PERMISSION)) {
            SessionUserVO sessionUser = SessionUtil.getCurrentUser();
            // 重新获取授权
            saTokenService.setUserPermissions(sessionUser);
            // 设置当前会话用户
            session.set(SessionConst.USER_SESSION_KEY, sessionUser);
            // 移除更新标识
            session.delete(SessionConst.NEED_UPDATE_ROLE_AND_PERMISSION);
        }
    }
}
