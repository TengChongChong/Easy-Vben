package com.easy.admin.cms.utils;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.cms.common.constant.CmsSessionKey;
import com.easy.admin.cms.model.CmsSite;
import com.easy.admin.cms.service.CmsSiteService;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.util.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 站点工具类
 *
 * @author TengChongChong
 * @date 2023-06-25
 */
@Component
public class CmsSiteUtil {

    private CmsSiteUtil() {
    }

    private static CmsSiteService cmsSiteService;

    /**
     * 获取当前登录用户编辑的站点
     *
     * @return 站点id
     */
    public static CmsSite getUserActiveSite() {
        String cmsSiteId = getUserActiveSiteId();
        if (StrUtil.isBlank(cmsSiteId)) {
            return null;
        }

        return cmsSiteService.get(cmsSiteId);
    }

    /**
     * 获取当前登录用户编辑的站点id
     *
     * @return 站点id
     */
    public static String getUserActiveSiteId() {
        CmsSite cmsSite = (CmsSite) ShiroUtil.getAttribute(CmsSessionKey.CURRENT_SITE);
        if (cmsSite == null) {
            return null;
        }
        // 验证站点权限
        if (!checkUserSite(cmsSite.getId())) {
            throw new EasyException("你无权操作站点[" + cmsSite.getName() + "]");
        }
        return cmsSite.getId();
    }

    /**
     * 设置当前登录用户编辑的站点
     *
     * @param cmsSite 站点
     */
    public static void setUserActiveSite(CmsSite cmsSite) {
        // 验证站点权限
        if (!checkUserSite(cmsSite.getId())) {
            throw new EasyException("你无权操作站点[" + cmsSite.getName() + "]");
        }
        ShiroUtil.setAttribute(CmsSessionKey.CURRENT_SITE, cmsSite);
    }

    /**
     * 验证用户是否有此站点权限
     *
     * @param cmsSiteId 站点Id
     * @return true/false
     */
    private static boolean checkUserSite(String cmsSiteId) {
        // todo: 待完善
        return true;
    }

    @Autowired
    public void setCmsSiteService(CmsSiteService cmsSiteService) {
        CmsSiteUtil.cmsSiteService = cmsSiteService;
    }
}
