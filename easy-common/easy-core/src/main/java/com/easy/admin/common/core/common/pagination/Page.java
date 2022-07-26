package com.easy.admin.common.core.common.pagination;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.easy.admin.common.core.constant.CommonConst;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * 简单分页模型
 *
 * @author hubin
 * @since 2018-06-09
 */
public class Page<T> implements IPage<T> {

    /**
     * 排序方式 Asc
     */
    private static final String ASC = "ascend";

    /**
     * 排序方式 Desc
     */
    private static final String DESC = "descend";

    /**
     * 查询数据列表
     */
    protected List<T> records = Collections.emptyList();

    /**
     * 总数
     */
    protected long total = 0;

    /**
     * 每页显示条数，默认 15
     */
    protected long pageSize = 15;

    /**
     * 当前页
     */
    protected long current = 1;

    /**
     * 排序字段信息
     */
    protected List<OrderItem> orders = new ArrayList<>();

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

    /**
     * 自动优化 COUNT SQL
     */
    protected boolean optimizeCountSql = true;
    /**
     * 是否进行 count 查询
     */
    protected boolean isSearchCount = true;

    public Page() {
    }

    /**
     * 分页构造函数
     *
     * @param current 当前页
     * @param pageSize    每页显示条数
     */
    public Page(long current, long pageSize) {
        this(current, pageSize, 0);
    }

    public Page(long current, long pageSize, long total) {
        this(current, pageSize, total, true);
    }

    public Page(long current, long pageSize, boolean isSearchCount) {
        this(current, pageSize, 0, isSearchCount);
    }

    public Page(long current, long pageSize, long total, boolean isSearchCount) {
        if (current > 1) {
            this.current = current;
        }
        this.pageSize = pageSize;
        this.total = total;
        this.isSearchCount = isSearchCount;
    }

    /**
     * 是否存在上一页
     *
     * @return true / false
     */
    public boolean hasPrevious() {
        return this.current > 1;
    }

    /**
     * 是否存在下一页
     *
     * @return true / false
     */
    public boolean hasNext() {
        return this.current < this.getPages();
    }

    @Override
    public List<T> getRecords() {
        return this.records;
    }

    @Override
    public Page<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

    @Override
    public long getTotal() {
        return this.total;
    }

    @Override
    public Page<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    @Override
    @JsonIgnore
    public long getSize() {
        return this.pageSize;
    }

    @Override
    public Page<T> setSize(long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public long getCurrent() {
        return this.current;
    }

    @Override
    public Page<T> setCurrent(long current) {
        this.current = current;
        return this;
    }


    /**
     * 查找 order 中正序排序的字段数组
     *
     * @param filter 过滤器
     * @return 返回正序排列的字段数组
     */
    private String[] mapOrderToArray(Predicate<OrderItem> filter) {
        List<String> columns = new ArrayList<>(orders.size());
        orders.forEach(i -> {
            if (filter.test(i)) {
                columns.add(i.getColumn());
            }
        });
        return columns.toArray(new String[0]);
    }

    /**
     * 移除符合条件的条件
     *
     * @param filter 条件判断
     */
    private void removeOrder(Predicate<OrderItem> filter) {
        for (int i = orders.size() - 1; i >= 0; i--) {
            if (filter.test(orders.get(i))) {
                orders.remove(i);
            }
        }
    }

    /**
     * 添加新的排序条件，构造条件可以使用工厂：{@link OrderItem#build(String, boolean)}
     *
     * @param items 条件
     * @return 返回分页参数本身
     */
    public Page<T> addOrder(OrderItem... items) {
        orders.addAll(Arrays.asList(items));
        return this;
    }

    /**
     * 添加新的排序条件，构造条件可以使用工厂：{@link OrderItem#build(String, boolean)}
     *
     * @param items 条件
     * @return 返回分页参数本身
     */
    public Page<T> addOrder(List<OrderItem> items) {
        orders.addAll(items);
        return this;
    }

    /**
     * 设置需要进行正序排序的字段
     * <p>
     * Replaced:{@link #addOrder(OrderItem...)}
     *
     * @param ascs 字段
     * @return 返回自身
     * @deprecated 3.2.0
     */
    @Deprecated
    public Page<T> setAscs(List<String> ascs) {
        return CollectionUtils.isNotEmpty(ascs) ? setAsc(ascs.toArray(new String[0])) : this;
    }

    /**
     * 升序
     * <p>
     * Replaced:{@link #addOrder(OrderItem...)}
     *
     * @param ascs 多个升序字段
     * @deprecated 3.2.0
     */
    @Deprecated
    public Page<T> setAsc(String... ascs) {
        // 保证原来方法 set 的语意
        removeOrder(OrderItem::isAsc);
        for (String s : ascs) {
            addOrder(OrderItem.asc(s));
        }
        return this;
    }

    /**
     * Replaced:{@link #addOrder(OrderItem...)}
     *
     * @param descs 需要倒序排列的字段
     * @return 自身
     * @deprecated 3.2.0
     */
    @Deprecated
    public Page<T> setDescs(List<String> descs) {
        // 保证原来方法 set 的语意
        if (CollectionUtils.isNotEmpty(descs)) {
            removeOrder(item -> !item.isAsc());
            for (String s : descs) {
                addOrder(OrderItem.desc(s));
            }
        }
        return this;
    }

    @Override
    public List<OrderItem> orders() {
        return getOrders();
    }

    public void setOrders(List<OrderItem> orders) {
        this.orders = orders;
    }

    @Override
    @JsonIgnore
    public boolean optimizeCountSql() {
        return optimizeCountSql;
    }

    public boolean isOptimizeCountSql() {
        return optimizeCountSql();
    }

    public Page<T> setSearchCount(boolean isSearchCount) {
        this.isSearchCount = isSearchCount;
        return this;
    }

    public Page<T> setOptimizeCountSql(boolean optimizeCountSql) {
        this.optimizeCountSql = optimizeCountSql;
        return this;
    }

    public List<OrderItem> getOrders() {
        List<OrderItem> orderItems = new ArrayList<>();
        // todo: 暂时写死驼峰转下划线
        sortField = StrUtil.toUnderlineCase(sortField);
        if (StrUtil.isNotBlank(sortField) && StrUtil.isNotBlank(sortOrder)) {
            if (sortOrder.equals(DESC)) {
                orderItems.add(OrderItem.desc(sortField));
            } else if (sortOrder.equals(ASC)) {
                orderItems.add(OrderItem.asc(sortField));
            }
        } else {
            if (defaultAscs.length > 0) {
                for (String asc : defaultAscs) {
                    orderItems.add(OrderItem.asc(asc));
                }
            }
            if (defaultDescs.length > 0) {
                for (String desc : defaultDescs) {
                    orderItems.add(OrderItem.desc(desc));
                }
            }
        }
        return orderItems;
    }


    public String[] getDefaultAscs() {
        return defaultAscs;
    }

    public void setDefaultAscs(String[] defaultAscs) {
        this.defaultAscs = defaultAscs;
    }

    public String[] getDefaultDescs() {
        return defaultDescs;
    }

    public void setDefaultDescs(String[] defaultDescs) {
        this.defaultDescs = defaultDescs;
    }

    public void setDefaultAsc(String defaultAscs) {
        this.defaultAscs = defaultAscs.split(CommonConst.SPLIT);
    }

    public void setDefaultDesc(String defaultDescs) {
        this.defaultDescs = defaultDescs.split(CommonConst.SPLIT);
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }
}
