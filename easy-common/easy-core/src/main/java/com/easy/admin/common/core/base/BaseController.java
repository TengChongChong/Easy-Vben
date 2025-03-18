package com.easy.admin.common.core.base;

import com.easy.admin.common.core.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * base controller
 *
 * @author TengChongChong
 * @date 2018/10/22
 */
@Slf4j
public class BaseController {
    /**
     * 默认成功提示
     */
    protected static Response successResponse = Response.success();

    /**
     * redirect
     */
    protected static String REDIRECT = "redirect:";
    /**
     * FORWARD
     */
    protected static String FORWARD = "forward:";

}
