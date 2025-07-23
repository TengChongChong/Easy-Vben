package com.easy.admin.workflow.constant.status;

import lombok.Getter;

/**
 * 挂起状态
 *
 * @author TengChongChong
 * @date 2025-07-14
 */
@Getter
public enum WorkflowSuspensionStatus {
    // 激活
    ACTIVATION(1, "激活"),
    // 挂起
    SUSPENSION(2, "挂起");

    final int code;
    final String desc;

    WorkflowSuspensionStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
