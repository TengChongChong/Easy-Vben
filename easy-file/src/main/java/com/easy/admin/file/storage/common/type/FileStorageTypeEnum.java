package com.easy.admin.file.storage.common.type;

/**
 * 文件存储方式
 *
 * @author TengChongChong
 * @date 2023-10-25
 **/
public enum FileStorageTypeEnum {

    LOCAL("local"),
    OSS("oss");

    final String code;

    FileStorageTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
