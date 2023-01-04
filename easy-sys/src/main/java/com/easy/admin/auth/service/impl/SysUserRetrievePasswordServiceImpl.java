package com.easy.admin.auth.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.MailUtil;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.core.mail.MailTemplate;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.sys.service.SysMailVerificationService;
import com.easy.admin.auth.service.SysUserRetrievePasswordService;
import com.easy.admin.auth.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 找回密码
 *
 * @author TengChongChong
 * @date 2019-03-28
 */
@Service
public class SysUserRetrievePasswordServiceImpl implements SysUserRetrievePasswordService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMailVerificationService sysMailVerifiesService;

    @Override
    public boolean sendEmail(String username, String email) {
        SysUser sysUser = sysUserService.getSysUserMailAndPhoneByUserName(username);
        if (sysUser == null || StrUtil.isBlank(sysUser.getEmail()) || !sysUser.getEmail().equals(email)) {
            throw new EasyException("账号与邮箱不匹配");
        }
        String hideUsername = StrUtil.hide(username, 1, username.length() - 1);
        // 验证码
        String code = RandomUtil.randomNumbers(6);
        // 放到redis中,用于修改密码时验证
        RedisUtil.set(RedisPrefix.RESET_PASSWORD_VERIFICATION_CODE + username, code);
        Map<String, Object> params = new HashMap<>(2);
        params.put("code", code);
        params.put("username", hideUsername);
        MailUtil.sendHtml(email, "账号" + hideUsername + "密码重置", MailTemplate.getContent("/mail/rest-password.html", params));
        return true;
    }

    @Override
    public String sendSms(String username, String mobile) {
        SysUser sysUser = sysUserService.getSysUserMailAndPhoneByUserName(username);
        if (sysUser == null || StrUtil.isBlank(sysUser.getEmail()) || !sysUser.getPhoneNumber().equals(mobile)) {
            throw new EasyException("账号与手机号不匹配");
        }
        // 验证码
        String code = RandomUtil.randomNumbers(6);
        // 放到redis中,用于修改密码时验证
        RedisUtil.set(RedisPrefix.RESET_PASSWORD_VERIFICATION_CODE + username, code);
        // todo: 发送短信
        return code;
    }

    @Override
    public boolean verifiesCode(String username, String code) {
        if (StrUtil.isBlank(username) || StrUtil.isBlank(code)) {
            throw new EasyException("获取账号或验证码失败");
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
        // 检查账户与验证码
        verifiesCode(username, code);
        boolean isSuccess = sysUserService.resetPassword(username, password);
        if (!isSuccess) {
            throw new EasyException("更新密码失败，请稍后重试");
        }
        sysMailVerifiesService.remove(code);
        return true;
    }
}
