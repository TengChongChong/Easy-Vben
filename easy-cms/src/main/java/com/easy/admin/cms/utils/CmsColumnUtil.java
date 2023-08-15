package com.easy.admin.cms.utils;

import com.easy.admin.cms.common.constant.CmsRedisKeyPrefix;
import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.cms.service.CmsColumnService;
import com.easy.admin.common.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 栏目工具类
 *
 * @author TengChongChong
 * @date 2021-11-18
 */
@Component
public class CmsColumnUtil {

    private CmsColumnUtil() {
    }

    private static CmsColumnService cmsColumnService;


    /**
     * 根据栏目id获取栏目数据，优先从缓存中获取
     *
     * @param siteId 站点id
     * @param id     栏目id
     * @return CmsColumn
     */
    public static CmsColumn getById(String siteId, String id) {
        CmsColumn cmsColumn = (CmsColumn) RedisUtil.get(CmsRedisKeyPrefix.COLUMN + siteId + ":" + id);
        if (cmsColumn == null) {
            return cmsColumnService.get(id);
        }
        return cmsColumn;
    }


    /**
     * 根据栏目别名获取栏目数据，优先从缓存中获取
     *
     * @param siteId 站点id
     * @param slug   栏目别名
     * @return CmsColumn
     */
    public static CmsColumn getBySlug(String siteId, String slug) {
        CmsColumn cmsColumn = (CmsColumn) RedisUtil.get(CmsRedisKeyPrefix.COLUMN + siteId + ":" + slug);
        if (cmsColumn == null) {
            return cmsColumnService.getBySlug(siteId, slug);
        }
        return cmsColumn;
    }


    @Autowired
    public void setCmsColumnService(CmsColumnService cmsColumnService) {
        CmsColumnUtil.cmsColumnService = cmsColumnService;
    }
}
