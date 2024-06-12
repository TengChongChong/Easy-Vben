package com.easy.admin.sys.model.vo;

import com.easy.admin.file.model.BaseFileInfo;

import java.util.List;

/**
 * 导入数据
 *
 * @author TengChongChong
 * @date 2024-05-14
 **/
public class SysImportExcelDataVO {

    /**
     * 起始行
     */
    private Integer startRow;

    /**
     * 上传的Excel
     */
    private BaseFileInfo baseFileInfo;

    /**
     * 配置的导入规则
     */
    private List<SysImportExcelTemplateDetailVO> templateDetailList;

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public BaseFileInfo getBaseFileInfo() {
        return baseFileInfo;
    }

    public void setBaseFileInfo(BaseFileInfo baseFileInfo) {
        this.baseFileInfo = baseFileInfo;
    }

    public List<SysImportExcelTemplateDetailVO> getTemplateDetailList() {
        return templateDetailList;
    }

    public void setTemplateDetailList(List<SysImportExcelTemplateDetailVO> templateDetailList) {
        this.templateDetailList = templateDetailList;
    }


}
