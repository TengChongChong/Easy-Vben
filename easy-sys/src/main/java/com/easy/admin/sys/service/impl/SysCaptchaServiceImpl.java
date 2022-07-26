package com.easy.admin.sys.service.impl;

import cn.hutool.core.util.StrUtil;
import com.anji.captcha.model.common.RepCodeEnum;
import com.anji.captcha.model.common.ResponseModel;
import com.anji.captcha.model.vo.CaptchaVO;
import com.anji.captcha.model.vo.PointVO;
import com.anji.captcha.service.CaptchaService;
import com.anji.captcha.util.AESUtil;
import com.anji.captcha.util.JsonUtil;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.sys.common.constant.CaptchaConst;
import com.easy.admin.sys.service.SysCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 短信验证码
 *
 * @author TengChongChong
 * @date 2020/12/23
 */
@Service
public class SysCaptchaServiceImpl implements SysCaptchaService{

    /**
     * 验证码有效期
     */
    private static final Long EXPIRE = 3 * 60L;

    /**
     * 允许误差范围
     */
    protected static int SLIP_OFFSET = 5;

    @Autowired
    private CaptchaService captchaService;

    @Override
    public CaptchaVO getCaptcha() {
        CaptchaVO captchaVO = new CaptchaVO();
        captchaVO.setCaptchaType("sysDragCaptcha");
        ResponseModel responseModel = captchaService.get(captchaVO);
        if (responseModel.isSuccess()) {
            return (CaptchaVO) responseModel.getRepData();
        } else {
            throw new EasyException(responseModel.getRepCode(), responseModel.getRepMsg());
        }
    }

    @Override
    public CaptchaVO checkCaptcha(CaptchaVO captchaVO) {
        if (captchaVO == null) {
            throw new EasyException("获取验证数据失败");
        }

        // 取坐标信息
        String codeKey = String.format(CaptchaConst.REDIS_CAPTCHA_KEY, captchaVO.getToken());
        String pointStr = (String) RedisUtil.get(codeKey);
        if (StrUtil.isBlank(pointStr)) {
            throw new EasyException("验证码已过期");
        }
        // 验证码只用一次，即刻失效
        RedisUtil.del(codeKey);

        PointVO point = JsonUtil.parseObject(pointStr, PointVO.class);
        PointVO dragPoint;
        String pointJson;
        try {
            // aes解密前端传回的坐标
            pointJson = AESUtil.aesDecrypt(captchaVO.getPointJson(), point.getSecretKey());
            dragPoint = JsonUtil.parseObject(pointJson, PointVO.class);
        } catch (Exception e) {
            throw new EasyException(e.getMessage());
        }
        if (point.x - SLIP_OFFSET > dragPoint.x || dragPoint.x > point.x + SLIP_OFFSET || point.y != dragPoint.y) {
            throw new EasyException(RepCodeEnum.API_CAPTCHA_COORDINATE_ERROR.getDesc());
        }

        // 校验成功，将信息存入缓存，用于后端二次校验
        String secretKey = point.getSecretKey();
        String value;
        try {
            value = AESUtil.aesEncrypt(captchaVO.getToken().concat("---").concat(pointJson), secretKey);
        } catch (Exception e) {
            throw new EasyException(e.getMessage());
        }
        // 放入Redis
        String secondKey = String.format(CaptchaConst.REDIS_SECOND_CAPTCHA_KEY, value);
        RedisUtil.set(secondKey, captchaVO.getToken(), EXPIRE);

        captchaVO.setResult(true);
        captchaVO.resetClientFlag();
        captchaVO.setCaptchaVerification(value);
        return captchaVO;
    }

    @Override
    public boolean verification(String captchaVerification) {
        String codeKey = String.format(CaptchaConst.REDIS_SECOND_CAPTCHA_KEY, captchaVerification);
        if (!RedisUtil.hasKey(codeKey)) {
            throw new EasyException(RepCodeEnum.API_CAPTCHA_INVALID.getDesc());
        }
        // 二次校验取值后，即刻失效
        RedisUtil.del(codeKey);
        return true;
    }
}
