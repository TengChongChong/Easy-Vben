package com.easy.admin.sys.model.vo;

import com.easy.admin.file.model.BaseFileInfo;
import lombok.Data;

import java.util.List;

/**
 * 导入数据
 *
 * @author TengChongChong
 * @date 2024-05-14
 **/
@Data
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


}
