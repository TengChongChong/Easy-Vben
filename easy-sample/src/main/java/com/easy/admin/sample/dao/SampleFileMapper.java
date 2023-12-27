package com.easy.admin.sample.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.easy.admin.sample.model.SampleFile;

/**
 * 文件示例
 *
 * @author tengchongchong
 * @date 2023-12-22
 */
public interface SampleFileMapper extends BaseMapper<SampleFile> {
    /**
     * 查询数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return List<SampleFile>
     */
    List<SampleFile> select(Page<SampleFile> page, @Param("ew") QueryWrapper<SampleFile> queryWrapper);
    /**
     * 查询详情
     *
     * @param id id
     * @return SampleFile
     */
    SampleFile getById(@Param("id") String id);

}