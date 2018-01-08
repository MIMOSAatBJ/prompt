package com.mimosa.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @describe: TODO
 * @author: ZH
 * @date: 2017/12/25 16:16
 * @version:
 **/
@Component
@EnableScheduling
public class Task {
    @Scheduled(cron = "0/10 * * * * ?")
    public void test() {
        System.out.println("-----------------");
    }
}
