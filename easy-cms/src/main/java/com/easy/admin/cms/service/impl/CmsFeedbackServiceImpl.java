package com.easy.admin.cms.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.cms.dao.CmsFeedbackMapper;
import com.easy.admin.cms.model.CmsFeedback;
import com.easy.admin.cms.service.CmsFeedbackService;
import com.easy.admin.cms.utils.CmsSiteUtil;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.util.ToolUtil;
import com.easy.admin.util.office.ExcelUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 用户反馈
 *
 * @author 系统管理员
 * @date 2023-07-10
 */
@Service
public class CmsFeedbackServiceImpl extends ServiceImpl<CmsFeedbackMapper, CmsFeedback> implements CmsFeedbackService {

    @Override
    public Page<CmsFeedback> select(CmsFeedback cmsFeedback, Page<CmsFeedback> page) {
        if (StrUtil.isBlank(CmsSiteUtil.getUserActiveSiteId())) {
            return page;
        }
        QueryWrapper<CmsFeedback> queryWrapper = getQueryWrapper(cmsFeedback);
        page.setDefaultDesc("t.create_date");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    private QueryWrapper<CmsFeedback> getQueryWrapper(CmsFeedback cmsFeedback) {
        QueryWrapper<CmsFeedback> queryWrapper = new QueryWrapper<>();
        if (cmsFeedback != null) {
            // 查询条件
            // 昵称
            if (Validator.isNotEmpty(cmsFeedback.getNickname())) {
                queryWrapper.like("t.nickname", cmsFeedback.getNickname());
            }
            // 邮箱
            if (Validator.isNotEmpty(cmsFeedback.getEmail())) {
                queryWrapper.like("t.email", cmsFeedback.getEmail());
            }
            // 手机号
            if (Validator.isNotEmpty(cmsFeedback.getPhoneNumber())) {
                queryWrapper.like("t.phone_number", cmsFeedback.getPhoneNumber());
            }
            // 内容
            if (Validator.isNotEmpty(cmsFeedback.getContent())) {
                queryWrapper.like("t.content", cmsFeedback.getContent());
            }
            // 状态
            if (Validator.isNotEmpty(cmsFeedback.getStatus())) {
                if (cmsFeedback.getStatus().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.status", cmsFeedback.getStatus().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.status", cmsFeedback.getStatus());
                }
            }
        }
        queryWrapper.eq("t.site_id", CmsSiteUtil.getUserActiveSiteId());
        return queryWrapper;
    }

    @Override
    public CmsFeedback get(String id) {
        ToolUtil.checkParams(id);
        return baseMapper.getById(id);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        ToolUtil.checkParams(ids);
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        return removeByIds(idList);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public CmsFeedback saveData(CmsFeedback cmsFeedback) {
        ToolUtil.checkParams(cmsFeedback);
        if (Validator.isEmpty(cmsFeedback.getId())) {
            // 新增,设置默认值
            cmsFeedback.setStatus(CommonStatus.ENABLE.getCode());
        }
        return (CmsFeedback) ToolUtil.checkResult(saveOrUpdate(cmsFeedback), cmsFeedback);
    }

    @Override
    public String exportData(CmsFeedback cmsFeedback) {
        QueryWrapper<CmsFeedback> queryWrapper = getQueryWrapper(cmsFeedback);
        queryWrapper.orderByDesc("t.create_date");
        List<CmsFeedback> list = baseMapper.exportData(queryWrapper);
        return ExcelUtil.writeAndGetDownloadId("用户反馈", "用户反馈", list, CmsFeedback.class);
    }

}