package com.easy.restful.sys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 *
 * @author tengchong
 * @date 2020/7/7
 */
@RestController
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "success";
    }

    @GetMapping("/test/permissions1")
    public String getPermissions1(){
        return "You have [Get /test/permissions1] permission";
    }
    @PostMapping("/test/permissions1")
    public String postPermissions1(){
        return "You have [Post /test/permissions1] permission";
    }

    @GetMapping("/test/permissions2")
    public String getPermissions2(){
        return "You have [Get /test/permissions2] permission";
    }
    @PostMapping("/test/permissions2")
    public String postPermissions2(){
        return "You have [Post /test/permissions2] permission";
    }

    @GetMapping("/test/permissions3")
    public String getPermissions3(){
        return "You have [Get /test/permissions3] permission";
    }
    @PostMapping("/test/permissions3")
    public String postPermissions3(){
        return "You have [Post /test/permissions3] permission";
    }

}
