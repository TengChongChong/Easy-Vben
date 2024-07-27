package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * 行政区划
 *
 * @author TengChongChong
 */
@Data
@TableName("sys_district")
public class SysDistrict extends Model<SysDictType> {

    @TableId
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
}