package com.example.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "springcloud-alibaba-provider",path = "/provider")
public interface ISayRemoteHello {

    @GetMapping(value = "/sayHello")
    String sayRemoteHello();


}
