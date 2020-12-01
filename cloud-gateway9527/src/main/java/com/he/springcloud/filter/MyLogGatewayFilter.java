package com.he.springcloud.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {

//    处理请求
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入MyLogGatewayFilter："+new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null){
            log.info("uname为null，非法用户");
//            设置状态码为NOT_ACCEPTABLE
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//            返回错误信息
            return exchange.getResponse().setComplete();
        }
//        通过过滤器，让下一个过滤器处理请求
        return chain.filter(exchange);
    }

//    过滤器的优先级最高可到2147483647，最低可到-2147483648
    @Override
    public int getOrder() {
        return 0;
    }
}
