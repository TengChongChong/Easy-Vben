package com.easy.restful.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.restful.common.core.common.status.CommonStatus;
import com.easy.restful.sys.dao.SysUserRoleMapper;
import com.easy.restful.sys.model.SysUserRole;
import com.easy.restful.sys.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色
 *
 * @author tengchong
 * @date 2020/7/9
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
    @Override
    public List<String> selectUserRoleCodesByUserId(String userId) {
        return getBaseMapper().selectUserRoleCodesByUserId(userId, CommonStatus.ENABLE.getCode());
    }
}
