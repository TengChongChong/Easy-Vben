package com.easy.admin.sys.model;

/**
 * 导入汇总，用于显示导入到临时表后的汇总信息
 *
 * @author TengChongChong
 * @date 2019-04-26
 */
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getFail() {
        return fail;
    }

    public void setFail(int fail) {
        this.fail = fail;
    }
}
