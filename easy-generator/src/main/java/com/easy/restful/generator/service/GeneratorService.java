package com.easy.restful.generator.service;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.easy.restful.common.core.common.select.Select;
import com.easy.restful.generator.model.Generator;

import java.util.List;

/**
 * 代码生成
 *
 * @author tengchong
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
     * @return List<Select>
     */
    List<Select> selectTable();

    /**
     * 根据表名获取字段列表
     *
     * @param tableName 表名
     * @return List<Select>
     */
    TableInfo selectFields(String tableName);

    /**
     * 查询所有模块
     *
     * @return List<Select>
     */
    List<Select> selectModules();
}
