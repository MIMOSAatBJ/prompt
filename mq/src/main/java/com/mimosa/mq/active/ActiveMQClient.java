package com.mimosa.mq.active;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @describe: TODO
 * @author: ZH
 * @date: 2017/11/20 15:10
 * @version:
 **/
@Component
public class ActiveMQClient {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(String destination, Object message) {
        jmsTemplate.convertAndSend(destination, message);
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }
}
