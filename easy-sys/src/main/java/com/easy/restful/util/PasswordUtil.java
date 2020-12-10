package com.easy.restful.util;

import cn.hutool.crypto.SecureUtil;

/**
 * 密码工具
 *
 * @author tengchong
 * @date 2018/9/4
 */
public class PasswordUtil {

    /**
     * 安全密码 作为盐值用于用户密码的加密
     * 注: 修改后会导致所有密码失效
     */
    public static final String PASSWORD = "e89aadbe-b052-11e8-96f8-529269fb1459";

    private PasswordUtil() {}

    /**
     * 加密密码 用于登录/重置密码
     *
     * @param password 密码(经过一次md5)
     * @param salt     盐
     * @return 加密后密码
     */
    public static String encryptedPasswords(String password, String salt) {
        return SecureUtil.md5((SecureUtil.md5(salt + PASSWORD) + password));
    }

    /**
     * 生成密码 用于用户注册/新增用户
     *
     * @param password 密码 未加密
     * @param salt     盐
     * @return 加密后密码
     */
    public static String generatingPasswords(String password, String salt) {
        return SecureUtil.md5((SecureUtil.md5(salt + PASSWORD) + SecureUtil.md5(password)));
    }
}
