package com.easy.admin.common.core.exception;

/**
 * 封装异常接口
 *
 * @author TengChongChong
 * @date 2019-01-20
 */
public interface EasyServiceException {
    /**
     * 响应码
     *
     * @return 响应码
     */
    String getCode();

    /**
     * 错误提示
     *
     * @return 错误提示
     */
    String getMessage();
}
