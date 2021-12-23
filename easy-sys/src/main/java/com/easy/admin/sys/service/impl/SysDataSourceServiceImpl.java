package com.easy.admin.sys.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.sys.dao.SysDataSourceMapper;
import com.easy.admin.sys.model.SysDataSource;
import com.easy.admin.sys.service.SysDataSourceService;
import com.easy.admin.util.ToolUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数据源管理
 *
 * @author TengChongChong
 * @date 2021-12-18
 */
@Service
public class SysDataSourceServiceImpl extends ServiceImpl<SysDataSourceMapper, SysDataSource> implements SysDataSourceService {

    @Value("${spring.datasource.dynamic.primary}")
    private String dynamicPrimary;

    /**
     * 列表
     * @param object 查询条
     * @param page   分页
     * @return Page<SysDataSource>
     */
    @Override
    public Page<SysDataSource> select(SysDataSource object, Page<SysDataSource> page) {
        QueryWrapper<SysDataSource> queryWrapper = new QueryWrapper<>();
        if(object != null){
            // 查询条件
            // 名称
            if (Validator.isNotEmpty(object.getName())) {
                queryWrapper.like("t.name", object.getName());
            }
            // url
            if (Validator.isNotEmpty(object.getUrl())) {
                queryWrapper.like("t.url", object.getUrl());
            }
            // 状态
            if (Validator.isNotEmpty(object.getStatus())) {
                queryWrapper.eq("t.status", object.getStatus());
            }
        }
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    @Override
    public List<SysDataSource> selectAll() {
        QueryWrapper<SysDataSource> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("t.status", CommonStatus.ENABLE.getCode());
        return baseMapper.selectAll(queryWrapper);
    }

    @Override
    public List<Select> selectOptions() {
        List<Select> selects = new ArrayList<>();
        // 主数据源
        selects.add(new Select(dynamicPrimary, dynamicPrimary));

        List<SysDataSource> dataSourceList = selectAll();
        if(CollUtil.isEmpty(dataSourceList)){
            return selects;
        }
        dataSourceList.forEach(dataSource -> selects.add(new Select(dataSource.getName(), dataSource.getName())));
        return selects;
    }

    /**
     * 详情
     *
     * @param id id
     * @return SysDataSource
     */
    @Override
    public SysDataSource get(String id) {
        ToolUtil.checkParams(id);
        return baseMapper.getById(id);
    }

    /**
     * 新增
     *
     * @return SysDataSource
     */
    @Override
    public SysDataSource add() {
        SysDataSource object = new SysDataSource();
        object.setStatus(CommonStatus.ENABLE.getCode());
        // 设置默认值
        return object;
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        ToolUtil.checkParams(ids);
        List<String> idList = Arrays.asList(ids.split(","));
        return removeByIds(idList);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysDataSource
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysDataSource saveData(SysDataSource object) {
        ToolUtil.checkParams(object);
        if (Validator.isEmpty(object.getId())) {
            // 新增,设置默认值
        }
        return (SysDataSource) ToolUtil.checkResult(saveOrUpdate(object), object);
    }


}