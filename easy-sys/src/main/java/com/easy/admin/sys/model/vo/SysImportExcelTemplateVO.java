package com.easy.admin.sys.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.easy.admin.sys.model.SysImportExcelTemplate;
import com.easy.admin.sys.model.SysImportExcelTemplateDetail;
import lombok.Data;

import java.util.List;

/**
 * @author TengChongChong
 * @date 2024-11-08
 **/
@Data
public class SysImportExcelTemplateVO extends SysImportExcelTemplate {
    /**
     * 导入配置
     */
    @TableField(exist = false)
    private List<SysImportExcelTemplateDetail> detailList;
}
