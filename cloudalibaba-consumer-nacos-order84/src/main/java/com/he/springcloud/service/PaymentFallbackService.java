package com.he.springcloud.service;

import com.he.springcloud.entities.CommonResult;
import com.he.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<Payment>(444,"服务降级返回，fallbcak",new Payment(id,"error"));
    }
}
