package com.easy.admin.common.core.common.pagination;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.easy.admin.common.core.constant.CommonConst;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单分页模型
 *
 * @author hubin
 * @since 2018-06-09
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Page<T> extends com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> {

    /**
     * 排序方式 Asc
     */
    private static final String ASC = "asc";

    /**
     * 排序方式 Desc
     */
    private static final String DESC = "desc";

    /**
     * 每页显示条数，默认 15
     */
    protected long pageSize = 15;

    /**
     * 排序方式
     */
    private String sortOrder;

    /**
     * 排序字段
     */
    private String sortField;

    /**
     * 默认 Asc 排序
     */
    private String[] defaultAscs = new String[]{};

    /**
     * 默认 Desc 排序
     */
    private String[] defaultDescs = new String[]{};


    public Page() {
    }

    public Page(long current, long size) {
        super(current, size);
    }

    public Page(long current, long size, long total) {
        super(current, size, total);
    }

    public Page(long current, long size, boolean searchCount) {
        super(current, size, searchCount);
    }

    public Page(long current, long size, long total, boolean searchCount) {
        super(current, size, total, searchCount);
    }

    @Override
    public long getSize() {
        return this.pageSize;
    }

    @Override
    public Page<T> setSize(long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public List<OrderItem> orders() {
        return getOrders();
    }

    public List<OrderItem> getOrders() {
        List<OrderItem> orderItems = new ArrayList<>();
        // todo: 暂时写死驼峰转下划线
        if (StrUtil.isNotBlank(sortField) && StrUtil.isNotBlank(sortOrder)) {
            sortField = StrUtil.toUnderlineCase(sortField);
            if (sortOrder.equals(DESC)) {
                orderItems.add(OrderItem.desc(sortField));
            } else if (sortOrder.equals(ASC)) {
                orderItems.add(OrderItem.asc(sortField));
            }
        } else {
            for (String asc : defaultAscs) {
                orderItems.add(OrderItem.asc(asc));
            }
            for (String desc : defaultDescs) {
                orderItems.add(OrderItem.desc(desc));
            }
        }
        return orderItems;
    }

    public void setDefaultAsc(String defaultAsc) {
        this.defaultAscs = defaultAsc.split(CommonConst.SPLIT);
    }

    public void setDefaultDesc(String defaultDesc) {
        this.defaultDescs = defaultDesc.split(CommonConst.SPLIT);
    }
}
