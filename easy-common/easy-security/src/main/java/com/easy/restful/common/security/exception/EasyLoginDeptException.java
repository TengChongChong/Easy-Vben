package com.easy.restful.common.security.exception;

import com.easy.restful.common.security.common.response.Dept;

/**
 * 用户登录异常 - 部门
 *
 * @author tengchong
 * @date 2020/7/31
 */
public class EasyLoginDeptException extends EasyLoginException {

    public EasyLoginDeptException(Dept dept) {
        super(dept.getCode(), dept.getMessage());
    }
}
