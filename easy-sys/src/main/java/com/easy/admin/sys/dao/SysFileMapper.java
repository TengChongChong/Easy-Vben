package com.easy.admin.sys.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.sys.model.SysFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件 
 *
 * @author TengChongChong
 * @date 2021-02-21
 */
public interface SysFileMapper extends BaseMapper<SysFile> {
    /**
     * 获取列表数据
     *
     * @param queryWrapper 查询条件
     * @return List<SysFile>
     */
    List<SysFile> select(@Param("ew") QueryWrapper<SysFile> queryWrapper);
}