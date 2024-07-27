package com.easy.admin.sys.model.vo;

import lombok.Data;

/**
 * redis
 *
 * @author TengChongChong
 * @date 2019-01-25
 */
@Data
public class SysRedisVO {
    /**
     * 键
     */
    private String key;

    /**
     * 有效期
     * 单位: 秒
     */
    private Long expire;

    /**
     * 值
     */
    private Object value;
}
