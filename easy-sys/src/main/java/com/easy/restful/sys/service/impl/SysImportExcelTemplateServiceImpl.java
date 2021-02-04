package com.easy.restful.sys.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.sys.dao.SysImportExcelTemplateMapper;
import com.easy.restful.sys.model.SysDownload;
import com.easy.restful.sys.model.SysImportExcelTemplate;
import com.easy.restful.sys.model.SysImportExcelTemplateDetails;
import com.easy.restful.sys.service.SysDownloadService;
import com.easy.restful.sys.service.SysImportExcelTemplateDetailsService;
import com.easy.restful.sys.service.SysImportExcelTemplateService;
import com.easy.restful.sys.service.SysImportExcelTemporaryService;
import com.easy.restful.util.ToolUtil;
import com.easy.restful.util.office.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 导入模板
 *
 * @author TengChong
 * @date 2019-04-10
 */
@Service
public class SysImportExcelTemplateServiceImpl extends ServiceImpl<SysImportExcelTemplateMapper, SysImportExcelTemplate> implements SysImportExcelTemplateService {

    @Autowired
    private SysImportExcelTemplateDetailsService templateDetailsService;
    @Autowired
    private SysImportExcelTemporaryService temporaryService;
    @Autowired
    private SysDownloadService sysDownloadService;
    /**
     * 列表
     *
     * @param object 查询条件
     * @return 数据集合
     */
    @Override
    public Page<SysImportExcelTemplate> select(SysImportExcelTemplate object, Page<SysImportExcelTemplate> page) {
        QueryWrapper<SysImportExcelTemplate> queryWrapper = new QueryWrapper<>();
        if (object != null) {
            // 查询条件
            // 导入模板名称
            if (Validator.isNotEmpty(object.getName())) {
                queryWrapper.like("name", object.getName());
            }
            // 模板代码
            if (Validator.isNotEmpty(object.getImportCode())) {
                queryWrapper.like("import_code", object.getImportCode());
            }
            // 导入表
            if (Validator.isNotEmpty(object.getImportTable())) {
                queryWrapper.eq("import_table", object.getImportTable());
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
        return getOne(queryWrapper);
    }

    /**
     * 新增
     *
     * @return 默认值
     */
    @Override
    public SysImportExcelTemplate add() {
        SysImportExcelTemplate object = new SysImportExcelTemplate();
        object.setStartRow(1);
        // 设置默认值
        return object;
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
        List<String> idList = Arrays.asList(ids.split(","));
        boolean isSuccess = removeByIds(idList);
        if (isSuccess) {
            // 删掉导入规则以及临时表数据
            templateDetailsService.deleteByTemplateIds(ids);
            temporaryService.deleteByTemplateIds(ids);
        }
        return isSuccess;
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return 保存后信息
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysImportExcelTemplate saveData(SysImportExcelTemplate object) {
        ToolUtil.checkParams(object);
        boolean isUpdate = false;
        // 模板代码不能重复
        QueryWrapper<SysImportExcelTemplate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("import_code", object.getImportCode());
        if (object.getId() != null) {
            queryWrapper.ne("id", object.getId());
            isUpdate = true;
        }
        object.setStartRow(1);
        int count = count(queryWrapper);
        if (count > 0) {
            throw new EasyException("模板代码 " + object.getImportCode() + " 中已存在，请修改后重试");
        }
        boolean isSuccess = saveOrUpdate(object);
        if (isSuccess && isUpdate) {
            // 修改的时候清空临时表
            temporaryService.deleteByTemplateIds(String.valueOf(object.getId()));
        }
        return (SysImportExcelTemplate) ToolUtil.checkResult(isSuccess, object);
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
        List<SysImportExcelTemplateDetails> details = templateDetailsService.selectDetails(sysImportExcelTemplate.getId());
        List<String> title = new ArrayList<>();
        for (SysImportExcelTemplateDetails detail : details) {
            title.add(detail.getTitle());
        }
        String path = ExcelUtil.writFile(null, title.toArray(new String[details.size()]), sysImportExcelTemplate.getName(), sysImportExcelTemplate.getName(), null);

        return sysDownloadService.saveData(new SysDownload(
                sysImportExcelTemplate.getName() + ExcelUtil.EXCEL_SUFFIX_XLSX,
                path
        )).getId();
    }

}