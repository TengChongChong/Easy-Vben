package com.easy.restful.sys.service;


import com.easy.restful.sys.model.Column;
import com.easy.restful.sys.model.SysImportExcelTemplateDetails;

import java.util.List;

/**
 * 导入模板详情
 *
 * @author TengChong
 * @date 2019-04-10
 */
public interface SysImportExcelTemplateDetailsService {
    /**
     * 获取已配置字段
     *
     * @param templateId 导入模板id
     * @return List<SysImportExcelTemplateDetails>
     */
    List<SysImportExcelTemplateDetails> selectDetails(String templateId);

    /**
     * 根据模板代码获取表格表头
     *
     * @param templateId 模板id
     * @return List<Column>
     */
    List<Column> selectTableHeadByTemplateCode(String templateId);

    /**
     * 保存
     *
     * @param templateId 导入模板id
     * @param list       表单内容
     * @return true/false
     */
    boolean saveData(String templateId, List<SysImportExcelTemplateDetails> list);

    /**
     * 根据模板ids删除规则
     *
     * @param templateIds 模板ids
     */
    void deleteByTemplateIds(String templateIds);
}
