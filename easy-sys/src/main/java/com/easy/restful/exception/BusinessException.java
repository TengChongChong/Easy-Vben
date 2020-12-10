package com.easy.restful.exception;

import com.easy.restful.common.core.exception.EasyServiceException;

/**
 * 自定义业务异常
 *
 * @author tengchong
 * @date 2019-01-20
 */
public enum BusinessException implements EasyServiceException {
    /**
     * 部门
     */
    // 部门部门编码不能重复
    DEPT_CODE_REGISTERED("201001", "部门部门编码不能重复"),
    // 部门下存在账户，无法删除
    DEPT_HAS_USER("201002", "部门下存在账户，无法删除"),
    // 部门不存在
    DEPT_NON_EXISTENT("201003", "部门被删除或禁用"),
    // 部门被禁用
    DEPT_DISABLED("201005", "部门被删除或禁用"),

    /**
     * 用户
     */
    // 用户名已注册
    USER_REGISTERED("203001", "用户名已注册"),
    // 手机号已注册
    MOBILE_PHONE_REGISTERED("203002", "手机号已注册"),
    // 用户禁用
    USER_DISABLED("203003", "用户已被禁用"),
    // 密码强度低
    LOW_PASSWORD_STRENGTH("203004", "密码强度过低"),
    // 用户不存在
    USER_NON_EXISTENT("203005", "用户名或密码错误"),
    // 无效的用户名或密码
    INVALID_USERNAME_OR_PASSWORD("203006", "用户名或密码错误"),

    // 不能删除超级管理员
    CANNOT_DELETE_SUPER_ADMIN("203009", "不能删除超级管理员"),
    // 不能禁用超级管理员
    CANNOT_DISABLED_SUPER_ADMIN("203010", "不能禁用超级管理员"),
    // 不能更改超级管理员角色
    CANNOT_CHANGE_SUPER_ADMIN("203011", "不能更改超级管理员角色"),

    /**
     * 导入
     */
    // 获取模板信息失败
    IMPORT_GET_TEMPLATE_FAIL("204001", "获取模板信息失败"),
    // 模板不匹配
    IMPORT_TEMPLATE_MISMATCH("204002", "模板不匹配，请重新下载模板"),
    // excel中无数据
    IMPORT_TEMPLATE_NO_DATA("204003", "请至少录入一条数据后导入"),
    // 导入失败
    IMPORT_INSERT_FAIL("204004", "导入失败，请稍后重试"),
    // 文件类型错误
    IMPORT_FILE_TYPE_ERROR("204005", "请上传excel文件"),
    // 文件不存在
    IMPORT_FILE_NOT_FIND("204006", "读取文件失败[文件不存在]"),
    // 转换失败
    IMPORT_REPLACE_FAIL("204007", "转换失败");

    /**
     * 错误代码
     */
    private String code;
    /**
     * 错误信息
     */
    private String message;

    BusinessException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
