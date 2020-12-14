package com.he.springcloud.service;

import com.he.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    Payment getPayment(@Param("id") Long id);

}
