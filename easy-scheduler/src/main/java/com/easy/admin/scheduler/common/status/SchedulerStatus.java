package com.easy.admin.scheduler.common.status;

import lombok.Getter;

/**
 * 定时任务
 *
 * @author TengChongChong
 * @date 2019-05-11
 */
@Getter
public enum SchedulerStatus {
    // 开启
    ENABLE("1", "开启"),
    // 暂停
    DISABLE("2", "暂停"),
    // 删除
    DELETE("0", "删除");

    final String code;
    final String desc;

    SchedulerStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
