package com.easy.admin.workflow.constant.status;

import lombok.Getter;

/**
 * 任务状态
 *
 * @author TengChongChong
 * @date 2025-07-14
 */
@Getter
public enum WorkflowTaskStatus {
    // 办理中
    IN_PROCESS("1", "办理中"),
    // 已撤销
    RESCINDED("-1", "已撤销"),
    // 已办结
    COMPLETED("2", "已办结");

    final String code;
    final String desc;

    WorkflowTaskStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
