package com.easy.restful.sys.service;

import com.easy.restful.sys.model.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * 系统用户
 *
 * @author tengchong
 * @date 2020/7/9
 */
public interface SysUserService {
    /**
     * 根据 用户名|手机号|邮箱 获取登录用户
     * 注：此方法未做非空验证，请自行验证
     *
     * @param account 用户
     * @return SysUser
     */
    SysUser getUserByAccount(@Param("account") String account);
}
