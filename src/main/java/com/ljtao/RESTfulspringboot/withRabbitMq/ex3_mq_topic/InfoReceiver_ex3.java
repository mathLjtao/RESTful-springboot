package com.ljtao.RESTfulspringboot.withRabbitMq.ex3_mq_topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value ="${mq.config.queue.info}",autoDelete = "ture"),
        exchange = @Exchange(value="${mq.config.exchange_2}",type = ExchangeTypes.TOPIC),
        key = "*.log.info"
))
public class InfoReceiver_ex3 {
    @RabbitHandler
    public void process(String msg){
        System.out.println("receiver 接收到info信息:"+msg);
    }
}
