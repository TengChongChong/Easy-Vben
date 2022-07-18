package com.easy.admin.sys.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.util.SpringContextHolder;
import com.easy.admin.exception.BusinessException;
import com.easy.admin.sys.common.constant.ImportConst;
import com.easy.admin.sys.dao.SysImportExcelDataMapper;
import com.easy.admin.sys.model.*;
import com.easy.admin.sys.service.*;
import com.easy.admin.util.ShiroUtil;
import com.easy.admin.util.ToolUtil;
import com.easy.admin.util.office.ExcelUtil;
import com.easy.admin.util.office.ImportExportUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 数据导入
 *
 * @author TengChongChong
 * @date 2019-04-17
 */
@Service
public class SysImportExcelDataServiceImpl implements SysImportExcelDataService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysDownloadService sysDownloadService;

    /**
     * 导入模板
     */
    @Autowired
    private SysImportExcelTemplateService importExcelTemplateService;
    /**
     * 导入规则
     */
    @Autowired
    private SysImportExcelTemplateDetailService importExcelTemplateDetailsService;

    /**
     * 临时表
     */
    @Autowired
    private SysImportExcelTemporaryService importExcelTemporaryService;

    /**
     * 字典
     */
    @Autowired
    private SysDictService sysDictService;
    /**
     * 导入数据mapper
     */
    @Autowired
    private SysImportExcelDataMapper mapper;

    @Override
    public boolean checkLastData(String templateId) {
        return importExcelTemporaryService.checkLastData(templateId);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean analysis(String templateId, String path) {
        logger.debug("解析文件:{}", path);
        ToolUtil.checkParams(templateId);
        ToolUtil.checkParams(path);
        // 检查模板信息
        SysImportExcelTemplate importExcelTemplate = importExcelTemplateService.get(templateId);
        if (importExcelTemplate == null) {
            // 获取模板信息失败
            throw new EasyException(BusinessException.IMPORT_GET_TEMPLATE_FAIL);
        }
        // 检查是否有权限访问
        if (StrUtil.isNotBlank(importExcelTemplate.getPermissionCode()) && !hasPermission(importExcelTemplate.getPermissionCode())) {
            // 无权导入
            logger.debug("无权访问导入[{}]{}", importExcelTemplate.getPermissionCode(), importExcelTemplate.getName());
            throw new EasyException("无权访问导入" + importExcelTemplate.getName());
        }
        // 检查导入规则
        List<SysImportExcelTemplateDetail> configs = importExcelTemplateDetailsService.selectDetails(importExcelTemplate.getId());
        if (configs == null || configs.isEmpty()) {
            // 无导入规则
            logger.debug("模板[{}]未配置导入规则", importExcelTemplate.getImportCode());
            throw new EasyException("模板[" + importExcelTemplate.getImportCode() + "]未配置导入规则");
        }
        File file = new File(path);
        checkFile(file);
        // 读取Excel
        ExcelReader reader = cn.hutool.poi.excel.ExcelUtil.getReader(path);
        List<List<Object>> data = reader.read();
        // 最小行
        int minDataRow = 3;
        if (data.size() < minDataRow) {
            // 请至少录入一条数据后导入
            throw new EasyException(BusinessException.IMPORT_TEMPLATE_NO_DATA);
        }
        data.remove(0);
        // 比对模板信息是否与导入规则匹配
        checkTemplate(data.get(0), configs);
        // 模板验证通过,将数据插入到临时表
        data.remove(0);
        SysUser sysUser = ShiroUtil.getCurrentUser();
        // 清空上次导入的信息
        cleanLastImport(importExcelTemplate);
        // 插入数据到临时表
        if (!insertData(sysUser, importExcelTemplate, configs, data)) {
            throw new EasyException(BusinessException.IMPORT_INSERT_FAIL);
        }
        // 唯一约束检查
        checkOnly(configs, templateId, sysUser.getId());
        if (StrUtil.isNotBlank(importExcelTemplate.getCallback())) {
            ImportService importService = SpringContextHolder.getBean(importExcelTemplate.getCallback());
            boolean isSuccess = importService.verificationData(templateId, sysUser.getId());
            if (!isSuccess) {
                throw new EasyException("执行验证数据回调失败");
            }
        }
        return true;
    }

    /**
     * 唯一约束检查
     *
     * @param configs    规则
     * @param templateId 模板id
     * @param userId     用户id
     */
    private void checkOnly(List<SysImportExcelTemplateDetail> configs, String templateId, String userId) {
        for (SysImportExcelTemplateDetail config : configs) {
            if (config.getOnly() != null && config.getOnly()) {
                importExcelTemporaryService.updateDuplicateData("field" + config.getOrderNo(), templateId, userId);
            }
        }
    }

    @Override
    public SysImportSummary selectSummary(String templateId) {
        ToolUtil.checkParams(templateId);
        return importExcelTemporaryService.selectImportSummary(templateId);
    }

    /**
     * 清除上次导入的信息
     *
     * @param importExcelTemplate 导入模板信息
     */
    private void cleanLastImport(SysImportExcelTemplate importExcelTemplate) {
        importExcelTemporaryService.cleanMyImport(importExcelTemplate.getId());
    }

    /**
     * 用户是否拥有指定权限标识
     *
     * @param code 权限标识
     * @return true/false
     */
    private boolean hasPermission(String code) {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null && StrUtil.isNotBlank(code)) {
            return subject.isPermitted(code);
        }
        return false;
    }

    /**
     * 检查excel文件
     *
     * @param file 文件
     */
    private void checkFile(File file) {
        if (!file.exists()) {
            // 文件不存在
            throw new EasyException(BusinessException.IMPORT_FILE_NOT_FIND);
        }
        String suffix = file.getName().substring(file.getName().indexOf("."));
        if (!ExcelUtil.EXCEL_SUFFIX_XLSX.equals(suffix) && !ExcelUtil.EXCEL_SUFFIX_XLS.equals(suffix)) {
            // 文件类型错误
            throw new EasyException(BusinessException.IMPORT_FILE_TYPE_ERROR);
        }
    }

    /**
     * 比对模板信息是否与导入规则匹配
     *
     * @param heads   标题
     * @param configs 导入规则
     * @return true/false
     */
    private boolean checkTemplate(List<Object> heads, List<SysImportExcelTemplateDetail> configs) {
        if (heads != null && heads.size() == configs.size()) {
            int length = heads.size();
            for (int i = 0; i < length; i++) {
                if (!heads.get(i).equals(configs.get(i).getTitle())) {
                    // 模板不匹配，请重新下载模板
                    throw new EasyException("模板不匹配，\"" + heads.get(i) + "\"应为\"" + configs.get(i).getTitle() + "\"");
                }
            }
            return true;
        }
        // 模板不匹配，请重新下载模板
        throw new EasyException(BusinessException.IMPORT_TEMPLATE_MISMATCH);
    }

    /**
     * 将数据导入临时表
     *
     * @param sysUser             当前登录用户
     * @param importExcelTemplate 模板信息
     * @param configs             导入规则
     * @param rows                excel中数据
     * @return true/false
     */
    private boolean insertData(SysUser sysUser,
                               SysImportExcelTemplate importExcelTemplate,
                               List<SysImportExcelTemplateDetail> configs,
                               List<List<Object>> rows) {
        List<SysImportExcelTemporary> temporaries = new ArrayList<>();
        // 查询所有本次导入所需的字典
        List<String> dictTypes = getDictType(configs);
        Map<String, String> cacheMap = new HashMap<>();
        if (!dictTypes.isEmpty()) {
            List<SysDict> dicts = sysDictService.selectDictType(dictTypes);
            setDictMap(cacheMap, dicts);
        }
        for (List<Object> row : rows) {
            temporaries.add(getTemporaryInfo(sysUser, importExcelTemplate, configs, row, cacheMap));
        }
        return importExcelTemporaryService.saveBatch(temporaries);
    }

    /**
     * 向缓存中添加字典
     *
     * @param cacheMap     缓存map
     * @param dictionaries 本次导入所需的字典
     */
    private void setDictMap(Map<String, String> cacheMap, List<SysDict> dictionaries) {
        if (dictionaries != null) {
            for (SysDict dict : dictionaries) {
                cacheMap.put(dict.getDictType() + dict.getName(), dict.getCode());
            }
        }
    }

    /**
     * 获取本次导入所需的全部字典类型
     *
     * @param configs 导入规则
     * @return list
     */
    private List<String> getDictType(List<SysImportExcelTemplateDetail> configs) {
        List<String> dictTypes = new ArrayList<>();
        for (SysImportExcelTemplateDetail detail : configs) {
            if ("sys_dict".equals(detail.getReplaceTable())) {
                dictTypes.add(detail.getReplaceTableDictType());
            }
        }
        return dictTypes;
    }

    /**
     * 将excel单行转为SysImportExcelTemporary对象
     *
     * @param sysUser             操作用户
     * @param importExcelTemplate 模板信息
     * @param configs             导入规则
     * @param data                行
     * @param cacheMap            缓存
     * @return SysImportExcelTemporary
     */
    private SysImportExcelTemporary getTemporaryInfo(SysUser sysUser,
                                                     SysImportExcelTemplate importExcelTemplate,
                                                     List<SysImportExcelTemplateDetail> configs,
                                                     List<Object> data,
                                                     Map<String, String> cacheMap) {
        try {
            Class temporaryClass = ImportExportUtil.getTemporaryClass();
            Object object = temporaryClass.newInstance();
            StringBuilder verificationResults = new StringBuilder();
            int configLength = configs.size();
            while (configLength-- > 0) {
                Method method = temporaryClass.getMethod("setField" + (configLength + 1), String.class);
                // 简单验证,此处只做非空检查
                boolean addVerificationResults = (data.size() <= configLength || Validator.isEmpty(data.get(configLength)))
                        && configs.get(configLength).getRequired() != null && configs.get(configLength).getRequired();
                if (addVerificationResults) {
                    verificationResults.append(configs.get(configLength).getTitle()).append("不能为空;");
                } else {
                    // 将单元格数据转为string
                    String cell = data.size() > configLength ? objectToString(data.get(configLength)) : "";
                    if (StrUtil.isNotBlank(cell)) {
                        // 转换数据 name to code/id
                        try {
                            cell = replaceData(cell, configs.get(configLength), cacheMap);
                        } catch (EasyException e) {
                            verificationResults.append(configs.get(configLength).getTitle()).append("转换失败;");
                        }

                        // 验证数据格式以及长度
                        try {
                            ImportExportUtil.verificationData(cell, configs.get(configLength));
                        } catch (EasyException e) {
                            verificationResults.append(e.getMessage());
                        }
                        method.invoke(object, cell);
                    }
                }
            }
            SysImportExcelTemporary temporary = (SysImportExcelTemporary) object;
            // 设置模板信息
            temporary.setTemplateId(importExcelTemplate.getId());
            temporary.setUserId(sysUser.getId());
            // 设置验证结果
            if (StrUtil.isNotBlank(verificationResults)) {
                temporary.setVerificationResults(verificationResults.toString());
                temporary.setVerificationStatus(ImportConst.VERIFICATION_STATUS_FAIL);
            } else {
                // 成功
                temporary.setVerificationStatus(ImportConst.VERIFICATION_STATUS_SUCCESS);
            }
            return temporary;
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException |
                 NoSuchMethodException e) {
            e.printStackTrace();
            throw new EasyException(e.getMessage());
        }
    }

    /**
     * 替换数据
     *
     * @param data     原数据
     * @param config   规则
     * @param cacheMap 缓存
     * @return 转换后数据
     */
    private String replaceData(String data, SysImportExcelTemplateDetail config, Map<String, String> cacheMap) {
        // 转换后的值
        String value;
        if (StrUtil.isNotBlank(config.getReplaceTable())) {
            // 字典表
            if (ImportConst.SYS_DICT.equals(config.getReplaceTable())) {
                value = cacheMap.get(config.getReplaceTableDictType() + data);
            } else {
                // 其他表
                value = mapper.queryString(config.getReplaceTable(), config.getReplaceTableFieldName(),
                        config.getReplaceTableFieldValue(), data);
                // 能不能查到都放缓存里,防止重复从数据库查询
                cacheMap.put(config.getReplaceTable() + data, value);
            }
            if (StrUtil.isBlank(value)) {
                // 抛出转换失败异常
                throw new EasyException(BusinessException.IMPORT_REPLACE_FAIL);
            }
        } else {
            // 转换失败了直接用导入值
            value = data;
        }
        return value;
    }


    /**
     * 将object类型转为string
     *
     * @param object object
     * @return string
     */
    private String objectToString(Object object) {
        if (object == null) {
            return "";
        }
        if (object instanceof Date) {
            return DateUtil.format((Date) object, DatePattern.NORM_DATETIME_PATTERN);
        } else {
            return String.valueOf(object);
        }
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int insertData(String templateId) {
        ToolUtil.checkParams(templateId);
        SysUser sysUser = ShiroUtil.getCurrentUser();
        SysImportExcelTemplate importExcelTemplate = importExcelTemplateService.get(templateId);
        // 检查是否有权限访问
        if (StrUtil.isNotBlank(importExcelTemplate.getPermissionCode()) && !hasPermission(importExcelTemplate.getPermissionCode())) {
            // 无权导入
            throw new EasyException("无权访问导入" + importExcelTemplate.getName());
        }
        // 回调Bean
        ImportService importService = null;
        if (StrUtil.isNotBlank(importExcelTemplate.getCallback())) {
            importService = SpringContextHolder.getBean(importExcelTemplate.getCallback());
            boolean isSuccess = importService.beforeImport(templateId, sysUser.getId());
            if (!isSuccess) {
                throw new EasyException("执行导入前回调失败");
            }
        }
        // 插入的字段
        List<String> insertFields = new ArrayList<>();
        // 查询字段
        List<String> selectFields = new ArrayList<>();
        // 导入规则
        List<SysImportExcelTemplateDetail> configs = importExcelTemplateDetailsService.selectDetails(importExcelTemplate.getId());
        if (configs != null && !configs.isEmpty()) {
            for (int i = 0; i < configs.size(); i++) {
                insertFields.add(configs.get(i).getFieldName());
                selectFields.add("field" + (i + 1));
            }
            int count = mapper.insert(importExcelTemplate.getImportTable(),
                    StrUtil.join(",", insertFields),
                    StrUtil.join(",", selectFields),
                    importExcelTemplate.getId(),
                    sysUser.getId(),
                    ImportConst.VERIFICATION_STATUS_SUCCESS);
            // 调用导入后回调
            if (importService != null) {
                boolean isSuccess = importService.afterImport();
                if (!isSuccess) {
                    throw new EasyException("执行导入后回调失败");
                }
                // 删除导入成功的数据
                isSuccess = importExcelTemporaryService.cleanSuccessData(templateId);
                if (!isSuccess) {
                    throw new EasyException("删除验证成功数据失败");
                }
            }
            return count;
        } else {
            throw new EasyException("模板[" + importExcelTemplate.getImportCode() + "]未配置导入规则");
        }
    }

    @Override
    public String exportVerificationFailData(String templateId, HttpServletRequest request) {
        ToolUtil.checkParams(templateId);
        SysImportExcelTemplate importExcelTemplate = importExcelTemplateService.get(templateId);
        // 导入规则
        List<SysImportExcelTemplateDetail> configs = importExcelTemplateDetailsService.selectDetails(importExcelTemplate.getId());
        if (configs == null || configs.isEmpty()) {
            throw new EasyException("模板[" + importExcelTemplate.getImportCode() + "]未配置导入规则");
        }
        String selectFields = ImportExportUtil.getSelectFields(configs, false);
        String leftJoinTables = ImportExportUtil.getLeftJoinTables(configs, false);
        QueryWrapper<SysImportExcelTemporary> queryWrapper = new QueryWrapper<>();
        // 导入用户id
        queryWrapper.eq("user_id", ShiroUtil.getCurrentUser().getId());
        queryWrapper.eq("template_id", importExcelTemplate.getId());
        queryWrapper.eq("verification_status", ImportConst.VERIFICATION_STATUS_FAIL);
        // 查询验证失败数据
        List<SysImportExcelTemporary> temporaryList = mapper.selectVerificationFailData(selectFields,
                leftJoinTables,
                queryWrapper);
        // 数据
        List<List<Object>> rows = ImportExportUtil.toExportData(temporaryList, configs, true);

        List<String> dictTypes = new ArrayList<>();
        for (SysImportExcelTemplateDetail detail : configs) {
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

        SysImportExcelTemplateDetail detail = new SysImportExcelTemplateDetail();
        detail.setTitle("验证结果");
        detail.setFieldLength(128);
        configs.add(detail);
        String path = ExcelUtil.writFile(importExcelTemplate.getName() + "验证失败数据", configs, dictionaries, rows);
        return sysDownloadService.saveData(new SysDownload(
                importExcelTemplate.getName() + "验证失败数据" + DateUtil.today() + ExcelUtil.EXCEL_SUFFIX_XLSX,
                path
        )).getId();

    }
}