package com.easy.admin.generator.model;

import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import lombok.Data;

/**
 * 表字段
 *
 * @author tengchong
 * @date 2022/7/26
 */
@Data
public class TableField {
    private boolean keyFlag;
    private boolean keyIdentityFlag;
    private String name;
    private String propertyName;
    private IColumnType columnType;
    private String comment;
    private String columnName;

    private MetaInfo metaInfo;
}
