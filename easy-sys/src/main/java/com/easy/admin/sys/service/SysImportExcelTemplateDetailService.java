package com.easy.admin.sys.service;


import com.easy.admin.sys.model.SysImportExcelTemplateDetail;

import java.util.List;

/**
 * 导入模板详情
 *
 * @author TengChong
 * @date 2019-04-10
 */
public interface SysImportExcelTemplateDetailService {
    /**
     * 获取已配置字段
     *
     * @param templateId 导入模板id
     * @return List<SysImportExcelTemplateDetails>
     */
    List<SysImportExcelTemplateDetail> selectDetails(String templateId);

    /**
     * 保存
     *
     * @param templateId 导入模板id
     * @param list       表单内容
     * @return true/false
     */
    boolean saveData(String templateId, List<SysImportExcelTemplateDetail> list);

    /**
     * 根据模板ids删除规则
     *
     * @param templateIds 模板ids
     */
    void deleteByTemplateIds(String templateIds);
}
