package com.easy.admin.auth.service;

import cn.hutool.json.JSONObject;
import com.easy.admin.auth.model.SysUser;

/**
 * 个人中心
 *
 * @author TengChongChong
 * @date 2019-03-04
 */
public interface SysUserPersonalCenterService {

    /**
     * 获取当前登录用户信息
     *
     * @return SysUser
     */
    SysUser getCurrentUser();

    /**
     * 保存头像
     *
     * @param url url
     * @return url
     */
    String saveUserAvatar(String url);

    /**
     * 保存当前用户信息
     *
     * @param sysUser 用户信息
     * @return 保存后信息
     */
    SysUser saveUserInfo(SysUser sysUser);

    /**
     * 申请绑定密保邮箱
     *
     * @param email 邮箱地址
     * @return true/false
     */
    boolean applicationBindingEmail(String email);

    /**
     * 申请绑定密保邮箱
     *
     * @param phone 手机号
     * @param captcha  验证码
     * @return true/false
     */
    boolean bindingPhone(String phone, String captcha);

    /**
     * 修改当前用户密码
     *
     * @param json {oldPassword: '', password: '', passwordStrength: ''}
     * @return true/false
     */
    boolean changePassword(JSONObject json);
}
