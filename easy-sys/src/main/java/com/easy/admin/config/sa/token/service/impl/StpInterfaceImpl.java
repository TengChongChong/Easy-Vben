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
    @Override
    public List<String> getPermissionList(Object o, String s) {
        SessionUserVO sessionUser = SessionUtil.getCurrentUser();
        if (sessionUser == null) {
            return Collections.emptyList();
        }
        return sessionUser.getPermissionCodeList();
    }

    @Override
    public List<String> getRoleList(Object o, String s) {
        SessionUserVO sessionUser = SessionUtil.getCurrentUser();
        if (sessionUser == null) {
            return Collections.emptyList();
        }
        return sessionUser.getRoleCodeList();
    }
}
