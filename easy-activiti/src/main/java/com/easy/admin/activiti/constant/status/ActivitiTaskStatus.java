package com.easy.admin.activiti.constant.status;

/**
 * 任务状态
 *
 * @author TengChongChong
 * @date 2020/5/22
 */
public enum ActivitiTaskStatus {
    // 办理中
    IN_PROCESS("1", "办理中"),
    // 已撤销
    RESCINDED("-1", "已撤销"),
    // 已办结
    COMPLETED("2", "已办结");

    String code;
    String message;

    ActivitiTaskStatus(String code, String message) {
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
