package com.easy.admin.sample.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sample.model.SampleGeneral;

/**
 * 代码生成示例
 *
 * @author 系统管理员
 * @date 2021-02-23
 */
public interface SampleGeneralService {
    /**
     * 列表
     * @param object 查询条件
     * @param page   分页
     * @return Page<SampleGeneral>
     */
    Page<SampleGeneral> select(SampleGeneral object, Page<SampleGeneral> page);

    /**
     * 详情
     *
     * @param id id
     * @return SampleGeneral
     */
    SampleGeneral input(String id);

    /**
     * 新增
     *
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
     * 保存
     *
     * @param object 表单内容
     * @return SampleGeneral
     */
    SampleGeneral saveData(SampleGeneral object);

    /**
     * 导出数据
     *
     * @param object 查询条件
     * @return 文件下载id
     */
    String exportData(SampleGeneral object);
}
