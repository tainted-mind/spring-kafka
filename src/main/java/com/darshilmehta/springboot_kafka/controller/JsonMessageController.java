package com.darshilmehta.springboot_kafka.controller;

import com.darshilmehta.springboot_kafka.entity.User;
import com.darshilmehta.springboot_kafka.kafka_json.KafkaJsonProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka_json")
public class JsonMessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonMessageController.class);

    private final KafkaJsonProducer kafkaJsonProducer;

    @Autowired
    public JsonMessageController(KafkaJsonProducer theKafkaJsonProducer) {
        this.kafkaJsonProducer = theKafkaJsonProducer;
    }

    @GetMapping("/user")
    public ResponseEntity<String> getUser(@RequestBody User user) {
        LOGGER.info("API hit to send an user to kafka broker");
        kafkaJsonProducer.sendUserMessage(user);
        return ResponseEntity.ok("User has been received");
    }

}
