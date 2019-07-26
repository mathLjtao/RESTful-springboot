package com.ljtao.RESTfulspringboot.withRabbitMq.ex3_mq_topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value ="${mq.config.queue.error}",autoDelete = "ture"),
        exchange = @Exchange(value="${mq.config.exchange_2}",type = ExchangeTypes.TOPIC),
        key = "*.log.error"
))
public class ErrorReceiver_ex3 {
    @RabbitHandler
    public void process(String msg){
        System.out.println("receiver 接收到error信息:"+msg);
    }
}