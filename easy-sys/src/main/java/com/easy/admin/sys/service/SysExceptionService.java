package com.easy.admin.sys.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sys.model.SysException;

/**
 * 异常日志
 *
 * @author TengChong
 * @date 2019-04-08
 */
public interface SysExceptionService {
    /**
     * 列表
     *
     * @param sysException 查询条件
     * @param page         分页
     * @return Page<SysException>
     */
    Page<SysException> select(SysException sysException, Page<SysException> page);

    /**
     * 详情
     *
     * @param id id
     * @return 详细信息
     */
    SysException get(String id);

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 保存
     *
     * @param sysException 表单内容
     * @return 保存后信息
     */
    SysException saveData(SysException sysException);

    /**
     * 清理异常日志表里的数据
     *
     * @return true/false
     */
    boolean clean();
}
