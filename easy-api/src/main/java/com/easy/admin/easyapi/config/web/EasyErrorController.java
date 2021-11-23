package com.easy.admin.easyapi.config.web;

import com.easy.admin.common.core.util.Response;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 自定义容器级错误响应内容
 *
 * @author TengChongChong
 * @date 2018/10/22
 */
@Controller
public class EasyErrorController extends BasicErrorController {

    public EasyErrorController() {
        super(new DefaultErrorAttributes(), new ErrorProperties());
    }

    /**
     * 自定义ajax响应内容
     */
    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        // 响应数据
        Map<String, Object> map = getErrorAttributes(request, ErrorAttributeOptions.defaults());
        return new ResponseEntity(Response.failError("00" + map.get("status"),  map.get("error") + " - " + map.get("path")), status);
    }
}
