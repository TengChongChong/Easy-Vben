package com.easy.admin.file.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.file.model.FileDetail;
import org.apache.ibatis.annotations.Param;
import org.dromara.x.file.storage.core.FileInfo;

import java.util.List;

/**
 * 文件信息
 *
 * @author 系统管理员
 * @date 2024-09-03
 */
public interface FileDetailMapper extends BaseMapper<FileDetail> {

    /**
     * 查询数据（无分页）
     *
     * @param queryWrapper 查询条件
     * @return List<FileDetail>
     */
    List<FileDetail> selectWithoutPage(@Param("ew") QueryWrapper<FileDetail> queryWrapper);

    /**
     * 查询数据
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @return List<FileDetail>
     */
    List<FileDetail> select(Page<FileInfo> page, @Param("ew") QueryWrapper<FileDetail> queryWrapper);

    /**
     * 查询详情
     *
     * @param id id
     * @return FileDetail
     */
    FileDetail getById(@Param("id") String id);

    /**
     * 查询需要删除的数据
     *
     * @param queryWrapper 查询条件
     * @return List<FileInfo>
     */
    List<FileInfo> selectDeleted(@Param("ew") QueryWrapper<FileDetail> queryWrapper);


    /**
     * 根据对象ID查询数据
     *
     * @param id id
     * @return FileDetail
     */
    List<FileDetail> selectByObjectId(@Param("id") String id);

}