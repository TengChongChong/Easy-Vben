package com.easy.admin.sys.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.easy.admin.sys.model.SysImportExcelTemporary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据导入
 *
 * @author TengChongChong
 * @date 2019-04-25
 */
public interface SysImportExcelDataMapper {
    /**
     * 查询
     *
     * @param table 表名
     * @param field 字段名
     * @param value 查询字段名
     * @param query 查询条件
     * @return 查询值
     */
    String queryString(@Param("table") String table, @Param("field") String field,
                       @Param("value") String value, @Param("query") String query);

    /**
     * 将临时表数据插入正式表
     *
     * @param table                     正式表
     * @param fields                    插入字段
     * @param tempFields                临时表中的字段
     * @param templateId                模板id
     * @param userId                    用户id
     * @param verificationStatusSuccess 验证通过数据状态
     * @return count
     */
    int insert(@Param("table") String table,
               @Param("fields") String fields,
               @Param("tempFields") String tempFields,
               @Param("templateId") String templateId,
               @Param("userId") String userId,
               @Param("verificationStatusSuccess") String verificationStatusSuccess);

    /**
     * 查询验证失败的数据
     *
     * @param selectFields  查询列
     * @param leftJoinTable 链接表
     * @param queryWrapper  查询条件
     * @return 数据
     */
    List<SysImportExcelTemporary> selectVerificationFailData(@Param("selectFields") String selectFields,
                                                             @Param("leftJoinTable") String leftJoinTable,
                                                             @Param("ew") QueryWrapper<SysImportExcelTemporary> queryWrapper);
}
