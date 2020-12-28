package com.easy.restful.sys.controller;

import cn.hutool.json.JSONObject;
import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.core.annotation.ResponseResult;
import com.easy.restful.sys.service.SysMailVerifiesService;
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
public class SysMailVerifiesController extends BaseController {

    /**
     * 邮箱验证 service
     */
    @Autowired
    private SysMailVerifiesService service;

    /**
     * 验证
     *
     * @param json {code: ''}
     * @return true/false
     */
    @PostMapping("/sys/mail/verifies")
    public boolean verifies(@RequestBody JSONObject json) {
        return service.verifies(json.getStr("code"));
    }
}
