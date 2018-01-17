package com.mimosa.mq;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @describe: TODO
 * @author: ZH
 * @date: 2017/11/20 11:54
 * @version:
 **/
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring*.xml");
//        RabbitMQClient client=applicationContext.getBean(RabbitMQClient.class);
//        for (int i=0;i<100;i++){
//
//            client.send("direct","rk","hahaha");
//        }
//        applicationContext.close();
//        ActiveMQClient client=applicationContext.getBean(ActiveMQClient.class);
//        for (int i=0;i<100;i++){
//
//            client.send("queue","hahaha");
//        }
        applicationContext.getBeansOfType(PropertySourcesPlaceholderConfigurer.class).forEach((k, v) -> {
            System.out.println(v.getAppliedPropertySources().iterator().next().getSource());
                }

        );
        applicationContext.close();
    }
}
