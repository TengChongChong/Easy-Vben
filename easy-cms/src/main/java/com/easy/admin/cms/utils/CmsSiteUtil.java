package com.easy.admin.cms.utils;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.cms.common.constant.CmsSessionKey;
import com.easy.admin.cms.model.CmsSite;
import com.easy.admin.cms.service.CmsSiteService;
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
public class CmsSiteUtil {

    private CmsSiteUtil() {}

    private static CmsSiteUserService cmsSiteUserService;

    private static CmsSiteService cmsSiteService;

    /**
     * 根据站点id获取站点数据
     *
     * @param id 站点id
     * @return CmsSite
     */
    public static CmsSite getSiteById(String id){
        return cmsSiteService.get(id);
    }

    /**
     * 获取当前登录用户编辑的站点
     *
     * @return 站点id
     */
    public static CmsSite getCurrentEditSite() {
        String siteId = (String) ShiroUtil.getAttribute(CmsSessionKey.CURRENT_SITE);
        if (StrUtil.isNotBlank(siteId)) {
            CmsSite cmsSite = cmsSiteService.get(siteId);
            if (cmsSite != null) {
                return cmsSite;
            }
        }

        // 站点id不存在
        CmsSite cmsSite = cmsSiteUserService.getSitesByUserId(ShiroUtil.getCurrentUser().getId());
        if (cmsSite == null) {
            throw new EasyException("用户无站点权限");
        }
        return cmsSite;
    }

    /**
     * 获取当前登录用户编辑的站点id
     *
     * @return 站点id
     */
    public static String getCurrentEditSiteId() {
        return getCurrentEditSite().getId();
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
        CmsSiteUtil.cmsSiteUserService = cmsSiteUserService;
    }

    @Autowired
    public void setCmsSiteService(CmsSiteService cmsSiteService) {
        CmsSiteUtil.cmsSiteService = cmsSiteService;
    }
}
