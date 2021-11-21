package com.easy.admin.util;

import cn.hutool.crypto.SecureUtil;
import junit.framework.TestCase;

/**
 * 密码工具
 *
 * @author TengChongChong
 * @date 2020/9/30
 */
public class PasswordUtilTest extends TestCase {
    /**
     * 加密密码 用于登录/重置密码
     */
    public void test_encryptedPasswords() {
        System.out.println(SecureUtil.md5("123"));
        System.out.println(PasswordUtil.encryptedPasswords("123", "xm9lqcpwf6"));
    }

    /**
     * 生成密码 用于用户注册/新增用户
     */
    public void test_generatingPasswords() {
        System.out.println(PasswordUtil.generatingPasswords("admin123", "xm9lqcpwf6"));
    }
}
