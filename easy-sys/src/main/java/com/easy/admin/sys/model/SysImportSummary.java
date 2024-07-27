package com.easy.admin.sys.model;

import lombok.Data;

/**
 * 导入汇总，用于显示导入到临时表后的汇总信息
 *
 * @author TengChongChong
 * @date 2019-04-26
 */
@Data
public class SysImportSummary {
    /**
     * 总共导入
     */
    private int total = 0;
    /**
     * 验证成功
     */
    private int success = 0;
    /**
     * 验证失败
     */
    private int fail = 0;

}
