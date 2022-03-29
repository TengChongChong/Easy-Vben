package com.easy.admin.generator.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.generator.model.CascaderDistrict;
import com.easy.admin.generator.model.District;

import java.util.List;

/**
 * 行政区划
 *
 * @author TengChongChong
 * @date 2022-03-08
 */
public interface DistrictMapper extends BaseMapper<District> {
    /**
     * 获取列表数据
     *
     * @return List<District>
     */
    List<District> select();

    /**
     * 获取列表数据
     *
     * @return List<CascaderDistrict>
     */
    List<CascaderDistrict> selectCascaderDistrict();

}