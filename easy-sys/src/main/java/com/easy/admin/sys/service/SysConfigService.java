package com.easy.admin.sys.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sys.model.SysConfig;

/**
 * 系统参数
 *
 * @author TengChongChong
 * @date 2019-03-03 15:52:44
 */
public interface SysConfigService {
    /**
     * 列表
     *
     * @param object 查询条件
     * @param page   分页
     * @return Page
     */
    Page<SysConfig> select(SysConfig object, Page<SysConfig> page);

    /**
     * 获取详情
     *
     * @param id id
     * @return SysConfig
     */
    SysConfig get(String id);

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return 是否成功
     */
    boolean remove(String ids);

    /**
     * 保存
     *
     * @param object 表单内容
     * @return 保存后信息
     */
    SysConfig saveData(SysConfig object);

    /**
     * 根据key获取系统参数value
     * 如果key存在会同时更新缓存中内容
     *
     * @param key key
     * @return config
     */
    SysConfig getByKey(String key);

    /**
     * 刷新缓存中的系统参数
     *
     * @return true/false
     */
    boolean refreshCache();
}
