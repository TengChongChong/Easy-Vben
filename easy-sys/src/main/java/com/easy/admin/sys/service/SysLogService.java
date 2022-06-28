package com.easy.admin.sys.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sys.model.SysLog;

/**
 * 日志
 *
 * @author TengChong
 * @date 2019-06-27
 */
public interface SysLogService {
    /**
     * 列表
     *
     * @param sysLog 查询条件
     * @param page   分页
     * @return Page<SysLog>
     */
    Page<SysLog> select(SysLog sysLog, Page<SysLog> page);

    /**
     * 详情
     *
     * @param id id
     * @return SysLog
     */
    SysLog get(String id);

    /**
     * 保存
     *
     * @param sysLog 表单内容
     * @return SysLog
     */
    SysLog saveData(SysLog sysLog);

    /**
     * 清理异常日志表里的数据
     *
     * @return true/false
     */
    boolean clean();
}
