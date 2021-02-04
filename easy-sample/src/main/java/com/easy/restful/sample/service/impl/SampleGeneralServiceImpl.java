package com.easy.restful.sample.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.sample.dao.SampleGeneralMapper;
import com.easy.restful.sample.model.SampleGeneral;
import com.easy.restful.sample.service.SampleGeneralService;
import com.easy.restful.util.ToolUtil;
import com.easy.restful.util.office.ExcelUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 代码生成示例
 *
 * @author 系统管理员
 * @date 2021-01-25
 */
@Service
public class SampleGeneralServiceImpl extends ServiceImpl<SampleGeneralMapper, SampleGeneral> implements SampleGeneralService {

    /**
     * 列表
     * @param object 查询条
     * @param page   分页
     * @return Page<SampleGeneral>
     */
    @Override
    public Page<SampleGeneral> select(SampleGeneral object, Page<SampleGeneral> page) {
        QueryWrapper<SampleGeneral> queryWrapper = new QueryWrapper<>();
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
            // 手机号码
            if (Validator.isNotEmpty(object.getPhone())) {
                queryWrapper.eq("t.phone", object.getPhone());
            }
        }
        page.setRecords(getBaseMapper().select(page, queryWrapper));
        return page;
    }

    /**
     * 详情
     *
     * @param id id
     * @return SampleGeneral
     */
    @Override
    public SampleGeneral input(String id) {
        ToolUtil.checkParams(id);
        return getBaseMapper().getById(id);
    }

    /**
     * 新增
     *
     * @return SampleGeneral
     */
    @Override
    public SampleGeneral add() {
        SampleGeneral object = new SampleGeneral();
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
     * @return SampleGeneral
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SampleGeneral saveData(SampleGeneral object) {
        ToolUtil.checkParams(object);
        if (Validator.isNotEmpty(object.getId())) {
            // 新增,设置默认值
        }
        return (SampleGeneral) ToolUtil.checkResult(saveOrUpdate(object), object);
    }

    @Override
    public String export(SampleGeneral object) {
        QueryWrapper<SampleGeneral> queryWrapper = new QueryWrapper<>();
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
            // 手机号码
            if (Validator.isNotEmpty(object.getPhone())) {
                queryWrapper.eq("t.phone", object.getPhone());
            }
        }
        List<SampleGeneral> list = getBaseMapper().export(queryWrapper);
        return ExcelUtil.writeAndGetDownloadId("导出示例", "人员", list, SampleGeneral.class);
    }
}