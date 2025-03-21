package com.easy.admin.common.core.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.easy.admin.common.core.constant.helper.NodePropertiesConstantsHelper;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 封装响应数据
 *
 * @author TengChongChong
 * @date 2020/08/24
 */
@Data
public class Response implements Serializable {
    /**
     * 错误级别 - info
     */
    public static final String SHOW_TYPE_INFO = "info";
    /**
     * 错误级别 - warning
     */
    public static final String SHOW_TYPE_WARNING = "warning";
    /**
     * 错误级别 - error
     */
    public static final String SHOW_TYPE_ERROR = "error";

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
     * 错误级别
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String showType;

    /**
     * 方便后端故障排除：唯一的请求ID，保留字段
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String traceId;

    /**
     * 方便后端故障排除：当前访问服务器的主机
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String host = NodePropertiesConstantsHelper.node;

    /**
     * 时间戳
     */
    private long timeStamp = System.currentTimeMillis();

    /**
     * 成功默认
     *
     * @return Response
     */
    public static Response success() {
        return success(null);
    }

    /**
     * 成功
     *
     * @param data 响应数据
     * @return Response
     */
    public static Response success(Object data) {
        Response response = new Response();
        response.setData(data);
        return response;
    }

    /**
     * 失败提示 - Notification 通知提醒框 - warning
     *
     * @param errorMessage 错误信息
     * @return Response
     */
    public static Response failWarning(String errorMessage) {
        return fail(null, ERROR_CODE, errorMessage, SHOW_TYPE_WARNING);
    }

    /**
     * 失败提示 - Notification 通知提醒框 - warning
     *
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     * @return Response
     */
    public static Response failWarning(String errorCode, String errorMessage) {
        return fail(null, errorCode, errorMessage, SHOW_TYPE_WARNING);
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
        return fail(data, errorCode, errorMessage, SHOW_TYPE_WARNING);
    }

    /**
     * 失败提示 - Notification 通知提醒框 - error
     *
     * @param errorMessage 错误信息
     * @return Response
     */
    public static Response failError(String errorMessage) {
        return fail(null, ERROR_CODE, errorMessage, SHOW_TYPE_ERROR);
    }

    /**
     * 失败提示 - Notification 通知提醒框 - error
     *
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     * @return Response
     */
    public static Response failError(String errorCode, String errorMessage) {
        return fail(null, errorCode, errorMessage, SHOW_TYPE_ERROR);
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
        return fail(data, errorCode, errorMessage, SHOW_TYPE_ERROR);
    }

    /**
     * 失败提示 - Notification 通知提醒框 - error
     *
     * @param data         响应数据
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     * @param showType     错误显示方式
     * @return Response
     */
    public static Response failError(Object data, String errorCode, String errorMessage, String showType) {
        return fail(data, errorCode, errorMessage, showType);
    }

    /**
     * 失败提示
     *
     * @param data         响应数据
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     * @param showType     错误显示方式
     * @return Response
     */
    public static Response fail(Object data, String errorCode, String errorMessage, String showType) {
        Response response = new Response();
        response.setSuccess(false);
        response.setData(data);
        response.setErrorCode(StrUtil.isBlank(errorCode) ? ERROR_CODE : errorCode);
        response.setErrorMessage(errorMessage);
        response.setShowType(showType);
        return response;
    }

    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }
}
