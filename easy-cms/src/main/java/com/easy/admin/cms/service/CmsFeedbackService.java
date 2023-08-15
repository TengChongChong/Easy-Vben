package com.easy.admin.cms.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.cms.model.CmsFeedback;

/**
 * 用户反馈
 *
 * @author 系统管理员
 * @date 2023-07-10
 */
public interface CmsFeedbackService {
    /**
     * 查询数据
     *
     * @param cmsFeedback 查询条件
     * @param page        分页
     * @return Page<CmsFeedback>
     */
    Page<CmsFeedback> select(CmsFeedback cmsFeedback, Page<CmsFeedback> page);

    /**
     * 查询详情
     *
     * @param id id
     * @return CmsFeedback
     */
    CmsFeedback get(String id);

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
     * @param cmsFeedback 表单内容
     * @return CmsFeedback
     */
    CmsFeedback saveData(CmsFeedback cmsFeedback);

    /**
     * 导出数据
     *
     * @param cmsFeedback 查询条件
     * @return 文件下载id
     */
    String exportData(CmsFeedback cmsFeedback);

}
