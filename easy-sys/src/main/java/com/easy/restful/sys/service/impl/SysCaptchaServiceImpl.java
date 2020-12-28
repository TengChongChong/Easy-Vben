package com.easy.restful.sys.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.common.redis.constant.RedisPrefix;
import com.easy.restful.common.redis.util.RedisUtil;
import com.easy.restful.sys.common.constant.SysConfigConst;
import com.easy.restful.sys.model.SysUser;
import com.easy.restful.sys.service.SysCaptchaService;
import com.easy.restful.util.ShiroUtil;
import com.easy.restful.util.SysConfigUtil;
import org.springframework.stereotype.Service;

/**
 * 短信验证码
 *
 * @author tengchong
 * @date 2020/12/23
 */
@Service
public class SysCaptchaServiceImpl implements SysCaptchaService {
    @Override
    public String bindingPhone(String phone) {
        SysUser currentUser = ShiroUtil.getCurrentUser();
        if(currentUser == null){
            throw new EasyException("你尚未登录，请登录后重试");
        }
        // 验证码
        String code;
        if (RedisUtil.hasKey(RedisPrefix.BINDING_PHONE_VERIFICATION_CODE + currentUser.getId())) {
            code = (String) RedisUtil.get(RedisPrefix.BINDING_PHONE_VERIFICATION_CODE + currentUser.getId());
        } else {
            code = RandomUtil.randomNumbers(6);
        }
        // 放到redis中,重新设置有效期,用于绑定时验证
        RedisUtil.set(RedisPrefix.BINDING_PHONE_VERIFICATION_CODE + currentUser.getId(), code, (int) SysConfigUtil.get(SysConfigConst.MESSAGE_EXPIRE));
        return code;
    }
}
