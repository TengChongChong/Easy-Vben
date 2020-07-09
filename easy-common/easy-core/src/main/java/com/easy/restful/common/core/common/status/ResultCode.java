package com.easy.restful.common.core.common.status;

/**
 * 响应码，由6位数字构成abbccc
 * a   错误级别 0-成功、1-信息、2-警告、3-错误
 * bb  服务模块代码，请从01开始使用00为公共模块
 * ccc 具体错误代码
 *
 * @author tengchong
 * @date 2018/10/22
 **/
public enum ResultCode {
    /**
     * 成功
     */
    OK("000000"),
    /**
     * 1、语义有误，当前请求无法被服务器理解。除非进行修改，否则客户端不应该重复提交这个请求 2、请求参数有误
     */
    BAD_REQUEST("300400"),
    /**
     * 用户没有权限（令牌、用户名、密码错误）
     */
    UNAUTHORIZED("300401"),
    /**
     * 用户得到授权（与401错误相对），但是访问是被禁止的
     */
    FORBIDDEN("300403"),
    /**
     * 发出的请求针对的是不存在的记录，服务器没有进行操作
     */
    NOT_FOUND("300404"),
    /**
     * info 级别提示
     */
    INTERNAL_SERVER_INFO("100500"),
    /**
     * warn 级别提示
     */
    INTERNAL_SERVER_WARN("200500"),
    /**
     * error 级别提示
     */
    INTERNAL_SERVER_ERROR("300500");

    /**
     * 响应码
     */
    private String code;

    ResultCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
