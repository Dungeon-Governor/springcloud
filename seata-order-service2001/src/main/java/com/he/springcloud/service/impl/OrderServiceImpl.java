package com.he.springcloud.service.impl;

import com.he.springcloud.dao.OrderDao;
import com.he.springcloud.domain.Order;
import com.he.springcloud.service.AccountService;
import com.he.springcloud.service.OrderService;
import com.he.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;


    @Override
//    name是事务名，可以随意命名，rollbackFor是当出现某个异常时回滚事务
    @GlobalTransactional(name = "he-create-order",rollbackFor = Exception.class)
    public void create(Order order) {

        log.info("----->开始新建订单");
        orderDao.create(order);

        log.info("----->订单为服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单为服务开始调用库存，扣减完成");

        log.info("----->订单为服务开始调用账户，做扣减");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单为服务开始调用账户，扣减完成");

        log.info("----->修改订单状态开始");
        orderDao.update(order.getId(),0);
        log.info("----->修改订单状态完成");

        log.info("----->下订单结束");

    }
}
