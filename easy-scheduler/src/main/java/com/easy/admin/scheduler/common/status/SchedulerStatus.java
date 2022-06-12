package com.easy.admin.scheduler.common.status;

/**
 * 定时任务
 *
 * @author TengChongChong
 * @date 2019-05-11
 */
public enum SchedulerStatus {
    // 开启
    ENABLE("1", "开启"),
    // 暂停
    DISABLE("2", "暂停"),
    // 删除
    DELETE("0", "删除");

    String code;
    String message;

    SchedulerStatus(String code, String message) {
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
