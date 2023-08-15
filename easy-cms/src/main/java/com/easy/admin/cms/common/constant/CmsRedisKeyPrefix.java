package com.easy.admin.cms.common.constant;

/**
 * Redis key 前缀
 *
 * @author tengchong
 * @date 2021-11-23
 */
public class CmsRedisKeyPrefix {
    /**
     * 站点缓存
     */
    public static final String SITE = "cms:site:";
    /**
     * 栏目缓存
     */
    public static final String COLUMN = "cms:column:";

    /**
     * 发布状态
     */
    public static final String RELEASE_STATUS = "cms:release:status:";

    /**
     * 已发布数量
     */
    public static final String RELEASE_DONE = "cms:release:done:";

    /**
     * 发布失败数量
     */
    public static final String RELEASE_FAIL = "cms:release:fail:";
}
