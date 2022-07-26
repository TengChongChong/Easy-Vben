package com.easy.admin.sys.common.constant;

/**
 * 图形验证码
 *
 * @author tengchong
 * @date 2022/7/21
 */
public class CaptchaConst {
    /**
     * check校验坐标
     */
    public static String REDIS_CAPTCHA_KEY = "captcha:%s";

    /**
     * 后台二次校验坐标
     */
    public static String REDIS_SECOND_CAPTCHA_KEY = "captcha:second-%s";
}
