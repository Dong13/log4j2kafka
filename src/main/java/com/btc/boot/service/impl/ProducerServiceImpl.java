package com.btc.boot.service.impl;

import com.btc.boot.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka.devdsh.topic}")
    private String topic;

    @Override
    public void send() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            kafkaTemplate.send(topic, Integer.toString(i), "test message-" + i);
        }
    }
}
