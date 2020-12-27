package com.he.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.he.springcloud.dao"})
public class MyBatisConfig {
}
