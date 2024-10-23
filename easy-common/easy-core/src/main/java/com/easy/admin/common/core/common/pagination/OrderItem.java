package com.easy.admin.common.core.common.pagination;

import lombok.Data;

/**
 * 排序元素载体
 *
 * @author TengChongChong
 * @date 2024-10-09
 **/
@Data
public class OrderItem {

    /**
     * 排序属性
     */
    private String property;

    /**
     * 需要进行排序的字段
     */
    private String field;

    /**
     * 排序方式 "asc" | "desc"
     */
    private String order;

    /**
     * 排序时间
     */
    private Long sortTime;
}
