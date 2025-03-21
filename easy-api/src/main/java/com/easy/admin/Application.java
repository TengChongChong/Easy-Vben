package com.easy.admin;

import org.beetl.ext.spring6.EnableBeetl;
import org.dromara.x.file.storage.spring.EnableFileStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 *
 * @author TengChongChong
 * @date 2020/06/12
 */
@EnableCaching
@EnableFileStorage
@EnableTransactionManagement
@SpringBootApplication
@EnableBeetl
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}