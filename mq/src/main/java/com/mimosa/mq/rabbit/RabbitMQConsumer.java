package com.mimosa.mq.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @describe: TODO
 * @author: ZH
 * @date: 2017/11/21 16:34
 * @version:
 **/
@Component
public class RabbitMQConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {

    }
}
