package com.easy.admin.sys.service;

import com.easy.admin.sys.model.SysImportSummary;
import com.easy.admin.sys.model.vo.SysImportExcelDataVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 数据导入
 *
 * @author TengChongChong
 * @date 2019-04-17
 */
public interface SysImportExcelDataService {

    /**
     * 检查上次导入数据
     *
     * @param templateId 模板id
     * @return true/false
     */
    boolean checkLastData(String templateId);

    /**
     * 解析文件
     *
     * @param bucketName local - 文件夹名称 / oss - bucket名称
     * @param objectName local - 文件路径 /  oss - objectName
     * @return List<List<Object>>
     */
    List<List<Object>> analysisExcel(String bucketName, String objectName);

    /**
     * 验证并解析文件
     *
     * @param templateId 模板id
     * @param sysImportExcelData 导入文件以及规则
     * @return true/false
     */
    boolean analysis(String templateId, SysImportExcelDataVO sysImportExcelData);

    /**
     * 查询指定导入汇总信息
     *
     * @param templateId 模板id
     * @return SysImportSummary
     */
    SysImportSummary selectSummary(String templateId);

    /**
     * 插入验证成功数据
     *
     * @param templateId 模板id
     * @return int
     */
    int insertData(String templateId);

    /**
     * 导出验证失败数据
     *
     * @param templateId 模板id
     * @param request    request
     * @return 文件下载id
     */
    String exportVerificationFailData(String templateId, HttpServletRequest request);
}
