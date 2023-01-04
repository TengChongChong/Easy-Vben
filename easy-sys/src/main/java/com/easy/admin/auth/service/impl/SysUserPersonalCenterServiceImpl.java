package com.easy.admin.auth.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.json.JSONObject;
import com.easy.admin.auth.common.constant.SessionConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.core.mail.MailTemplate;
import com.easy.admin.sys.common.constant.MailConst;
import com.easy.admin.sys.model.SysMailVerification;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.sys.service.SysMailVerificationService;
import com.easy.admin.auth.service.SysUserPersonalCenterService;
import com.easy.admin.auth.service.SysUserService;
import com.easy.admin.util.PasswordUtil;
import com.easy.admin.util.ShiroUtil;
import com.easy.admin.util.file.FileUtil;
import com.easy.admin.util.file.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
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


    @Override
    public SysUser getCurrentUser() {
        SysUser sysUser = ShiroUtil.getCurrentUser();
        if (sysUser != null) {
            SysUser queryResult = sysUserService.selectEmailAndPhone(sysUser.getId());
            if (queryResult != null) {
                sysUser.setPhoneNumber(queryResult.getPhoneNumber());
                sysUser.setEmail(queryResult.getEmail());
            }
            // 如果数据库中email也为空,查询是否有待验证url
            String mail = sysMailVerifiesService.getMailByUserId(sysUser.getId());
            if (StrUtil.isNotBlank(mail)) {
                sysUser.setEmail(mail);
                sysUser.setMailIsVerifies(false);
            }
        }
        return sysUser;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public String saveUserAvatar(String url) {
        if (StrUtil.isBlank(url)) {
            throw new EasyException("获取头像路径失败");
        }
        String path = FileUtil.getPath(url);
        File file = new File(path);
        if (!file.exists()) {
            throw new EasyException("头像文件不存在");
        }
        if (file.exists() && FileUtil.inFormalPath(path)) {
            return url;
        }
        SysUser sysUser = ShiroUtil.getCurrentUser();
        // 以前设置了头像
        String oldAvatar = null;
        if (StrUtil.isNotBlank(sysUser.getAvatar())) {
            oldAvatar = sysUser.getAvatar();
        }
        // 将新头像移动到正式目录
        path = FileUtil.moveToFormal(path);
        // 更新数据库
        url = FileUtil.getUrl(path);
        boolean isSuccess = sysUserService.updateAvatar(url);
        if (isSuccess) {
            if (StrUtil.isNotBlank(oldAvatar)) {
                // 删除原头像以及缩略图
                ImageUtil.delThumbnail(new File(FileUtil.getPath(oldAvatar)));
                FileUtil.del(oldAvatar);
            }
            // 生成缩略图
            ImageUtil.generateThumbnail(new File(path));
            // 更新redis中用户信息
            sysUser.setAvatar(url);
            sysUser = FileUtil.initAvatar(sysUser);
            ShiroUtil.setCurrentUser(sysUser);
            return url;
        } else {
            // 更新失败了,把移动到正式目录的图片删掉
            cn.hutool.core.io.FileUtil.del(new File(path));
            throw new EasyException("更新数据失败");
        }

    }

    @Override
    public SysUser saveUserInfo(SysUser sysUser) {
        if (sysUser == null) {
            throw new EasyException(GlobalException.FAILED_TO_GET_DATA);
        }
        SysUser currentUser = ShiroUtil.getCurrentUser();
        sysUser.setId(currentUser.getId());
        sysUser = sysUserService.saveData(sysUser, false);
        // 保存成功后更新redis中的用户信息
        currentUser.setNickname(sysUser.getNickname());
        currentUser.setSex(sysUser.getSex());
        currentUser.setBirthday(sysUser.getBirthday());
        ShiroUtil.setCurrentUser(currentUser);
        if (StrUtil.isNotBlank(sysUser.getAvatar())) {
            saveUserAvatar(sysUser.getAvatar());
        }
        return currentUser;
    }

    @Override
    public boolean applicationBindingEmail(String email) {
        if (StrUtil.isBlank(email)) {
            throw new EasyException("获取邮箱信息失败");
        }
        SysUser currentUser = ShiroUtil.getCurrentUser();
        SysMailVerification sysMailVerifies = sysMailVerifiesService.saveData(String.valueOf(currentUser.getId()), email, MailConst.MAIL_BINDING_MAIL);
        if (sysMailVerifies != null) {
            String url = "/#/auth/personal/center/mail-verifies/" + sysMailVerifies.getCode();
            String hideUsername = StrUtil.hide(currentUser.getUsername(), 1, currentUser.getUsername().length() - 1);
            Map<String, Object> params = new HashMap<>(2);
            params.put("url", url);
            params.put("username", hideUsername);
            MailUtil.sendHtml(email, "账号" + hideUsername + "密保邮箱验证", MailTemplate.getContent("/mail/verify-mail.html", params));
            return true;
        }
        return false;
    }

    @Override
    public boolean changePassword(JSONObject json) {
        String oldPassword = json.getStr("oldPassword"),
                password = json.getStr("password");

        if (StrUtil.isBlank(oldPassword)) {
            throw new EasyException("请输入当前密码");
        }
        if (StrUtil.isBlank(password)) {
            throw new EasyException("请输入新密码");
        }

        SysUser sysUser = ShiroUtil.getCurrentUser();
        if (sysUser == null) {
            throw new EasyException("请登录后重试");
        }

        // 检查当前密码是否正确
        SysUser passwordAndSlat = sysUserService.selectPasswordAndSalt(sysUser.getId());
        if (!PasswordUtil.encryptedPasswords(oldPassword, passwordAndSlat.getSalt()).equals(passwordAndSlat.getPassword())) {
            throw new EasyException("原密码输入错误");
        }
        // 修改密码
        boolean isSuccess = sysUserService.resetPassword(sysUser.getUsername(), password);
        sysUser.setPassword(PasswordUtil.encryptedPasswords(password, passwordAndSlat.getSalt()));
        ShiroUtil.setAttribute(SessionConst.USER_SESSION_KEY, sysUser);
        return isSuccess;
    }

    @Override
    public boolean bindingPhone(String phone, String captcha) {
        SysUser currentUser = ShiroUtil.getCurrentUser();
        String redisCode = (String) RedisUtil.get(RedisPrefix.BINDING_PHONE_VERIFICATION_CODE + currentUser.getId());
        if (StrUtil.isBlank(redisCode)) {
            throw new EasyException("验证码已过期，请重新获取");
        }
        if (!redisCode.equals(captcha)) {
            throw new EasyException("验证码错误，请重新输入");
        }
        RedisUtil.del(RedisPrefix.BINDING_PHONE_VERIFICATION_CODE + currentUser.getId());
        return sysUserService.setPhone(currentUser.getId(), phone);
    }
}
