package com.easy.admin.cms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.cms.dao.CmsSiteUserMapper;
import com.easy.admin.cms.model.CmsSite;
import com.easy.admin.cms.model.CmsSiteUser;
import com.easy.admin.cms.service.CmsSiteUserService;
import com.easy.admin.cms.utils.CmsSiteUtils;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.util.ShiroUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 站点用户权限
 *
 * @author TengChongChong
 * @date 2021-11-18
 */
@Service
public class CmsSiteUserServiceImpl extends ServiceImpl<CmsSiteUserMapper, CmsSiteUser> implements CmsSiteUserService {
    @Override
    public List<CmsSiteUser> selectUsersBySiteId(String siteId) {
        return baseMapper.selectUsersBySiteId(siteId, CommonStatus.ENABLE.getCode());
    }

    @Override
    public CmsSite getSitesByUserId(String userId) {
        if(StrUtil.isBlank(userId)){
            userId = ShiroUtil.getCurrentUser().getId();
        }
        return baseMapper.getSitesByUserId(userId, CommonStatus.ENABLE.getCode());
    }

    @Override
    public List<CmsSite> selectSitesByUserId(String userId) {
        if(StrUtil.isBlank(userId)){
            userId = ShiroUtil.getCurrentUser().getId();
        }

        return baseMapper.selectSitesByUserId(userId, CommonStatus.ENABLE.getCode());
    }

    @Override
    public String getCurrentEditSiteId() {
        return CmsSiteUtils.getCurrentEditSiteId();
    }

    @Override
    public boolean setCurrentEditSiteId(String siteId) {
        CmsSiteUtils.setCurrentEditSiteId(siteId);
        return true;
    }

    @Override
    public boolean removeBySiteId(String siteId) {
        return baseMapper.deleteBySiteId(siteId) > 0;
    }
}