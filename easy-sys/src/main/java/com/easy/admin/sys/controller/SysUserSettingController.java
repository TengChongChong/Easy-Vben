package com.easy.admin.sys.controller;

import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.sys.model.SysUserSetting;
import com.easy.admin.sys.service.SysUserSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 用户偏好设置
 *
 * @author TengChong
 * @date 2019-03-04 23:41:03
 */
@RestController
@ResponseResult
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
     * @return SysUserSetting
     */
    @PostMapping
    public SysUserSetting save(@RequestBody @Valid SysUserSetting object) {
        return service.saveData(object);
    }
}
