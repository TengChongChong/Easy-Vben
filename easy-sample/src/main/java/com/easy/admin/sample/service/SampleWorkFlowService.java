package com.easy.admin.sample.service;


import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sample.model.SampleWorkFlow;

/**
 * 流程示例
 *
 * @author TengChong
 * @date 2020-04-26
 */
public interface SampleWorkFlowService {
    /**
     * 列表
     *
     * @param object 查询条件
     * @param page   分页
     * @return 数据集合
     */
    Page<SampleWorkFlow> select(SampleWorkFlow object, Page<SampleWorkFlow> page);

    /**
     * 详情
     *
     * @param id id
     * @return 详细信息
     */
    SampleWorkFlow get(String id);

    /**
     * 新增
     *
     * @return 默认值
     */
    SampleWorkFlow add();

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return 是否成功
     */
    boolean remove(String ids);

    /**
     * 保存
     *
     * @param object 表单内容
     * @return 保存后信息
     */
    SampleWorkFlow saveData(SampleWorkFlow object);
}
