package com.easy.admin.auth.model.vo.session;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 部门
 *
 * @author TengChongChong
 * @date 2024/8/6
 */
@Data
public class SessionDeptVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 父id
     */
    private String parentId;

    /**
     * 全称
     */
    private String name;

    /**
     * 简称
     */
    private String simpleName;

    /**
     * 部门代码
     */
    private String code;

    /**
     * 部门类型编码
     */
    private String typeCode;

    /**
     * 状态
     */
    private String status;

}