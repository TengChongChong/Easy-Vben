package com.easy.restful.sys.service;

import com.easy.restful.sys.model.SysUserSetting;

/**
 * 用户偏好设置
 *
 * @author TengChong
 * @date 2019-03-04 23:41:03
 */
public interface SysUserSettingService {
    /**
     * 保存
     *
     * @param object 表单内容
     * @return 保存后信息
     */
    SysUserSetting saveData(SysUserSetting object);
}
