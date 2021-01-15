package com.easy.restful.activiti.constant.status;

/**
 * 挂起状态
 *
 * @author tengchong
 * @date 2020/5/22
 */
public enum SuspensionStatus {
    // 激活
    ACTIVATION(1, "激活"),
    // 挂起
    SUSPENSION(2, "挂起");

    int code;
    String message;

    SuspensionStatus(int code, String message) {
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
