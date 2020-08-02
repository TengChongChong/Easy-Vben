package com.easy.restful.easyapi.config.web;

import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.common.core.util.Tips;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 通用异常处理(应用级异常)
 *
 * @author tengchong
 * @date 2018/10/22
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 拦截业务异常
     */
    @ExceptionHandler(EasyException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object easyException(HttpServletRequest request, EasyException e) {
        logger.debug("业务异常", e);
        return new Tips(e.getCode(), e.getMessage());
    }

    /**
     * 未知异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object handleException(HttpServletRequest request, RuntimeException e) {
        logger.debug("未知异常", e);
        // 将异常记录到表中
        saveLog(HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getRequestURI(), e);
        return Tips.fail(e.getMessage());
    }

    /**
     * 保存异常信息
     *
     * @param code 错误代码
     * @param uri  请求地址
     * @param e    异常信息
     */
    private void saveLog(int code, String uri, RuntimeException e) {

    }
}
