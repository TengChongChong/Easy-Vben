package com.easy.admin.sample.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sample.model.SampleGeneral;

/**
 * 代码生成示例
 *
 * @author 系统管理员
 * @date 2023-12-27
 */
public interface SampleGeneralService {
    /**
     * 查询数据
     *
     * @param sampleGeneral 查询条件
     * @param page   分页
     * @return Page<SampleGeneral>
     */
    Page<SampleGeneral> select(SampleGeneral sampleGeneral, Page<SampleGeneral> page);

    /**
     * 查询详情
     *
     * @param id id
     * @return SampleGeneral
     */
    SampleGeneral get(String id);

    /**
     * 新增
     * @return SampleGeneral
     */
    SampleGeneral add();
    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 保存/修改
     *
     * @param sampleGeneral 表单内容
     * @return SampleGeneral
     */
    SampleGeneral saveData(SampleGeneral sampleGeneral);

    /**
     * 导出数据
     *
     * @param sampleGeneral 查询条件
     * @return 文件下载id
     */
    String exportData(SampleGeneral sampleGeneral);

}
