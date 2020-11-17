package com.he.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//该注解用于向consul和zookeeper作为注册中心时注册服务
@EnableDiscoveryClient
@SpringBootApplication
public class CloudProviderPayment8004Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8004Application.class, args);
    }

}
