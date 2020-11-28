package com.he.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients
//开启Hystrix
@EnableHystrix
public class CloudConsumerHystrixOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerHystrixOrder80Application.class, args);
    }

}
