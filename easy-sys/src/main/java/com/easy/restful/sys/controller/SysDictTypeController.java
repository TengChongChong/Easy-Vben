package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.core.annotation.ResponseResult;
import com.easy.restful.sys.model.SysDictType;
import com.easy.restful.sys.service.SysDictTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 字典类型
 *
 * @author tengchong
 * @date 2018/11/4
 */
@RestController
@ResponseResult
@RequestMapping("/auth/sys/dict/type")
public class SysDictTypeController extends BaseController {

    @Autowired
    private SysDictTypeService service;

    /**
     * 列表
     *
     * @param object 查询条件
     * @return Page<SysDictType>
     */
    @GetMapping
    @RequiresPermissions("sys:dict:type:select")
    public Page<SysDictType> select(SysDictType object, Page<SysDictType> page) {
        return service.select(object, page);
    }

    /**
     * 查询所有
     *
     * @return List<SysDictType>
     */
    @GetMapping("all")
    @RequiresPermissions("sys:dict:type:select")
    public List<SysDictType> selectAll() {
        return service.selectAll();
    }

    /**
     * 删除
     *
     * @param ids 字典类型ids
     * @return true/false
     */
    @DeleteMapping("{ids}")
    @RequiresPermissions("sys:dict:type:remove")
    public boolean remove(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysDictType
     */
    @PostMapping
    @RequiresPermissions("sys:dict:type:save")
    public SysDictType save(@RequestBody @Valid SysDictType object) {
        return service.saveData(object);
    }

}
