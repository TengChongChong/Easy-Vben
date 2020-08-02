package com.easy.restful.common.security.exception;

import com.easy.restful.common.security.common.response.Access;

/**
 * 用户登录异常 - 用户
 *
 * @author tengchong
 * @date 2020/7/31
 */
public class EasyLoginAccessException extends EasyLoginException {

    public EasyLoginAccessException(Access access) {
        super(access.getCode(), access.getMessage());
    }
}
