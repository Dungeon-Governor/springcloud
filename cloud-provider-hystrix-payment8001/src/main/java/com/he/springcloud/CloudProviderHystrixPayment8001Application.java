package com.he.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
//开启服务降级
@EnableCircuitBreaker
public class CloudProviderHystrixPayment8001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderHystrixPayment8001Application.class, args);
    }

}
