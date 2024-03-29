package com.easy.admin.file.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.file.model.FileDownload;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 下载 
 *
 * @author TengChong
 * @date 2019-11-11
 */
public interface FileDownloadMapper extends BaseMapper<FileDownload> {
    /**
     * 获取列表数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return 数据列表
     */
    List<FileDownload> select(Page<FileDownload> page, @Param("ew") QueryWrapper<FileDownload> queryWrapper);
}