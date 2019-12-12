package com.example.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhaojh
 * @date : 2019-12-11
 * @function :nacos作为配置中心
 */

@RestController
@RequestMapping(value = "/config")
@RefreshScope
public class NacosController {

    @Value("${useLocalCache}")
    public boolean useLocalCache;


    @RequestMapping("/get")
    public boolean get() {
        return useLocalCache;
    }

}
