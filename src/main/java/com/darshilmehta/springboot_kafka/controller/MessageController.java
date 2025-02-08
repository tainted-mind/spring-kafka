package com.darshilmehta.springboot_kafka.controller;

import com.darshilmehta.springboot_kafka.kafka.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    private final KafkaProducer kafkaProducer;

    @Autowired
    public MessageController(KafkaProducer theKafkaProducer) {
        this.kafkaProducer = theKafkaProducer;
    }

    @GetMapping("/message")
    public ResponseEntity<String> getMessage(@RequestParam String message) {
        LOGGER.info("API hit to send a message to kafka broker");
        kafkaProducer.sendMessage(message);
        return new ResponseEntity<>("Message has been received", HttpStatus.OK);
    }

}
