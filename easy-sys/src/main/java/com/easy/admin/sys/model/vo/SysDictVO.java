package com.easy.admin.sys.model.vo;

import com.easy.admin.sys.model.SysDict;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 字典
 *
 * @author TengChongChong
 * @date 2024-10-23
 **/
@Data
public class SysDictVO extends SysDict {
    /**
     * 父字典名称
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String parentName;
}
