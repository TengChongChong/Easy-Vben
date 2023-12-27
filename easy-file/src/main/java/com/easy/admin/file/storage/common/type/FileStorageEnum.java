package com.easy.admin.file.storage.common.type;

/**
 * 文件存储类型
 *
 * @author TengChongChong
 * @date 2023-10-25
 **/
public enum FileStorageEnum {

    // 本地
    LOCAL("local"),
    // oss - MinIo
    MINIO("minio");

    final String code;

    FileStorageEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
