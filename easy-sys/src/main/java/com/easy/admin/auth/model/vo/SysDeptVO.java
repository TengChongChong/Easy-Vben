package com.easy.admin.auth.model.vo;

import com.easy.admin.auth.model.SysDept;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 部门
 *
 * @author TengChongChong
 * @date 2024-10-24
 **/
@Data
public class SysDeptVO extends SysDept {
    
    /**
     * 部门类型名称
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String typeName;
}
