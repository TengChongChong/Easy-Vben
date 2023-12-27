package com.easy.admin.file.storage.util;

/**
 * 处理预签名参数
 *
 * @author TengChongChong
 * @date 2023-10-25
 **/
public class PreSignatureParamUtil {

    /**
     * 对象存储默认允许上传最大文件长度 1gb
     */
    private static final long OSS_UPPER_LIMIT = 1024 * 1024 * 1024L;

    /**
     * 获取文件最小长度，单位 b
     *
     * @param lowerLimit 文件最小长度
     * @return 文件最小长度
     */
    public static Long getLowerLimit(Long lowerLimit) {
        if(lowerLimit == null){
            return 1L;
        }
        return lowerLimit;
    }

    /**
     * 文件最大长度，单位 b
     *
     * @param upperLimit 文件最大长度
     * @return 文件最大长度
     */
    public static Long getUpperLimit(Long upperLimit) {
        if(upperLimit == null){
            // 从系统参数中获取，此参数单位为 mb
            //Long ossUpperLimit = (Long) SysConfigUtil.get("ossUpperLimit");
            Long ossUpperLimit = null;
            if(ossUpperLimit == null){
                return OSS_UPPER_LIMIT;
            }
            return ossUpperLimit * 1024 * 1024;
        }
        return upperLimit;
    }
}
