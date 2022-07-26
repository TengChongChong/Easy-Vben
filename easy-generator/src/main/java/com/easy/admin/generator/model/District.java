package com.easy.admin.generator.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.List;

/**
 * 行政区划
 *
 * @author TengChongChong
 * @date 2022-03-08
 */
@TableName("district")
public class District extends Model<District> {

    private Integer id;
    /**
     * 行政区划名称
     */
    private String name;
    /**
     * 父id
     */
    private Integer parentId;
    /**
     * 行政区划名称第一个汉字的拼音首字母  eg: 南京 n
     */
    private String initial;
    /**
     * 行政区划名称汉字的拼音首字母 eg: 南京 nj
     */
    private String initials;
    /**
     * 行政区划名称汉字的拼音 eg: 南京 nanjing
     */
    private String pinyin;
    /**
     * 额外的名称 eg: xx族
     */
    private String extra;
    /**
     * 后缀 eg: 省、市、区
     */
    private String suffix;
    /**
     * 行政区划编码
     */
    private String code;
    /**
     * 电话区号
     */
    private String areaCode;
    /**
     * 排序值
     */
    private Integer order;
    //

    /**
     * 子节点
     */
    @TableField(exist = false)
    private List<District> children;

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }
    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }
    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<District> getChildren() {
        return children;
    }

    public void setChildren(List<District> children) {
        this.children = children;
    }
}
