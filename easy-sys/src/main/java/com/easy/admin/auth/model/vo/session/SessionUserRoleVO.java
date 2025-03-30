package com.easy.admin.auth.model.vo.session;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户角色
 *
 * @author TengChongChong
 * @date 2024/8/6
 */
@Data
public class SessionUserRoleVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    private String id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色标识
     */
    private String code;

}