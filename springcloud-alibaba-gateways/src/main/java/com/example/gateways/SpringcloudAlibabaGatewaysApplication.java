package com.example.gateways;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *  网管路由
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class SpringcloudAlibabaGatewaysApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudAlibabaGatewaysApplication.class, args);
    }

}
