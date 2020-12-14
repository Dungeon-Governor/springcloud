package com.he.springcloud.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.he.springcloud.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl  implements TestService {
    @Override
//    设置链路资源名
    @SentinelResource("test")
    public String test() {
        return "预热测试";
    }
}
