package com.darshilmehta.springboot_kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> theKafkaTemplate) {
        this.kafkaTemplate = theKafkaTemplate;
    }

    public void sendMessage(String message) {
        LOGGER.info("Message has been received: {}", message);
        kafkaTemplate.send("javaguides", message);
    }

}
