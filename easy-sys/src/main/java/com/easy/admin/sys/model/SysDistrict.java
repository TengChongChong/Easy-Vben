package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


/**
 * 行政区划
 * @author TengChongChong
 */
@TableName("sys_district")
public class SysDistrict extends Model<SysDictType> {

    @TableId(value = "id")
    private String id;
    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空")
    private String name;
    /**
     * 父 ID
     */
    private String parentId;
    /**
     * 拼音首字母
     */
    private String initial;
    /**
     * 拼音首字母集合
     */
    private String initials;
    /**
     * 拼音
     */
    private String pinyin;
    /**
     * 附加说明
     */
    private String extra;
    /**
     * 行政级别
     */
    private String suffix;
    /**
     * 行政代码
     */
    @NotBlank(message = "代码不能为空")
    private String code;
    /**
     * 区号
     */
    private String areaCode;
    /**
     * 排序 升序
     */
    private Integer orderNo;

    public SysDistrict() {
    }

    public SysDistrict(String id) {
        this.id = id;
    }

    public SysDistrict(String id, Integer orderNo) {
        this.id = id;
        this.orderNo = orderNo;
    }

    public SysDistrict(String id, String parentId, Integer orderNo) {
        this.id = id;
        this.parentId = parentId;
        this.orderNo = orderNo;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
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

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}