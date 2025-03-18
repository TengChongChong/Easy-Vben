package com.easy.admin.task;

import com.easy.admin.sys.service.SysExceptionService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 清理异常日志表里的数据
 * 全局异常中拦截到未知异常时(RuntimeException)会插入到 sys_exception 表中
 *
 * @author TengChongChong
 * @date 2019-06-27
 */
@Slf4j
@Component
public class CleanExceptionLog {

    @Autowired
    private SysExceptionService service;

    public void clean() {
        log.debug("清理异常日志表");
        service.clean();
    }
}
