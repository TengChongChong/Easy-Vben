package com.easy.admin.sys.model.vo;

import lombok.Data;

/**
 * 数据导入 - 导入规则
 *
 * @author TengChongChong
 * @date 2024-05-14
 **/
@Data
public class SysImportExcelTemplateDetailVO {
    /**
     * 数据库字段名
     */
    private String fieldName;

    /**
     * 导入时Excel 字段下标
     */
    private Integer index;

}
