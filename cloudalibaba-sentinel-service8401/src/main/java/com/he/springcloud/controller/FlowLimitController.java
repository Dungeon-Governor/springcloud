package com.he.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.he.springcloud.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @Resource
    private TestService testService;

    @GetMapping("/testA")
    public String testA(){
//        try {
////            暂停0.8s
//            TimeUnit.MILLISECONDS.sleep(800);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "testA"+testService.test();
    }
    @GetMapping("/testB")
    public String testB(){
        log.info("testB");
        return "testB"+testService.test();
    }


    @GetMapping("/testD")
    public String testD(){
//        try {
////            暂停1s线程
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("testD，测试RT");
        int age = 10/0;
        log.info("testD，异常比例");
        return "*****testD*****";
    }

    @GetMapping("/testE")
    public String testE(){
        log.info("testE，异常数量");
        int age = 10/0;
        return "*****testE*****";
    }

    @GetMapping("/testHotKey")
//    设置资源名和兜底方法为deal_testHotKey
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "*****testHotKey*****";
    }

    public String deal_testHotKey(String p1, String p2, BlockException e){
        return "*****deal_testHotKey*****";
    }

}
