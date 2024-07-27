package com.easy.admin.generator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * 级联行政区划
 *
 * @author tengchong
 * @date 2022/3/8
 */
@Data
public class CascaderDistrict {

    @JsonIgnore
    private Integer id;
    /**
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

}
