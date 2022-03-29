package com.easy.admin.generator.controller;

import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.generator.model.CascaderDistrict;
import com.easy.admin.generator.model.District;
import com.easy.admin.generator.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 行政区划
 *
 * @author tengchong
 * @date 2022/3/8
 */
@RestController
@ResponseResult
public class DistrictController {
    @Autowired
    private DistrictService service;

    @GetMapping("/district")
    public List<District> selectDistrict(){
        return service.selectDistrict();
    }

    @GetMapping("/cascader/district")
    public List<CascaderDistrict> selectCascaderDistrict(){
        return service.selectCascaderDistrict();
    }
}
