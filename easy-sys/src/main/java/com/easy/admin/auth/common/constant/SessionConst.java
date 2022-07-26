package com.easy.admin.auth.common.constant;

/**
 * Session常量
 *
 * @author TengChongChong
 * @date 2018/9/4
 */
public class SessionConst {

    private SessionConst() {
    }

    /**
     * 当前登录用户session key
     */
    public static final String USER_SESSION_KEY = "user";

    /**
     * 管理员强制退出
     */
    public static final String FORCE_LOGOUT = "force_logout";

    /**
     * 在其他地方登录,被踢出
     */
    public static final String LOGIN_ELSEWHERE = "login_elsewhere";

    /**
     * 验证码id
     */
    public static final String CODE_ID = "codeId";

    /**
     * 验证码
     */
    public static final String VERIFICATION_CODE = "verificationCode";

    /**
     * 记住我方式登录
     */
    public static final String REMEMBER_ME = "rememberMe";

}
