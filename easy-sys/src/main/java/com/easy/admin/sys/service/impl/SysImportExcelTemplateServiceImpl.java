package com.easy.admin.sys.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.sys.common.constant.ImportConst;
import com.easy.admin.sys.dao.SysImportExcelTemplateMapper;
import com.easy.admin.sys.model.SysDict;
import com.easy.admin.sys.model.SysDownload;
import com.easy.admin.sys.model.SysImportExcelTemplate;
import com.easy.admin.sys.model.SysImportExcelTemplateDetail;
import com.easy.admin.sys.service.*;
import com.easy.admin.util.ToolUtil;
import com.easy.admin.util.office.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 导入模板
 *
 * @author TengChong
 * @date 2019-04-10
 */
@Service
public class SysImportExcelTemplateServiceImpl extends ServiceImpl<SysImportExcelTemplateMapper, SysImportExcelTemplate> implements SysImportExcelTemplateService {

    @Autowired
    private SysImportExcelTemplateDetailService templateDetailsService;

    @Autowired
    private SysImportExcelTemporaryService temporaryService;

    @Autowired
    private SysDownloadService sysDownloadService;

    @Autowired
    private SysDictService sysDictService;

    /**
     * 列表
     *
     * @param sysImportExcelTemplate 查询条件
     * @return 数据集合
     */
    @Override
    public Page<SysImportExcelTemplate> select(SysImportExcelTemplate sysImportExcelTemplate, Page<SysImportExcelTemplate> page) {
        QueryWrapper<SysImportExcelTemplate> queryWrapper = new QueryWrapper<>();
        if (sysImportExcelTemplate != null) {
            // 查询条件
            // 导入模板名称
            if (Validator.isNotEmpty(sysImportExcelTemplate.getName())) {
                queryWrapper.like("name", sysImportExcelTemplate.getName());
            }
            // 模板代码
            if (Validator.isNotEmpty(sysImportExcelTemplate.getImportCode())) {
                queryWrapper.like("import_code", sysImportExcelTemplate.getImportCode());
            }
            // 导入表
            if (Validator.isNotEmpty(sysImportExcelTemplate.getImportTable())) {
                queryWrapper.eq("import_table", sysImportExcelTemplate.getImportTable());
            }
        }
        return page(page, queryWrapper);
    }

    /**
     * 详情
     *
     * @param id id
     * @return 详细信息
     */
    @Override
    public SysImportExcelTemplate get(String id) {
        ToolUtil.checkParams(id);
        return getById(id);
    }

    @Override
    public SysImportExcelTemplate getByImportCode(String importCode) {
        QueryWrapper<SysImportExcelTemplate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("import_code", importCode);
        SysImportExcelTemplate sysImportExcelTemplate = getOne(queryWrapper);
        if (sysImportExcelTemplate != null) {
            sysImportExcelTemplate.setDetailList(templateDetailsService.selectDetails(sysImportExcelTemplate.getId()));
        }
        return sysImportExcelTemplate;
    }

    /**
     * 新增
     *
     * @return 默认值
     */
    @Override
    public SysImportExcelTemplate add() {
        SysImportExcelTemplate sysImportExcelTemplate = new SysImportExcelTemplate();
        sysImportExcelTemplate.setStartRow(1);
        // 设置默认值
        return sysImportExcelTemplate;
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return 是否成功
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        ToolUtil.checkParams(ids);
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        boolean isSuccess = removeByIds(idList);
        if (isSuccess) {
            // 删掉导入规则以及临时表数据
            templateDetailsService.deleteByTemplateIds(ids);
            temporaryService.deleteByTemplateIds(ids);
        }
        return isSuccess;
    }

    @Override
    public boolean checkHav(String importCode, String id) {
        // 模板代码不能重复
        QueryWrapper<SysImportExcelTemplate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("import_code", importCode);
        if (StrUtil.isNotBlank(id)) {
            queryWrapper.ne("id", id);
        }
        long count = count(queryWrapper);
        return count > 0;
    }

    /**
     * 保存
     *
     * @param sysImportExcelTemplate 表单内容
     * @return 保存后信息
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysImportExcelTemplate saveData(SysImportExcelTemplate sysImportExcelTemplate) {
        ToolUtil.checkParams(sysImportExcelTemplate);
        if (checkHav(sysImportExcelTemplate.getImportCode(), sysImportExcelTemplate.getId())) {
            throw new EasyException("模板代码 " + sysImportExcelTemplate.getImportCode() + " 中已存在，请修改后重试");
        }
        boolean isUpdate = StrUtil.isNotBlank(sysImportExcelTemplate.getId());
        boolean isSuccess = saveOrUpdate(sysImportExcelTemplate);
        if (isSuccess && isUpdate) {
            // 修改的时候清空临时表
            temporaryService.deleteByTemplateIds(String.valueOf(sysImportExcelTemplate.getId()));
        }

        return (SysImportExcelTemplate) ToolUtil.checkResult(isSuccess, sysImportExcelTemplate);
    }

    @Override
    public String downloadTemplate(String importCode, HttpServletRequest request) {
        ToolUtil.checkParams(importCode);
        QueryWrapper<SysImportExcelTemplate> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id, name");
        queryWrapper.eq("import_code", importCode);
        SysImportExcelTemplate sysImportExcelTemplate = getOne(queryWrapper);
        if (sysImportExcelTemplate == null) {
            throw new EasyException("模板信息不存在");
        }
        List<SysImportExcelTemplateDetail> details = templateDetailsService.selectDetails(sysImportExcelTemplate.getId());
        List<String> dictTypes = new ArrayList<>();
        for (SysImportExcelTemplateDetail detail : details) {
            if (ImportConst.SYS_DICT.equals(detail.getReplaceTable())) {
                // 收集所需的字典类别数据
                dictTypes.add(detail.getReplaceTableDictType());
            }
        }
        Map<String, List<SysDict>> dictionaries = null;
        if (!dictTypes.isEmpty()) {
            // 如果模板中包含字典，则设置select
            dictionaries = sysDictService.selectDictionaries(ArrayUtil.toArray(dictTypes, String.class));
        }
        String path = ExcelUtil.writFile(sysImportExcelTemplate.getName(), details, dictionaries);

        return sysDownloadService.saveData(new SysDownload(
                sysImportExcelTemplate.getName() + ExcelUtil.EXCEL_SUFFIX_XLSX,
                path
        )).getId();
    }

}