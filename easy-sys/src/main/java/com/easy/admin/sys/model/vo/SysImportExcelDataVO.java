package com.easy.admin.sys.model.vo;

import lombok.Data;
import org.dromara.x.file.storage.core.FileInfo;

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
    private FileInfo fileInfo;

    /**
     * 配置的导入规则
     */
    private List<SysImportExcelTemplateDetailVO> templateDetailList;


}
