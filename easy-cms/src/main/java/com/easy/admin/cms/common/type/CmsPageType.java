package com.easy.admin.cms.common.type;

/**
 * 发布类型
 *
 * @author TengChongChong
 * @date 2021-11-19
 */

public enum CmsPageType {
    // 首页
    INDEX("index", "首页"),
    // 搜索
    SEARCH("search", "搜索"),
    // 404
    ERROR_404("404", "404");

    String code;
    String message;

    CmsPageType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 获取枚举
     *
     * @param code code
     * @return CmsPageType
     */
    public static CmsPageType getCmsPageType(String code) {
        switch (code) {
            case "index":
                return CmsPageType.INDEX;
            case "search":
                return CmsPageType.SEARCH;
            case "404":
                return CmsPageType.ERROR_404;
            default:
                return null;
        }
    }
}
