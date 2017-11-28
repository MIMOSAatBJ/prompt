package com.mimosa.mq.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @describe: TODO
 * @author: ZH
 * @date: 2017/11/21 16:34
 * @version:
 **/
@Component
public class RabbitMQConsumer implements MessageListener {

    @Autowired
    private RabbitTemplate amqpTemplate;

    @Autowired
    private ConnectionFactory connectionFactoryAMQP;

    @Override
    public void onMessage(Message message) {
    }
}
