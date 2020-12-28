package com.easy.restful.sys.service;

import cn.hutool.json.JSONObject;
import com.easy.restful.sys.model.SysUser;
import com.easy.restful.sys.model.SysUserSetting;

/**
 * 个人中心
 *
 * @author tengchong
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
     * @param path 文件路径
     * @return url
     */
    String saveUserAvatar(String path);

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
     * 保存偏好设置
     *
     * @param setting 偏好设置
     * @return true/false
     */
    boolean saveUserSetting(SysUserSetting setting);

    /**
     * 修改当前用户密码
     *
     * @param json {oldPassword: '', password: '', passwordStrength: ''}
     * @return true/false
     */
    boolean changePassword(JSONObject json);
}
