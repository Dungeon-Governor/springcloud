package com.he.springcloud.server;

import com.he.springcloud.entities.CommonResult;
import com.he.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
//要调用的地微服务名称
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment);

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id);

    @GetMapping("/payment/timeout")
    public String paymentTimeout();

}
