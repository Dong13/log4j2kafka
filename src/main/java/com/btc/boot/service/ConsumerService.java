package com.btc.boot.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ConsumerService {
    void receive(ConsumerRecord consumerRecord);
}
