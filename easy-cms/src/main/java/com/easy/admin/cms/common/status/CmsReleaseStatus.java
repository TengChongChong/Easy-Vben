package com.easy.admin.cms.common.status;

/**
 * 发布状态
 *
 * @author tengchong
 * @date 2021-11-29
 */
public enum CmsReleaseStatus {
    // 待发布
    TO_BE_RELEASED("0", "待发布"),
    // 发布中
    PUBLISHING("1", "发布中"),
    // 已完成
    PUBLISHED("2", "已完成"),
    // 已取消
    CANCELLED("-1", "已取消"),
    // 发布失败
    FAIL("-2", "发布失败");

    String code;
    String message;

    CmsReleaseStatus(String code, String message) {
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
