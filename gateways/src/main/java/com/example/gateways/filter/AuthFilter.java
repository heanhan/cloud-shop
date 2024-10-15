package com.example.gateways.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author : zhaojh
 * @date : 2024-08-13
 * @function :功能实现 全局的用户权限的拦截
 */

@Component
public class AuthFilter implements Ordered, GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");//获取口令
        if(token == null|| token.isEmpty()){
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.MULTI_STATUS);
            return response.setComplete();
        }
        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
