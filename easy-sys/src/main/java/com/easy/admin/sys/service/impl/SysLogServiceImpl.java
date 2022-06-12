package com.easy.admin.sys.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
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
     * @param object 查询条件
     * @return 数据集合
     */
    @Override
    public Page<SysLog> select(SysLog object, Page<SysLog> page) {
        QueryWrapper<SysLog> queryWrapper = new QueryWrapper<>();
        if (object != null) {
            // 查询条件
            // 模块
            if (Validator.isNotEmpty(object.getModular())) {
                queryWrapper.like("t.modular", object.getModular());
            }
            // 方法
            if (Validator.isNotEmpty(object.getMethod())) {
                queryWrapper.like("t.method", object.getMethod());
            }
            // ip
            if (Validator.isNotEmpty(object.getIp())) {
                queryWrapper.like("t.ip", object.getIp());
            }
            // url
            if (Validator.isNotEmpty(object.getUrl())) {
                queryWrapper.like("t.url", object.getUrl());
            }
            // uri
            if (Validator.isNotEmpty(object.getUri())) {
                queryWrapper.like("t.uri", object.getUri());
            }
            // clazz
            if (Validator.isNotEmpty(object.getClazz())) {
                queryWrapper.like("t.clazz", object.getClazz());
            }
            // params
            if (Validator.isNotEmpty(object.getParams())) {
                queryWrapper.like("t.params", object.getParams());
            }
            // 操作人
            if (Validator.isNotEmpty(object.getOperationUser())) {
                queryWrapper.like("u.nickname", object.getOperationUser());
            }
            // 操作时间
            if (Validator.isNotEmpty(object.getOperationDate())) {
                queryWrapper.eq("t.operation_date", object.getOperationDate());
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
     * @param object 表单内容
     * @return 保存后信息
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysLog saveData(SysLog object) {
        return (SysLog) ToolUtil.checkResult(saveOrUpdate(object), object);
    }

    @Override
    public boolean clean() {
        QueryWrapper<SysLog> clean = new QueryWrapper<>();
        Date cleanDate = DateUtil.offsetDay(new Date(), (int) SysConfigUtil.get(SysConfigConst.CLEAN_SYS_LOG) * -1);
        clean.lt("operation_date", cleanDate);
        return remove(clean);
    }
}