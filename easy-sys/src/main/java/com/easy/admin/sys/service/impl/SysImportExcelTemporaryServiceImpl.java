package com.easy.admin.sys.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.util.ToolUtil;
import com.easy.admin.sys.common.constant.ImportConst;
import com.easy.admin.sys.dao.SysImportExcelTemporaryMapper;
import com.easy.admin.sys.model.SysImportExcelTemplateDetail;
import com.easy.admin.sys.model.SysImportExcelTemporary;
import com.easy.admin.sys.model.SysImportSummary;
import com.easy.admin.sys.service.SysImportExcelTemplateDetailService;
import com.easy.admin.sys.service.SysImportExcelTemporaryService;
import com.easy.admin.config.sa.token.util.SessionUtil;
import com.easy.admin.util.office.ImportExportUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * 导入临时表
 *
 * @author TengChong
 * @date 2019-04-10
 */
@Slf4j
@Service
public class SysImportExcelTemporaryServiceImpl extends ServiceImpl<SysImportExcelTemporaryMapper, SysImportExcelTemporary> implements SysImportExcelTemporaryService {

    @Autowired
    private SysImportExcelTemplateDetailService importExcelTemplateDetailsService;

    /**
     * 列表
     *
     * @param sysImportExcelTemporary 查询条件
     * @return 数据集合
     */
    @Override
    public Page<SysImportExcelTemporary> select(SysImportExcelTemporary sysImportExcelTemporary, Page<SysImportExcelTemporary> page) {
        QueryWrapper<SysImportExcelTemporary> queryWrapper = new QueryWrapper<>();
        // 导入用户id
        queryWrapper.eq("user_id", SessionUtil.getCurrentUser().getId());
        if (sysImportExcelTemporary == null || sysImportExcelTemporary.getTemplateId() == null) {
            // 必须指定模板id
            throw new EasyException("未指定模板id");
        }
        // 查询导入规则,翻译转换后的字段(此处不翻译字典)
        List<SysImportExcelTemplateDetail> configs = importExcelTemplateDetailsService.selectDetails(sysImportExcelTemporary.getTemplateId());
        String selectFields = ImportExportUtil.getSelectFields(configs, true);
        String leftJoinTables = ImportExportUtil.getLeftJoinTables(configs, true);
        // 查询条件
        // 模板id
        if (Validator.isNotEmpty(sysImportExcelTemporary.getTemplateId())) {
            queryWrapper.eq("template_id", sysImportExcelTemporary.getTemplateId());
        }
        // filed 1
        if (Validator.isNotEmpty(sysImportExcelTemporary.getField1())) {
            queryWrapper.and(i -> i.like("field1", sysImportExcelTemporary.getField1()));
        }
        // filed 2
        if (Validator.isNotEmpty(sysImportExcelTemporary.getField2())) {
            queryWrapper.and(i -> i.like("field2", sysImportExcelTemporary.getField2()));
        }
        // filed 3
        if (Validator.isNotEmpty(sysImportExcelTemporary.getField3())) {
            queryWrapper.and(i -> i.like("field3", sysImportExcelTemporary.getField3()));
        }
        page.setDefaultAsc("verification_status");
        page.setRecords(baseMapper.select(page, selectFields, leftJoinTables, queryWrapper));
        return page;
    }

