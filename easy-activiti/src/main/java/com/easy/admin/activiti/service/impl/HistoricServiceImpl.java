package com.easy.admin.activiti.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.activiti.dao.HistoricMapper;
import com.easy.admin.activiti.model.Historic;
import com.easy.admin.activiti.model.Task;
import com.easy.admin.activiti.service.HistoricService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 流程历史活动记录
 *
 * @author TengChongChong
 * @date 2020/5/7
 */
@Service
public class HistoricServiceImpl extends ServiceImpl<HistoricMapper, Historic> implements HistoricService {

    @Override
    public List<Historic> select(String processInstanceId) {
        QueryWrapper<Historic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("aha.proc_inst_id_", processInstanceId);
        queryWrapper.orderByAsc("aha.start_time_");

        List<Historic> historicList = baseMapper.select(queryWrapper);
        return historicList;
    }

    @Override
    public Task selectTask(String businessKey) {
        return baseMapper.selectTask(businessKey);
    }
}
