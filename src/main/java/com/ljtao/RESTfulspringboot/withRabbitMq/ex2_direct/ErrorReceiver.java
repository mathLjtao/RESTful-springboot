package com.ljtao.RESTfulspringboot.withRabbitMq.ex2_direct;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value ="${mq.config.queue.error}",autoDelete = "ture"),
        exchange = @Exchange(value="${mq.config.exchange}",type = ExchangeTypes.DIRECT),
        key = "${mq.config.queue.error.routing.key}"
))
public class ErrorReceiver {
    @RabbitHandler
    public void process(String msg){
        System.out.println("receiver 接收到error信息:"+msg);
    }
}