package com.easy.restful.common.security;

import junit.framework.TestCase;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 密码测试
 *
 * @author tengchong
 * @date 2020/7/29
 */
public class PasswordEncoderTest extends TestCase {
    public void test_encoder(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "123";
        String encoderPassword = passwordEncoder.encode(password);
        System.out.println(encoderPassword);
        System.out.println(passwordEncoder.matches(password, encoderPassword));
    }
}
