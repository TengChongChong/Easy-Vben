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
import com.easy.admin.util.ToolUtil;
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
     * @param object 查询条件
     * @return 数据集合
     */
    @Override
    public Page<SysException> select(SysException object, Page<SysException> page) {
        QueryWrapper<SysException> queryWrapper = new QueryWrapper<>();
        if (object != null) {
            // 查询条件
            // 错误代码
            if (Validator.isNotEmpty(object.getCode())) {
                queryWrapper.like("code", object.getCode());
            }
            // 异常类型
            if (Validator.isNotEmpty(object.getType())) {
                queryWrapper.like("type", object.getType());
            }
            // 请求地址
            if (Validator.isNotEmpty(object.getUrl())) {
                queryWrapper.like("url", object.getUrl());
            }
            // 错误信息
            if (Validator.isNotEmpty(object.getMessage())) {
                queryWrapper.like("message", object.getMessage());
            }
            // 触发用户
            if (Validator.isNotEmpty(object.getNickname())) {
                queryWrapper.like("u.nickname", object.getNickname());
            }
            // 触发时间 - 开始
            if (Validator.isNotEmpty(object.getStartTriggerTime())) {
                queryWrapper.ge("trigger_time", object.getStartTriggerTime());
            }
            // 触发时间 - 结束
            if (Validator.isNotEmpty(object.getEndTriggerTime())) {
                queryWrapper.le("trigger_time", object.getEndTriggerTime());
            }
        }
        page.setDefaultDesc("trigger_time");
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
        ToolUtil.checkParams(id);
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
        ToolUtil.checkParams(ids);
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        return removeByIds(idList);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return 保存后信息
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysException saveData(SysException object) {
        ToolUtil.checkParams(object);
        if (StrUtil.isBlank(object.getId())) {
            // 新增,设置默认值
            if (StrUtil.isBlank(object.getMessage()) && StrUtil.isNotBlank(object.getType())) {
                try {
                    object.setMessage(object.getType().substring(object.getType().lastIndexOf(".") + 1));
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
        return (SysException) ToolUtil.checkResult(saveOrUpdate(object), object);
    }

    @Override
    public boolean clean() {
        QueryWrapper<SysException> clean = new QueryWrapper<>();
        Date cleanDate = DateUtil.offsetDay(new Date(),  Convert.toInt(SysConfigUtil.get(SysConfigConst.CLEAN_EXCEPTION_LOG)) * -1);
        clean.lt("trigger_time", cleanDate);
        return remove(clean);
    }
}