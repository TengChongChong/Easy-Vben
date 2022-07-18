package com.easy.admin.sys.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sys.model.SysImportExcelTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * 导入模板
 *
 * @author TengChong
 * @date 2019-04-10
 */
public interface SysImportExcelTemplateService {
    /**
     * 列表
     *
     * @param sysImportExcelTemplate 查询条件
     * @param page                   page
     * @return Page<SysImportExcelTemplate>
     */
    Page<SysImportExcelTemplate> select(SysImportExcelTemplate sysImportExcelTemplate, Page<SysImportExcelTemplate> page);

    /**
     * 详情
     *
     * @param id id
     * @return SysImportExcelTemplate
     */
    SysImportExcelTemplate get(String id);

    /**
     * 根据模板代码获取导入信息
     *
     * @param importCode 模板代码
     * @return SysImportExcelTemplate
     */
    SysImportExcelTemplate getByImportCode(String importCode);

    /**
     * 新增
     *
     * @return SysImportExcelTemplate
     */
    SysImportExcelTemplate add();

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 模版代码是否已存在
     *
     * @param importCode 模版代码
     * @param id         数据id
     * @return true/false
     */
    boolean checkHav(String importCode, String id);

    /**
     * 保存
     *
     * @param sysImportExcelTemplate 表单内容
     * @return SysImportExcelTemplate
     */
    SysImportExcelTemplate saveData(SysImportExcelTemplate sysImportExcelTemplate);

    /**
     * 下载导入模板
     *
     * @param importCode 模板代码
     * @param request    request
     * @return 文件下载id
     */
    String downloadTemplate(String importCode, HttpServletRequest request);
}
