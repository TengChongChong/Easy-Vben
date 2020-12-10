package com.easy.restful.sys.start;

import com.easy.restful.sys.service.SysDictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 启动后生成字典静态资源
 *
 * @author tengchong
 * @date 2019-03-21
 */
@Component
public class GenerateSysDict implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysDictService sysDictService;

    @Override
    public void run(String... args){
        logger.info("生成字典静态资源...");
        try {
            sysDictService.generateDictData();
        } catch (RuntimeException e) {
            logger.error("生成字典静态资源失败[" + e.getMessage() + "]...");
        }

    }
}
