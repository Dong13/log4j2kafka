package com.btc.boot.service.impl;

import com.btc.boot.service.ConsumerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Value("${kafka.devdsh.topic}")
    private String topic;

    @Override
    @KafkaListener(topics = "${kafka.devdsh.topic}")
    public void receive(ConsumerRecord consumerRecord) {
        System.out.println(String.format("Topic - %s, Partition - %d, Value: %s",
                topic, consumerRecord.partition(), consumerRecord.value()));
    }
}
