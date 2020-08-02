package com.easy.restful.common.security.exception;

import com.easy.restful.common.core.exception.EasyException;

/**
 * 用户登录异常
 *
 * @author tengchong
 * @date 2020/7/31
 */
public class EasyLoginException extends EasyException {

    public EasyLoginException(String code, String message) {
        super(code, "登录失败，" + message);
    }
}
