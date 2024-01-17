package com.example.userordermanagement.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(Source.class)
public class KafkaConfig {
    // Configuration for Kafka binder will be picked up from application.properties
}