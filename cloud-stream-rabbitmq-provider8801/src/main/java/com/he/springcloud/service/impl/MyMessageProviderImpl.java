package com.he.springcloud.service.impl;

import com.he.springcloud.service.MyMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

//将信道Channel和Exchange绑定在一起
//定义为消息的推送管道
@EnableBinding(Source.class)
@Slf4j
public class MyMessageProviderImpl implements MyMessageProvider {

//    消息发送管道
    @Resource
    private MessageChannel output;

    @Override
    public String send() {

        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("*****serial："+ serial);
        return null;
    }
}
