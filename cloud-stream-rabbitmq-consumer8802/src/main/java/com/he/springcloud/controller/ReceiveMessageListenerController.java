package com.he.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
//将信道Channel和Exchange绑定在一起
//定义为消息的接收管道
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String ServerPort;

    @StreamListener(Sink.INPUT)
//    监听队列，用于消费者的队列的消息接收
    public void input(Message<String> message){

        log.info("消费者8802------》接收到消息："+message.getPayload()+"\t port："+ServerPort);

    }

}
