package com.easy.admin.generator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * 级联行政区划
 *
 * @author tengchong
 * @date 2022/3/8
 */
public class CascaderDistrict {

    @JsonIgnore
    private Integer id;
    /**
     *
     * 父id
     */
    @JsonIgnore
    private Integer parentId;
    /**
     * value
     */
    private String value;
    /**
     * label
     */
    private String label;
    /**
     * 子节点
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<CascaderDistrict> children;

    public CascaderDistrict() {
    }

    public CascaderDistrict(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<CascaderDistrict> getChildren() {
        return children;
    }

    public void setChildren(List<CascaderDistrict> children) {
        this.children = children;
    }
}
