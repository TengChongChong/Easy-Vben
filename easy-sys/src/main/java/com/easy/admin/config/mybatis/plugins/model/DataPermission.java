package com.easy.admin.config.mybatis.plugins.model;

import com.easy.admin.auth.common.type.DataPermissionType;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 数据权限
 *
 * @author TengChongChong
 * @date 2024-07-23
 **/
@Data
public class DataPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    private DataPermissionType type;

    private List<String> deptIds;

    public DataPermission() {
    }

    public DataPermission(DataPermissionType type) {
        this.type = type;
    }

    public DataPermission(DataPermissionType type, List<String> deptIds) {
        this.type = type;
        this.deptIds = deptIds;
    }
}
