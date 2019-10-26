package com.example.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 添加服务发现注解 @EnableDiscoveryClient
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudAlibabaProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudAlibabaProviderApplication.class, args);
    }

}
