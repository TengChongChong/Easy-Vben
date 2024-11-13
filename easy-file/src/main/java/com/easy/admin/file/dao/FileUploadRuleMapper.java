package com.easy.admin.file.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.file.model.FileUploadRule;
import com.easy.admin.file.model.vo.FileUploadRuleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件上传规则
 *
 * @author tengchongchong
 * @date 2023-11-17
 */
public interface FileUploadRuleMapper extends BaseMapper<FileUploadRule> {
    /**
     * 查询数据
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @return List<FileUploadRule>
     */
    List<FileUploadRule> select(Page<FileUploadRule> page, @Param("ew") QueryWrapper<FileUploadRule> queryWrapper);

    /**
     * 查询所有存放目录
     *
     * @return 文件夹
     */
    List<String> selectAllDirectory();

    /**
     * 获取上传规则
     *
     * @param slug 规则别名
     * @return FileUploadRule
     */
    FileUploadRuleVO getBySlug(@Param("slug") String slug);

    /**
     * 查询详情
     *
     * @param id id
     * @return FileUploadRule
     */
    FileUploadRule getById(@Param("id") String id);

}