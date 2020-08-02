package com.easy.restful.common.security.exception;

import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.common.security.common.response.Token;

/**
 * Token 异常
 *
 * @author tengchong
 * @date 2020/7/31
 */
public class EasyTokenException extends EasyException {

    public EasyTokenException(Token token) {
        super(token.getCode(),token.getMessage());
    }
}
