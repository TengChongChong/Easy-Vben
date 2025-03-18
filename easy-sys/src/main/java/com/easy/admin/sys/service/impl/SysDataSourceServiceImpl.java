package com.easy.admin.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Validator;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DruidDataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.sys.dao.SysDataSourceMapper;
import com.easy.admin.sys.model.SysDataSource;
import com.easy.admin.sys.service.SysDataSourceService;
import com.easy.admin.common.core.util.ToolUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数据源管理
 *
 * @author TengChongChong
 * @date 2021-12-18
 */
@Slf4j
@Service
public class SysDataSourceServiceImpl extends ServiceImpl<SysDataSourceMapper, SysDataSource> implements SysDataSourceService {

    @Value("${spring.datasource.dynamic.primary}")
    private String dynamicPrimary;

    @Autowired
    private DynamicRoutingDataSource dynamicRoutingDataSource;

    @Autowired
    private DruidDataSourceCreator druidDataSourceCreator;

    /**
     * 列表
     *
     * @param sysDataSource 查询条
     * @param page          分页
     * @return Page<SysDataSource>
     */
    @Override
    public Page<SysDataSource> select(SysDataSource sysDataSource, Page<SysDataSource> page) {
        QueryWrapper<SysDataSource> queryWrapper = new QueryWrapper<>();
        if (sysDataSource != null) {
            // 查询条件
            // 名称
            if (Validator.isNotEmpty(sysDataSource.getName())) {
                queryWrapper.like("t.name", sysDataSource.getName());
            }
            // url
            if (Validator.isNotEmpty(sysDataSource.getUrl())) {
                queryWrapper.like("t.url", sysDataSource.getUrl());
            }
            // 账号
            if (Validator.isNotEmpty(sysDataSource.getUsername())) {
                queryWrapper.like("t.username", sysDataSource.getUsername());
            }
            // 密码
            if (Validator.isNotEmpty(sysDataSource.getPassword())) {
                queryWrapper.like("t.password", sysDataSource.getPassword());
            }
            // 备注
            if (Validator.isNotEmpty(sysDataSource.getRemarks())) {
                queryWrapper.like("t.remarks", sysDataSource.getRemarks());
            }
            // 状态
            if (Validator.isNotEmpty(sysDataSource.getStatus())) {
                if (sysDataSource.getStatus().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.status", sysDataSource.getStatus().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.status", sysDataSource.getStatus());
                }
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
        if (CollUtil.isEmpty(dataSourceList)) {
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
        return baseMapper.getById(id);
    }

    /**
     * 新增
     *
     * @return SysDataSource
     */
    @Override
    public SysDataSource add() {
        SysDataSource sysDataSource = new SysDataSource();
        sysDataSource.setStatus(CommonStatus.ENABLE.getCode());
        // 设置默认值
        return sysDataSource;
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
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));

        // 移除数据源
        QueryWrapper<SysDataSource> selectNames = new QueryWrapper<>();
        selectNames.in("id", idList);
        List<String> names = baseMapper.selectName(selectNames);
        if (CollUtil.isNotEmpty(names)) {
            names.forEach(name -> dynamicRoutingDataSource.removeDataSource(name));
        }

        return removeByIds(idList);
    }

    /**
     * 保存
     *
     * @param sysDataSource 表单内容
     * @return SysDataSource
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysDataSource saveData(SysDataSource sysDataSource) {
        SysDataSource oldDataSource = null;
        if (Validator.isNotEmpty(sysDataSource.getId())) {
            oldDataSource = get(sysDataSource.getId());
        }
        boolean isSuccess = saveOrUpdate(sysDataSource);
        if (!isSuccess) {
            throw new EasyException("数据源保存失败");
        }
        if (oldDataSource != null) {
            dynamicRoutingDataSource.removeDataSource(oldDataSource.getName());
        }
        addDataSource(sysDataSource);
        return sysDataSource;
    }


    @Override
    public void addDataSource(SysDataSource dataSource) {
        DataSource masterDs = dynamicRoutingDataSource.getDataSource(dynamicPrimary);
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        BeanUtil.copyProperties(masterDs, dataSourceProperty);
        dataSourceProperty.setUrl(dataSource.getUrl());
        dataSourceProperty.setUsername(dataSource.getUsername());
        dataSourceProperty.setPassword(dataSource.getPassword());

        DataSource ds = druidDataSourceCreator.createDataSource(dataSourceProperty);
        dynamicRoutingDataSource.addDataSource(dataSource.getName(), ds);
        log.debug("添加 {} 数据源", dataSource.getName());
    }
}