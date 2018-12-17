package com.btc.log4j2kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Consumer {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id", "test-group");
        KafkaConsumer kafkaConsumer = new KafkaConsumer(properties);
        List topics = new ArrayList();
        topics.add("devdsh-test");
        kafkaConsumer.subscribe(topics);
        try {
            while (true) {
                ConsumerRecords consumerRecords = kafkaConsumer.poll(10);
                for (Object consumerRecord : consumerRecords) {
                    ConsumerRecord record = (ConsumerRecord) consumerRecord;
                    System.out.println(String.format("Topic - %s, Partition - %d, Value: %s",
                            record.topic(), record.partition(), record.value()));
                }
            }
        } finally {
            kafkaConsumer.close();
        }
    }
}
