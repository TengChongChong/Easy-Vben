package com.easy.admin.file.common.type;

import lombok.Getter;

/**
 * 文件访问控制
 *
 * @author TengChongChong
 * @date 2025-04-23
 **/
@Getter
public enum FileAccessControl {

    PRIVATE("private", "私有读写"),
    PUBLIC_READ("public-read", "公有读私有写"),
    PUBLIC_READ_WRITE("public-read-write", "公有读写（高风险）");

    final String code;
    final String desc;

    FileAccessControl(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
