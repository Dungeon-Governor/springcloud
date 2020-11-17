package com.he.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudConsumerOrderzk80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderzk80Application.class, args);
    }

}
