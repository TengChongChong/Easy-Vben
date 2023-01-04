package com.easy.admin.sys.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.sys.common.constant.SysConfigConst;
import com.easy.admin.sys.dao.SysLogMapper;
import com.easy.admin.sys.model.SysLog;
import com.easy.admin.sys.service.SysLogService;
import com.easy.admin.util.SysConfigUtil;
import com.easy.admin.util.ToolUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 日志
 *
 * @author TengChong
 * @date 2019-06-27
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    /**
     * 列表
     *
     * @param sysLog 查询条件
     * @return 数据集合
     */
    @Override
    public Page<SysLog> select(SysLog sysLog, Page<SysLog> page) {
        QueryWrapper<SysLog> queryWrapper = new QueryWrapper<>();
        if (sysLog != null) {
            // 查询条件
            // 模块
            if (Validator.isNotEmpty(sysLog.getModular())) {
                queryWrapper.like("t.modular", sysLog.getModular());
            }
            // 方法
            if (Validator.isNotEmpty(sysLog.getMethod())) {
                queryWrapper.like("t.method", sysLog.getMethod());
            }
            // ip
            if (Validator.isNotEmpty(sysLog.getIp())) {
                queryWrapper.like("t.ip", sysLog.getIp());
            }
            // url
            if (Validator.isNotEmpty(sysLog.getUrl())) {
                queryWrapper.like("t.url", sysLog.getUrl());
            }
            // uri
            if (Validator.isNotEmpty(sysLog.getUri())) {
                queryWrapper.like("t.uri", sysLog.getUri());
            }
            // clazz
            if (Validator.isNotEmpty(sysLog.getClazz())) {
                queryWrapper.like("t.clazz", sysLog.getClazz());
            }
            // params
            if (Validator.isNotEmpty(sysLog.getParams())) {
                queryWrapper.like("t.params", sysLog.getParams());
            }
            // 操作人
            if (Validator.isNotEmpty(sysLog.getOperationUser())) {
                queryWrapper.like("u.nickname", sysLog.getOperationUser());
            }
            // 操作时间 - 开始
            if (Validator.isNotEmpty(sysLog.getStartOperationDate())) {
                queryWrapper.ge("t.operation_date", sysLog.getStartOperationDate());
            }
            // 操作时间 - 结束
            if (Validator.isNotEmpty(sysLog.getEndOperationDate())) {
                queryWrapper.le("t.operation_date", sysLog.getEndOperationDate());
            }
            if (Validator.isNotEmpty(sysLog.getHttpMethod())) {
                if (sysLog.getHttpMethod().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.http_method", sysLog.getHttpMethod().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.http_method", sysLog.getHttpMethod());
                }
            }
        }
        // 设置默认排序
        page.setDefaultDesc("operation_date");
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
    public SysLog get(String id) {
        ToolUtil.checkParams(id);
        return baseMapper.getById(id);
    }

    /**
     * 保存
     *
     * @param sysLog 表单内容
     * @return 保存后信息
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysLog saveData(SysLog sysLog) {
        return (SysLog) ToolUtil.checkResult(saveOrUpdate(sysLog), sysLog);
    }

    @Override
    public boolean clean() {
        QueryWrapper<SysLog> clean = new QueryWrapper<>();
        Date cleanDate = DateUtil.offsetDay(new Date(), Convert.toInt(SysConfigUtil.get(SysConfigConst.CLEAN_SYS_LOG)) * -1);
        clean.lt("operation_date", cleanDate);
        return remove(clean);
    }
}