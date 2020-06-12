package com.easy.restful.sys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户
 *
 * @author tengchong
 * @date 2020/6/12
 */
@RestController
@RequestMapping("/user")
public class SysUserController {
    @GetMapping
    public String getUsers() {
        return "Hello Spring Security";
    }
}
