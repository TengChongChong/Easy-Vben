package com.easy.admin.sys.service;

import com.easy.admin.sys.model.SysRedisVO;

import java.util.Set;

/**
 * redis 管理
 *
 * @author TengChongChong
 * @date 2019-01-25
 */
public interface SysRedisService {
    /**
     * 根据前缀查询redis列表
     *
     * @param prefix 前缀
     * @return List<String>
     */
    Set<String> selectByPrefix(String prefix);

    /**
     * 根据键获取信息
     *
     * @param key 键
     * @return SysRedis
     */
    SysRedisVO get(String key);

    /**
     * 根据键删除信息
     *
     * @param key 键
     * @return true/false
     */
    boolean remove(String key);

    /**
     * 保存
     *
     * @param sysRedis redis信息
     * @return SysRedisVO
     */
    boolean save(SysRedisVO sysRedis);

}
