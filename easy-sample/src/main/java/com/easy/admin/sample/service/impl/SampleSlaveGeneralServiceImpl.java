package com.easy.admin.sample.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.util.ToolUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.List;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.easy.admin.sample.model.SampleSlaveGeneral;
import com.easy.admin.sample.service.SampleSlaveGeneralService;
import com.easy.admin.sample.dao.SampleSlaveGeneralMapper;

/**
 * 从库示例
 *
 * @author 系统管理员
 * @date 2022-06-23
 */
@Service
@DS("slave")
public class SampleSlaveGeneralServiceImpl extends ServiceImpl<SampleSlaveGeneralMapper, SampleSlaveGeneral> implements SampleSlaveGeneralService {

    /**
     * 列表
     *
     * @param sampleSlaveGeneral 查询条件
     * @param page   分页
     * @return Page<SampleSlaveGeneral>
     */
    @Override
    public Page<SampleSlaveGeneral> select(SampleSlaveGeneral sampleSlaveGeneral, Page<SampleSlaveGeneral> page) {
        QueryWrapper<SampleSlaveGeneral> queryWrapper = getQueryWrapper(sampleSlaveGeneral);
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    /**
     * 获取查询条件
     *
     * @param sampleSlaveGeneral 查询条件
     * @return QueryWrapper<SampleSlaveGeneral>
     */
    private QueryWrapper<SampleSlaveGeneral> getQueryWrapper(SampleSlaveGeneral sampleSlaveGeneral){
        QueryWrapper<SampleSlaveGeneral> queryWrapper = new QueryWrapper<>();
        if(sampleSlaveGeneral != null){
            // 查询条件
            // 姓名
            if (Validator.isNotEmpty(sampleSlaveGeneral.getName())) {
                queryWrapper.like("t.name", sampleSlaveGeneral.getName());
            }
            // 性别
            if (Validator.isNotEmpty(sampleSlaveGeneral.getSex())) {
                if (sampleSlaveGeneral.getSex().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.sex", sampleSlaveGeneral.getSex().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.sex", sampleSlaveGeneral.getSex());
                }
            }
            // 手机号码
            if (Validator.isNotEmpty(sampleSlaveGeneral.getPhone())) {
                queryWrapper.like("t.phone", sampleSlaveGeneral.getPhone());
            }
            // 状态
            if (Validator.isNotEmpty(sampleSlaveGeneral.getStatus())) {
                if (sampleSlaveGeneral.getStatus().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.status", sampleSlaveGeneral.getStatus().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.status", sampleSlaveGeneral.getStatus());
                }
            }
            // 地址
            if (Validator.isNotEmpty(sampleSlaveGeneral.getAddress())) {
                queryWrapper.like("t.address", sampleSlaveGeneral.getAddress());
            }
        }
        return queryWrapper;
    }

    /**
     * 详情
     *
     * @param id id
     * @return SampleSlaveGeneral
     */
    @Override
    public SampleSlaveGeneral get(String id) {
        ToolUtil.checkParams(id);
        return baseMapper.getById(id);
    }

    /**
     * 新增
     *
     * @return SampleSlaveGeneral
     */
    @Override
    public SampleSlaveGeneral add() {
        SampleSlaveGeneral sampleSlaveGeneral = new SampleSlaveGeneral();
        // 设置默认值
        return sampleSlaveGeneral;
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
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        return removeByIds(idList);
    }

    /**
     * 保存
     *
     * @param sampleSlaveGeneral 表单内容
     * @return SampleSlaveGeneral
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SampleSlaveGeneral saveData(SampleSlaveGeneral sampleSlaveGeneral) {
        ToolUtil.checkParams(sampleSlaveGeneral);
        if (Validator.isEmpty(sampleSlaveGeneral.getId())) {
            // 新增,设置默认值
        }
        return (SampleSlaveGeneral) ToolUtil.checkResult(saveOrUpdate(sampleSlaveGeneral), sampleSlaveGeneral);
    }

}