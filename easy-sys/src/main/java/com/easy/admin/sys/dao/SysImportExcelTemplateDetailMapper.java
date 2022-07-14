package com.easy.admin.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.sys.model.TableHeadColumn;
import com.easy.admin.sys.model.SysImportExcelTemplateDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 导入模板详情
 *
 * @author TengChong
 * @date 2019-04-10
 */
public interface SysImportExcelTemplateDetailMapper extends BaseMapper<SysImportExcelTemplateDetail> {
    /**
     * 根据模板id获取表格表头
     *
     * @param templateId 模板id
     * @return heads
     */
    List<TableHeadColumn> selectTableHeadByTemplateId(@Param("templateId") String templateId);


}