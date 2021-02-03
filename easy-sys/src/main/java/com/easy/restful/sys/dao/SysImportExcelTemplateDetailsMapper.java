package com.easy.restful.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.restful.sys.model.Column;
import com.easy.restful.sys.model.SysImportExcelTemplateDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 导入模板详情
 *
 * @author TengChong
 * @date 2019-04-10
 */
public interface SysImportExcelTemplateDetailsMapper extends BaseMapper<SysImportExcelTemplateDetails> {
    /**
     * 根据模板id获取表格表头
     *
     * @param templateId 模板id
     * @return heads
     */
    List<Column> selectTableHeadByTemplateId(@Param("templateId") String templateId);


}