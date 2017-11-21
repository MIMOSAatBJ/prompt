package com.mimosa.mq.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @describe: Amqp消息发送端
 * @author: ZH
 * @date: 2017/11/20 11:43
 * @version:
 **/

@Component
public class RabbitMQClient {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * @param exchange
     * @param routingKey
     * @param message
     */
    public void send(String exchange, String routingKey, Object message) {
        amqpTemplate.convertAndSend(exchange, routingKey, message);
    }

    /**
     * 通过此方法获取基础组件调用比较原始的方法
     *
     * @return
     */
    public AmqpTemplate getAmqpTemplate() {
        return amqpTemplate;
    }
}
