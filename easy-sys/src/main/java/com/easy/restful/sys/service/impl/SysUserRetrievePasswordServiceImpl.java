package com.easy.restful.sys.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.MailUtil;
import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.common.redis.constant.RedisPrefix;
import com.easy.restful.common.redis.util.RedisUtil;
import com.easy.restful.core.mail.MailTemplate;
import com.easy.restful.sys.model.SysUser;
import com.easy.restful.sys.service.SysMailVerifiesService;
import com.easy.restful.sys.service.SysUserRetrievePasswordService;
import com.easy.restful.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 找回密码
 *
 * @author tengchong
 * @date 2019-03-28
 */
@Service
public class SysUserRetrievePasswordServiceImpl implements SysUserRetrievePasswordService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMailVerifiesService sysMailVerifiesService;

    @Override
    public boolean sendEmail(String username, String email) {
        SysUser sysUser = sysUserService.getSysUserMailAndPhoneByUserName(username);
        if (sysUser == null || StrUtil.isBlank(sysUser.getEmail()) || !sysUser.getEmail().equals(email)) {
            throw new EasyException("用户名与邮箱不匹配");
        }
        String hideUsername = StrUtil.hide(username, 1, username.length() - 1);
        // 验证码
        String code = RandomUtil.randomString(6);
        // 放到redis中,用于修改密码时验证
        RedisUtil.set(RedisPrefix.RESET_PASSWORD_VERIFICATION_CODE + username, code);
        Map<String, Object> params = new HashMap<>(2);
        params.put("code", code);
        params.put("username", hideUsername);
        MailUtil.sendHtml(email, "账号" + hideUsername + "密码重置", MailTemplate.getContent("/mail/rest-password.html", params));
        return true;
    }

    @Override
    public String sendMessage(String username, String phone) {
        SysUser sysUser = sysUserService.getSysUserMailAndPhoneByUserName(username);
        if (sysUser == null || StrUtil.isBlank(sysUser.getEmail()) || !sysUser.getPhone().equals(phone)) {
            throw new EasyException("用户名与手机号不匹配");
        }
        String hideUsername = StrUtil.hide(username, 1, username.length() - 1);
        // 验证码
        String code = RandomUtil.randomString(6);
        // 放到redis中,用于修改密码时验证
        RedisUtil.set(RedisPrefix.RESET_PASSWORD_VERIFICATION_CODE + username, code);
        Map<String, Object> params = new HashMap<>(2);
        params.put("code", code);
        params.put("username", hideUsername);
        // todo: 发送短信，这里只做模拟
        return code;
    }

    @Override
    public boolean verifiesCode(String username, String code) {
        if (StrUtil.isBlank(username) || StrUtil.isBlank(code)) {
            throw new EasyException("获取用户名或验证码失败");
        }
        String relCode = (String) RedisUtil.get(RedisPrefix.RESET_PASSWORD_VERIFICATION_CODE + username);
        // 缓存中有当前用户重置密码需要的验证码
        if (StrUtil.isBlank(relCode)) {
            throw new EasyException("验证码已过期，请重新发送");
        }
        if (!relCode.equals(code)) {
            throw new EasyException("验证码错误，请重新输入");
        }
        return true;
    }

    @Override
    public boolean resetPassword(String username, String code, String password) {
        if (StrUtil.isNotBlank(username) && StrUtil.isNotBlank(code)) {
            if (verifiesCode(username, code)) {
                boolean isSuccess = sysUserService.resetPassword(username, password, null);
                if (isSuccess) {
                    sysMailVerifiesService.remove(code);
                    return true;
                } else {
                    throw new EasyException("更新密码失败，请稍后重试");
                }
            }
        }
        throw new EasyException("获取用户名或校验码失败");
    }

}
