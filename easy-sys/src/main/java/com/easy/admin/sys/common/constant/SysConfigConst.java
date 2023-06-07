package com.easy.admin.sys.common.constant;

/**
 * 系统参数key
 *
 * @author TengChongChong
 * @date 2019-03-03
 */
public class SysConfigConst {

    private SysConfigConst() {
    }

    /**
     * 登录时密码错误尝试次数，超过后会被账号会被锁定
     */
    public static final String LOGIN_ATTEMPTS = "loginAttempts";

    /**
     * 尝试登录次数过多账号锁定时长 单位：秒
     */
    public static final String LOGIN_LOCK_LENGTH = "loginLockLength";

    /**
     * 系统名称
     */
    public static final String PROJECT_NAME = "projectName";

    /**
     * session失效时间 单位：秒
     */
    public static final String SESSION_INVALIDATE_TIME = "sessionInvalidateTime";

    /**
     * 记住我session失效时间 单位：天
     */
    public static final String REMEMBER_ME_SESSION_INVALIDATE_TIME = "rememberMeSessionInvalidateTime";

    /**
     * 是否开启验证码
     */
    public static final String LOGIN_VERIFICATION_CODE = "loginVerificationCode";

    /**
     * 登录失败累计多少次后需要输入验证码后才可以登录,需要同时开启loginVerificationCode生效
     */
    public static final String LOGIN_ATTEMPTS_VERIFICATION_CODE = "loginAttemptsVerificationCode";

    /**
     * 是否开启用户注册
     */
    public static final String OPEN_REGISTRATION = "openRegistration";

    /**
     * 是否允许多点登录
     */
    public static final String LOGIN_MULTIPOINT = "loginMultipoint";

    /**
     * 新消息检查间隔时长 默认10s
     */
    public static final String MESSAGE_CHECK_INTERVAL = "messageCheckInterval";

    /**
     * 清理多少天前异常日志 单位: 天
     */
    public static final String CLEAN_EXCEPTION_LOG = "cleanExceptionLog";

    /**
     * 清理多少天前访问日志 单位: 天
     */
    public static final String CLEAN_SYS_LOG = "cleanSysLog";

    /**
     * 文件下载表中文件默认有效期 单位：秒
     */
    public static final String DOWNLOAD_EFFECTIVE_EXPIRE = "downloadEffectiveExpire";

    /**
     * 短信验证码有效期 单位：秒
     */
    public static final String MESSAGE_EXPIRE = "messageExpire";



}
