package com.easy.restful.common.core.exception;


import com.easy.restful.common.core.common.status.ResultCode;

/**
 * 自定义Exception
 *
 * @author tengchong
 * @date 2019-01-20
 */
public class EasyException extends RuntimeException {
    /**
     * 响应码
     */
    private String code;
    /**
     * 错误信息
     */
    private String message;

    public EasyException(String message) {
        // 默认为error级别错误
        this.code = ResultCode.INTERNAL_SERVER_ERROR.getCode();
        this.message = message;
    }

    public EasyException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public EasyException(EasyServiceException easyServiceException) {
        this.code = easyServiceException.getCode();
        this.message = easyServiceException.getMessage();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
