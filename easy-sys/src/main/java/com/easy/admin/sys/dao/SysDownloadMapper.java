package com.easy.admin.sys.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sys.model.SysDownload;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 下载 
 *
 * @author TengChong
 * @date 2019-11-11
 */
public interface SysDownloadMapper extends BaseMapper<SysDownload> {
    /**
     * 获取列表数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return 数据列表
     */
    List<SysDownload> select(Page<SysDownload> page, @Param("ew") QueryWrapper<SysDownload> queryWrapper);
}