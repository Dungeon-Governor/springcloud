package com.he.springcloud.controller;

import com.he.springcloud.service.MyMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private MyMessageProvider myMessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return myMessageProvider.send();
    }

}
