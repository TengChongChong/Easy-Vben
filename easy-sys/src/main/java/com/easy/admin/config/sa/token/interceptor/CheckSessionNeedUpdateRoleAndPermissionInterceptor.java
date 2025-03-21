package com.easy.admin.config.sa.token.interceptor;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import com.easy.admin.auth.common.constant.SessionConst;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.config.sa.token.service.SaTokenService;
import com.easy.admin.config.sa.token.util.SessionUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 检查当前会话权限是否需要更新
 * 只对更改角色权限（菜单、数据权限）即时更新，增加或移除角色不会触发更新
 *
 * @author TengChongChong
 * @date 2024-09-20
 **/
@Component
public class CheckSessionNeedUpdateRoleAndPermissionInterceptor {

    @Resource
    private SaTokenService saTokenService;

    public void check() {
        SaSession session = StpUtil.getSession();
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
