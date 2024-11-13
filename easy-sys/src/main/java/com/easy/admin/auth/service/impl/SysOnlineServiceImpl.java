package com.easy.admin.auth.service.impl;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.easy.admin.auth.common.constant.SessionConst;
import com.easy.admin.auth.model.SysUserOnline;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.auth.service.SysUserOnlineService;
import com.easy.admin.common.core.common.pagination.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 会话管理
 *
 * @author TengChongChong
 * @date 2018/9/12
 */
@Service
public class SysOnlineServiceImpl implements SysUserOnlineService {

    @Override
    public Page<SysUserOnline> select(SysUserOnline sysUserOnline, Page<SysUserOnline> page) {
        int size = ((Long) page.getPageSize()).intValue();
        int start = (((Long) page.getCurrent()).intValue() - 1) * size;

        String keyword = (sysUserOnline != null && StrUtil.isNotBlank(sysUserOnline.getToken())) ? sysUserOnline.getToken() : "";
        List<String> tokenList = StpUtil.searchTokenValue(keyword, start, size, true);
        if (tokenList == null || tokenList.isEmpty()) {
            return page;
        }
        List<SysUserOnline> userOnlineList = new ArrayList<>();
        for (String token : tokenList) {
            // 获取 token
            String realToken = token.contains(":") ? token.substring(token.lastIndexOf(":") + 1) : token;
            SaSession session = StpUtil.getTokenSessionByToken(realToken);

            // token 中的用户信息
            SessionUserVO sessionUserVO = (SessionUserVO) session.get(SessionConst.USER_SESSION_KEY);
            SysUserOnline userOnline = new SysUserOnline();

            BeanUtil.copyProperties(sessionUserVO, userOnline);

            userOnline.setId((String) StpUtil.getLoginIdByToken(realToken));
            // 设备
            userOnline.setDevice(StpUtil.getLoginDevice());
            userOnline.setToken(realToken);
            userOnline.setDeptName(sessionUserVO.getDept().getName());
            userOnline.setTimeout(StpUtil.getTokenTimeout(realToken));
            userOnline.setSessionStatus(userOnline.getId() != null ? "1" : "-1");
            userOnlineList.add(userOnline);
        }
        page.setRecords(userOnlineList);
        return page;
    }

    @Override
    public boolean forceLogout(String token) {
        // 强制指定 Token 注销下线
        StpUtil.kickoutByTokenValue(token);
        return true;
    }
}
