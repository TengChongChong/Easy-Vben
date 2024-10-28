package com.easy.admin.auth.model.vo;

import com.easy.admin.auth.model.SysDeptType;
import lombok.Data;

import java.util.List;

/**
 * 部门类型
 *
 * @author TengChongChong
 * @date 2024-10-24
 **/
@Data
public class SysDeptTypeVO extends SysDeptType {

    /**
     * 该部门类型可以选择的角色列表 1,2,3
     */
    private List<String> roleIdList;
}
