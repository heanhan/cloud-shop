package com.example.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供者的控制器
 */
@RestController
@RequestMapping(value="/provider")
public class ProviderController {

    @GetMapping(value = "/sayHello")
    public String sayHello(){
        return "hello Spring Cloud alibaba of word !";
    }
}
