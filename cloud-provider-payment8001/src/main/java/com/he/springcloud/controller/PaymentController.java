package com.he.springcloud.controller;

import com.he.springcloud.entities.CommonResult;
import com.he.springcloud.entities.Payment;
import com.he.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

//    读取配置文件中 的server.port
    @Value("${server.port}")
    private String ServerPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if (result > 0){
            return new CommonResult(200,"插入数据库成功"+ServerPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id){
        Payment payment = paymentService.getPaymentById(id);
        System.out.println("查询成功");
        if (payment != null){
            return new CommonResult(200,"查询成功"+ServerPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询ID"+id,null);
        }
    }

    @GetMapping("/payment/timeout")
    public String paymentTimeout(){
        try {
            Thread.sleep(8);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ServerPort;
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
//        获取已注册的微服务信息
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*******element:"+element);
        }
//        获取这个微服务名字下的所有实例对象信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance :
                instances) {
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

}
