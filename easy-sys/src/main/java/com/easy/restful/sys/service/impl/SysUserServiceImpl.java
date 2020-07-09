package com.easy.restful.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.restful.sys.dao.SysUserMapper;
import com.easy.restful.sys.model.SysUser;
import com.easy.restful.sys.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * 系统用户
 *
 * @author tengchong
 * @date 2020/7/9
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Override
    public SysUser getUserByAccount(String account) {
        return getBaseMapper().getUserByAccount(account);
    }
}
