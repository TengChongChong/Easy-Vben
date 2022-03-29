package com.easy.admin.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.generator.dao.DistrictMapper;
import com.easy.admin.generator.model.CascaderDistrict;
import com.easy.admin.generator.model.District;
import com.easy.admin.generator.service.DistrictService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 行政区划
 *
 * @author TengChongChong
 * @date 2022-03-08
 */
@Service
public class DistrictServiceImpl extends ServiceImpl<DistrictMapper, District> implements DistrictService {

    @Override
    public List<District> selectDistrict() {
        Map<Integer, List<District>> districtMap = new HashMap<>();
        List<District> districts = baseMapper.select();
        districts.forEach(district -> {
            List<District> children = districtMap.getOrDefault(district.getParentId(), new ArrayList<>());
            children.add(district);
            districtMap.put(district.getParentId(), children);
        });

        districts.forEach(district -> district.setChildren(districtMap.get(district.getId())));

        return districts.stream().filter(v -> 0 == v.getParentId()).collect(Collectors.toList());
    }

    @Override
    public List<CascaderDistrict> selectCascaderDistrict() {
        Map<Integer, List<CascaderDistrict>> districtMap = new HashMap<>();
        List<CascaderDistrict> districts = baseMapper.selectCascaderDistrict();
        districts.forEach(district -> {
            List<CascaderDistrict> children = districtMap.getOrDefault(district.getParentId(), new ArrayList<>());
            children.add(district);
            districtMap.put(district.getParentId(), children);
        });

        districts.forEach(district -> district.setChildren(districtMap.get(district.getId())));

        return districts.stream().filter(v -> 0 == v.getParentId()).collect(Collectors.toList());
    }
}