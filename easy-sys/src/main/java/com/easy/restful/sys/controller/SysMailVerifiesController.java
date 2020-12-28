package com.easy.restful.sys.controller;

import cn.hutool.json.JSONObject;
import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.util.Response;
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
     */
    @PostMapping("/sys/mail/verifies")
    public Response verifies(@RequestBody JSONObject json) {
        return Response.success(service.verifies(json.getStr("code")));
    }
}
