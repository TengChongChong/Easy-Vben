package com.easy.admin.common.core.exception;


import com.easy.admin.common.core.common.status.ResultCode;

/**
 * 全局异常
 *
 * @author TengChongChong
 * @date 2019-08-30
 */
public enum GlobalException implements EasyServiceException {
    // 会话信息已过期
    SESSION_INVALID(ResultCode.UNAUTHORIZED.getCode(), "会话信息已过期"),
    // 用户在其他地方登录
    SESSION_LOGIN_ELSEWHERE(ResultCode.UNAUTHORIZED.getCode(), "你的账号在其他地方登录，你被强制退出"),
    // 被管理员强制踢出
    SESSION_FORCE_LOGOUT(ResultCode.UNAUTHORIZED.getCode(), "被管理员强制退出"),
    // 要删除的信息包含子节点
    EXIST_CHILD(ResultCode.INTERNAL_SERVER.getCode(), "要删除的信息包含子节点，请移除子节点后重试"),
    // 获取数据失败
    FAILED_TO_GET_DATA(ResultCode.INTERNAL_SERVER.getCode(), "获取数据失败，请重试"),
    // 乐观锁
    LOCK_ERROR(ResultCode.INTERNAL_SERVER.getCode(), "当前编辑数据已被他人修改，请重新点击修改按钮获取最新数据"),
    // 未知错误
    UNKNOWN_ERROR(ResultCode.INTERNAL_SERVER.getCode(), "未知错误，请联系管理员");
    /**
     * 错误代码
     */
    private String code;
    /**
     * 错误信息
     */
    private String message;

    GlobalException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
