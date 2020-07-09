package com.easy.restful.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.restful.sys.model.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * 用户管理
 *
 * @author tengchong
 * @date 2018/12/6
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据用户名获取登录用户
     *
     * @param account 根据 用户名|手机号|邮箱 获取登录用户
     * @return SysUser
     */
    SysUser getUserByAccount(@Param("account") String account);
}