package com.easy.restful.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.restful.common.core.common.status.CommonStatus;
import com.easy.restful.sys.dao.SysRolePermissionsMapper;
import com.easy.restful.sys.model.SysRolePermissions;
import com.easy.restful.sys.service.SysRolePermissionsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色权限
 *
 * @author tengchong
 * @date 2020/7/9
 */
@Service
public class SysRolePermissionsServiceImpl extends ServiceImpl<SysRolePermissionsMapper, SysRolePermissions> implements SysRolePermissionsService {

    @Override
    public List<SysRolePermissions> selectAll() {
        return getBaseMapper().selectAll(CommonStatus.ENABLE.getCode());
    }
}
