package com.darshilmehta.springboot_kafka.kafka_json;

import com.darshilmehta.springboot_kafka.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = "javaguides_json", groupId = "json-group-0")
    public void consume(User user) {
        LOGGER.info("User received: {}", user.toString());
    }

}
