package com.he.springcloud.controller;

import com.he.springcloud.entities.CommonResult;
import com.he.springcloud.entities.Payment;
import com.he.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = paymentService.getPayment(id);
        CommonResult<Payment> result = new CommonResult(200,"serverPort："+serverPort,payment);
        return result;
    }

}
