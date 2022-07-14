package com.easy.admin.activiti.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.activiti.dao.ActivitiHistoricMapper;
import com.easy.admin.activiti.model.ActivitiHistoric;
import com.easy.admin.activiti.model.ActivitiTask;
import com.easy.admin.activiti.service.ActivitiHistoricService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 流程历史活动记录
 *
 * @author TengChongChong
 * @date 2020/5/7
 */
@Service
public class ActivitiHistoricServiceImpl extends ServiceImpl<ActivitiHistoricMapper, ActivitiHistoric> implements ActivitiHistoricService {

    @Override
    public List<ActivitiHistoric> select(String processInstanceId) {
        QueryWrapper<ActivitiHistoric> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("aha.proc_inst_id_", processInstanceId);
        queryWrapper.orderByAsc("aha.start_time_");

        List<ActivitiHistoric> activitiHistoricList = baseMapper.select(queryWrapper);
        return activitiHistoricList;
    }

    @Override
    public ActivitiTask selectTask(String businessKey) {
        return baseMapper.selectTask(businessKey);
    }
}
