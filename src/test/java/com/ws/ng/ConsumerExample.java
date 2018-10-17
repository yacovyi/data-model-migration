package com.ws.ng;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

/**
 * Just a consumer to see if your producer does anything
 */
public class ConsumerExample {
    public static void main(String[] args) {
        final Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG,
                "KafkaExampleConsumer1");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());

        KafkaConsumer consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Collections.singleton("test"));

        try {

            while (true) {
                ConsumerRecords poll = consumer.poll(1000);
                poll.records("test").forEach(System.out::println);
            }
        } finally {
            consumer.unsubscribe();
            consumer.close();
        }


    }
}
