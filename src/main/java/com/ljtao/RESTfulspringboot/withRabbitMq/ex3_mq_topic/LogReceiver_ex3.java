package com.ljtao.RESTfulspringboot.withRabbitMq.ex3_mq_topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;
/*
接收所有路由健（key）包含log的信息
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value ="${mq.config.queue.logs}",autoDelete = "ture"),
        exchange = @Exchange(value="${mq.config.exchange_2}",type = ExchangeTypes.TOPIC),
        key = "*.log.*"
))
public class LogReceiver_ex3 {
    @RabbitHandler
    public void process(String msg){
        System.out.println("logs 匹配、接受所有的日志信息:"+msg);
    }
}
