package com.easy.admin.sys.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.sys.dao.SysImportExcelTemplateDetailMapper;
import com.easy.admin.sys.model.Column;
import com.easy.admin.sys.model.SysImportExcelTemplateDetail;
import com.easy.admin.sys.service.SysImportExcelTemplateDetailService;
import com.easy.admin.util.ToolUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 导入模板详情
 *
 * @author TengChong
 * @date 2019-04-10
 */
@Service
public class SysImportExcelTemplateDetailServiceImpl extends ServiceImpl<SysImportExcelTemplateDetailMapper, SysImportExcelTemplateDetail> implements SysImportExcelTemplateDetailService {

    /**
     * 获取已配置字段
     *
     * @param templateId 导入模板id
     * @return 数据列表
     */
    @Override
    public List<SysImportExcelTemplateDetail> selectDetails(String templateId) {
        ToolUtil.checkParams(templateId);
        QueryWrapper<SysImportExcelTemplateDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("template_id", templateId);
        queryWrapper.orderByAsc("order_no");
        return list(queryWrapper);
    }

    @Override
    public List<Column> selectTableHeadByTemplateCode(String templateId) {
        ToolUtil.checkParams(templateId);
        List<Column> columns = baseMapper.selectTableHeadByTemplateId(templateId);
        int columnsLength = columns.size();
        while (columnsLength-- > 0) {
            columns.get(columnsLength).setField("field" + (columnsLength + 1));
        }
        return columns;
    }

    /**
     * 保存
     *
     * @param templateId 导入模板id
     * @param list       表单内容
     * @return true/false
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean saveData(String templateId, List<SysImportExcelTemplateDetail> list) {
        QueryWrapper<SysImportExcelTemplateDetail> deleteOld = new QueryWrapper<>();
        deleteOld.eq("template_id", templateId);
        remove(deleteOld);

        // 设置字段长度
        if(list != null && !list.isEmpty()){
            for (SysImportExcelTemplateDetail details : list) {
                details.setTemplateId(templateId);
                if(StrUtil.isNotBlank(details.getReplaceTable())){
                    details.setReplaceTable(details.getReplaceTable().toLowerCase());
                }
                String type = details.getFieldType();
                if(type.contains("(")){
                    details.setFieldType(type.substring(0, type.indexOf("(")));
                    details.setFieldLength(type.substring(type.indexOf("(") + 1, type.length() - 1));
                }
            }
        }
        return saveBatch(list);
    }

    @Override
    public void deleteByTemplateIds(String templateIds) {
        QueryWrapper<SysImportExcelTemplateDetail> delete = new QueryWrapper<>();
        List<String> idList = Arrays.asList(templateIds.split(","));
        delete.in("template_id", idList);
        remove(delete);
    }
}