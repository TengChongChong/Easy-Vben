package com.easy.admin.sample.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sample.model.SampleWorkFlow;

/**
 * 流程示例
 *
 * @author 系统管理员
 * @date 2022-07-08
 */
public interface SampleWorkFlowService {
    /**
     * 列表
     *
     * @param sampleWorkFlow 查询条件
     * @param page   分页
     * @return Page<SampleWorkFlow>
     */
    Page<SampleWorkFlow> select(SampleWorkFlow sampleWorkFlow, Page<SampleWorkFlow> page);

    /**
     * 详情
     *
     * @param id id
     * @return SampleWorkFlow
     */
    SampleWorkFlow get(String id);

    /**
     * 新增
     *
     * @return SampleWorkFlow
     */
    SampleWorkFlow add();

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 保存
     *
     * @param sampleWorkFlow 表单内容
     * @return SampleWorkFlow
     */
    SampleWorkFlow saveData(SampleWorkFlow sampleWorkFlow);

    /**
     * 导出数据
     *
     * @param sampleWorkFlow 查询条件
     * @return 文件下载id
     */
    String exportData(SampleWorkFlow sampleWorkFlow);

}
