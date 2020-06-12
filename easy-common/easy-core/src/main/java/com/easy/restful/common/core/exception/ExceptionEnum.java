package com.easy.restful.common.core.exception;

import com.easy.restful.common.core.constant.status.ResultCode;

/**
 * 常用异常
 *
 * @author tengchong
 * @date 2018/10/31
 **/
public enum ExceptionEnum implements EasyServiceException {
    // 获取数据失败
    FAILED_TO_GET_DATA(ResultCode.INTERNAL_SERVER_ERROR.getCode(), "获取数据失败，请重试"),
    // 未知错误
    UNKNOWN_ERROR(ResultCode.INTERNAL_SERVER_ERROR.getCode(), "未知错误，请联系管理员");

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
