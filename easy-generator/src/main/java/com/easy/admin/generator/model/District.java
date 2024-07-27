package com.easy.admin.generator.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.List;

/**
 * 行政区划
 *
 * @author TengChongChong
 * @date 2022-03-08
 */
@Data
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
    private Integer orderNo;
    //

    /**
     * 子节点
     */
    @TableField(exist = false)
    private List<District> children;
}
