package com.easy.restful.auth.constant;

/**
 * Session常量
 *
 * @author tengchong
 * @date 2018/9/4
 */
public class SessionConst {

    /**
     * 当前登录用户session key
     */
    public static final String USER_SESSION_KEY = "user";

    /**
     * 记住我cookie
     */
    public static final String REMEMBER_ME = "rememberMe";

    /**
     * 管理员强制退出
     */
    public static final String FORCE_LOGOUT = "force_logout";

    /**
     * 在其他地方登录,被踢出
     */
    public static final String LOGIN_ELSEWHERE = "login_elsewhere";

    /**
     * 超时失效
     */
    public static final String INVALID = "invalid";

    /**
     * 登录验证码
     */
    public static final String VERIFICATION_CODE = "verificationCode";


}
