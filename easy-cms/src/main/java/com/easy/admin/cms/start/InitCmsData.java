package com.easy.admin.cms.start;

import com.easy.admin.cms.service.CmsColumnService;
import com.easy.admin.cms.service.CmsSiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 启动时将cms数据放到redis中
 *
 * @author tengchong
 * @date 2021/11/23
 */
@Component
public class InitCmsData implements CommandLineRunner {

    @Autowired
    private CmsSiteService cmsSiteService;

    @Autowired
    private CmsColumnService cmsColumnService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) {
        logger.debug("加载CMS数据");
        cmsSiteService.refreshCache();

        cmsColumnService.refreshCache(null);
    }

}
