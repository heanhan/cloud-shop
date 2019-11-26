package com.example.gateways;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *  网管路由
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudAlibabaGatewaysApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudAlibabaGatewaysApplication.class, args);
    }

}
