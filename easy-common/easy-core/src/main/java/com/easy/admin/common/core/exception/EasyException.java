package com.easy.admin.common.core.exception;


import com.easy.admin.common.core.common.status.ResultCode;

/**
 * 自定义Exception
 *
 * @author TengChongChong
 * @date 2019-01-20
 */
public class EasyException extends RuntimeException {
    /**
     * 响应码
     */
    private String code = ResultCode.INTERNAL_SERVER.getCode();
    /**
     * 错误信息
     */
    private String message;

    /**
     * 错误显示方式：0 静默 ； 1 notification.info; 2 notification.warning; 3 notification.error; 9 page
     */
    private Integer showType = 3;

    public EasyException(String message) {
        // 默认为error级别错误
        this.code = ResultCode.INTERNAL_SERVER.getCode();
        this.message = message;
    }

    public EasyException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public EasyException(Integer showType, String message) {
        this.message = message;
        this.showType = showType;
    }

    public EasyException(Integer showType, String code, String message) {
        this.code = code;
        this.message = message;
        this.showType = showType;
    }

    public EasyException(EasyServiceException easyServiceException) {
        this.code = easyServiceException.getCode();
        this.message = easyServiceException.getMessage();
    }
    public EasyException(Integer showType, EasyServiceException easyServiceException) {
        this.code = easyServiceException.getCode();
        this.message = easyServiceException.getMessage();
        this.showType = showType;
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

    public Integer getShowType() {
        return showType;
    }

    public void setShowType(Integer showType) {
        this.showType = showType;
    }
}