    /**
     * 详情
     *
     * @param id id
     * @return 详细信息
     */
    @Override
    public SysImportExcelTemporary get(String id) {
        QueryWrapper<SysImportExcelTemporary> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "template_id");
        queryWrapper.eq("id", id);
        queryWrapper.eq("user_id", SessionUtil.getCurrentUser().getId());
        SysImportExcelTemporary sysImportExcelTemporary = getOne(queryWrapper);
        // 查询导入规则,翻译转换后的字段(此处不翻译字典)
        List<SysImportExcelTemplateDetail> configs = importExcelTemplateDetailsService.selectDetails(sysImportExcelTemporary.getTemplateId());
        String selectFields = ImportExportUtil.getSelectFields(configs, true);
        String leftJoinTables = ImportExportUtil.getLeftJoinTables(configs, true);
        return baseMapper.getOne(selectFields, leftJoinTables, id);
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
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        return removeByIds(idList);
    }

    @Override
    public boolean checkLastData(String templateId) {
        SessionUserVO currentUser = SessionUtil.getCurrentUser();
        QueryWrapper<SysImportExcelTemporary> selectLastData = new QueryWrapper<>();
        selectLastData.eq("user_id", currentUser.getId());
        selectLastData.eq("template_id", templateId);
        return count(selectLastData) > 0;
    }

    @Override
    public boolean cleanMyImport(String templateId) {
        SessionUserVO currentUser = SessionUtil.getCurrentUser();
        QueryWrapper<SysImportExcelTemporary> clean = new QueryWrapper<>();
        clean.eq("user_id", currentUser.getId());
        clean.eq("template_id", templateId);
        return remove(clean);
    }

    @Override
    public boolean cleanSuccessData(String templateId) {
        SessionUserVO currentUser = SessionUtil.getCurrentUser();
        // 删除已导入成功的数据
        QueryWrapper<SysImportExcelTemporary> deleteSuccess = new QueryWrapper<>();
        deleteSuccess.eq("verification_status", ImportConst.VERIFICATION_STATUS_SUCCESS);
        deleteSuccess.eq("user_id", currentUser.getId());
        deleteSuccess.eq("template_id", templateId);
        return remove(deleteSuccess);
    }

    @Override
    public void deleteByTemplateIds(String templateIds) {
        QueryWrapper<SysImportExcelTemporary> clean = new QueryWrapper<>();
        List<String> idList = Arrays.asList(templateIds.split(","));
        clean.in("template_id", idList);
        remove(clean);
    }

    @Override
    public SysImportSummary selectImportSummary(String templateId) {
        SessionUserVO currentUser = SessionUtil.getCurrentUser();
        List<SysImportExcelTemporary> temporaries = baseMapper.selectImportSummary(templateId, currentUser.getId());
        SysImportSummary summary = new SysImportSummary();
        if (temporaries != null && !temporaries.isEmpty()) {
            for (SysImportExcelTemporary temporary : temporaries) {
                int count = Integer.parseInt(temporary.getField1());
                if (ImportConst.VERIFICATION_STATUS_SUCCESS.equals(temporary.getVerificationStatus())) {
                    summary.setSuccess(count);
                }
                if (ImportConst.VERIFICATION_STATUS_FAIL.equals(temporary.getVerificationStatus())) {
                    summary.setFail(count);
                }
            }
            summary.setTotal(summary.getSuccess() + summary.getFail());
        }
        return summary;
    }

    @Override
    public SysImportExcelTemporary saveData(SysImportExcelTemporary sysImportExcelTemporary) {
        // 保存之前检查数据状态
        List<SysImportExcelTemplateDetail> configs = importExcelTemplateDetailsService.selectDetails(sysImportExcelTemporary.getTemplateId());
        if (configs != null && !configs.isEmpty()) {
            Class temporaryClass = ImportExportUtil.getTemporaryClass();
            for (int i = 0; i < configs.size(); i++) {
                String value;
                // 获取当前校验值
                try {
                    Method method = temporaryClass.getMethod("getField" + (i + 1));
                    value = (String) method.invoke(sysImportExcelTemporary);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    log.debug("导入数据数据校验失败", e);
                    throw new EasyException("数据数据校验失败" + e.getMessage());
                }
                // 校验数据, 如失败直接抛异常到前端
                // 基本校验
                baseVerificationData(value, configs.get(i));
                // 替换校验
                String replaceValue = getReplaceTableFieldValue(value, configs.get(i));
                try {
                    Method method = temporaryClass.getMethod("setField" + (i + 1), String.class);
                    method.invoke(sysImportExcelTemporary, replaceValue);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    log.debug("设置替换值失败", e);
                    throw new EasyException("设置替换值失败" + e.getMessage());
                }
                boolean only = configs.get(i).getDataOnly();
                if (only) {
                    // 唯一校验, 这里只检查临时表中是否唯一,在正式表中是否唯一请在导入前回调中检查
                    // 因为此处校验无意义,正式表中数据可能会发生变动导致校验过时
                    int count = baseMapper.count("field" + (i + 1), replaceValue, sysImportExcelTemporary.getId());
                    if (count > 0) {
                        throw new EasyException("数据中已存在[" + configs.get(i).getTitle() + "=" + value + "]的数据，请勿重复导入");
                    }
                }
            }
        }
        sysImportExcelTemporary.setVerificationResults("");
        sysImportExcelTemporary.setVerificationStatus(ImportConst.VERIFICATION_STATUS_SUCCESS);
        return (SysImportExcelTemporary) ToolUtil.checkResult(updateById(sysImportExcelTemporary), sysImportExcelTemporary);
    }

    /**
     * 根据规则校验值是否正确
     *
     * @param value  值
     * @param config 规则
     */
    private void baseVerificationData(String value, SysImportExcelTemplateDetail config) {
        StringBuilder verificationResults = new StringBuilder();
        // 非空
        if (Validator.isEmpty(value) && config.getDataRequired()) {
            verificationResults.append(config.getTitle()).append("不能为空;");
        }
        // 数据类型以及长度
        try {
            ImportExportUtil.verificationData(value, config);
        } catch (EasyException e) {
            verificationResults.append(e.getMessage());
        }
        if (StrUtil.isNotBlank(verificationResults.toString())) {
            throw new EasyException(verificationResults.toString());
        }
    }

    /**
     * 获取替换值
     *
     * @param value  值
     * @param config 规则
     * @return 替换值
     */
    private String getReplaceTableFieldValue(String value, SysImportExcelTemplateDetail config) {
        String replaceValue;
        if (StrUtil.isNotBlank(value) &&
                StrUtil.isNotBlank(config.getReplaceTable()) &&
                StrUtil.isNotBlank(config.getReplaceTableFieldValue()) &&
                StrUtil.isNotBlank(config.getReplaceTableFieldName())) {
            // 如果设置了替换信息, 先判断value是否已经是替换后的值,如果不是在替换
            if (ImportConst.SYS_DICT.equals(config.getReplaceTable())) {
                // 字典表中有字典类型 单独处理
                replaceValue = baseMapper.getDictReplaceTableFieldValue(
                        config.getReplaceTable(),
                        config.getReplaceTableFieldValue(),
                        config.getReplaceTableFieldValue(),
                        value, config.getReplaceTableDictType());
                if (StrUtil.isBlank(replaceValue)) {
                    // 字典表中有字典类型 单独处理
                    replaceValue = baseMapper.getDictReplaceTableFieldValue(
                            config.getReplaceTable(),
                            config.getReplaceTableFieldName(),
                            config.getReplaceTableFieldValue(),
                            value, config.getReplaceTableDictType());
                }
            } else {
                replaceValue = baseMapper.getReplaceTableFieldValue(
                        config.getReplaceTable(),
                        config.getReplaceTableFieldValue(),
                        config.getReplaceTableFieldValue(),
                        value);
                if (StrUtil.isBlank(replaceValue)) {
                    replaceValue = baseMapper.getReplaceTableFieldValue(
                            config.getReplaceTable(),
                            config.getReplaceTableFieldName(),
                            config.getReplaceTableFieldValue(),
                            value);
                }
            }
            if (StrUtil.isBlank(replaceValue)) {
                throw new EasyException(config.getTitle() + "转换失败;");
            }
            return replaceValue;
        }
        return value;
    }

    @Override
    public boolean saveBatch(List<SysImportExcelTemporary> list) {
        return super.saveBatch(list);
    }

    @Override
    public void updateDuplicateData(String field, String templateId, String userId) {
        baseMapper.updateDuplicateData(field, templateId, userId, ImportConst.VERIFICATION_STATUS_FAIL);
    }
}