package com.easy.admin.generator.service;

import com.easy.admin.generator.model.CascaderDistrict;
import com.easy.admin.generator.model.District;

import java.util.List;

/**
 * 行政区划
 *
 * @author TengChongChong
 * @date 2022-03-08
 */
public interface DistrictService {

    /**
     * 获取级联行政区划数据
     *
     * @return 级联行政区划数据
     */
    List<District> selectDistrict();

    /**
     * 获取级联行政区划数据
     *
     * @return 级联行政区划数据
     */
    List<CascaderDistrict> selectCascaderDistrict();
}
