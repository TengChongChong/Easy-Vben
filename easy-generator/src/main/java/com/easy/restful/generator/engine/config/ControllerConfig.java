package com.easy.restful.generator.engine.config;

import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.core.annotation.ResponseResult;
import com.easy.restful.generator.constant.GeneratorPackageConst;
import com.easy.restful.generator.model.Generator;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;

/**
 * controller 模板生成的配置
 *
 * @author tengchong
 * @date 2019-01-08
 */
public class ControllerConfig extends AbstractConfig {

    public ControllerConfig(Generator generator) {
        super(generator);
        imports.add(RequiresPermissions.class);
        imports.add(Autowired.class);
        imports.add(RestController.class);
        imports.add(ResponseResult.class);
        imports.add(RequestMapping.class);
        if(generator.isGeneratorMethodsSelect() || generator.isGeneratorMethodsAdd()){
            imports.add(GetMapping.class);
            imports.add(Page.class);
        }
        if(generator.isGeneratorMethodsRemove()){
            imports.add(DeleteMapping.class);
        }
        if(generator.isGeneratorMethodsSave()){
            imports.add(PostMapping.class);
            imports.add(RequestBody.class);
        }
        if(generator.isGeneratorMethodsSelect() || generator.isGeneratorMethodsRemove()){
            imports.add(PathVariable.class);
        }

        if (generator.isGeneratorMethodsSave()) {
            // 表达验证
            imports.add(Valid.class);
        }

        this.path = backEndFilePath + GeneratorPackageConst.CONTROLLER + File.separator + generator.getModelName() + "Controller.java";
    }
}
