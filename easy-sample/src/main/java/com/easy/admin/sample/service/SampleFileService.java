package com.easy.admin.sample.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sample.model.SampleFile;

/**
 * 文件示例
 *
 * @author tengchongchong
 * @date 2023-12-22
 */
public interface SampleFileService {
    /**
     * 查询数据
     *
     * @param sampleFile 查询条件
     * @param page   分页
     * @return Page<SampleFile>
     */
    Page<SampleFile> select(SampleFile sampleFile, Page<SampleFile> page);

    /**
     * 查询详情
     *
     * @param id id
     * @return SampleFile
     */
    SampleFile get(String id);

    /**
     * 新增
     * @return SampleFile
     */
    SampleFile add();
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
     * @param sampleFile 表单内容
     * @return SampleFile
     */
    SampleFile saveData(SampleFile sampleFile);

    /**
     * 下载
     *
     * @param id id
     * @return 文件下载id
     */
    String download(String id);

}
