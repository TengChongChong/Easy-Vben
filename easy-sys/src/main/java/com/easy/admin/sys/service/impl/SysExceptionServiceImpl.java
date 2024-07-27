package com.easy.admin.sys.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.sys.common.constant.SysConfigConst;
import com.easy.admin.sys.dao.SysExceptionMapper;
import com.easy.admin.sys.model.SysException;
import com.easy.admin.sys.service.SysExceptionService;
import com.easy.admin.util.SysConfigUtil;
import com.easy.admin.common.core.util.ToolUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 异常日志
 *
 * @author TengChong
 * @date 2019-04-08
 */
@Service
public class SysExceptionServiceImpl extends ServiceImpl<SysExceptionMapper, SysException> implements SysExceptionService {

    /**
     * 列表
     *
     * @param sysException 查询条件
     * @return 数据集合
     */
    @Override
    public Page<SysException> select(SysException sysException, Page<SysException> page) {
        QueryWrapper<SysException> queryWrapper = new QueryWrapper<>();
        if (sysException != null) {
            // 查询条件
            // 错误代码
            if (Validator.isNotEmpty(sysException.getId())) {
                queryWrapper.eq("id", sysException.getId());
            }
            if (Validator.isNotEmpty(sysException.getCode())) {
                queryWrapper.like("t.code", sysException.getCode());
            }
            // 异常类型
            if (Validator.isNotEmpty(sysException.getType())) {
                queryWrapper.like("t.type", sysException.getType());
            }
            // 请求地址
            if (Validator.isNotEmpty(sysException.getUrl())) {
                queryWrapper.like("t.url", sysException.getUrl());
            }
            // 错误信息
            if (Validator.isNotEmpty(sysException.getMessage())) {
                queryWrapper.like("t.message", sysException.getMessage());
            }
            // 触发用户
            if (Validator.isNotEmpty(sysException.getNickname())) {
                queryWrapper.like("u.nickname", sysException.getNickname());
            }
            // 触发时间 - 开始
            if (Validator.isNotEmpty(sysException.getStartTriggerTime())) {
                queryWrapper.ge("t.trigger_time", sysException.getStartTriggerTime());
            }
            // 触发时间 - 结束
            if (Validator.isNotEmpty(sysException.getEndTriggerTime())) {
                queryWrapper.le("t.trigger_time", sysException.getEndTriggerTime());
            }
        }
        page.setDefaultDesc("t.trigger_time");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    /**
     * 详情
     *
     * @param id id
     * @return 详细信息
     */
    @Override
    public SysException get(String id) {
        return baseMapper.getById(id);
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return 是否成功
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        return removeByIds(idList);
    }

    /**
     * 保存
     *
     * @param sysException 表单内容
     * @return 保存后信息
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysException saveData(SysException sysException) {
        if (StrUtil.isBlank(sysException.getId())) {
            // 新增,设置默认值
            if (StrUtil.isBlank(sysException.getMessage()) && StrUtil.isNotBlank(sysException.getType())) {
                try {
                    sysException.setMessage(sysException.getType().substring(sysException.getType().lastIndexOf(".") + 1));
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
        return (SysException) ToolUtil.checkResult(saveOrUpdate(sysException), sysException);
    }

    @Override
    public boolean clean() {
        QueryWrapper<SysException> clean = new QueryWrapper<>();
        Date cleanDate = DateUtil.offsetDay(new Date(), Convert.toInt(SysConfigUtil.get(SysConfigConst.CLEAN_EXCEPTION_LOG)) * -1);
        clean.lt("trigger_time", cleanDate);
        return remove(clean);
    }
}