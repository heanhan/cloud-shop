package com.example.order.fallback;

import com.example.order.feign.AccountFeign;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author : zhaojh
 * @date : 2019-12-12
 * @function :
 */

@Component
public class AccountFallback implements AccountFeign {
    @Override
    public String decrease(Long userId, BigDecimal money) {
        return "this is fallback message";
    }
}
