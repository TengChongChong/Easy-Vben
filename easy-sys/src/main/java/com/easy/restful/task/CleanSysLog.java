package com.easy.restful.task;

import com.easy.restful.sys.service.SysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 清理访问日志表里的数据
 *
 * @author tengchong
 * @date 2019-06-27
 */
@Component
public class CleanSysLog {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysLogService service;

    public void clean() {
        logger.debug("清理系统日志表");
        service.clean();
    }
}
