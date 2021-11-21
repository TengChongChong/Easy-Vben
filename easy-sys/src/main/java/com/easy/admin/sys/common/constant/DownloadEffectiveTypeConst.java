package com.easy.admin.sys.common.constant;

/**
 * 文件有效期类型
 *
 * @author TengChongChong
 * @date 2019/11/11
 */
public class DownloadEffectiveTypeConst {

    private DownloadEffectiveTypeConst() {}

    /**
     * 常规 - 经过一段时间会失效 （有效期为系统参数：downloadEffectiveExpire）
     */
    public static final String GENERAL = "general";

    /**
     * 永久
     */
    public static final String FOREVER = "forever";

}
