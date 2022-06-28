package com.easy.admin.easyapi.config.web;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.common.core.common.status.ResultCode;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.util.Response;
import com.easy.admin.sys.model.SysException;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.sys.service.SysExceptionService;
import com.easy.admin.util.ShiroUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 通用异常处理(应用级异常)
 *
 * @author TengChongChong
 * @date 2018/10/22
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysExceptionService sysExceptionService;

    /**
     * 拦截业务异常
     */
    @ExceptionHandler(EasyException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response easyException(HttpServletRequest request, EasyException e) {
        logger.debug("业务异常", e);
        return Response.failError(null, e.getCode(), e.getMessage(), e.getShowType());
    }

    /**
     * 拦截未经认证异常（未登录）
     */
    @ExceptionHandler(UnauthenticatedException.class)
    public Response unauthenticatedException(UnauthenticatedException e) {
        return Response.failError(ResultCode.UNAUTHORIZED.getCode(), "你尚未登录，请登录后重试");
    }

    /**
     * 权限异常（已登录无权限）
     */
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Response unauthorizedException(HttpServletRequest request, UnauthorizedException e) {
        // 你无权限访问此资源
        return Response.failError(ResultCode.FORBIDDEN.getCode(), "无权限访问[" + request.getMethod() + "]" + request.getRequestURI());
    }

    /**
     * 登录异常
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Response authenticationException(HttpServletRequest request, AuthenticationException e) {
        if (e.getCause() != null && e.getCause() instanceof EasyException) {
            logger.error("登录异常:" + e.getCause().getMessage());
            EasyException easyException = (EasyException) e.getCause();
            return Response.failError(null, easyException.getCode(), easyException.getMessage(), easyException.getShowType());
        } else {
            logger.error("登录异常:" + e.getMessage());
            return Response.failError(e.getMessage(), Response.SHOW_TYPE_WARNING);
        }
    }

    /**
     * 缺少请求体异常
     *
     * @param e 缺少请求体异常
     * @return ResponseResult
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Response parameterBodyMissingExceptionHandler(HttpMessageNotReadableException e) {
        return Response.failError(ResultCode.BAD_REQUEST.getCode(), "参数体为空或参数类型错误[" + e.getMessage() + "]");
    }

    /**
     * 参数效验异常
     *
     * @param e 参数验证异常
     * @return ResponseInfo
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response parameterExceptionHandler(MethodArgumentNotValidException e) {
        // 获取异常信息
        BindingResult exceptions = e.getBindingResult();
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
        if (exceptions.hasErrors()) {
            List<ObjectError> errors = exceptions.getAllErrors();
            if (!errors.isEmpty()) {
                // 这里列出了全部错误参数，按正常逻辑，只需要第一条错误即可
                FieldError fieldError = (FieldError) errors.get(0);
                return Response.failError(ResultCode.BAD_REQUEST.getCode(), fieldError.getDefaultMessage());
            }
        }
        return Response.failError(ResultCode.BAD_REQUEST.getCode(), "参数效验异常[" + e.getMessage() + "]");
    }

    /**
     * 未知异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object handleException(HttpServletRequest request, RuntimeException e) {
        logger.debug("未知异常", e);
        // 将异常记录到表中
        saveLog(HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getMethod() + " " + request.getRequestURI(), e);
        return Response.failError(e.getMessage());
    }

    /**
     * 保存异常信息
     *
     * @param code 错误代码
     * @param uri  请求地址
     * @param e    异常信息
     */
    private void saveLog(int code, String uri, RuntimeException e) {
        SysException sysException = new SysException();
        sysException.setCode(code);
        sysException.setMessage(e.getMessage());
        sysException.setUrl(uri);
        sysException.setTriggerTime(new Date());
        sysException.setType(e.getClass().getName());
        sysException.setTrace(StrUtil.join("\n\t", e.getStackTrace()));
        SysUser currentUser = ShiroUtil.getCurrentUser();
        if (currentUser != null) {
            sysException.setUserId(currentUser.getId());
        }
        sysExceptionService.saveData(sysException);
    }
}
