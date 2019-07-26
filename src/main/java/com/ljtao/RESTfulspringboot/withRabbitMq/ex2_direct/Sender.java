package com.ljtao.RESTfulspringboot.withRabbitMq.ex2_direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;

    public void send() throws  Exception{
        String msg="send msg:hello "+new Date();
        this.amqpTemplate.convertAndSend(this.exchange,"log.info.routing.key","msg");
        this.amqpTemplate.convertAndSend(this.exchange,"log.error.routing.key","msg");
    }
}
