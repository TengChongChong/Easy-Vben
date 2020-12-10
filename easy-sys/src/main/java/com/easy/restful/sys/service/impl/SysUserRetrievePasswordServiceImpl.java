package com.easy.restful.sys.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.extra.mail.MailUtil;
import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.common.redis.constant.RedisPrefix;
import com.easy.restful.common.redis.util.RedisUtil;
import com.easy.restful.core.mail.MailTemplate;
import com.easy.restful.sys.common.constant.SysConst;
import com.easy.restful.sys.service.SysMailVerifiesService;
import com.easy.restful.sys.service.SysUserRetrievePasswordService;
import com.easy.restful.sys.service.SysUserService;
import com.easy.restful.util.SysConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean sendMail(String username, String mail) {
        if (StrUtil.isNotBlank(username)) {
            String userMail = sysUserService.getSysUserMailByUserName(username);
            if (StrUtil.isNotBlank(userMail) && userMail.equals(mail)) {
                String hideUsername = StrUtil.hide(username, 1, username.length() - 1);
                // 验证码
                String code = RandomUtil.randomString(6);
                // 放到redis中,用于修改密码时验证
                RedisUtil.set(RedisPrefix.RESET_PASSWORD_VERIFICATION_CODE + username, code);
                String content = "<b>尊敬的" + hideUsername + "你好：</b>\n" +
                        "<br><br>\n" +
                        "感谢你使用\n" +
                        "<a href=\"" + SysConst.projectProperties.getProjectUrl() + "\" target=\"_blank\" rel=\"noopener\">\n" +
                        "    " + SysConfigUtil.getProjectName() + "\n" +
                        "</a>\n" +
                        "<br><br>\n" +
                        "我们已经收到了你的重置密码申请，你的验证码为 <font style=\"color: #dc3545;\">" + code + "</font>，有效期30分钟。\n";
                MailUtil.sendHtml(mail, "账号" + hideUsername + "密码重置", MailTemplate.sendResetPasswordMail(content));
                return true;
            }
            throw new EasyException("用户名与邮箱不匹配");
        } else {
            throw new EasyException("获取用户名失败");
        }
    }

    @Override
    public boolean verifiesCode(String username, String code) {
        if (StrUtil.isNotBlank(username) && StrUtil.isNotBlank(code)) {
            String relCode = (String)RedisUtil.get(RedisPrefix.RESET_PASSWORD_VERIFICATION_CODE + username);
            // 缓存中有当前用户重置密码需要的验证码
            if(StrUtil.isNotBlank(relCode)){
                if(SecureUtil.md5(relCode).equals(code)){
                    return true;
                }
                throw new EasyException("验证码错误，请重新输入");
            }
            throw new EasyException("验证码已过期，请重新发送");
        }
        throw new EasyException("获取用户名或验证码失败");
    }

    @Override
    public boolean resetPassword(String username, String code, String password) {
        if (StrUtil.isNotBlank(username) && StrUtil.isNotBlank(code)) {
            if (verifiesCode(username, code)) {
                boolean isSuccess = sysUserService.resetPassword(username, password);
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
