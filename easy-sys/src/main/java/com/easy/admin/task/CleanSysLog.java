package com.easy.admin.task;

import com.easy.admin.sys.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 清理访问日志表里的数据
 *
 * @author TengChongChong
 * @date 2019-06-27
 */
@Slf4j
@Component
public class CleanSysLog {

    @Autowired
    private SysLogService service;

    public void clean() {
        log.debug("清理系统日志表");
        service.clean();
    }
}
