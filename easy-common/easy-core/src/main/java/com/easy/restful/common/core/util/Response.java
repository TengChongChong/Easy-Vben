package com.easy.restful.common.core.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.ContentType;
import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.servlet.http.HttpServletResponse;

/**
 * 封装响应数据
 *
 * @author tengchong
 * @date 2020/08/24
 */
public class Response {
    /**
     * 静默
     */
    public static final int SILENT = 0;
    /**
     * Notification 通知提醒框 - info
     */
    public static final int NOTIFICATION_INFO = 1;
    /**
     * Notification 通知提醒框 - warning
     */
    public static final int NOTIFICATION_WARNING = 2;
    /**
     * Notification 通知提醒框 - error
     */
    public static final int NOTIFICATION_ERROR = 3;
    /**
     * Error Page
     */
    public static final int PAGE = 9;
    /**
     * 默认错误码
     */
    private static final String ERROR_CODE = "00500";

    /**
     * 是否成功
     */
    private boolean success = true;

    /**
     * 响应数据
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    /**
     * 错误码
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode;

    /**
     * 错误信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;

    /**
     * 错误显示方式：0 静默 ； 1 notification.info; 2 notification.warning; 3 notification.error; 9 page
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer showType;

    /**
     * 方便后端故障排除：唯一的请求ID，保留字段
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String traceId;

    /**
     * 方便后端故障排除：当前访问服务器的主机，保留字段
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String host;

    /**
     * 时间戳
     */
    private long timeStamp = System.currentTimeMillis();

    /**
     * 成功默认
     *
     * @return Tips
     */
    public static Response success() {
        return success(null);
    }

    /**
     * 成功
     *
     * @param data 响应数据
     * @return Tips
     */
    public static Response success(Object data) {
        Response response = new Response();
        response.setData(data);
        return response;
    }

    /**
     * 失败提示 - 静默
     *
     * @param errorMessage 错误信息
     * @return Response
     */
    public static Response failSilent(String errorMessage) {
        return fail(null, ERROR_CODE, errorMessage, SILENT);
    }

    /**
     * 失败提示 - 静默
     *
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     * @return Response
     */
    public static Response failSilent(String errorCode, String errorMessage) {
        return fail(null, errorCode, errorMessage, SILENT);
    }

    /**
     * 失败提示 - 静默
     *
     * @param data         响应数据
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     * @return Response
     */
    public static Response failSilent(Object data, String errorCode, String errorMessage) {
        return fail(data, errorCode, errorMessage, SILENT);
    }

    /**
     * 失败提示 - Notification 通知提醒框 - warning
     *
     * @param errorMessage 错误信息
     * @return Response
     */
    public static Response failWarning(String errorMessage) {
        return fail(null, ERROR_CODE, errorMessage, NOTIFICATION_WARNING);
    }

    /**
     * 失败提示 - Notification 通知提醒框 - warning
     *
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     * @return Response
     */
    public static Response failWarning(String errorCode, String errorMessage) {
        return fail(null, errorCode, errorMessage, NOTIFICATION_WARNING);
    }

    /**
     * 失败提示 - Notification 通知提醒框 - warning
     *
     * @param data         响应数据
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     * @return Response
     */
    public static Response failWarning(Object data, String errorCode, String errorMessage) {
        return fail(data, errorCode, errorMessage, NOTIFICATION_WARNING);
    }

    /**
     * 失败提示 - Notification 通知提醒框 - error
     *
     * @param errorMessage 错误信息
     * @return Response
     */
    public static Response failError(String errorMessage) {
        return fail(null, ERROR_CODE, errorMessage, NOTIFICATION_ERROR);
    }

    /**
     * 失败提示 - Notification 通知提醒框 - error
     *
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     * @return Response
     */
    public static Response failError(String errorCode, String errorMessage) {
        return fail(null, errorCode, errorMessage, NOTIFICATION_ERROR);
    }

    /**
     * 失败提示 - Notification 通知提醒框 - error
     *
     * @param data         响应数据
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     * @return Response
     */
    public static Response failError(Object data, String errorCode, String errorMessage) {
        return fail(data, errorCode, errorMessage, NOTIFICATION_ERROR);
    }

    /**
     * 失败提示 - Error Page
     *
     * @param errorMessage 错误信息
     * @return Response
     */
    public static Response failPage(String errorMessage) {
        return fail(null, ERROR_CODE, errorMessage, PAGE);
    }

    /**
     * 失败提示 - Error Page
     *
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     * @return Response
     */
    public static Response failPage(String errorCode, String errorMessage) {
        return fail(null, errorCode, errorMessage, PAGE);
    }

    /**
     * 失败提示 - Error Page
     *
     * @param data         响应数据
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     * @return Response
     */
    public static Response failPage(Object data, String errorCode, String errorMessage) {
        return fail(data, errorCode, errorMessage, PAGE);
    }


    /**
     * 失败提示
     *
     * @param data         响应数据
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     * @param showType     错误显示方式：0 静默 ； 1 message.warn; 2 message.error; 4 notification; 9 page
     * @return Response
     */
    public static Response fail(Object data, String errorCode, String errorMessage, Integer showType) {
        Response response = new Response();
        response.setSuccess(false);
        response.setData(data);
        response.setErrorCode(StrUtil.isBlank(errorCode) ? ERROR_CODE : errorCode);
        response.setErrorMessage(errorMessage);
        response.setShowType(showType);
        return response;
    }

    /**
     * 返回信息
     *
     * @param response HttpServletResponse
     * @param code     状态码
     * @param message  消息
     */
    public static void response(HttpServletResponse response, String code, String message) {
        ServletUtil.write(
                response,
                Response.failError(code, message).toString(),
                ContentType.build(ContentType.JSON.getValue(), CharsetUtil.charset(CharsetUtil.UTF_8)));
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getShowType() {
        return showType;
    }

    public void setShowType(Integer showType) {
        this.showType = showType;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }
}
