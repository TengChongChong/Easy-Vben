package com.easy.admin.sys.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.util.Response;
import com.easy.admin.sys.common.constant.MailConst;
import com.easy.admin.sys.dao.SysMailVerifiesMapper;
import com.easy.admin.sys.model.SysMailVerifies;
import com.easy.admin.sys.model.SysUser;
import com.easy.admin.sys.service.SysMailVerifiesService;
import com.easy.admin.sys.service.SysUserService;
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
public class SysMailVerifiesServiceImpl extends ServiceImpl<SysMailVerifiesMapper, SysMailVerifies> implements SysMailVerifiesService {

    @Autowired
    private SysUserService sysUserService;


    @Override
    public boolean verifies(String code) {
        // 此方法异常信息使用静默提示
        if (StrUtil.isBlank(code)) {
            throw new EasyException(Response.SILENT, "校验码无效或已过期，请重新发送验证邮件");
        }
        QueryWrapper<SysMailVerifies> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", code);
        SysMailVerifies sysMailVerifies = getOne(queryWrapper);
        if (sysMailVerifies == null) {
            throw new EasyException(Response.SILENT, "校验码无效或已过期，请重新发送验证邮件");
        }
        if (sysMailVerifies.getExpired().getTime() < System.currentTimeMillis()) {
            // 删除过期校验信息
            remove(queryWrapper);
            throw new EasyException(Response.SILENT, "校验码已过期，请重新发送验证邮件");
        }
        // 校验码未过期
        SysUser sysUser = sysUserService.get(sysMailVerifies.getUserId());
        if (sysUser == null) {
            remove(queryWrapper);
            throw new EasyException(Response.SILENT, "获取用户信息失败，请重新发送验证邮件");
        }
        // 更新用户表中的邮箱
        if (sysUserService.setUserMail(sysUser.getId(), sysMailVerifies.getMail())) {
            remove(queryWrapper);
        } else {
            throw new EasyException(Response.SILENT, "更新用户信息失败，请重试");
        }
        return true;
    }

    @Override
    public boolean verifiesData(String code, String userId) {
        if (StrUtil.isNotBlank(code)) {
            QueryWrapper<SysMailVerifies> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("code", code);
            if (StrUtil.isNotBlank(userId)) {
                queryWrapper.eq("user_id", userId);
                SysMailVerifies sysMailVerifies = getOne(queryWrapper);
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
    public SysMailVerifies saveData(String userId, String email, String type) {
        QueryWrapper<SysMailVerifies> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        remove(queryWrapper);
        SysMailVerifies sysMailVerifies = new SysMailVerifies();
        sysMailVerifies.setUserId(userId);
        sysMailVerifies.setMail(email);
        sysMailVerifies.setType(type);
        sysMailVerifies.setExpired(DateUtil.offsetDay(new Date(), 1));
        sysMailVerifies.setCode(RandomUtil.randomString(255));
        save(sysMailVerifies);
        return sysMailVerifies;
    }

    @Override
    public String getMailByUserId(String userId) {
        return getBaseMapper().getMailByUserId(userId, MailConst.MAIL_BINDING_MAIL);
    }

    @Override
    public boolean remove(String code) {
        QueryWrapper<SysMailVerifies> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", code);
        return remove(queryWrapper);
    }
}