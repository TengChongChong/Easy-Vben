package com.easy.admin.sample.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sample.dao.SampleWorkFlowMapper;
import com.easy.admin.sample.model.SampleWorkFlow;
import com.easy.admin.sample.service.SampleWorkFlowService;
import com.easy.admin.util.ShiroUtil;
import com.easy.admin.util.ToolUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 流程示例
 *
 * @author TengChong
 * @date 2020-04-26
 */
@Service
public class SampleWorkFlowServiceImpl extends ServiceImpl<SampleWorkFlowMapper, SampleWorkFlow> implements SampleWorkFlowService {

    /**
     * 列表
     * @param object 查询条件
     * @return 数据集合
     */
    @Override
    public Page<SampleWorkFlow> select(SampleWorkFlow object, Page<SampleWorkFlow> page) {
        QueryWrapper<SampleWorkFlow> queryWrapper = new QueryWrapper<>();
        if(object != null){
            // 查询条件
            // 流程实例id
            if (Validator.isNotEmpty(object.getProcessInstanceId())) {
                queryWrapper.eq("t.process_instance_id", object.getProcessInstanceId());
            }
            // 请假类型
            if (Validator.isNotEmpty(object.getLeaveType())) {
                queryWrapper.eq("t.leave_type", object.getLeaveType());
            }
            // 状态
            if (Validator.isNotEmpty(object.getStatus())) {
                queryWrapper.eq("t.status", object.getStatus());
            }
        }
        queryWrapper.eq("t.create_user", ShiroUtil.getCurrentUser().getId());
        page.setDefaultDesc("t.create_date");
        page.setRecords(getBaseMapper().select(page, queryWrapper));
        return page;
    }

    /**
     * 详情
     *
     * @param id id
     * @return 详细信息
     */
    @Override
    public SampleWorkFlow input(String id) {
        ToolUtil.checkParams(id);
        return getBaseMapper().getById(id);
    }

    /**
     * 新增
     *
     * @return 默认值
     */
    @Override
    public SampleWorkFlow add() {
        SampleWorkFlow object = new SampleWorkFlow();
        // 设置默认值
        return object;
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
        List<String> idList = Arrays.asList(ids.split(","));
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
    public SampleWorkFlow saveData(SampleWorkFlow object) {
        ToolUtil.checkParams(object);
        if (StrUtil.isBlank(object.getId())) {
            // 新增,设置默认值
        }
        // 解析日期范围
        if(StrUtil.isNotBlank(object.getDateRange())){
            object.setStartDate(DateUtil.parse(object.getDateRange().split("~")[0].trim()));
            object.setEndDate(DateUtil.parse(object.getDateRange().split("~")[1].trim()));
        }
        return (SampleWorkFlow) ToolUtil.checkResult(saveOrUpdate(object), object);
    }
}