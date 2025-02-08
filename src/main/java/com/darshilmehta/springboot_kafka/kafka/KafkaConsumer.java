package com.darshilmehta.springboot_kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "javaguides", groupId = "string-group-0")
    public void consume(String message) {
        LOGGER.info("Message received in primary group: {}", message);
    }

    @KafkaListener(topics = "javaguides", groupId = "string-group-1")
    public void otherConsume(String message) {
        LOGGER.info("Message received in secondary group: {}", message);
    }

}
