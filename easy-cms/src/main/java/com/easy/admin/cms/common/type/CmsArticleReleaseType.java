package com.easy.admin.cms.common.type;

/**
 * 文章发布类型
 *
 * @author TengChongChong
 * @date 2021-11-19
 */

public enum CmsArticleReleaseType {
    // 手动
    MANUAL("1", "手动"),
    // 自动
    AUTOMATIC("2", "自动");

    String code;
    String message;

    CmsArticleReleaseType(String code, String message) {
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
