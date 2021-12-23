package com.easy.admin.sample.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sample.dao.SampleSlaveGeneralMapper;
import com.easy.admin.sample.model.SampleSlaveGeneral;
import com.easy.admin.sample.service.SampleSlaveGeneralService;
import com.easy.admin.sys.common.constant.DataSourceConst;
import com.easy.admin.util.ToolUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 从库示例
 *
 * @author 系统管理员
 * @date 2021-12-20
 */
@Service
@DS(DataSourceConst.EASY_FRAME_SLAVE)
public class SampleSlaveGeneralServiceImpl extends ServiceImpl<SampleSlaveGeneralMapper, SampleSlaveGeneral> implements SampleSlaveGeneralService {

    /**
     * 列表
     * @param object 查询条
     * @param page   分页
     * @return Page<SampleSlaveGeneral>
     */
    @Override
    public Page<SampleSlaveGeneral> select(SampleSlaveGeneral object, Page<SampleSlaveGeneral> page) {
        QueryWrapper<SampleSlaveGeneral> queryWrapper = new QueryWrapper<>();
        if(object != null){
            // 查询条件
            // 姓名
            if (Validator.isNotEmpty(object.getName())) {
                queryWrapper.like("t.name", object.getName());
            }
            // 性别
            if (Validator.isNotEmpty(object.getSex())) {
                queryWrapper.eq("t.sex", object.getSex());
            }
            // 年龄
            if (Validator.isNotEmpty(object.getAge())) {
                queryWrapper.eq("t.age", object.getAge());
            }
            // 手机号码
            if (Validator.isNotEmpty(object.getPhone())) {
                queryWrapper.eq("t.phone", object.getPhone());
            }
            // 状态
            if (Validator.isNotEmpty(object.getStatus())) {
                queryWrapper.eq("t.status", object.getStatus());
            }
            // 地址
            if (Validator.isNotEmpty(object.getAddress())) {
                queryWrapper.eq("t.address", object.getAddress());
            }
        }
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
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
        SampleSlaveGeneral object = new SampleSlaveGeneral();
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
     * @return SampleSlaveGeneral
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SampleSlaveGeneral saveData(SampleSlaveGeneral object) {
        ToolUtil.checkParams(object);
        if (Validator.isEmpty(object.getId())) {
            // 新增,设置默认值
        }
        return (SampleSlaveGeneral) ToolUtil.checkResult(saveOrUpdate(object), object);
    }


}