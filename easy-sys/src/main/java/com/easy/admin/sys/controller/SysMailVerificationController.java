package com.easy.admin.sys.controller;

import cn.hutool.json.JSONObject;
import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.sys.service.SysMailVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 邮箱验证
 *
 * @author TengChong
 * @date 2019-03-24
 */
@RestController
@ResponseResult
public class SysMailVerificationController extends BaseController {

    /**
     * 邮箱验证 service
     */
    @Autowired
    private SysMailVerificationService service;

    /**
     * 验证
     *
     * @param json {code: ''}
     * @return true/false
     */
    @PostMapping("/api/mail/verification")
    public boolean verifies(@RequestBody JSONObject json) {
        return service.verifies(json.getStr("code"));
    }
}
