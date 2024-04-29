package com.example.order.fallback;

import com.example.order.feign.StorageFeign;
import org.springframework.stereotype.Component;

/**
 * @author : zhaojh
 * @date : 2019-12-12
 * @function :
 */

@Component
public class StorageFallback implements StorageFeign {
    @Override
    public String decrease(Long productId, Integer count) {
        return "this is for fallback message";
    }
}
