package com.example.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
@EnableKafka
public class KafkaConsumer {
	
	@Autowired
	WeatherRepository weatherRepo;

	@KafkaListener(topics = "weather", groupId = "group-id")
	public void listen(@Payload Weather message) {
		System.out.println("Received Messasge in group - group-id: " + message.toString());
		weatherRepo.save(message);
		
	}

}
