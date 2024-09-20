package com.easy.admin.config.sa.token.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.config.sa.token.util.SessionUtil;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * 自定义权限加载接口实现类
 *
 * @author TengChongChong
 * @date 2024-09-03
 **/
@Component
public class StpInterfaceImpl implements StpInterface {

    /**
     * 返回指定账号id所拥有的权限码集合
     *
     * @param loginId   账号id
     * @param loginType 账号类型
     * @return 该账号id具有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        SessionUserVO sessionUser = SessionUtil.getCurrentUser();
        if (sessionUser == null) {
            return Collections.emptyList();
        }
        return sessionUser.getPermissionCodeList();
    }

    /**
     * 返回指定账号id所拥有的角色标识集合
     *
     * @param loginId   账号id
     * @param loginType 账号类型
     * @return 该账号id具有的角色标识集合
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        SessionUserVO sessionUser = SessionUtil.getCurrentUser();
        if (sessionUser == null) {
            return Collections.emptyList();
        }
        return sessionUser.getRoleCodeList();
    }
}
