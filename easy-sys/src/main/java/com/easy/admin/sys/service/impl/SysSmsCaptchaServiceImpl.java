package com.easy.admin.sys.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.RandomUtil;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.config.sa.token.util.SessionUtil;
import com.easy.admin.sys.common.constant.SysConfigConst;
import com.easy.admin.sys.service.SysCaptchaService;
import com.easy.admin.sys.service.SysSmsCaptchaService;
import com.easy.admin.util.SysConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 短信验证码
 *
 * @author TengChongChong
 * @date 2020/12/23
 */
@Service
public class SysSmsCaptchaServiceImpl implements SysSmsCaptchaService {

    /**
     * 验证码
     */
    @Autowired
    private SysCaptchaService sysCaptchaService;

    @Override
    public String sendBindingPhoneNumberSms(String phoneNumber, String captchaVerification) {

        if (!sysCaptchaService.verification(captchaVerification)) {
            throw new EasyException("验证码无效，请重试");
        }

        SessionUserVO currentUser = SessionUtil.getCurrentUser();
        if (currentUser == null) {
            throw new EasyException("你尚未登录，请登录后重试");
        }
        // 验证码
        String code;
        String redisKey = RedisPrefix.BINDING_PHONE_VERIFICATION_CODE + currentUser.getId() + ":" + phoneNumber;
        if (RedisUtil.hasKey(redisKey)) {
            code = (String) RedisUtil.get(redisKey);
        } else {
            code = RandomUtil.randomNumbers(6);
        }
        // 放到redis中,重新设置有效期,用于绑定时验证
        RedisUtil.set(redisKey, code, Convert.toInt(SysConfigUtil.get(SysConfigConst.MESSAGE_EXPIRE)));
        return code;
    }
}
