package com.easy.admin.sys.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sys.model.SysImportExcelTemporary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 导入临时表
 *
 * @author TengChong
 * @date 2019-04-10
 */
public interface SysImportExcelTemporaryMapper extends BaseMapper<SysImportExcelTemporary> {
    /**
     * 获取导入汇总信息
     *
     * @param templateId 模板id
     * @param userId     用户id
     * @return 导入汇总
     */
    List<SysImportExcelTemporary> selectImportSummary(@Param("templateId") String templateId, @Param("userId") String userId);

    /**
     * 查询临时表数据
     *
     * @param page          分页
     * @param selectFields  查询列
     * @param leftJoinTable 链接表
     * @param queryWrapper  查询条件
     * @return 数据
     */
    List<SysImportExcelTemporary> select(Page<SysImportExcelTemporary> page,
                                         @Param("selectFields") String selectFields,
                                         @Param("leftJoinTable") String leftJoinTable,
                                         @Param("ew") QueryWrapper<SysImportExcelTemporary> queryWrapper);

    /**
     * 获取数据详情
     *
     * @param selectFields  查询列
     * @param leftJoinTable 链接表
     * @param id  数据id
     * @return 数据
     */
    SysImportExcelTemporary getOne(@Param("selectFields") String selectFields,
                                         @Param("leftJoinTable") String leftJoinTable,
                                         @Param("id")String id);

    /**
     * 获取替换值
     *
     * @param table                  表名
     * @param replaceTableFieldName  替换表-名称
     * @param replaceTableFieldValue 替换表-值
     * @param value                  值
     * @return 替换值
     */
    String getReplaceTableFieldValue(@Param("table") String table,
                                     @Param("replaceTableFieldName") String replaceTableFieldName,
                                     @Param("replaceTableFieldValue") String replaceTableFieldValue,
                                     @Param("value") String value);

    /**
     * 获取替换值-字典
     *
     * @param table                  表名
     * @param replaceTableFieldName  替换表-名称
     * @param replaceTableFieldValue 替换表-值
     * @param value                  值
     * @param dictType               字典
     * @return 替换值
     */
    String getDictReplaceTableFieldValue(@Param("table") String table,
                                         @Param("replaceTableFieldName") String replaceTableFieldName,
                                         @Param("replaceTableFieldValue") String replaceTableFieldValue,
                                         @Param("value") String value,
                                         @Param("dictType") String dictType);

    /**
     * 校验数据是否唯一
     *
     * @param fieldName 字段名
     * @param value 值
     * @param id 数据id
     * @return 数量
     */
    int count(@Param("fieldName") String fieldName,
                      @Param("value") String value,
                      @Param("id") String id);

    /**
     * 更新重复数据状态
     *
     * @param field 唯一约束字段
     * @param templateId 导入模板id
     * @param userId 用户id
     * @param status 状态
     */
    void updateDuplicateData(@Param("field")String field,
                             @Param("templateId")String templateId,
                             @Param("userId")String userId,
                             @Param("status") String status);


}