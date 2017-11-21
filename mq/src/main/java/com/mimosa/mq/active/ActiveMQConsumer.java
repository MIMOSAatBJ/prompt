package com.mimosa.mq.active;

import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @describe: TODO
 * @author: ZH
 * @date: 2017/11/21 16:38
 * @version:
 **/
@Component
public class ActiveMQConsumer implements MessageListener {
    @Override
    public void onMessage(Message message) {

    }
}
