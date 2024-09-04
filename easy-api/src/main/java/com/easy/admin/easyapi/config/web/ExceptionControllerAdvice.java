package com.easy.admin.easyapi.config.web;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.common.core.common.status.ResultCode;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.util.Response;
import com.easy.admin.config.properties.ProjectProperties;
import com.easy.admin.config.sa.token.util.SessionUtil;
import com.easy.admin.sys.common.status.ProfilesActiveStatus;
import com.easy.admin.sys.model.SysException;
import com.easy.admin.sys.service.SysExceptionService;
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
    private ProjectProperties projectProperties;

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
    @ExceptionHandler(NotLoginException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Response unauthenticatedException(NotLoginException e) {
        switch (e.getType()) {
            case NotLoginException.INVALID_TOKEN:
            case NotLoginException.TOKEN_TIMEOUT:
                return Response.failError(ResultCode.UNAUTHORIZED.getCode(), "会话已失效，请重新登录");
            case NotLoginException.BE_REPLACED:
                StpUtil.logout();
                return Response.failError(ResultCode.UNAUTHORIZED.getCode(), "你的帐号在另一地点登录，你已被迫退出");
            case NotLoginException.KICK_OUT:
                StpUtil.logout();
                return Response.failError(ResultCode.UNAUTHORIZED.getCode(), "你被管理员强制退出");
            default:
                return Response.failError(ResultCode.UNAUTHORIZED.getCode(), "你尚未登录，请登录后重试");
        }
    }

    /**
     * 权限异常（已登录无权限）
     */
    @ExceptionHandler({NotPermissionException.class, NotRoleException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Response unauthorizedException(HttpServletRequest request, SaTokenException e) {
        // 你无权限访问此资源
        return Response.failError(ResultCode.FORBIDDEN.getCode(), "无权限访问[" + request.getMethod() + "]" + request.getRequestURI());
    }

    /**
     * 会话异常（已登录无权限）
     */
    @ExceptionHandler({SaTokenException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response saTokenExceptionException(HttpServletRequest request, SaTokenException e) {
        // 你无权限访问此资源
        return Response.failError(ResultCode.FORBIDDEN.getCode(), "会话异常[" + request.getMethod() + "]" + request.getRequestURI());
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
        SysException sysException = saveLog(HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getMethod() + " " + request.getRequestURI(), e);
        if (ProfilesActiveStatus.DEV.getProfilesActive().equals(projectProperties.getProfilesActive())) {
            return Response.failError(e.getMessage());
        } else {
            // 非开发环境不返回错误信息，防止泄露数据库或其他敏感信息
            return Response.failError("操作失败，系统已记录错误信息，错误ID：" + sysException.getId());
        }
    }

    /**
     * 保存异常信息
     *
     * @param code 错误代码
     * @param uri  请求地址
     * @param e    异常信息
     */
    private SysException saveLog(int code, String uri, RuntimeException e) {
        SysException sysException = new SysException();
        sysException.setCode(code);
        sysException.setMessage(e.getMessage());
        sysException.setUrl(uri);
        sysException.setTriggerTime(new Date());
        sysException.setType(e.getClass().getName());
        sysException.setTrace(StrUtil.join("\n\t", e.getStackTrace()));
        try {
            SessionUserVO currentUser = SessionUtil.getCurrentUser();
            if (currentUser != null) {
                sysException.setUserId(currentUser.getId());
            }
        } catch (RuntimeException runtimeException) {
            // ignore
        }

        sysExceptionService.saveData(sysException);
        return sysException;
    }
}
