package com.he.springcloud.controller;

import com.he.springcloud.domain.CommonResult;
import com.he.springcloud.domain.Order;
import com.he.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

//    因为这个OrderController是暴露给用户使用的，不能用post，真正创建是在StorageService，那里使用的post
    @GetMapping("/order/create")
    public CommonResult<Order> create(Order order){
        orderService.create(order);
        return new CommonResult<Order>(200,"订单创建成功");
    }

}
