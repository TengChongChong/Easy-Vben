package com.easy.admin.generator.generator.impl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.generator.constant.GeneratorListTemplateConst;
import com.easy.admin.generator.constant.GeneratorMethodConst;
import com.easy.admin.generator.constant.GeneratorPackageConst;
import com.easy.admin.generator.constant.GeneratorTemplateConst;
import com.easy.admin.generator.generator.GeneratorFile;
import com.easy.admin.generator.model.GeneratorConfig;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成 Controller
 *
 * @author tengchong
 * @date 2022/6/20
 */
public class GeneratorController extends GeneratorFile {

    /**
     * 构造
     *
     * @param generatorConfig 生成配置
     */
    public GeneratorController(GeneratorConfig generatorConfig, TableInfo tableInfo) {
        super(generatorConfig, tableInfo);
    }

    @Override
    public void init() {
        // 设置模板
        this.setTemplate(GeneratorTemplateConst.CONTROLLER);
        // 设置导入包
        this.setImports(initImports());
        // 设置文件路径
        this.setFilePath(this.backEndPathBasePath + GeneratorPackageConst.CONTROLLER + generatorConfig.getBasicsConfig().getModelName() + "Controller.java");
    }

    /**
     * 初始化导入类
     *
     * @return 导入类
     */
    private List<Class<?>> initImports() {
        List<Class<?>> imports = new ArrayList<>();
        imports.add(RequiresPermissions.class);
        imports.add(Autowired.class);
        imports.add(RestController.class);
        imports.add(ResponseResult.class);
        imports.add(RequestMapping.class);
        imports.add(Tag.class);
        imports.add(Operation.class);
        if (GeneratorListTemplateConst.TREE_TABLE.equals(generatorConfig.getBasicsConfig().getListGeneratorTemplate()) ||
                GeneratorListTemplateConst.TREE.equals(generatorConfig.getBasicsConfig().getListGeneratorTemplate())) {
            imports.add(List.class);
            imports.add(Tree.class);
        }
        if (generatorConfig.isGeneratorMethod(GeneratorMethodConst.SELECT) || generatorConfig.isGeneratorMethod(GeneratorMethodConst.ADD)) {
            imports.add(GetMapping.class);
        }
        if (generatorConfig.isGeneratorMethod(GeneratorMethodConst.SELECT)) {
            imports.add(Page.class);
        }
        if (generatorConfig.isGeneratorMethod(GeneratorMethodConst.REMOVE)) {
            imports.add(DeleteMapping.class);
            imports.add(PathVariable.class);
        }
        if (generatorConfig.isGeneratorMethod(GeneratorMethodConst.SAVE)) {
            imports.add(PostMapping.class);
            imports.add(RequestBody.class);
            // 表达验证
            imports.add(Valid.class);
        }
        return imports;
    }
}
