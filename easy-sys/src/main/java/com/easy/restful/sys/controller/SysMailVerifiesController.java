package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.util.Response;
import com.easy.restful.sys.service.SysMailVerifiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
     * @param code 校验码
     */
    @GetMapping("/sys/mail/verifies/{code}")
    public Response verifies(@PathVariable String code) {
        return Response.success(service.verifies(code));
    }
}
