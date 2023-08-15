package com.easy.admin.cms.common.type;

/**
 * 文件类型
 *
 * @author TengChongChong
 * @date 2021-11-19
 */

public enum CmsFileType {
    /**
     * 文章封面
     */
    ARTICLE_COVER("article-cover", "文章封面"),
    /**
     * 资源库文件
     */
    MEDIA_FILE("media-file", "资源库文件");

    String code;
    String message;

    CmsFileType(String code, String message) {
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
