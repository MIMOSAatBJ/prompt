package com.mimosa;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            Watcher watcher = new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {

                }
            };
            ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 30000,
                    watchedEvent -> System.out.println(watchedEvent.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Hello World!");
    }
}
