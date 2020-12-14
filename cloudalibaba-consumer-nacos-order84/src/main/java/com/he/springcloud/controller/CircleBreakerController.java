package com.he.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.he.springcloud.entities.CommonResult;
import com.he.springcloud.entities.Payment;
import com.he.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",
//            fallback只负责业务异常
            fallback = "handlerFallBack",
//            blockHandler只负责sentinel控制台配置违规
            blockHandler = "blockHandler",
//            设置fallback不处理IllegalArgumentException异常
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable("id") Long id){
        CommonResult result = restTemplate.getForObject(serverUrl + "/paymentSQL/" + id, CommonResult.class, id);
        if(id == 4){
            throw new IllegalArgumentException("非法参数异常");
        }else if(result.getData() == null){
            throw new NullPointerException("该id没有相应记录，空指针异常");
        }
        return result;
    }

    public CommonResult<Payment> handlerFallBack(@PathVariable Long id,Throwable e){
        Payment payment = new Payment(id, null);
        CommonResult<Payment> result = new CommonResult(444,"兜底方法handlerFallBack，异常信息："+e.getMessage(),payment);
        return result;
    }
    public CommonResult<Payment> blockHandler(@PathVariable Long id, BlockException e){
        Payment payment = new Payment(id, null);
        CommonResult<Payment> result = new CommonResult(445,"blockHandler限流，无此流水：BlockException信息："+e.getMessage(),payment);
        return result;
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }

}
