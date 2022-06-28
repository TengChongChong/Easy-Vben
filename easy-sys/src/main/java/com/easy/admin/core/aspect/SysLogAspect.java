package com.easy.admin.core.aspect;

import com.easy.admin.common.core.util.WebUtils;
import com.easy.admin.sys.model.SysLog;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.sys.service.SysLogService;
import com.easy.admin.util.ShiroUtil;
import com.easy.admin.util.http.IpUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * 日志
 *
 * @author TengChongChong
 * @date 2019-06-27
 */
@Aspect
@Component
public class SysLogAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysLogService service;

    /**
     * 切点
     */
    @Pointcut("@annotation(com.easy.admin.core.annotation.SysLog)")
    public void pointcut() {
    }

    /**
     * return 后保存日志信息
     *
     * @param joinPoint 切点
     */
    @AfterReturning("pointcut()")
    public void saveSysLog(JoinPoint joinPoint) {
        HttpServletRequest request = null;
        try {
            request = WebUtils.getRequest();
        } catch (NullPointerException e) {
            logger.debug("获取request失败");
        }
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 被拦截的方法
        Method method = signature.getMethod();

        // 注解信息
        com.easy.admin.core.annotation.SysLog log = method.getAnnotation(com.easy.admin.core.annotation.SysLog.class);

        // 日志信息
        SysLog sysLog = new SysLog();
        // 设置注解信息
        sysLog.setModular(log.modular());
        sysLog.setMethod(log.method());
        // 操作用户信息
        sysLog.setOperationDate(new Date());
        SysUser currentUser = ShiroUtil.getCurrentUser();
        if (currentUser != null) {
            sysLog.setOperationUser(currentUser.getId());
        }
        //
        sysLog.setClazz(signature.getDeclaringTypeName());
        sysLog.setMethodName(signature.getName());

        // 参数
        Object[] args = joinPoint.getArgs();
        sysLog.setParams(Arrays.toString(args));
        if (request != null) {
            // 设置请求信息
            sysLog.setHttpMethod(request.getMethod());
            sysLog.setUri(request.getRequestURI());
            sysLog.setUrl(request.getRequestURL().toString());
            sysLog.setIp(IpUtil.getIpAddress(request));
        }
        try {
            service.saveData(sysLog);
        } catch (RuntimeException e) {
            logger.info("保存日志信息失败", e);
        }
    }

}
