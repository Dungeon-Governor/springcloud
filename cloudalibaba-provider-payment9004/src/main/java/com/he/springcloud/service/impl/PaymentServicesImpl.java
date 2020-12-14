package com.he.springcloud.service.impl;

import com.he.springcloud.dao.PaymentDao;
import com.he.springcloud.entities.Payment;
import com.he.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServicesImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public Payment getPayment(Long id) {
        return paymentDao.getPayment(id);
    }
}
