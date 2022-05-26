package com.easy.admin.sys.dao;

import com.easy.admin.sys.model.SysMailVerification;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 邮箱验证
 *
 * @author TengChong
 * @date 2019-03-24
 */
public interface SysMailVerificationMapper extends BaseMapper<SysMailVerification> {
    /**
     * 根据用户id获取待验证邮箱地址
     *
     * @param userId 用户id
     * @param type 类型
     * @return
     */
    String getMailByUserId(@Param("userId") String userId, @Param("type") String type);
}