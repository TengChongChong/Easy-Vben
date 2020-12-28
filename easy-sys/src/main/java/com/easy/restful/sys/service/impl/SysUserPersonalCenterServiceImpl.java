package com.easy.restful.sys.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.json.JSONObject;
import com.easy.restful.auth.constant.SessionConst;
import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.common.core.exception.GlobalException;
import com.easy.restful.common.redis.constant.RedisPrefix;
import com.easy.restful.common.redis.util.RedisUtil;
import com.easy.restful.core.mail.MailTemplate;
import com.easy.restful.sys.common.constant.MailConst;
import com.easy.restful.sys.common.constant.SysConfigConst;
import com.easy.restful.sys.model.SysMailVerifies;
import com.easy.restful.sys.model.SysUser;
import com.easy.restful.sys.model.SysUserSetting;
import com.easy.restful.sys.service.SysMailVerifiesService;
import com.easy.restful.sys.service.SysUserPersonalCenterService;
import com.easy.restful.sys.service.SysUserService;
import com.easy.restful.util.PasswordUtil;
import com.easy.restful.util.ShiroUtil;
import com.easy.restful.util.SysConfigUtil;
import com.easy.restful.util.file.FileUtil;
import com.easy.restful.util.file.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 个人中心
 *
 * @author tengchong
 * @date 2019-03-04
 */
@Service
public class SysUserPersonalCenterServiceImpl implements SysUserPersonalCenterService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMailVerifiesService sysMailVerifiesService;


    @Override
    public SysUser getCurrentUser() {
        SysUser sysUser = ShiroUtil.getCurrentUser();
        if (sysUser != null) {
            SysUser queryResult = sysUserService.selectEmailAndPhone(sysUser.getId());
            if (queryResult != null) {
                sysUser.setPhone(queryResult.getPhone());
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
    public String saveUserAvatar(String path) {
        if (StrUtil.isNotBlank(path)) {
            File file = new File(path);
            if (!file.exists()) {
                throw new EasyException("头像文件不存在");
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
            String url = FileUtil.getUrl(path);
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
            }
        }
        throw new EasyException("获取头像路径失败");
    }

    @Override
    public SysUser saveUserInfo(SysUser sysUser) {
        if (sysUser != null) {
            SysUser currentUser = ShiroUtil.getCurrentUser();
            sysUser.setId(currentUser.getId());
            sysUser = sysUserService.saveData(sysUser, false);
            // 保存成功后更新redis中的用户信息
            currentUser.setNickname(sysUser.getNickname());
            currentUser.setSex(sysUser.getSex());
            currentUser.setBirthday(sysUser.getBirthday());
            ShiroUtil.setCurrentUser(currentUser);
            if (StrUtil.isNotBlank(sysUser.getAvatar())) {
                saveUserAvatar(FileUtil.getPath(sysUser.getAvatar()));
            }
            return currentUser;
        } else {
            throw new EasyException(GlobalException.FAILED_TO_GET_DATA);
        }
    }

    @Override
    public boolean applicationBindingEmail(String email) {
        if (StrUtil.isNotBlank(email)) {
            SysUser currentUser = ShiroUtil.getCurrentUser();
            SysMailVerifies sysMailVerifies = sysMailVerifiesService.saveData(String.valueOf(currentUser.getId()), email, MailConst.MAIL_BINDING_MAIL);
            if (sysMailVerifies != null) {
                String url = "/sys/mail-verifies/bind-mail/" + sysMailVerifies.getCode();
                String hideUsername = StrUtil.hide(currentUser.getUsername(), 1, currentUser.getUsername().length() - 1);
                Map<String, Object> params = new HashMap<>();
                params.put("url", url);
                params.put("username", hideUsername);
                MailUtil.sendHtml(email, "账号" + hideUsername + "密保邮箱验证", MailTemplate.getContent("/mail/verify-mail.html", params));
                return true;
            }
        } else {
            throw new EasyException("获取邮箱信息失败");
        }
        return false;
    }

    @Override
    public boolean saveUserSetting(SysUserSetting setting) {
        return false;
    }

    @Override
    public boolean changePassword(JSONObject json) {
        String oldPassword = json.getStr("oldPassword"),
                password = json.getStr("password"),
                passwordStrength = json.getStr("passwordStrength");

        if (StrUtil.isBlank(oldPassword)) {
            throw new EasyException("请输入当前密码");
        }
        if (StrUtil.isBlank(password)) {
            throw new EasyException("请输入新密码");
        }
        if (StrUtil.isBlank(passwordStrength)) {
            passwordStrength = Convert.toStr((SysConfigUtil.get(SysConfigConst.PASSWORD_SECURITY_LEVEL)));
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
        boolean isSuccess = sysUserService.resetPassword(sysUser.getUsername(), password, passwordStrength);
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
