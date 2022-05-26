package com.easy.admin.sys.service;

import com.easy.admin.sys.model.SysMailVerification;

/**
 * 邮箱验证
 *
 * @author TengChong
 * @date 2019-03-24
 */
public interface SysMailVerificationService {
    /**
     * 验证
     *
     * @param code 校验码
     * @return true/false
     */
    boolean verifies(String code);

    /**
     * 验证校验码与用户标识是否有效
     *
     * @param code   校验码
     * @param userId 用户标识
     * @return true/false
     */
    boolean verifiesData(String code, String userId);

    /**
     * 保存
     *
     * @param userId 用户id
     * @param email  邮箱
     * @param type   类型
     * @return 验证邮件信息
     */
    SysMailVerification saveData(String userId, String email, String type);

    /**
     * 根据用户id查询是否有待验证mail
     *
     * @param userId 用户id
     * @return 邮箱
     */
    String getMailByUserId(String userId);

    /**
     * 删除校验信息
     *
     * @param code 校验码
     * @return true/false
     */
    boolean remove(String code);
}
