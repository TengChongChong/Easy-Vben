package com.easy.restful.activiti.service;

import com.easy.restful.activiti.model.Historic;
import com.easy.restful.activiti.model.Task;

import java.util.List;

/**
 * 流程历史活动记录
 *
 * @author tengchong
 * @date 2020/5/7
 */
public interface HistoricService {
    /**
     * 查询
     *
     * @param object 查询条件
     * @return List<Historic>
     */
    List<Historic> select(Historic object);

    /**
     * 根据业务id查询流程实例
     *
     * @param businessKey 业务id
     * @return 流程实例
     */
    Task selectTask(String businessKey);
}
