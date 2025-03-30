package com.easy.admin.auth.model.vo;

import com.easy.admin.auth.model.SysMenu;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 菜单
 *
 * @author 系统管理员
 * @date 2025-03-21
 */
@Data
public class SysMenuVO extends SysMenu implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // 非表字段
}
