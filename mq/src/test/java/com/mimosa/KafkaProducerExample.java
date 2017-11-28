package com.mimosa;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerExample {
    public static void main(String[] args) {
        Producer<String, String> producer = null;
        try {
            Properties props = new Properties();
            props.put("bootstrap.servers", "127.0.0.1:9092");
            props.put("acks", "all");
            props.put("group.id", "test");
            props.put("retries", 0);
            props.put("batch.size", 16384);
            props.put("linger.ms", 1);
            props.put("buffer.memory", 8388608);
            props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

            producer = new KafkaProducer<>(props);
            long start=System.currentTimeMillis();
            for (int i = 0;i<1000000 ; i++) {
                producer.send(new ProducerRecord<>("topic3", Integer.toString(i), Integer.toString(i)+"xxxxxx"));
            }
            long end=System.currentTimeMillis();
            System.out.println("use:"+(end-start));
        } catch (Exception e) {

        } finally {
            if (producer != null) {
                producer.close();
            }

        }

    }
}
