package com.example.order.feign;


import com.example.order.fallback.StorageFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "springcloud-alibaba-storage",fallback = StorageFallback.class)
public interface StorageFeign {

    /**
     * 扣减库存
     * @param productId
     * @param count
     * @return
     */
    @GetMapping(value = "/storage/decrease")
    String decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
