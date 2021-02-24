package com.easy.restful.common.redis.constant;

/**
 * redis key前缀
 *
 * @author tengchong
 * @date 2019-01-23
 */
public class RedisPrefix {

    /**
     * 用户登录尝试次数以及锁定账号
     */
    public static final String ACCOUNT = "account:";

    /**
     * 当前会话尝试登录次数
     */
    public static final String SESSION = "account:session:";

    /**
     * shiro session
     */
    public static final String SHIRO_SESSION = "shiro:session:";

    /**
     * shiro 授权
     */
    public static final String SHIRO_AUTHORIZATION = "shiro:authorization:";

    /**
     * 系统参数
     */
    public static final String SYS_CONFIG = "sys:config:";
    /**
     * 找回密码验证码
     */
    public static final String RESET_PASSWORD_VERIFICATION_CODE = "reset:password:verification:code:";

    /**
     * 绑定手机号短信验证码
     */
    public static final String BINDING_PHONE_VERIFICATION_CODE = "binding:phone:verification:code";

    /**
     * 登录验证码
     */
    public static final String VERIFICATION_CODE = "verification:code:";
}
