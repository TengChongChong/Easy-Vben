package com.easy.restful.sys.service;

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
     * @return true/false
     */
    boolean saveUserInfo(SysUser sysUser);

    /**
     * 申请绑定密保邮箱
     *
     * @param mail 邮箱地址
     * @return true/false
     */
    boolean applicationBindingMail(String mail);

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
     * @param oldPassword 当前密码
     * @param password    新密码
     * @return true/false
     */
    boolean changePassword(String oldPassword, String password);
}
