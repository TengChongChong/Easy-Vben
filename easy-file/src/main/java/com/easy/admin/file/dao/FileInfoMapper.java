package com.easy.admin.file.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.file.model.FileInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件 
 *
 * @author TengChongChong
 * @date 2021-02-21
 */
public interface FileInfoMapper extends BaseMapper<FileInfo> {
    /**
     * 获取列表数据
     *
     * @param queryWrapper 查询条件
     * @return List<FileInfo>
     */
    List<FileInfo> select(@Param("ew") QueryWrapper<FileInfo> queryWrapper);
}