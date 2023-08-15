package com.easy.admin.cms.common.type;

/**
 * 发布类型
 *
 * @author TengChongChong
 * @date 2021-11-19
 */

public enum CmsReleaseType {
    // 页面
    PAGE("page", "页面"),
    // 栏目
    COLUMN("column", "栏目"),
    // 文章
    ARTICLE("article", "文章");

    String code;
    String message;

    /**
     * 获取枚举
     *
     * @param code code
     * @return CmsReleaseType
     */
    public static CmsReleaseType getCmsReleaseType(String code) {
        switch (code) {
            case "page":
                return CmsReleaseType.PAGE;
            case "column":
                return CmsReleaseType.COLUMN;
            case "article":
                return CmsReleaseType.ARTICLE;
            default:
                return null;
        }
    }

    CmsReleaseType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
