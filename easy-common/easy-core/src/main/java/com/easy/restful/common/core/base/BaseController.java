package com.easy.restful.common.core.base;

import com.easy.restful.common.core.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * base controller
 *
 * @author tengchong
 * @date 2018/10/22
 */

public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
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
