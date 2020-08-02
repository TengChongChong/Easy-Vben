package com.easy.restful.common.core.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.ContentType;
import cn.hutool.json.JSONObject;
import com.easy.restful.common.core.common.status.ResultCode;
import com.easy.restful.common.core.exception.EasyException;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.servlet.http.HttpServletResponse;

/**
 * 封装响应数据
 *
 * @author tengchong
 * @date 2018/10/22
 */
public class Tips {

    /**
     * 响应码，由6位数字构成a,bb,ccc；如级别 >= 2使用封装ajax时会自动提示错误信息
     * a   表示错误级别 eg: 0-成功、1-信息、2-警告、3-错误
     * bb  服务模块代码，请从01开始使用00为公共模块
     * ccc 具体错误代码
     * <p>
     * 注：com.frame.easy.common.status.ResultStatus 中定义的错误代码请按照注释在相应的场景下使用
     */
    private String code;

    /**
     * 提示文字，当code >= 2并且message不为空时将会提示错误
     * 注: 如处理失败,务必返回原因
     */
    private String message;

    /**
     * 响应数据
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    /**
     * 时间戳
     */
    private long timeStamp = System.currentTimeMillis();

    /**
     * 成功默认
     * 响应码默认为000000
     *
     * @return Tips
     */
    public static Tips success() {
        return success("success", null);
    }

    /**
     * 成功
     * 响应码默认为000000
     *
     * @param message 提示
     * @return Tips
     */
    public static Tips success(String message) {
        return success(message, null);
    }

    /**
     * 成功
     * 响应码默认为000000
     *
     * @param data 响应数据
     * @return Tips
     */
    public static Tips success(Object data) {
        return new Tips(ResultCode.OK.getCode(), "success", data);
    }

    /**
     * 成功
     * 响应码默认为000000
     *
     * @param message 提示
     * @param data    响应数据
     * @return Tips
     */
    public static Tips success(String message, Object data) {
        return new Tips(ResultCode.OK.getCode(), message, data);
    }

    /**
     * 失败默认
     * 响应码默认为300500
     *
     * @param message 提示
     * @return Tips
     */
    public static Tips fail(String message) {
        return fail(message, null);
    }

    /**
     * 失败
     * 响应码默认为300500，
     *
     * @param message 提示
     * @param data    响应数据
     * @return Tips
     */
    public static Tips fail(String message, Object data) {
        return new Tips(ResultCode.INTERNAL_SERVER_ERROR.getCode(), message, data);
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
                new Tips(code, message).toString(),
                ContentType.build(ContentType.JSON.getValue(), CharsetUtil.charset(CharsetUtil.UTF_8)));
    }

    public Tips() {
    }

    public Tips(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Tips(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Tips(EasyException e) {
        this.code = e.getCode();
        this.message = e.getMessage();
    }

    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
