package com.example.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;


/**
 * Spring Cloud 原生注解 @RefreshScope 实现配置自动更新
 */
@SpringBootApplication
public class SpringcloudAlibabaNacosConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudAlibabaNacosConfigApplication.class, args);
    }

}
