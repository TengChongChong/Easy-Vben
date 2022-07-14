package com.easy.admin.sample.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.sample.dao.SampleWorkFlowMapper;
import com.easy.admin.sample.model.SampleWorkFlow;
import com.easy.admin.sample.service.SampleWorkFlowService;
import com.easy.admin.util.ToolUtil;
import com.easy.admin.util.office.ExcelUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 流程示例
 *
 * @author 系统管理员
 * @date 2022-07-08
 */
@Service
public class SampleWorkFlowServiceImpl extends ServiceImpl<SampleWorkFlowMapper, SampleWorkFlow> implements SampleWorkFlowService {

    /**
     * 列表
     *
     * @param sampleWorkFlow 查询条件
     * @param page   分页
     * @return Page<SampleWorkFlow>
     */
    @Override
    public Page<SampleWorkFlow> select(SampleWorkFlow sampleWorkFlow, Page<SampleWorkFlow> page) {
        QueryWrapper<SampleWorkFlow> queryWrapper = getQueryWrapper(sampleWorkFlow);
        page.setDefaultDesc("t.create_date");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    /**
     * 获取查询条件
     *
     * @param sampleWorkFlow 查询条件
     * @return QueryWrapper<SampleWorkFlow>
     */
    private QueryWrapper<SampleWorkFlow> getQueryWrapper(SampleWorkFlow sampleWorkFlow){
        QueryWrapper<SampleWorkFlow> queryWrapper = new QueryWrapper<>();
        if(sampleWorkFlow != null){
            // 查询条件
            // 请假类型
            if (Validator.isNotEmpty(sampleWorkFlow.getLeaveType())) {
                if (sampleWorkFlow.getLeaveType().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.leave_type", sampleWorkFlow.getLeaveType().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.leave_type", sampleWorkFlow.getLeaveType());
                }
            }
            // 开始时间
            if (Validator.isNotEmpty(sampleWorkFlow.getStartDate())) {
                queryWrapper.ge("t.start_date", sampleWorkFlow.getStartDate());
            }
            // 结束时间
            if (Validator.isNotEmpty(sampleWorkFlow.getEndDate())) {
                queryWrapper.le("t.end_date", sampleWorkFlow.getEndDate());
            }
            // 原因
            if (Validator.isNotEmpty(sampleWorkFlow.getReason())) {
                queryWrapper.like("t.reason", sampleWorkFlow.getReason());
            }
            // 状态
            if (Validator.isNotEmpty(sampleWorkFlow.getStatus())) {
                if (sampleWorkFlow.getStatus().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.status", sampleWorkFlow.getStatus().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.status", sampleWorkFlow.getStatus());
                }
            }
        }
        return queryWrapper;
    }

    /**
     * 详情
     *
     * @param id id
     * @return SampleWorkFlow
     */
    @Override
    public SampleWorkFlow get(String id) {
        ToolUtil.checkParams(id);
        return baseMapper.getById(id);
    }

    /**
     * 新增
     *
     * @return SampleWorkFlow
     */
    @Override
    public SampleWorkFlow add() {
        SampleWorkFlow sampleWorkFlow = new SampleWorkFlow();
        // 设置默认值
        return sampleWorkFlow;
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
     * @param sampleWorkFlow 表单内容
     * @return SampleWorkFlow
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SampleWorkFlow saveData(SampleWorkFlow sampleWorkFlow) {
        ToolUtil.checkParams(sampleWorkFlow);
        if (Validator.isEmpty(sampleWorkFlow.getId())) {
            // 新增,设置默认值
        }
        return (SampleWorkFlow) ToolUtil.checkResult(saveOrUpdate(sampleWorkFlow), sampleWorkFlow);
    }

    @Override
    public String exportData(SampleWorkFlow sampleWorkFlow) {
        QueryWrapper<SampleWorkFlow> queryWrapper = getQueryWrapper(sampleWorkFlow);
        List<SampleWorkFlow> list = baseMapper.exportData(queryWrapper);
        return ExcelUtil.writeAndGetDownloadId("流程示例", "流程示例", list, SampleWorkFlow.class);
    }

}