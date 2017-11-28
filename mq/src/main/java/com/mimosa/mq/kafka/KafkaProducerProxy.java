package com.mimosa.mq.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.errors.ProducerFencedException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @describe: TODO
 * @author: ZH
 * @date: 2017/11/22 10:36
 * @version:
 **/
public final class KafkaProducerProxy implements Producer {

    @Autowired
    Producer producer;

    public KafkaProducerProxy(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void initTransactions() {
        producer.initTransactions();
    }

    @Override
    public void beginTransaction() throws ProducerFencedException {
        producer.beginTransaction();
    }

    @Override
    public void commitTransaction() throws ProducerFencedException {
        producer.commitTransaction();
    }

    @Override
    public void abortTransaction() throws ProducerFencedException {
        producer.abortTransaction();
    }

    @Override
    public Future<RecordMetadata> send(ProducerRecord record) {
        return producer.send(record);
    }

    @Override
    public Future<RecordMetadata> send(ProducerRecord record, Callback callback) {
        return producer.send(record);
    }

    @Override
    public void flush() {
        producer.flush();
    }

    @Override
    public List<PartitionInfo> partitionsFor(String topic) {
        return producer.partitionsFor(topic);
    }

    @Override
    public Map<MetricName, ? extends Metric> metrics() {
        return producer.metrics();
    }

    @Override
    public void close() {
        throw new RuntimeException("you needn't call close method in your application");
    }

    @Override
    public void close(long timeout, TimeUnit unit) {
        throw new RuntimeException("you needn't call close method in your application");
    }

    @Override
    public void sendOffsetsToTransaction(Map offsets, String consumerGroupId) throws ProducerFencedException {
        throw new RuntimeException("you needn't call close method in your application");
    }

    private void forceClose() {
        producer.close();
    }
}
