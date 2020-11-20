package com.he.springcloud.controller;


import com.he.springcloud.entities.CommonResult;
import com.he.springcloud.entities.Payment;
import com.he.springcloud.server.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String paymentTimeout(){
//        客户端默认等待1s
        return paymentFeignService.paymentTimeout();
    }

}
