package com.easy.admin.cms.common.status;

/**
 * 文章状态
 *
 * @author TengChongChong
 * @date 2021-11-19
 */

public enum CmsArticleStatus {
    // 草稿
    DRAFT("0", "草稿"),
    // 已发布
    PUBLISHED("1", "已发布"),
    // 已撤销
    RESCINDED("-1", "已撤销");

    String code;
    String message;

    CmsArticleStatus(String code, String message) {
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
