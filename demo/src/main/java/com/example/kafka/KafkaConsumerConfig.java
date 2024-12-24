package com.example.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.dev.Weather;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

//	@Bean
//	public Map<String, Object> consumerFactory() {
//		Map<String, Object> props = new HashMap<>();
//		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		props.put(ConsumerConfig.GROUP_ID_CONFIG, "group-id");
//		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//		props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.example.dev");
//		return props;
//	}
//
//	@Bean
//	public ConsumerFactory<String, Weather> kafkaListenerContainerFactory() {
//		return new DefaultKafkaConsumerFactory<>(consumerFactory(), new StringDeserializer(),
//				new ErrorHandlingDeserializer<>(new JsonDeserializer<>(Weather.class, false)));
//	}
//
//	public ConcurrentKafkaListenerContainerFactory<String, Weather> doActionKafkaListenerContainerFactory() {
//		ConcurrentKafkaListenerContainerFactory<String, Weather> factory = new ConcurrentKafkaListenerContainerFactory<>();
//		factory.setConsumerFactory(kafkaListenerContainerFactory());
//		return factory;
//	}
	
    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group-id");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.example.dev");
        return props;
    }

    @Bean
    public ConsumerFactory<String, Weather> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                consumerConfigs(),
                new StringDeserializer(),
                new JsonDeserializer<>(Weather.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Weather> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Weather> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}


