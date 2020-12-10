package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.util.Response;
import com.easy.restful.sys.model.SysUserSetting;
import com.easy.restful.sys.service.SysUserSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户偏好设置
 *
 * @author TengChong
 * @date 2019-03-04 23:41:03
 */
@RestController
@RequestMapping("/auth/sys/user/setting")
public class SysUserSettingController extends BaseController {
    /**
     * 用户偏好设置 service
     */
    @Autowired
    private SysUserSettingService service;

    /**
     * 保存
     *
     * @param object 表单内容

     */
    @PostMapping

    public Response save(SysUserSetting object){
        return Response.success(service.saveData(object));
    }
}
