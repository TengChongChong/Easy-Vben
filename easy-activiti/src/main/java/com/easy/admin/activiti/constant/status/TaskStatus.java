package com.easy.admin.activiti.constant.status;

/**
 * 任务状态
 *
 * @author TengChongChong
 * @date 2020/5/22
 */
public enum TaskStatus {
    // 办理中
    IN_PROCESS(1, "办理中"),
    // 已撤销
    RESCINDED(-1, "已撤销"),
    // 已办结
    COMPLETED(2, "已办结");

    int code;
    String message;

    TaskStatus(int code, String message) {
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
