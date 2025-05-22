package com.easy.admin.generator.model;

import lombok.Data;

/**
 * 生成字典常量
 *
 * @author TengChongChong
 * @date 2025-05-21
 **/
@Data
public class GenerateDictEnumResponse {
    private String javaFileName;
    private String jsFileName;
    private String javaCode;
    private String jsCode;
}
