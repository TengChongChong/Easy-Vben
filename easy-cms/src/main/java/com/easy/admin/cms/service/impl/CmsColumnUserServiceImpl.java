package com.easy.admin.cms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.cms.dao.CmsColumnUserMapper;
import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.cms.model.CmsColumnUser;
import com.easy.admin.cms.service.CmsColumnUserService;
import com.easy.admin.cms.utils.CmsSiteUtil;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.util.ShiroUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 栏目用户权限
 *
 * @author TengChongChong
 * @date 2021-11-19
 */
@Service
public class CmsColumnUserServiceImpl extends ServiceImpl<CmsColumnUserMapper, CmsColumnUser> implements CmsColumnUserService {

    @Override
    public List<CmsColumnUser> selectUsersByColumnId(String columnId) {
        return baseMapper.selectUsersByColumnId(columnId, CommonStatus.ENABLE.getCode());
    }

    @Override
    public List<CmsColumn> selectColumnsByUserId(String userId) {
        if(StrUtil.isBlank(userId)){
            userId = ShiroUtil.getCurrentUser().getId();
        }

        return baseMapper.selectColumnsByUserId(CmsSiteUtil.getCurrentEditSiteId(), userId, CommonStatus.ENABLE.getCode());
    }

    @Override
    public boolean removeBySiteId(String siteId) {
        return baseMapper.deleteBySiteId(siteId) > 0;
    }

    @Override
    public boolean removeByColumnId(String columnId) {
        return baseMapper.deleteByColumnId(columnId) > 0;
    }
}