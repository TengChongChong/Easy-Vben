package com.easy.admin.cms.utils;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.cms.common.constant.CmsSessionKey;
import com.easy.admin.cms.model.CmsSite;
import com.easy.admin.cms.service.CmsSiteUserService;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.util.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 站点工具类
 *
 * @author TengChongChong
 * @date 2021/11/18
 */
@Component
public class CmsSiteUtils {

    private static CmsSiteUserService cmsSiteUserService;

    /**
     * 获取当前登录用户编辑的站点id
     *
     * @return 站点id
     */
    public static String getCurrentEditSiteId() {
        String siteId = (String) ShiroUtil.getAttribute(CmsSessionKey.CURRENT_SITE);
        if (StrUtil.isBlank(siteId)) {
            CmsSite cmsSite = cmsSiteUserService.getSitesByUserId(ShiroUtil.getCurrentUser().getId());
            if (cmsSite == null) {
                throw new EasyException("用户无站点权限");
            }
            return cmsSite.getId();
        }
        return siteId;
    }

    /**
     * 设置当前登录用户编辑的站点id
     *
     * @param siteId 站点id
     */
    public static void setCurrentEditSiteId(String siteId) {
        ShiroUtil.setAttribute(CmsSessionKey.CURRENT_SITE, siteId);
    }

    @Autowired
    public void setCmsSiteUserService(CmsSiteUserService cmsSiteUserService) {
        CmsSiteUtils.cmsSiteUserService = cmsSiteUserService;
    }
}
