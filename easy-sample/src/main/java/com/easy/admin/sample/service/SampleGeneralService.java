package com.easy.admin.sample.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.easy.admin.sample.model.SampleGeneral;
import com.easy.admin.sample.model.vo.SampleGeneralVO;

/**
 * 代码生成示例
 *
 * @author 系统管理员
 * @date 2025-03-21
 */
public interface SampleGeneralService extends IService<SampleGeneral> {

    /**
     * 查询数据
     *
     * @param sampleGeneral 查询条件
     * @param page   分页
     * @return Page<SampleGeneralVO>
     */
    Page<SampleGeneralVO> select(SampleGeneralVO sampleGeneral, Page<SampleGeneralVO> page);

    /**
     * 查询详情
     *
     * @param id id
     * @return SampleGeneralVO
     */
    SampleGeneralVO get(String id);

    /**
     * 新增
     * @return SampleGeneralVO
     */
    SampleGeneralVO add();

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
     * @param sampleGeneralVO 表单内容
     * @return SampleGeneralVO
     */
    SampleGeneralVO saveData(SampleGeneralVO sampleGeneralVO);

    /**
     * 导出数据
     *
     * @param sampleGeneral 查询条件
     * @return 文件下载id
     */
    String exportData(SampleGeneralVO sampleGeneral);
}
