package com.easy.admin.generator.type;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.type.ITypeConvertHandler;
import com.baomidou.mybatisplus.generator.type.TypeRegistry;
import org.springframework.stereotype.Component;

/**
 * 代码生成类型转换器
 *
 * @author tengchong
 * @date 2023/3/30
 */
@Component
public class EasyTypeConvertHandler implements ITypeConvertHandler {
    @Override
    public IColumnType convert(GlobalConfig globalConfig, TypeRegistry typeRegistry, TableField.MetaInfo metaInfo) {
        IColumnType columnType = typeRegistry.getColumnType(metaInfo);
        if (columnType.equals(DbColumnType.TIMESTAMP)) {
            return DbColumnType.DATE;
        } else {
            return columnType;
        }
    }
}
