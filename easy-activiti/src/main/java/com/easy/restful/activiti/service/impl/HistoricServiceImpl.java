package com.easy.restful.activiti.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.restful.activiti.dao.HistoricMapper;
import com.easy.restful.activiti.model.Historic;
import com.easy.restful.activiti.model.Task;
import com.easy.restful.activiti.service.HistoricService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 流程历史活动记录
 *
 * @author tengchong
 * @date 2020/5/7
 */
@Service
public class HistoricServiceImpl extends ServiceImpl<HistoricMapper, Historic> implements HistoricService {

    @Override
    public List<Historic> select(String processInstanceId) {
        QueryWrapper<Historic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("aha.proc_inst_id_", processInstanceId);
        queryWrapper.orderByAsc("aha.start_time_");

        List<Historic> historicList = getBaseMapper().select(queryWrapper);
        return historicList;
    }

    @Override
    public Task selectTask(String businessKey) {
        return getBaseMapper().selectTask(businessKey);
    }
}
