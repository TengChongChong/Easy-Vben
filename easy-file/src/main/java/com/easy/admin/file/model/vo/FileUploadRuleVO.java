package com.easy.admin.file.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.easy.admin.file.model.FileUploadRule;
import lombok.Data;

import java.util.List;

/**
 * 文件上传规则
 *
 * @author TengChongChong
 * @date 2024-10-31
 **/
@Data
public class FileUploadRuleVO extends FileUploadRule {
    
    /**
     * 文件后缀
     */
    @TableField(exist = false)
    private List<String> suffixArray;
}
