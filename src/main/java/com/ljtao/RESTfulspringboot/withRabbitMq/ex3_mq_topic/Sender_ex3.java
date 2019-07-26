package com.ljtao.RESTfulspringboot.withRabbitMq.ex3_mq_topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sender_ex3 {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Value("${mq.config.exchange_2}")
    private String exchange;

    public void userProcess(){
        //第一个参数是交换器，第二个是交换器的路由健，第三个是发送的信息
        this.amqpTemplate.convertAndSend(this.exchange,"user.log.debug","msg:user.log.debug。。。。。。");
        this.amqpTemplate.convertAndSend(this.exchange,"user.log.info","msg:user.log.info。。。。。。");
        this.amqpTemplate.convertAndSend(this.exchange,"user.log.warn","msg:user.log.warn。。。。。。");
        this.amqpTemplate.convertAndSend(this.exchange,"user.log.error","msg:user.log.error。。。。。。");
    }
    public void orderProcess(){
        this.amqpTemplate.convertAndSend(this.exchange,"order.log.debug","msg:order.log.debug。。。。。。");
        this.amqpTemplate.convertAndSend(this.exchange,"order.log.info","msg:order.log.info。。。。。。");
        this.amqpTemplate.convertAndSend(this.exchange,"order.log.warn","msg:order.log.warn。。。。。。");
        this.amqpTemplate.convertAndSend(this.exchange,"order.log.error","msg:order.log.error。。。。。。");
    }
    public void productProcess(){
        this.amqpTemplate.convertAndSend(this.exchange,"product.log.debug","msg:product.log.debug。。。。。。");
        this.amqpTemplate.convertAndSend(this.exchange,"product.log.info","msg:product.log.info。。。。。。");
        this.amqpTemplate.convertAndSend(this.exchange,"product.log.warn","msg:product.log.warn。。。。。。");
        this.amqpTemplate.convertAndSend(this.exchange,"product.log.error","msg:product.log.error。。。。。。");
    }
}
