package com.easy.admin.sys.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.util.Response;
import com.easy.admin.sys.common.constant.MailConst;
import com.easy.admin.sys.dao.SysMailVerificationMapper;
import com.easy.admin.sys.model.SysMailVerification;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.sys.service.SysMailVerificationService;
import com.easy.admin.auth.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 邮箱验证
 *
 * @author TengChong
 * @date 2019-03-24
 */
@Service
public class SysMailVerificationServiceImpl extends ServiceImpl<SysMailVerificationMapper, SysMailVerification> implements SysMailVerificationService {

    @Autowired
    private SysUserService sysUserService;


    @Override
    public boolean verifies(String code) {
        if (StrUtil.isBlank(code)) {
            throw new EasyException(Response.SHOW_TYPE_WARNING, "校验码无效或已过期，请重新发送验证邮件");
        }
        QueryWrapper<SysMailVerification> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", code);
        SysMailVerification sysMailVerifies = getOne(queryWrapper);
        if (sysMailVerifies == null) {
            throw new EasyException(Response.SHOW_TYPE_WARNING, "校验码无效或已过期，请重新发送验证邮件");
        }
        if (sysMailVerifies.getExpired().getTime() < System.currentTimeMillis()) {
            // 删除过期校验信息
            remove(queryWrapper);
            throw new EasyException(Response.SHOW_TYPE_WARNING, "校验码已过期，请重新发送验证邮件");
        }
        // 校验码未过期
        SysUser sysUser = sysUserService.get(sysMailVerifies.getUserId());
        if (sysUser == null) {
            remove(queryWrapper);
            throw new EasyException(Response.SHOW_TYPE_WARNING, "获取用户信息失败，请重新发送验证邮件");
        }
        // 更新用户表中的邮箱
        if (sysUserService.setUserMail(sysUser.getId(), sysMailVerifies.getMail())) {
            remove(queryWrapper);
        } else {
            throw new EasyException(Response.SHOW_TYPE_WARNING, "更新用户信息失败，请重试");
        }
        return true;
    }

    @Override
    public boolean verifiesData(String code, String userId) {
        if (StrUtil.isNotBlank(code)) {
            QueryWrapper<SysMailVerification> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("code", code);
            if (StrUtil.isNotBlank(userId)) {
                queryWrapper.eq("user_id", userId);
                SysMailVerification sysMailVerifies = getOne(queryWrapper);
                if (sysMailVerifies != null) {
                    return System.currentTimeMillis() < sysMailVerifies.getExpired().getTime();
                } else {
                    throw new EasyException("校验码失效，请重新申请");
                }
            }
        }
        return false;
    }

    @Override
    public SysMailVerification saveData(String userId, String email, String type) {
        QueryWrapper<SysMailVerification> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        remove(queryWrapper);
        SysMailVerification sysMailVerifies = new SysMailVerification();
        sysMailVerifies.setUserId(userId);
        sysMailVerifies.setMail(email);
        sysMailVerifies.setType(type);
        sysMailVerifies.setExpired(DateUtil.offsetDay(new Date(), 1));
        sysMailVerifies.setCode(RandomUtil.randomString(128));
        save(sysMailVerifies);
        return sysMailVerifies;
    }

    @Override
    public String getMailByUserId(String userId) {
        return baseMapper.getMailByUserId(userId, MailConst.MAIL_BINDING_MAIL);
    }

    @Override
    public boolean remove(String code) {
        QueryWrapper<SysMailVerification> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", code);
        return remove(queryWrapper);
    }
}