package com.easy.admin.auth.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.MailUtil;
import com.easy.admin.auth.common.constant.SessionConst;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.auth.model.vo.ChangePasswordVO;
import com.easy.admin.auth.model.vo.SysUserVO;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.auth.service.SysUserPersonalCenterService;
import com.easy.admin.auth.service.SysUserService;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.config.sa.token.util.SessionUtil;
import com.easy.admin.core.mail.MailTemplate;
import com.easy.admin.file.service.FileDetailService;
import com.easy.admin.file.util.file.FileUtil;
import com.easy.admin.sys.common.constant.MailConst;
import com.easy.admin.sys.model.SysMailVerification;
import com.easy.admin.sys.service.SysMailVerificationService;
import com.easy.admin.util.PasswordUtil;
import org.dromara.x.file.storage.core.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 个人中心
 *
 * @author TengChongChong
 * @date 2019-03-04
 */
@Service
public class SysUserPersonalCenterServiceImpl implements SysUserPersonalCenterService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMailVerificationService sysMailVerifiesService;

    @Autowired
    private FileDetailService fileDetailService;

    @Override
    public SysUserVO getCurrentUser() {
        SessionUserVO currentUser = SessionUtil.getCurrentUser();
        SysUser sysUser = sysUserService.get(currentUser.getId());
        if (sysUser == null) {
            return null;
        }
        SysUserVO sysUserVO = new SysUserVO();
        BeanUtil.copyProperties(sysUser, sysUserVO);
        sysUserVO.setAvatar(fileDetailService.getOne(currentUser.getId(), "avatar"));
        return sysUserVO;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void saveUserAvatar(FileInfo avatar) {
        if (FileUtil.inFormalPath(avatar.getPath())) {
            // 未修改头像
            return;
        }

        SessionUserVO currentUser = SessionUtil.getCurrentUser();
        // 删除原头像
        fileDetailService.removeByObjectIdAndObjectType(currentUser.getId(), "avatar");

        // 保存头像
        avatar = fileDetailService.saveToFormal(currentUser.getId(), "avatar", avatar);

        currentUser.setAvatar(avatar.getUrl());

        SessionUtil.setCurrentUser(currentUser);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysUserVO saveUserInfo(SysUserVO sysUser) {
        if (sysUser == null) {
            throw new EasyException(GlobalException.FAILED_TO_GET_DATA);
        }
        SessionUserVO currentUser = SessionUtil.getCurrentUser();
        sysUser.setId(currentUser.getId());
        sysUser = sysUserService.saveData(sysUser, false);
        // 保存成功后更新redis中的用户信息
        currentUser.setNickname(sysUser.getNickname());
        currentUser.setSex(sysUser.getSex());
        currentUser.setBirthday(sysUser.getBirthday());
        if (currentUser.getBirthday() != null) {
            currentUser.setAge(DateUtil.age(currentUser.getBirthday(), new Date()));
        }
        SessionUtil.setCurrentUser(currentUser);
        if (sysUser.getAvatar() != null) {
            saveUserAvatar(sysUser.getAvatar());
        }
        return sysUser;
    }

    @Override
    public boolean applicationBindingEmail(String email) {
        if (StrUtil.isBlank(email)) {
            throw new EasyException("获取邮箱信息失败");
        }
        SessionUserVO currentUser = SessionUtil.getCurrentUser();
        SysMailVerification sysMailVerifies = sysMailVerifiesService.saveData(String.valueOf(currentUser.getId()), email, MailConst.MAIL_BINDING_MAIL);
        if (sysMailVerifies != null) {
            String url = "/#/auth/personal/mail-verifies/" + sysMailVerifies.getCode();
            String hideUsername = StrUtil.hide(currentUser.getUsername(), 1, currentUser.getUsername().length() - 1);
            Map<String, Object> params = new HashMap<>(2);
            params.put("url", url);
            params.put("username", hideUsername);
            MailUtil.sendHtml(email, "用户名" + hideUsername + "密保邮箱验证", MailTemplate.getContent("/mail/verify-mail.html", params));
            return true;
        }
        return false;
    }

    @Override
    public boolean changePassword(ChangePasswordVO changePassword) {
        if (StrUtil.isBlank(changePassword.getCurrentPassword())) {
            throw new EasyException("请输入当前密码");
        }
        if (StrUtil.isBlank(changePassword.getNewPassword())) {
            throw new EasyException("请输入新密码");
        }

        SessionUserVO currentUser = SessionUtil.getCurrentUser();
        if (currentUser == null) {
            throw new EasyException("请登录后重试");
        }

        // 检查当前密码是否正确
        SysUser passwordAndSlat = sysUserService.selectPasswordAndSalt(currentUser.getId());
        if (!PasswordUtil.encryptedPasswords(changePassword.getCurrentPassword(), passwordAndSlat.getSalt()).equals(passwordAndSlat.getPassword())) {
            throw new EasyException("原密码输入错误");
        }
        // 修改密码
        boolean isSuccess = sysUserService.resetPassword(currentUser.getUsername(), changePassword.getNewPassword());
        currentUser.setPassword(PasswordUtil.encryptedPasswords(changePassword.getNewPassword(), passwordAndSlat.getSalt()));
        SessionUtil.setAttribute(SessionConst.USER_SESSION_KEY, currentUser);
        return isSuccess;
    }

    @Override
    public boolean bindingPhoneNumber(String phoneNumber, String captcha) {
        SessionUserVO currentUser = SessionUtil.getCurrentUser();
        String redisKey = RedisPrefix.BINDING_PHONE_VERIFICATION_CODE + currentUser.getId() + ":" + phoneNumber;
        String redisCode = (String) RedisUtil.get(redisKey);
        if (StrUtil.isBlank(redisCode)) {
            throw new EasyException("验证码已过期，请重新获取");
        }
        if (!redisCode.equals(captcha)) {
            throw new EasyException("验证码错误，请重新输入");
        }
        RedisUtil.del(redisKey);
        boolean isSuccess = sysUserService.setPhone(currentUser.getId(), phoneNumber);
        if (isSuccess) {
            currentUser.setPhoneNumber(phoneNumber);
            SessionUtil.setCurrentUser(currentUser);
        }
        return isSuccess;
    }
}
