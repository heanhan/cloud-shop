package com.example.account.fallback;

import com.example.account.feign.OrderFeign;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderFallback implements OrderFeign {

    @Override
    public String update(Long userId, BigDecimal money, Integer status) {
        return "this is fallback message";
    }

}
