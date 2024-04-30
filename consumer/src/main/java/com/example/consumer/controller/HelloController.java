package com.example.consumer.controller;

import com.example.consumer.feign.ISayRemoteHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/consumer")
public class HelloController {

    @Resource
    private ISayRemoteHello sayRemoteHello;

    @GetMapping(value = "/getReoteInfos")
    public String getReoteInfos(){
        String contents = sayRemoteHello.sayRemoteHello();
        return contents;
    }
}
