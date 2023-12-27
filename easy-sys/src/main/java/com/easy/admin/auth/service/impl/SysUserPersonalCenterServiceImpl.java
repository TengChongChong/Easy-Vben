package com.easy.admin.auth.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.json.JSONObject;
import com.easy.admin.auth.common.constant.SessionConst;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.auth.service.SysUserPersonalCenterService;
import com.easy.admin.auth.service.SysUserService;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.core.mail.MailTemplate;
import com.easy.admin.file.model.FileInfo;
import com.easy.admin.file.service.FileInfoService;
import com.easy.admin.file.storage.FileStorageFactory;
import com.easy.admin.file.util.file.ImageUtil;
import com.easy.admin.sys.common.constant.MailConst;
import com.easy.admin.sys.model.SysMailVerification;
import com.easy.admin.sys.service.SysMailVerificationService;
import com.easy.admin.util.PasswordUtil;
import com.easy.admin.util.ShiroUtil;
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

    @Autowired
    private FileInfoService fileInfoService;

    /**
     * 文件存储
     */
    @Autowired
    private FileStorageFactory fileStorageFactory;

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
    public boolean saveUserAvatar(FileInfo avatar) {
        if (fileStorageFactory.getFileStorage().inFormalPath(avatar.getObjectName())) {
            // 未修改头像
            return true;
        }

        SysUser sysUser = ShiroUtil.getCurrentUser();
        // 删除原头像
        fileInfoService.delete(sysUser.getId(), "avatar");

        if (avatar.getSize() > 1024 * 100) {
            // 超过100kb，压缩

            // 下载文件到本地
            String fullFilePath = fileStorageFactory.getFileStorage().downloadToLocalTemporaryPath(avatar.getBucketName(), avatar.getObjectName());
            // 压缩文件
            String thumbnailFile = ImageUtil.generateThumbnail(new File(fullFilePath), 300);
            // 上传文件到存储
            fileStorageFactory.getFileStorage().uploadFile(avatar.getBucketName(), avatar.getObjectName(), thumbnailFile);
            // 文件大小
            avatar.setSize(new File(thumbnailFile).length());
        }

        // 保存头像
        fileInfoService.saveData(sysUser.getId(), "avatar", avatar);

        sysUser.setAvatar(avatar);

        ShiroUtil.setCurrentUser(sysUser);

        return true;
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
        if (sysUser.getAvatar() != null) {
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
