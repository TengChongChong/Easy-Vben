package com.easy.admin.generator.service;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.generator.model.Generator;

import java.util.List;

/**
 * 代码生成
 *
 * @author TengChongChong
 * @date 2019-01-09
 */
public interface GeneratorService {
    /**
     * 生成代码
     *
     * @param object 参数
     * @return 是否成功
     */
    boolean generate(Generator object);

    /**
     * 获取表名
     *
     * @param dataSource 数据源
     * @return List<Select>
     */
    List<Select> selectTable(String dataSource);

    /**
     * 根据表名获取字段列表
     *
     * @param dataSource 数据源
     * @param tableName 表名
     * @return List<Select>
     */
    TableInfo selectFields(String dataSource, String tableName);

    /**
     * 查询所有模块
     *
     * @return List<Select>
     */
    List<Select> selectModules();
}
