package com.easy.admin.sample.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sample.model.SampleSlaveGeneral;

/**
 * 从库示例
 *
 * @author 系统管理员
 * @date 2021-12-20
 */
public interface SampleSlaveGeneralService {
    /**
     * 列表
     * @param object 查询条件
     * @param page   分页
     * @return Page<SampleSlaveGeneral>
     */
    Page<SampleSlaveGeneral> select(SampleSlaveGeneral object, Page<SampleSlaveGeneral> page);

    /**
     * 详情
     *
     * @param id id
     * @return SampleSlaveGeneral
     */
    SampleSlaveGeneral get(String id);

    /**
     * 新增
     *
     * @return SampleSlaveGeneral
     */
    SampleSlaveGeneral add();

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
     * @return SampleSlaveGeneral
     */
    SampleSlaveGeneral saveData(SampleSlaveGeneral object);

}
