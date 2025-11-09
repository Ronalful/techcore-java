package com.example.module11;

import io.lettuce.core.resource.ClientResources;
import io.lettuce.core.tracing.MicrometerTracing;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.RecordMessageConverter;

import java.util.Map;

@Configuration
class ObservabilityConfiguration {

    //Redis
    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory(RedisProperties redisProperties,
                                                             ObservationRegistry observationRegistry) {
        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
        redisConfig.setHostName(redisProperties.getHost());
        redisConfig.setPort(redisProperties.getPort());
        redisConfig.setDatabase(redisProperties.getDatabase());

        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                .clientResources(ClientResources.builder()
                        .tracing(new MicrometerTracing(observationRegistry, "my-redis-cache"))
                        .build())
                .build();

        return new LettuceConnectionFactory(redisConfig, clientConfig);
    }

    //Kafka
    @Bean
    public ProducerFactory<String, Object> producerFactory(KafkaProperties kafkaProperties) {
        return new DefaultKafkaProducerFactory<>(kafkaProperties.buildProducerProperties());
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate(
            ProducerFactory<String, Object> producerFactory,
            ObjectProvider<RecordMessageConverter> messageConverter) {

        KafkaTemplate<String, Object> kafkaTemplate = new KafkaTemplate<>(producerFactory);
        messageConverter.ifUnique(kafkaTemplate::setMessageConverter);
        kafkaTemplate.setObservationEnabled(true);
        kafkaTemplate.setMicrometerTags(Map.of(
                "topic", "kafka_send",
                "app-name", "kafka"
        ));
        return kafkaTemplate;
    }
}