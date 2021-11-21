package com.easy.admin.generator.controller;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.generator.model.Generator;
import com.easy.admin.generator.service.GeneratorService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 代码生成
 *
 * @author TengChongChong
 * @date 2019-01-09
 */
@RestController
@ResponseResult
@RequestMapping("/auth/generator")
public class GeneratorController {

    @Autowired
    private GeneratorService service;

    /**
     * 获取表名
     *
     * @return List<Select>
     */
    @RequiresRoles("sys:admin")
    @GetMapping("table")
    public List<Select> selectTable() {
        return service.selectTable();
    }

    /**
     * 根据表名获取字段列表
     *
     * @param tableName      表名
     * @return TableInfo
     */
    @RequiresRoles("sys:admin")
    @GetMapping("fields")
    public TableInfo selectFields(String tableName) {
        return service.selectFields(tableName);
    }

    /**
     * 查询项目中模块
     *
     * @return List<Select>
     */
    @RequiresRoles("sys:admin")
    @GetMapping("modules")
    public List<Select> selectModules(){
        return service.selectModules();
    }
    /**
     * 生成代码
     *
     * @param object 参数
     * @return true/false
     */
    @PostMapping()
    public boolean generate(@RequestBody Generator object) {
        return service.generate(object);
    }
}
