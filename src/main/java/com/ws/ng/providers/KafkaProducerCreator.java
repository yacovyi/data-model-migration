package com.ws.ng.providers;

import com.ws.ng.configuration.Config;
import org.apache.kafka.clients.producer.KafkaProducer;

import javax.inject.Inject;
import java.util.Properties;

public class KafkaProducerCreator {

    @Inject
    Config config;

    private final Properties getProducerProps() {
        Properties props = new Properties();
        props.put("bootstrap.servers", config.kafkaBrokers());
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        return props;
    }

    public KafkaProducer<String, String> createProducer() {
        return new KafkaProducer<>(getProducerProps());
    }
}
