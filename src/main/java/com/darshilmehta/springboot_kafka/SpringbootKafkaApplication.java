package com.darshilmehta.springboot_kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Kafka Cluster     - Holds all the kafka brokers
 * Kafka Broker      - It is the refers to the kafka server that is responsible to hold the messages
 * Topics            - Each broker can have any number of topics; consider a topic for a specific purpose; Each topic has unique name to identify them
 * Kafka Partitions  - Since kafka is a distributed system, it stores all the messages on different computers, hence a topic is then divided into partitions
 * Producers         - Producers are the ones that produce the messages that are to be consumed, these are sent to the broker that stores them
 * Consumers         - Consumers poll a frequent intervals from the broker to fetch if any new message has been produced
 * Consumer Groups   - Each consumer group has one or more consumer whose task is to consume all the messages from the kafka server
 * Offset            - It is a sequence of ids that are given to the messages in sequential order starting from zero
 * */

@SpringBootApplication
public class SpringbootKafkaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaApplication.class, args);
	}

}
