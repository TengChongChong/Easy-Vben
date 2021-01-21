package com.easy.restful.scheduler.common.status;

/**
 * 定时任务
 *
 * @author tengchong
 * @date 2019-05-11
 */
public enum SchedulerStatus {
    // 开启
    ENABLE(1, "开启"),
    // 暂停
    DISABLE(2, "暂停"),
    // 删除
    DELETE(0, "删除");

    int code;
    String message;

    SchedulerStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
