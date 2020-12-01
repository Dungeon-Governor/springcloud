package com.he.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
//        https://baike.baidu.com/calendar
//        这样访问localhost:9527/calendar会跳转到https://baike.baidu.com/calendar
        routes.route("path_route_he",
                r ->r.path("/calendar")
                        .uri("https://baike.baidu.com/calendar")).build();
        return routes.build();
    }

}