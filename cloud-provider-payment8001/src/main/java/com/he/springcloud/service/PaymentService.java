package com.he.springcloud.service;

import com.he.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") long id);

}
